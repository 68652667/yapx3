package com.kh.yapx3.champion.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.lotation.LotationChampion;

public class URLConnection {
	
	private final RestTemplate restTemplate = new RestTemplate();
	private String urlStr = "";
	public static String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
	
	//반환값이 object일때({} -> 이걸로 시작할때)
	public JSONObject urlInput(String urlStr) throws IOException {

		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject jobj = new JSONObject(sb.toString());
		
		return jobj;
	}
	
	//반환값이 Array일때([] -> 이걸로 시작할때)
	public JSONArray urlInputArray(String urlStr) throws IOException {

		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONArray jobj = new JSONArray(sb.toString());
		
		return jobj;
	}
	
	//Match 게임 검색
	public JSONObject matchGameSearch(String accountId) throws IOException{
		urlStr = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/8KKjkdbSMbdI_c7PMarrf7OVKZC2E_83fqZwwJooX13O?api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
		JSONObject jobj = urlInput(urlStr);
		return jobj;
	}
	
	//Match
	public JSONObject matchGame(String gameId) throws IOException{
		urlStr = "https://kr.api.riotgames.com/lol/match/v4/matches/3838862365?api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
		JSONObject jobj = urlInput(urlStr);
		return jobj;
	}
	
	//챔피언 마스터리 url
	public JSONArray chMatery(String encrypteSummoonerName) throws IOException {
		urlStr = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"+encrypteSummoonerName + api ;
		JSONArray jarray = urlInputArray(urlStr);
		return jarray; 
	}
	
	//소환사 검색 url
	public JSONObject searhName(String searchName) throws IOException{
		urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+searchName + api;
		JSONObject jobj = urlInput(urlStr);
		return jobj;
	}
	
	//이번주 로테이션 url
	public LotationChampion lotation() throws IOException{
		urlStr = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?" + api;
		HttpHeaders header = new HttpHeaders();
	    HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<LotationChampion> getMatch = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, LotationChampion.class);
	    return getMatch.getBody();
	}

	//챔피언 데이터 url
	public ChampionAll championData() throws IOException{
		urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		HttpHeaders header = new HttpHeaders();
	    HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
	    return championAll.getBody();
	}

	//챔피언 데이터 url
	public JSONObject championDataOrigin() throws IOException{
		urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		JSONObject jobj = urlInput(urlStr);
		return jobj;
	}
		
	//첼린져 리그들 
	public JSONObject challengerLegue() throws IOException{
		urlStr = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?" + api;
		JSONObject jobj = urlInput(urlStr);
		return jobj;
	}
}