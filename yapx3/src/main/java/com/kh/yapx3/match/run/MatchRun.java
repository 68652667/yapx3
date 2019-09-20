package com.kh.yapx3.match.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.kh.yapx3.match.model.vo.Summoner_1;

public class MatchRun {

	public static void main(String[] args) throws Exception {
//		new MatchRun().challengerleagues("RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f");
		new MatchRun().GMleagues("RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f");
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
