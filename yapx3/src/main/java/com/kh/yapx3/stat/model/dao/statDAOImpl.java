package com.kh.yapx3.stat.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.match.model.vo.Match;
import com.kh.yapx3.stat.model.vo.ChampStat;
import com.kh.yapx3.stat.model.vo.MatchString;

@Repository
public class statDAOImpl implements StatDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<ChampStat> selectChampStat() {
		return sqlSession.selectList("stat.selectChampStat");
	}

	@Override
	public List<ChampStat> selectChampPick() {
		return sqlSession.selectList("stat.selectChampPick");
	}

	@Override
	public List<ChampStat> selectChampBan() {
		return sqlSession.selectList("stat.selectChampBan");
	}

	@Override
	public List<ChampStat> selectChampBanB() {
		return sqlSession.selectList("stat.selectChampBanB");
	}

	@Override
	public List<ChampStat> selectChampPickB() {
		return sqlSession.selectList("stat.selectChampPickB");
	}

	@Override
	public List<ChampStat> selectChampStatB() {
		return sqlSession.selectList("stat.selectChampStatB");
	}

}
