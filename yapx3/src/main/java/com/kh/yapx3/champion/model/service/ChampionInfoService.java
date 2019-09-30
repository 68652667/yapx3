package com.kh.yapx3.champion.model.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.kh.yapx3.champion.model.matchline.MatchVO;
import com.kh.yapx3.champion.model.vo.Camp;

public interface ChampionInfoService {
	
	//해당 챔피언 통계(미완성)
	public int championInfo(int id);
	
	public Map<String, String> chMastery(String searchMastery);

	public Map<String, Integer> championAll();
	
	public Map<String, String> apiTest(String searchName);
	
	public List<String> champion();

	public List<MatchVO> playGame(String string, int championId);

	public Map<String, String> challengerLegue();

	public String summonerSearch(String key);

	public int championWin(int championId);

	public int championLineTop(int championId);

	public int championLineBottom(int championId);

	public List<Integer> championLine(int championId);
	
//	public List<ChampionMastery> chMastery();
}
