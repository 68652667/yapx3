package com.kh.yapx3.match.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.kh.yapx3.board.tip.model.vo.ChampSkills;
import com.kh.yapx3.match.model.vo.Summoner_1;

public class MatchRun {

	public static void main(String[] args) throws Exception {
//		new MatchRun().challengerleagues("RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f");
//		new MatchRun().GMleagues("RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f");
//		new MatchRun().test1();
		new MatchRun().test2();
	}
	
	private void test2() throws Exception{
		
		File file = new File("data.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader bufReader = new BufferedReader(fr);

		String sb = "";
		String line = "";
        while((line = bufReader.readLine()) != null){
            sb += line;
        }
        bufReader.close();
        
        JSONObject champ =  new JSONObject(sb.toString());
        JSONArray arr = champ.getJSONArray("champ");
        for(int i=0; i<arr.length(); i++) {
        	JSONObject c = (JSONObject) arr.get(i);
        	String id = c.getString("id");
        	String passive = c.getString("passive");
        	String spell1 = c.getString("spell1");
        	String spell2 = c.getString("spell2");
        	String spell3 = c.getString("spell3");
        	String spell4 = c.getString("spell4");
        	System.out.println(id+", "+passive+", "+spell1+", "+spell2+", "+spell3+", "+spell4);
        }
	}

	private void test1() throws Exception{

		org.json.simple.JSONArray jsa = new org.json.simple.JSONArray();
		org.json.simple.JSONObject jo = new org.json.simple.JSONObject();
		
		List<ChampSkills> champList = new ArrayList<ChampSkills>();
		String url = "http://ddragon.leagueoflegends.com/cdn/9.19.1/data/ko_KR/champion.json";
		URL url_ = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(url_.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject champ =  new JSONObject(sb.toString());
		JSONObject dataObject = (JSONObject) champ.get("data");
		Iterator i = (Iterator) dataObject.keys();
		
//		File file = new File("data.json");
//		
//		FileWriter fw = new FileWriter(file);
//		
//		fw.write("{\n");
		while(i.hasNext()) {
			ChampSkills c = new ChampSkills();
			
			String dataKey = i.next().toString();
			JSONObject data = dataObject.getJSONObject(dataKey);
			String id = (String) data.get("id");
			c.setId(id);
			
			String url2 = "http://ddragon.leagueoflegends.com/cdn/9.19.1/data/en_US/champion/"+id+".json";
			URL url2_ = new URL(url2);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(url2_.openConnection().getInputStream()));
			String sb2 = br2.readLine();
			JSONObject champ2 =  new JSONObject(sb2.toString());
			JSONObject dataObject2 = (JSONObject) champ2.get("data");
			Iterator i2 = (Iterator) dataObject2.keys();
			while(i2.hasNext()) {
				String dataKey2 = i2.next().toString();
				JSONObject dataObject2_2 = (JSONObject) dataObject2.get(dataKey2);
				JSONArray spells = (JSONArray) dataObject2_2.get("spells");
				JSONObject passive = dataObject2_2.getJSONObject("passive").getJSONObject("image");
				String pa = (String) passive.get("full");
				JSONObject k1 = spells.getJSONObject(0).getJSONObject("image");
				String spell1 = (String) k1.get("full");
				JSONObject k2 = spells.getJSONObject(1).getJSONObject("image");
				String spell2 = (String) k2.get("full");
				JSONObject k3 = spells.getJSONObject(2).getJSONObject("image");
				String spell3 = (String) k3.get("full");
				JSONObject k4 = spells.getJSONObject(3).getJSONObject("image");
				String spell4 = (String) k4.get("full");
				c.setQ(spell1);
				c.setW(spell2);
				c.setE(spell3);
				c.setR(spell4);
				c.setPassive(pa);
				jo = new org.json.simple.JSONObject();
				jo.put("id", id);
				jo.put("spell1", spell1);
				jo.put("spell2", spell2);
				jo.put("spell3", spell3);
				jo.put("spell4", spell4);
				jo.put("passive", pa);
				System.out.println(jo.toJSONString());
				jsa.add(jo);
//				fw.write("	\""+id+"\" : {\n		\"id\" : \""+id+"\"\n	},\n");
			}
			champList.add(c);
		}
		
		org.json.simple.JSONObject ob = new org.json.simple.JSONObject();
		ob.put("champs", jsa);
		String jsonInfo = ob.toJSONString();
		System.out.println(jsonInfo);
		
//		fw.write("}\n");
//		fw.close();
	
	}

	public void challengerleagues(String key) throws Exception {
		String urlStr = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?api_key="+key;
		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject chalObj = new JSONObject(sb.toString());
		JSONArray chalEntry = chalObj.getJSONArray("entries");
		List<String> chalIdList = new ArrayList<String>();
		
		for(Object e : chalEntry) {
			JSONObject jo = (JSONObject)e;
			String chalId = jo.getString("summonerId");
			chalIdList.add(chalId);
		}
		
		List<Summoner_1> list = new ArrayList<Summoner_1>();
		
		for(int i=0; i<chalIdList.size(); i++) {
			if(i != 0 && i%95 == 0) {
				System.out.println("아이디 리스트 : " + i);
				Thread.sleep(120001);
			}
			URL url2 = new URL("https://kr.api.riotgames.com/lol/summoner/v4/summoners/"+chalIdList.get(i)+"?api_key="+key);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openConnection().getInputStream()));
			String sb2 = br2.readLine();
			JSONObject j = new JSONObject(sb2.toString());
			
			Summoner_1 sum1 = new Summoner_1();
			sum1.setAccountId(j.getString("accountId"));
			sum1.setId(j.getString("id"));
			sum1.setName(j.getString("name"));
			sum1.setProfileIconId(j.get("profileIconId").toString());
			sum1.setPuuid(j.getString("puuid"));
			sum1.setRevisionDate(j.get("revisionDate").toString());
			sum1.setSummonerLevel(j.get("summonerLevel").toString());
			list.add(sum1);
		}
		
		System.out.println("매치 맵 시작!");
		Thread.sleep(120001);
		
		Map<String, String> matchMap = new HashMap<String, String>();
		
		for(int i=0; i<list.size(); i++) {
			if(i != 0 && i%95 == 0) {
				System.out.println("매치 리스트 : " + i);
				Thread.sleep(120001);
			}
			URL url3 = new URL("https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"+list.get(i).getAccountId()+"?api_key="+key);
			BufferedReader br3 = new BufferedReader(new InputStreamReader(url3.openConnection().getInputStream()));
			String sb3 = br3.readLine();
			JSONObject j = new JSONObject(sb3.toString());
			JSONArray matchList = j.getJSONArray("matches");
			for(Object e : matchList) {
				JSONObject matches = (JSONObject)e;
				String gameId = matches.get("gameId").toString();
				matchMap.put(gameId, gameId);
			}
			
		}
		
		System.out.println("파일 시작!");
		
		File file = new File("chellengerMatches.sql");
		
		FileWriter fw = new FileWriter(file);
		
		for(String matchId : matchMap.keySet()) {
			fw.write("insert into match(gameid) values ('"+matchId+"');\n");
		}
		
		fw.close();
	}
	
	public void GMleagues(String key) throws Exception {
		String urlStr = "https://kr.api.riotgames.com/lol/league/v4/grandmasterleagues/by-queue/RANKED_SOLO_5x5?api_key="+key;
		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject chalObj = new JSONObject(sb.toString());
		JSONArray chalEntry = chalObj.getJSONArray("entries");
		List<String> chalIdList = new ArrayList<String>();
		
		for(Object e : chalEntry) {
			JSONObject jo = (JSONObject)e;
			String chalId = jo.getString("summonerId");
			chalIdList.add(chalId);
		}
		
		List<Summoner_1> list = new ArrayList<Summoner_1>();
		
		for(int i=0; i<chalIdList.size(); i++) {
			if(i != 0 && i%95 == 0) {
				System.out.println("아이디 리스트 : " + i);
				Thread.sleep(120001);
			}
			URL url2 = new URL("https://kr.api.riotgames.com/lol/summoner/v4/summoners/"+chalIdList.get(i)+"?api_key="+key);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openConnection().getInputStream()));
			String sb2 = br2.readLine();
			JSONObject j = new JSONObject(sb2.toString());
			
			Summoner_1 sum1 = new Summoner_1();
			sum1.setAccountId(j.getString("accountId"));
			sum1.setId(j.getString("id"));
			sum1.setName(j.getString("name"));
			sum1.setProfileIconId(j.get("profileIconId").toString());
			sum1.setPuuid(j.getString("puuid"));
			sum1.setRevisionDate(j.get("revisionDate").toString());
			sum1.setSummonerLevel(j.get("summonerLevel").toString());
			list.add(sum1);
		}
		
		System.out.println("매치 맵 시작!");
		Thread.sleep(120001);
		
		Map<String, String> matchMap = new HashMap<String, String>();
		
		for(int i=0; i<list.size(); i++) {
			if(i != 0 && i%95 == 0) {
				System.out.println("매치 리스트 : " + i);
				Thread.sleep(120001);
			}
			URL url3 = new URL("https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"+list.get(i).getAccountId()+"?api_key="+key);
			BufferedReader br3 = new BufferedReader(new InputStreamReader(url3.openConnection().getInputStream()));
			String sb3 = br3.readLine();
			JSONObject j = new JSONObject(sb3.toString());
			JSONArray matchList = j.getJSONArray("matches");
			for(Object e : matchList) {
				JSONObject matches = (JSONObject)e;
				String gameId = matches.get("gameId").toString();
				matchMap.put(gameId, gameId);
			}
			
		}
		
		System.out.println("파일 시작!");
		
		File file = new File("GMMatches.sql");
		
		FileWriter fw = new FileWriter(file);
		
		for(String matchId : matchMap.keySet()) {
			fw.write("insert into match(gameid) values ('"+matchId+"');\n");
		}
		
		fw.close();
	}

}
