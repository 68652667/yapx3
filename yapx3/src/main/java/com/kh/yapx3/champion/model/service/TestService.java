package com.kh.yapx3.champion.model.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.model.match.GetMatch;

@Service
public class TestService {
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	private String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
	private String getMatchUrlStr = "https://kr.api.riotgames.com/lol/match/v4/matches/3869663388?" + api;

	public GetMatch getResponseEntity() {
		
		HttpHeaders header = new HttpHeaders();
	    HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<GetMatch> getMatch = restTemplate.exchange(getMatchUrlStr, HttpMethod.GET, httpEntity, GetMatch.class);
		
	    return getMatch.getBody();
	    
	}
	
}
