package com.kh.yapx3.champion.model.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.kh.yapx3.champion.model.matchline.MatchVO;
import com.kh.yapx3.champion.model.vo.Camp;

public interface ApiService {
	
	//해당 챔피언 통계(미완성)
	public JSONObject championInfo();
	
	public Map<String, String> chMastery(String searchMastery);

	public List<Camp> championAll();
	
	public Map<String, String> apiTest(String searchName);
	
	public List<String> champion();

	public List<MatchVO> playGame(String string, int championId);

	public Map<String, String> challengerLegue();

	public String summonerSearch(String key);
	
//	public List<ChampionMastery> chMastery();
}
