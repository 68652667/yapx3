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
import com.kh.yapx3.champion.model.vo.ChampionTipBoardVO;

@Repository
public class ChampionDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	

	public int championTipInsert(ChampionTipBoardVO tipBoard) {
		return sqlSession.insert("champion.championTipInsert", tipBoard);
	}



	public List<ChampionTipBoardVO> championGetTipList(int championId) {
		List<ChampionTipBoardVO> tipList = sqlSession.selectList("champion.championTipList", championId);
		return tipList;
	}



	public int championTipLike(ChampionTipBoardVO tip) {
		return sqlSession.update("champion.championTipLike", tip);
	}
	
}
