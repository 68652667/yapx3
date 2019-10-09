package com.kh.yapx3.ranking.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Repository
public class RankingDAOImpl implements RankingDAO {
	
	JSONParser jsonParser = new JSONParser();

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Map<String, String>> result(String champName) {
		
		return sqlSession.selectList("ranking.champmaster", champName);
	}

}
