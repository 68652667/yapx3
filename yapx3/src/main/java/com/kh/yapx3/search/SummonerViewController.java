package com.kh.yapx3.search;

import java.io.BufferedReader;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.yapx3.search.model.vo.Match;
import com.kh.yapx3.search.model.vo.MyItemBuild;
import com.kh.yapx3.search.model.vo.Participant;
import com.kh.yapx3.search.model.vo.Team;
import com.kh.yapx3.search.model.vo.Summoner_1;

@Controller
@RequestMapping("/summoner")
public class SummonerViewController{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private String ApiKey = "RGAPI-b0f1c9f8-bc6b-48c9-bd2d-e303c45548ff";
	
	
	@GetMapping("/summonerView")
	public String summonerView(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		response.setContentType("application/json; charset=utf-8");
		String summonerName = request.getParameter("Name");
		String summonerId = request.getParameter("summonerId");
		
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
		
//		System.out.println("어카운트 아이디확인"+sum1.getAccountId());
		
		url = new URL(urlStr);
		br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		sb = br.readLine();
		j = new JSONObject(sb.toString());
		
		JSONArray matchData = j.getJSONArray("matches");
		
		
		List<Match> list = new ArrayList<Match>();
		
for(int i=0; i<10; i++) {
			
			JSONObject match = (JSONObject) matchData.get(i);
			
			System.out.println("매치데이터확인"+matchData.get(i));
//			System.out.println("매치게임아이디확인"+match.get("gameId").toString());
			
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
			JSONObject bFrames = (JSONObject) b1.get(0);
			JSONObject bpart = bFrames.getJSONObject("participantFrames");
			String ab = bFrames.get("timestamp").toString();
			JSONArray bEvent = (JSONArray)bFrames.get("events");

			
			for(int x = 0; x<b1.length(); x++) {
				 bFrames = (JSONObject) b1.get(x);
				 bpart = bFrames.getJSONObject("participantFrames");
				 ab = bFrames.get("timestamp").toString();
				 bEvent = (JSONArray)bFrames.get("events");
			}
				
				
//				System.out.println(bFrames);
//				System.out.println(bpart);
//				System.out.println(bFrames);
				System.out.println(bEvent);
//				String checkId = player.getString("summonerId");
			
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

			
			JSONArray ja = j.getJSONArray("teams");
			JSONObject team = (JSONObject) ja.get(0);
			Team t = new Team(team.get("teamId").toString(), team.getString("win"));
			m.setTeam1(t);
			team = (JSONObject) ja.get(1);
			t = new Team(team.get("teamId").toString(), team.getString("win"));
			m.setTeam2(t);
			
			
//			System.out.println("팀 VO확인"+t);
			
			JSONArray ja_1 = j.getJSONArray("participants");
			JSONArray ja_2 = j.getJSONArray("participantIdentities");
			
			JSONObject participant = (JSONObject) ja_1.get(0);
			JSONObject participantIdentities = (JSONObject) ja_2.get(0);
			JSONObject stats = participant.getJSONObject("stats");
			JSONObject player = participantIdentities.getJSONObject("player");
			Participant p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			System.out.println(summonerName);
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants1(p);
			
//			System.out.println("참가자 VO확인"+p);
						
			participant = (JSONObject) ja_1.get(1);
			participantIdentities = (JSONObject) ja_2.get(1);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants2(p);
			
			participant = (JSONObject) ja_1.get(2);
			participantIdentities = (JSONObject) ja_2.get(2);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants3(p);
			
			participant = (JSONObject) ja_1.get(3);
			participantIdentities = (JSONObject) ja_2.get(3);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants4(p);
			
			participant = (JSONObject) ja_1.get(4);
			participantIdentities = (JSONObject) ja_2.get(4);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants5(p);
			
			participant = (JSONObject) ja_1.get(5);
			participantIdentities = (JSONObject) ja_2.get(5);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants6(p);
			
			participant = (JSONObject) ja_1.get(6);
			participantIdentities = (JSONObject) ja_2.get(6);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants7(p);
			
			participant = (JSONObject) ja_1.get(7);
			participantIdentities = (JSONObject) ja_2.get(7);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants8(p);
			
			participant = (JSONObject) ja_1.get(8);
			participantIdentities = (JSONObject) ja_2.get(8);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants9(p);
			
			participant = (JSONObject) ja_1.get(9);
			participantIdentities = (JSONObject) ja_2.get(9);
			stats = participant.getJSONObject("stats");
			player = participantIdentities.getJSONObject("player");
			if((summonerName.trim()).equals(player.getString("summonerName").trim())) {
				
			}
			p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestKillingSpree").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageTaken").toString(), stats.get("totalMinionsKilled").toString(), player.getString("accountId"), player.getString("summonerName"), player.getString("summonerId"), player.getString("currentAccountId"), player.getString("matchHistoryUri"), stats.get("champLevel").toString());
			p.setChampionId(chap.get(p.getChampionId()));
			p.setSpell1Id(spell.get(p.getSpell1Id()));
			p.setSpell2Id(spell.get(p.getSpell2Id()));
			m.setParticipants10(p);
			
//			System.out.println("매치 VO확인"+m);
			
			MyItemBuild b = new MyItemBuild();
			
			m.setMyIteamBuild(new MyItemBuild("s","a","s"));
			
			list.add(m);
					
		}
		
		new Gson().toJson(list, response.getWriter());
	}
	
	@GetMapping("/summonerProfile")
	public void summonerProfile(HttpServletRequest request, HttpServletResponse response) {
		
		
		String searchName = request.getParameter("summonerName").replaceAll(" ","%20");
		
		String urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + searchName + "?api_key=" + ApiKey;
		
		System.out.println(urlStr);
		
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
		
		System.out.println("소환사 아이디확인@@@!!"+summonerId);
		
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
	
	
//	@RequestMapping("/champion")
//	public void champion(HttpServletRequest request, HttpServletResponse response) throws ParserConfigurationException, SAXException {
//		
//		response.setContentType("application/json; charset=utf-8");
//		
//		String urlStr = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f";
//		String urlStr2 = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/en_US/champion.json";
//		try {
//			URL url = new URL(urlStr);
//			URL url2 = new URL(urlStr2);
//			BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
//			BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openConnection().getInputStream()));
//			
//			String sb = br.readLine();
//			String sb2 = br2.readLine();
//			
//			JSONObject jobj = new JSONObject(sb.toString());
//			JSONObject jobj2 = new JSONObject(sb2.toString());
//			
//			JSONArray jar = (JSONArray) jobj.get("freeChampionIds");
//			JSONObject dataObject = jobj2.getJSONObject("data");
//			
//			Iterator num = dataObject.keys();
//			
//			List<String> list = new ArrayList<String>();
//			
//			while(num.hasNext()) {
//				String dataKey = num.next().toString();
//				
//				JSONObject data = dataObject.getJSONObject(dataKey);
//				JSONObject data_ = data.getJSONObject("image");
//				String img = data_.getString("full");
//				
//				String key = data.getString("key");
//
//				for(int i = 0; i<jar.length(); i++) {
//					String chap = jar.get(i).toString();
//					if(key.equals(chap)) {
//						list.add(img);
//					}
//				}
//			}
//			response.setCharacterEncoding("utf-8");
//			
//			new Gson().toJson(list, response.getWriter());
//			
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
}
