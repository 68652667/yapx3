package com.kh.yapx3.board.gontip.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.board.gontip.model.service.GontipService;
import com.kh.yapx3.board.gontip.model.vo.Gontip;

@Repository
public class GontipDAOImpl implements GontipDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Gontip> selectGontipList(int cPage) {
		int offset = (cPage-1)*GontipService.NUM_PER_PAGE;
		int limit = GontipService.NUM_PER_PAGE;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("gontip.selectGontipList",null,rowBounds);
	}
	
}
