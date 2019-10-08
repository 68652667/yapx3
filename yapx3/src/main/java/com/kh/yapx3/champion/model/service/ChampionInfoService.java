package com.kh.yapx3.champion.model.service;

import java.util.List;
import java.util.Map;

import com.kh.yapx3.champion.model.matchline.MatchVO;
import com.kh.yapx3.champion.model.vo.ChampionInfoVO;
import com.kh.yapx3.champion.model.vo.ChampionSkillInfo;

public interface ChampionInfoService {
	
	//해당 챔피언 통계(미완성)
	public List<ChampionInfoVO> championInfo(int id);
	
	public Map<String, String> chMastery(String searchMastery);

	public Map<String, Integer> championAll();
	
	public Map<String, String> apiTest(String searchName);
	
	public List<String> champion();

	public List<MatchVO> playGame(String string, int championId);

	public Map<String, String> challengerLegue();

	public String summonerSearch(String key);

	public List<Map<String, String>> championLine(int championId);

	public List<ChampionInfoVO> summonerSkillList(int championId);

	public List<ChampionInfoVO> championRune(int championId);

	public List<ChampionInfoVO> championStartItem(int championId);

	public Map<Integer, Integer> championItem(int championId);

	public ChampionSkillInfo championSkillInfo(int championId);

}
