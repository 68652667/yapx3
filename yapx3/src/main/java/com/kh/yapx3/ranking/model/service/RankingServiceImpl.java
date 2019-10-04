package com.kh.yapx3.ranking.model.service;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.ranking.model.dao.RankingDAO;

@Service
public class RankingServiceImpl implements RankingService {

	@Autowired
	RankingDAO rankingDAO;
	
	@Override
	public List<Map<String, String>> result(String champName) {
		return rankingDAO.result(champName);
	}

}
