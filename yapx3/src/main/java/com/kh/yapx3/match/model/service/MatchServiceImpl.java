package com.kh.yapx3.match.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.service.ChampValue;
import com.kh.yapx3.champion.model.vo.Camp;
import com.kh.yapx3.match.model.dao.MatchDAO;
import com.kh.yapx3.match.model.gamelist.MatchGameList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class MatchServiceImpl implements MatchService {

	Logger logger = LoggerFactory.getLogger(getClass());
	RestTemplate restTemplate = new RestTemplate();
	String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
	
	MatchDAO matchDAO;
	JSONArray participantDataAll;
	Map<String, Integer> championMap = new HashMap<String, Integer>();
	
	//모든 챔피언의 리스트를 가져온다(가,나,다 순)
	public List<Integer> championAll() {
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		HttpHeaders header = new HttpHeaders();
	    HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
		List<Integer> championKey = new ArrayList<Integer>();
			
		for (Map.Entry<String, ChampValue> champ : championAll.getBody().getData().entrySet()) {
			championKey.add(champ.getValue().getKey());
		}
		
		return championKey;
	}
	
	public JSONArray participantDataFor(int i) {
		List<Integer> championKey = championAll();
		JSONObject jobj = new JSONObject();
		int cnt = 1;
		for(int j = 0; j < participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).size(); j++) {
			logger.info("---------------------participant"+(i+1)+"---------------------");
			for(int k = 0; k <championKey.size(); k++) {
				if(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getInt("championId") == championKey.get(k)) {
					championMap.put(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("championId"), cnt++);
					logger.info("championKey: "+ participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("championId"));
				}
			}
			logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("championId").toString());
			for(int k = 0; k < 7; k++) {
				logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("item"+k).toString());
			}
			for(int k = 0; k < 6; k++) {
				logger.info(participantDataAll.getJSONObject(i).getJSONArray("participant"+ (i + 1)).getJSONObject(j).getString("perk"+k).toString());
			}
		}
		return participantDataAll;
	}
	
	public JSONArray participantData() {
		matchDAO = new MatchDAO();
		participantDataAll = matchDAO.participant();
		for(int i = 0; i < participantDataAll.size(); i++ ) {
			if(i == 0) {participantDataFor(i);}
			if(i == 1) {participantDataFor(i);}
			if(i == 2) {participantDataFor(i);}
			if(i == 3) {participantDataFor(i);}
			if(i == 4) {participantDataFor(i);}
			if(i == 5) {participantDataFor(i);}
			if(i == 6) {participantDataFor(i);}
			if(i == 7) {participantDataFor(i);}
			if(i == 8) {participantDataFor(i);}
			if(i == 9) {participantDataFor(i);}
		}
		System.out.println("championCount: " + championMap);
		return participantDataAll;
	}

	@Override
	public List<MatchGameList> gameList(List<String> gameId) {
		String urlStr;
		HttpHeaders header;
	    HttpEntity<String> httpEntity;
		ResponseEntity<MatchGameList> gameListInfo;
		
		
		List<Integer> items = new ArrayList<Integer>();
		List<String> itemsCount = new ArrayList<String>();
		
		for(int i = 0; i < gameId.size(); i++) {
			
			urlStr = "https://kr.api.riotgames.com/lol/match/v4/matches/"+ gameId.get(i) +"?" + api;
			header = new HttpHeaders();
			httpEntity = new HttpEntity<>(header);
			gameListInfo = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, MatchGameList.class);
			System.out.println("--------------------------------------");
			logger.info("gameId: " + gameListInfo.getBody().getGameId().toString());
			logger.info("gameTeam: " + gameListInfo.getBody().getTeams().toString());
			logger.info("stats: "+gameListInfo.getBody().getParticipants().get(0).getStats().toString());
			for(int j = 0; j < 10; j++ ) {
				logger.info("participantId: "+gameListInfo.getBody().getParticipants().get(j).getParticipantId());
				logger.info("championId: "+gameListInfo.getBody().getParticipants().get(j).getChampionId());
				logger.info("item0: " + gameListInfo.getBody().getParticipants().get(j).getStats().getItem0());
				logger.info("item1: " + gameListInfo.getBody().getParticipants().get(j).getStats().getItem1());
				logger.info("item2: " + gameListInfo.getBody().getParticipants().get(j).getStats().getItem2());
				logger.info("item3: " + gameListInfo.getBody().getParticipants().get(j).getStats().getItem3());
				logger.info("item4: " + gameListInfo.getBody().getParticipants().get(j).getStats().getItem4());
				logger.info("item5: " + gameListInfo.getBody().getParticipants().get(j).getStats().getItem5());
				logger.info("item6: " + gameListInfo.getBody().getParticipants().get(j).getStats().getItem6());
			}
		}
		return null;
	}

}
