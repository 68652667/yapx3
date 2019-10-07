package com.kh.yapx3.champion.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.champion.model.vo.ChampionInfoVO;

@Repository
public class ChampionDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public int championCount(int id) {
		
		int championCount = sqlSession.selectOne("champion.championCount", id);
		return championCount;
	}

	public int championWin(int championId) {
		int championWin = sqlSession.selectOne("champion.championWin", championId);
		return championWin;
	}

	public int championLineTop(int championId) {
		int championLineTop = sqlSession.selectOne("champion.championLineTop", championId);
		return championLineTop;
	}

	public int championLineBottom(int championId) {
		int championLineBottom = sqlSession.selectOne("champion.championLineBottom", championId);
		return championLineBottom;
	}

	public List<Map<String, String>> championLineAll(int championId){
		List<Map<String, String>> lineList = sqlSession.selectList("champion.championLineAll", championId);
		return lineList;
	}
	public List<ChampionInfoVO> summonerSkill(int championId){
		List<ChampionInfoVO> spellList = sqlSession.selectList("champion.summonerSkillRank", championId);
		return spellList;
	}
	
	public List<ChampionInfoVO> summonerWinSkillRank(int championId){
		List<ChampionInfoVO> spellList = sqlSession.selectList("champion.summonerWinSkillRank", championId);
		return spellList;
	}

	public List<ChampionInfoVO> championRune(int championId) {
		List<ChampionInfoVO> championPerkList = sqlSession.selectList("champion.championPerk",championId);
		return championPerkList;
	}
	

	public List<ChampionInfoVO> championStartItem(int championId) {
		List<ChampionInfoVO> itemStartList = sqlSession.selectList("champion.championStartItem", championId);
		return itemStartList;
		
	}

	public List<ChampionInfoVO> championItem(int championId, int i) {
		List<ChampionInfoVO> itemRank =	sqlSession.selectList("champion.championItem"+i, championId);
		return itemRank;
	}
	
}
