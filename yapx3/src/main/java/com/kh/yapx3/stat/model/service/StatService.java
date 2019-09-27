package com.kh.yapx3.stat.model.service;

import java.util.List;

import com.kh.yapx3.match.model.vo.Match;
import com.kh.yapx3.stat.model.vo.ChampStat;
import com.kh.yapx3.stat.model.vo.MatchString;

public interface StatService {

	List<ChampStat> selectChampStat();

	List<ChampStat> selectChampPick();

	List<ChampStat> selectChampBan();

	List<ChampStat> selectChampBanB();

	List<ChampStat> selectChampPickB();

	List<ChampStat> selectChampStatB();


}
