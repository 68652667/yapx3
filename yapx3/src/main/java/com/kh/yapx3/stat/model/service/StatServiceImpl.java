package com.kh.yapx3.stat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.match.model.vo.Match;
import com.kh.yapx3.stat.model.dao.StatDAO;
import com.kh.yapx3.stat.model.vo.ChampStat;
import com.kh.yapx3.stat.model.vo.MatchString;

@Service
public class StatServiceImpl implements StatService {
	
	@Autowired
	StatDAO statDAO;

	@Override
	public List<ChampStat> selectChampStat() {
		return statDAO.selectChampStat();
	}

	@Override
	public List<ChampStat> selectChampPick() {
		return statDAO.selectChampPick();
	}

	@Override
	public List<ChampStat> selectChampBan() {
		return statDAO.selectChampBan();
	}

	@Override
	public List<ChampStat> selectChampBanB() {
		return statDAO.selectChampBanB();
	}

	@Override
	public List<ChampStat> selectChampPickB() {
		return statDAO.selectChampPickB();
	}

	@Override
	public List<ChampStat> selectChampStatB() {
		return statDAO.selectChampStatB();
	}


}
