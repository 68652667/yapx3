package com.kh.yapx3.search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.kh.yapx3.champion.model.vo.ChampionSkillInfo;
import com.kh.yapx3.search.model.vo.Match;
import com.kh.yapx3.search.model.vo.MyItemBuild;
import com.kh.yapx3.search.model.vo.MySkillBuild;
import com.kh.yapx3.search.model.vo.Participant;
import com.kh.yapx3.search.model.vo.Spectator;
import com.kh.yapx3.search.model.vo.Spectator_banned;
import com.kh.yapx3.search.model.vo.Spectator_participant;
import com.kh.yapx3.search.model.vo.Team;
import com.kh.yapx3.search.model.vo.Summoner_1;

@Controller
@RequestMapping("/summoner")
public class SummonerViewController{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private String ApiKey = "RGAPI-b0f1c9f8-bc6b-48c9-bd2d-e303c45548ff";
//	private String ApiKey = "RGAPI-e933f166-9bc4-48f7-bd07-b25986d1d51d";
	
	@Autowired
	ServletContext servletContext;
	
	
	@GetMapping("/summonerView")
	public String summonerView(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		response.setContentType("application/json; charset=utf-8");
		String summonerName = request.getParameter("Name").replaceAll(" ", "%20");
		String summonerId = "";
		String urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + ApiKey;
		try {
			URL url = new URL( urlStr );
			BufferedReader br = new BufferedReader( 
						new InputStreamReader( url.openConnection().getInputStream() ) );
			
			String sb = br.readLine();
			
			JSONObject jobj = new JSONObject( sb.toString() );
			summonerName = jobj.getString("name");
			summonerId = jobj.getString("id");
			
		} catch ( Exception e ) {
			e.printStackTrace();
			//logger.info("없는 아이디입니다.");

			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().append("noneId");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		model.addAttribute("summonerName",summonerName);
		model.addAttribute("summonerId",summonerId);
		
		return "summoner/summonerView";
	}
	
		
	@RequestMapping("/searchView")
	public void apiTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		response.setContentType("application/json; charset=utf-8");
		
		String searchName = request.getParameter("summonerName").replaceAll(" ","%20");
		String summonerName = request.getParameter("summonerName");
		
		String urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+searchName+"?api_key="+ApiKey;
		String urlStr2 = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/en_US/champion.json";
		String urlStr3 = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/en_US/summoner.json";
		
		
		
		
		URL url = new URL(urlStr);
		URL url2 = new URL(urlStr2);
		URL url3 = new URL(urlStr3);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openConnection().getInputStream()));
		BufferedReader br3 = new BufferedReader(new InputStreamReader(url3.openConnection().getInputStream()));
		
		String sb = br.readLine();
		String sb2 = br2.readLine();
		String sb3 = br3.readLine();
				
		JSONObject j = new JSONObject(sb.toString());
		JSONObject chapdata = new JSONObject(sb2.toString());
		JSONObject chapdataObject = chapdata.getJSONObject("data");
		JSONObject spelldata = new JSONObject(sb3.toString());
		JSONObject spelldataObject = spelldata.getJSONObject("data");
		
		
		Iterator num1 = chapdataObject.keys();
		Iterator num2 = spelldataObject.keys();
		
		Map<String, String> chap = new HashMap<String, String>();
		Map<String, String> spell = new HashMap<String, String>();
		
		while(num1.hasNext()) {
			String dataKey = num1.next().toString();
			JSONObject data = chapdataObject.getJSONObject(dataKey);
			JSONObject data_ = data.getJSONObject("image");
			String img = data_.getString("full");
			String key = data.getString("key");
			String id = data.getString("id");
			chap.put(key, id);
		}
		
		while(num2.hasNext()) {
			String dataKey = num2.next().toString();
			JSONObject data = spelldataObject.getJSONObject(dataKey);
			String key = data.getString("key");
			String id = data.getString("id");
			spell.put(key, id);
		}
		
		Summoner_1 sum1 = new Summoner_1();
		sum1.setAccountId(j.getString("accountId"));
		sum1.setId(j.getString("id"));
		sum1.setName(j.getString("name"));
		sum1.setProfileIconId(j.get("profileIconId").toString());
		sum1.setPuuid(j.getString("puuid"));
		sum1.setRevisionDate(j.get("revisionDate").toString());
		sum1.setSummonerLevel(j.get("summonerLevel").toString());
		
		urlStr = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"+sum1.getAccountId()+"?api_key="+ApiKey;
		
		url = new URL(urlStr);
		br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		sb = br.readLine();
		j = new JSONObject(sb.toString());
		
		JSONArray matchData = j.getJSONArray("matches");
		String partCheck = "";
		int partCheck_ = 0;
		
		List<Match> list = new ArrayList<Match>();
		
		
		int tempi = 0;	
		
			for(int i=0; i<20; i++) {
				
				List<MyItemBuild> build1 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build2 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build3 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build4 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build5 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build6 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build7 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build8 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build9 = new ArrayList<MyItemBuild>();
				List<MyItemBuild> build10 = new ArrayList<MyItemBuild>();
				
				List<MySkillBuild> skb1 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb2 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb3 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb4 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb5 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb6 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb7 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb8 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb9 = new ArrayList<MySkillBuild>();
				List<MySkillBuild> skb10 = new ArrayList<MySkillBuild>();
			
			JSONObject match = (JSONObject) matchData.get(i);
			
			urlStr = "https://kr.api.riotgames.com/lol/match/v4/matches/"+match.get("gameId").toString()+"?api_key="+ApiKey;
			url = new URL(urlStr);
			br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
			sb = br.readLine();
			j = new JSONObject(sb.toString());
			
			String buildStr = "https://kr.api.riotgames.com/lol/match/v4/timelines/by-match/"+match.get("gameId").toString()+"?api_key="+ApiKey;
			URL buildURL = new URL(buildStr);
			BufferedReader buildBr = new BufferedReader(new InputStreamReader(buildURL.openConnection().getInputStream()));
			String buildSb = buildBr.readLine();
			JSONObject buildJO = new JSONObject(buildSb.toString());
				
			JSONArray b1 = buildJO.getJSONArray("frames");

			
			
			Match m = new Match();
			m.setGameId(j.get("gameId").toString());
			m.setGameCreation(j.get("gameCreation").toString());
			m.setGameDuration(j.get("gameDuration").toString());
			m.setQueueId(j.get("queueId").toString());
			m.setMapId(j.get("mapId").toString());
			m.setSeasonId(j.get("seasonId").toString());
			m.setGameVersion(j.getString("gameVersion"));
			m.setGameMode(j.getString("gameMode"));
			m.setGameType(j.getString("gameType"));
			
			
			MyItemBuild mb = new MyItemBuild();
			MySkillBuild skb = new MySkillBuild();
			
			JSONArray ja = j.getJSONArray("teams");
			JSONObject team = (JSONObject) ja.get(0);
			Team t = new Team(team.get("teamId").toString(), team.getString("win"));
			m.setTeam1(t);
			team = (JSONObject) ja.get(1);
			t = new Team(team.get("teamId").toString(), team.getString("win"));
			m.setTeam2(t);
			
			JSONArray ja_1 = j.getJSONArray("participants");
			JSONArray ja_2 = j.getJSONArray("participantIdentities");
			
			JSONObject participant = (JSONObject) ja_1.get(0);
			JSONObject participantIdentities = (JSONObject) ja_2.get(0);
			JSONObject stats = participant.getJSONObject("stats");
			JSONObject player = participantIdentities.getJSONObject("player");
			
			partCheck = participant.get("participantId").toString();
			partCheck_ = Integer.parseInt(partCheck);
				
			for(int x = 0; x<b1.length(); x++) {
				JSONObject bFrames = (JSONObject) b1.get(x);
				JSONArray bEvent = (JSONArray)bFrames.get("events");
				for(int y = 0; y<bEvent.length(); y++) {
				JSONObject bEvent_x = (JSONObject) bEvent.get(y);
				
				String type = (String)bEvent_x.get("type");
				
				
				
				
				if(type.equals("ITEM_SOLD")||type.equals("ITEM_PURCHASED")) {
					int parti = (int)bEvent_x.get("participantId");
					if(parti==1) {
					
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						
						build1.add(mb);
						
						
					}
					else if(parti==2) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						build2.add(mb);
						
					}
					else if(parti==3) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						build3.add(mb);
						
					}
					else if(parti==4) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						build4.add(mb);
						
					}
					else if(parti==5) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						build5.add(mb);
						
					}
					else if(parti==6) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						build6.add(mb);
						
					}
					else if(parti==7) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						build7.add(mb);
						
					}
					else if(parti==8) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						build8.add(mb);
						
					}
					else if(parti==9) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						build9.add(mb);
						
					}
					else if(parti==10) {
						
						
						int time = (int)bEvent_x.get("timestamp");
						int item = (int)bEvent_x.get("itemId");
						mb = new MyItemBuild(time, type, item, parti);
						
						build10.add(mb);
						
					}
				}
				
				if(type.equals("SKILL_LEVEL_UP")) {
					int parti = (int)bEvent_x.get("participantId");
					if(parti==1) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb1.add(skb);
						
												
						
						}
					else if(parti==2) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb2.add(skb);
						
						
						
						}
					else if(parti==3) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb3.add(skb);
						
						
						
					}
					else if(parti==4) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb4.add(skb);
						
						
						
					}
					else if(parti==5) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb5.add(skb);
						
						
						
					}
					else if(parti==6) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb6.add(skb);
						
						
						
					}
					else if(parti==7) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb7.add(skb);
						
						
						
					}
					else if(parti==8) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb8.add(skb);
						
						
						
					}
					else if(parti==9) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb9.add(skb);
						
						
						
					}
					else if(parti==10) {
						int time = (int)bEvent_x.get("timestamp");
						int skillSlot = (int)bEvent_x.get("skillSlot");
						
						skb = new MySkillBuild(time, skillSlot, type, parti);
						
						skb10.add(skb);
						
						
						
					}
						
				
				}
				
				
				}//y
				}//x	
			
	
				
			Participant p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(),build1,skb1,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			FileReader reader = new FileReader(servletContext.getRealPath("/resources/json/skill.json"));
			BufferedReader KObr = new BufferedReader(reader);
			String line;
			String jj="";
			
			while((line = KObr.readLine()) != null) {
				jj += line;
			}
			JSONArray jarr = new JSONArray(jj.toString());
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants1(p);
			
			
			participant = (JSONObject) ja_1.get(1);
			participantIdentities = (JSONObject) ja_2.get(1);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build2, skb2,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			
			m.setParticipants2(p);
			
			participant = (JSONObject) ja_1.get(2);
			participantIdentities = (JSONObject) ja_2.get(2);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build3, skb3,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants3(p);
			
			participant = (JSONObject) ja_1.get(3);
			participantIdentities = (JSONObject) ja_2.get(3);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build4, skb4,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants4(p);
			
			participant = (JSONObject) ja_1.get(4);
			participantIdentities = (JSONObject) ja_2.get(4);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build5, skb5,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants5(p);
			
			participant = (JSONObject) ja_1.get(5);
			participantIdentities = (JSONObject) ja_2.get(5);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build6, skb6,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants6(p);
			
			participant = (JSONObject) ja_1.get(6);
			participantIdentities = (JSONObject) ja_2.get(6);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build7, skb7,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants7(p);
			
			participant = (JSONObject) ja_1.get(7);
			participantIdentities = (JSONObject) ja_2.get(7);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build8, skb8,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants8(p);
			
			participant = (JSONObject) ja_1.get(8);
			participantIdentities = (JSONObject) ja_2.get(8);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build9, skb9,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants9(p);
			
			participant = (JSONObject) ja_1.get(9);
			participantIdentities = (JSONObject) ja_2.get(9);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString(),stats.get("perkPrimaryStyle").toString(),stats.get("perkSubStyle").toString(),stats.get("perk0").toString(),stats.get("perk1").toString(),stats.get("perk2").toString(),stats.get("perk3").toString(),stats.get("perk4").toString(), stats.get("perk5").toString(), stats.get("statPerk0").toString(),stats.get("statPerk1").toString(),stats.get("statPerk2").toString(), build10, skb10,participant.get("championId").toString(),"","","","","");
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			
			for(int ix = 0; ix < jarr.length(); ix++) {
				if(Integer.parseInt(participant.get("championId").toString()) == jarr.getJSONObject(ix).getInt("key")) {
					p.setChampionKO(jarr.getJSONObject(ix).getString("championName"));
					p.setChamQ(jarr.getJSONObject(ix).getString("championQSkill"));
					p.setChamW(jarr.getJSONObject(ix).getString("championWSkill"));
					p.setChamE(jarr.getJSONObject(ix).getString("championESkill"));
					p.setChamR(jarr.getJSONObject(ix).getString("championRSkill"));
				}
			}
			
			m.setParticipants10(p);
			
			m.setTest1(b1);
			
			
			list.add(m);
					
		}
		
		new Gson().toJson(list, response.getWriter());
		
	}
	
	@GetMapping("/summonerProfile")
	public void summonerProfile(HttpServletRequest request, HttpServletResponse response) {
		
		
		String searchName = request.getParameter("summonerName").replaceAll(" ","%20");
		
		String urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + searchName + "?api_key=" + ApiKey;
		
		try {
			URL url = new URL( urlStr );
			BufferedReader br = new BufferedReader( 
						new InputStreamReader( url.openConnection().getInputStream() ) );
			
			String sb = br.readLine();
			
			JSONObject jobj = new JSONObject( sb.toString() );
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jobj.toString());
			
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	@GetMapping("/summonerRank")
	public void league( HttpServletRequest request,
						HttpServletResponse response) {
		
		String summonerId = request.getParameter("summonerId");
		
		String urlStr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId + "?api_key=" + ApiKey;
		

		try {
			URL url = new URL( urlStr );
			BufferedReader br = new BufferedReader
					( new InputStreamReader( url.openConnection().getInputStream() ) );
			
			String sb = br.readLine();
			
			JSONArray jobj = new JSONArray( sb.toString() );
			
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jobj.toString());
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	@GetMapping("/summonerInGame")
	public void inGame( HttpServletRequest request,
						HttpServletResponse response) {
				String summonerId = request.getParameter("summonerId");
				
				System.out.println(summonerId);
			
			
				//인게임정보 
				
				try {
					
					List<Spectator> list = new ArrayList<Spectator>();
					List<Spectator_participant> spList = new ArrayList<Spectator_participant>();
					List<Spectator_banned> banList = new ArrayList<Spectator_banned>();
					String inGameStr = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/"+summonerId+"?api_key="+ApiKey;
					
					System.out.println(inGameStr);
					
					String urlStr2 = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/en_US/champion.json";
					String urlStr3 = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/en_US/summoner.json";
					
					URL url2 = new URL(urlStr2);
					URL url3 = new URL(urlStr3);
					
					BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openConnection().getInputStream()));
					BufferedReader br3 = new BufferedReader(new InputStreamReader(url3.openConnection().getInputStream()));
					
					String sb2 = br2.readLine();
					String sb3 = br3.readLine();
							
					JSONObject chapdata = new JSONObject(sb2.toString());
					JSONObject chapdataObject = chapdata.getJSONObject("data");
					JSONObject spelldata = new JSONObject(sb3.toString());
					JSONObject spelldataObject = spelldata.getJSONObject("data");
					
					
					Iterator num1 = chapdataObject.keys();
					Iterator num2 = spelldataObject.keys();
					
					Map<String, String> chap = new HashMap<String, String>();
					Map<String, String> spell = new HashMap<String, String>();
					
					while(num1.hasNext()) {
						String dataKey = num1.next().toString();
						JSONObject data = chapdataObject.getJSONObject(dataKey);
						JSONObject data_ = data.getJSONObject("image");
						String img = data_.getString("full");
						String key = data.getString("key");
						String id = data.getString("id");
						chap.put(key, id);
					}
					
					while(num2.hasNext()) {
						String dataKey = num2.next().toString();
						JSONObject data = spelldataObject.getJSONObject(dataKey);
						String key = data.getString("key");
						String id = data.getString("id");
						spell.put(key, id);
					}
					
										
					URL inGameUrl = new URL(inGameStr);
					BufferedReader inGamebr = new BufferedReader(new InputStreamReader(inGameUrl.openConnection().getInputStream()));
					String inGameSb = inGamebr.readLine();
					JSONObject inGameObj = new JSONObject(inGameSb.toString());
					String gameType = inGameObj.getString("gameType");
					JSONArray inGameArr = inGameObj.getJSONArray("participants");
					JSONObject observers = inGameObj.getJSONObject("observers");
					JSONArray banned = inGameObj.getJSONArray("bannedChampions");
					int banCham = 0;
					int banTeamId = 0;
					Spectator_banned SpBan = new Spectator_banned();
					
					for(int i=0; i<banned.length(); i++) {
						JSONObject ban = (JSONObject) banned.get(i);
						 banCham = ban.getInt("championId");
						 banTeamId = ban.getInt("teamId");
						 SpBan = new Spectator_banned(banTeamId,chap.get(Integer.toString(banCham)));
						 
						 banList.add(SpBan);
					}
					
					
					
					JSONObject perks;
					JSONArray perkId;
					int perkSubStyle;
					int championId = 0;
					int spell1 = 0;
					int spell2 = 0;
					String summonerIds = "";
					int teamId = 0;
					String summonerName = "";
					JSONObject perkIdResult;
					
					Spectator_participant sp = new Spectator_participant();
					Spectator spt = new Spectator();
					Spectator_banned ban = new Spectator_banned();
					
					JSONObject  p1 = (JSONObject) inGameArr.get(0);
					
					spt.setBanned(banList);
					spt.setObservers(observers);
					spt.setGameMode(gameType);
					
				
				for(int i = 0; i<10; i++) {
						
					
				 p1 = (JSONObject) inGameArr.get(i);
				
				 perks = (JSONObject)p1.getJSONObject("perks");
				 perkId = (JSONArray)perks.getJSONArray("perkIds");
				 perkSubStyle = perks.getInt("perkSubStyle");
				 
				 championId = p1.getInt("championId");
				 spell1 =  p1.getInt("spell1Id");
				 spell2 = p1.getInt("spell2Id");
				 summonerIds = p1.getString("summonerId");
				 teamId = p1.getInt("teamId");
				 summonerName = p1.getString("summonerName");
				 
				 
				 String urlStr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerIds + "?api_key=" + ApiKey;
					URL url = new URL( urlStr );
					BufferedReader br = new BufferedReader
						( new InputStreamReader( url.openConnection().getInputStream() ) );
						
						String sb = br.readLine();
						
						JSONArray jobj = new JSONArray( sb.toString() );
						JSONObject job12 = (JSONObject)jobj.get(0);
						
						String rank = job12.getString("rank");
						String tier = job12.getString("tier");
						int LP = job12.getInt("leaguePoints");
				 
				 
					
					sp = new Spectator_participant();
					
					sp.setChampionId(chap.get(Integer.toString(championId)));
					sp.setSummonerName(summonerName.toString());
					sp.setPerks(perkId);
					sp.setPerkSubStyle(perkSubStyle);
					sp.setSpell1(spell.get(Integer.toString(spell1)));
					sp.setSpell2(spell.get(Integer.toString(spell2)));
					sp.setTeamId(teamId);
					sp.setTier(tier);
					sp.setRank(rank);
					sp.setLP(LP);
					
					spList.add(sp);
					
					}
				spt.setParticipant(spList);
					
				list.add(spt);
				
				System.out.println(list);
					

					//만약 게임중이 아니라면 File Not FoundException 뜸
					
		
					
					
					response.setCharacterEncoding("utf-8");
					new Gson().toJson(list, response.getWriter());	
					
					
				}catch(FileNotFoundException e) {
					
				}
				catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		
	
	}
	
}
