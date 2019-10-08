package com.kh.yapx3.board.gontip.model.dao;

import java.util.List;

import com.kh.yapx3.board.gontip.model.vo.Gontip;

public interface GontipDAO {

	List<Gontip> selectGontipList(int cPage);

}
