package com.kh.yapx3.board.gontip.model.service;

import java.util.List;

import com.kh.yapx3.board.gontip.model.vo.Gontip;

public interface GontipService {

	int NUM_PER_PAGE = 10;
	
	List<Gontip> selectGontipList(int cPage);

}
