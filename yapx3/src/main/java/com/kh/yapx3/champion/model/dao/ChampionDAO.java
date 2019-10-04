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
		logger.info("챔피언의 총 플레이 수: " + championCount);
		return championCount;
	}

	public int championWin(int championId) {
		int championWin = sqlSession.selectOne("champion.championWin", championId);
		logger.info("챔피언으로 이긴 횟수: " + championWin);
		return championWin;
	}

	public int championLineTop(int championId) {
		int championLineTop = sqlSession.selectOne("champion.championLineTop", championId);
		logger.info("해당 챔피언으로 탑을 간 횟수: " + championLineTop);
		return championLineTop;
	}

	public int championLineBottom(int championId) {
		int championLineBottom = sqlSession.selectOne("champion.championLineBottom", championId);
		logger.info("해당 챔피언으로 바텀을 간 횟수: " + championLineBottom);
		return championLineBottom;
	}

	public List<Map<String, String>> championLineAll(int championId){
		List<Map<String, String>> lineList = sqlSession.selectList("champion.championLineAll", championId);
		return lineList;
	}
	public Map<Integer, String> summonerSkill(int championId){
		List<Map<String, Integer>> summonerSkillId1List = sqlSession.selectList("champion.summonerSkillId1", championId);
		List<Map<String, Integer>> summonerSkillId2List = sqlSession.selectList("champion.summonerSkillId2", championId);
		//객체로 불러오기
		List<ChampionInfoVO> spellList = sqlSession.selectList("champion.summonerSkillRank", championId);
		int count = 0;
		Map<Integer, String> map = new HashMap<Integer, String>();
		ChampionInfoVO summonerSpellVo;
		for(int i = 0 ; i < spellList.size(); i++) {
			summonerSpellVo = new ChampionInfoVO();
			for(int j = 0; j < spellList.size(); j++) {
				if((spellList.get(i).getSummonerSpell1id() == spellList.get(j).getSummonerSpell2id())&&
				   (spellList.get(i).getSummonerSpell2id() == spellList.get(j).getSummonerSpell1id())) {
						count = spellList.get(i).getCount() + spellList.get(j).getCount();
						map.put(count, String.valueOf(spellList.get(i).getSummonerSpell2id())+","+String.valueOf(spellList.get(i).getSummonerSpell1id()) );
				}
			}
		}
		
		
		Map<String, Integer> summonerSkillSum = new HashMap<String, Integer>();
		
		//순서 정렬
		logger.info("sortSummonerSkill: " + summonerSkillSum);
		return map;
	}

	public List<ChampionInfoVO> championRune(int championId) {
		List<ChampionInfoVO> championPerkList = sqlSession.selectList("champion.championPerk",championId);
		List<ChampionInfoVO> sendChampionPerkList = new ArrayList<ChampionInfoVO>();
		for(int i = 0; i<2; i++) {
			sendChampionPerkList.add(championPerkList.get(i));
		}
		
		return sendChampionPerkList;
	}
	
}
