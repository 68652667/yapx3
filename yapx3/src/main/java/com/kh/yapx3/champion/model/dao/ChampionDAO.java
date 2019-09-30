package com.kh.yapx3.champion.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		return championLineTop;
	}

	public int championLineBottom(int championId) {
		int championLineBottom = sqlSession.selectOne("champion.championLineBottom", championId);
		return championLineBottom;
	}

	public List<Integer> championLine(int championId) {
		List<Integer> championLine = new ArrayList<Integer>();
		Map<String, Integer> championMap = new HashMap<String, Integer>();
		for(int i = 0; i < 5; i ++) {
			switch (i) {
			case 0:
				championMap.put("TOP", championId);
				championLine.add(sqlSession.selectOne("champion.championLine", championMap));
				break;
			case 1:
				championMap.put("BOTTOM", championId);
				championLine.add(sqlSession.selectOne("champion.championLine", championMap));
				break;
			case 2:
				championMap.put("NONE", championId);
				championLine.add(sqlSession.selectOne("champion.championLine", championMap));
				break;
			case 3:
				championMap.put("MIDDLE", championId);
				championLine.add(sqlSession.selectOne("champion.championLine", championMap));
				break;
			case 4:
				championMap.put("JUNGLE", championId);
				championLine.add(sqlSession.selectOne("champion.championLine", championMap));
				break;
			default:
				break;
			}
		}
		return null;
	}

	
}
