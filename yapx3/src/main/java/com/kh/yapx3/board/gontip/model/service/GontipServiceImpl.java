package com.kh.yapx3.board.gontip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.board.gontip.model.dao.GontipDAO;
import com.kh.yapx3.board.gontip.model.vo.Gontip;

@Service
public class GontipServiceImpl implements GontipService {

	@Autowired
	GontipDAO gontipDAO;

	@Override
	public List<Gontip> selectGontipList(int cPage) {
		return gontipDAO.selectGontipList(cPage);
	}
	
}
