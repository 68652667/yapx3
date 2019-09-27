package com.kh.yapx3.board.free.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.board.free.model.service.FreeService;
import com.kh.yapx3.board.free.model.vo.Free;
import com.kh.yapx3.board.free.model.vo.FreeAttachment;
import com.kh.yapx3.board.free.model.vo.FreeVO;
import com.kh.yapx3.board.free.model.vo.FreeWithFileCount;

@Repository
public class FreeDAOImpl implements FreeDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<FreeWithFileCount> selectFreeList(int cPage) {
		int offset = (cPage-1)*FreeService.NUM_PER_PAGE;
		int limit = FreeService.NUM_PER_PAGE;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("free.selectFreeList",null,rowBounds);
	}

	@Override
	public int insertBoard(Free free) {
		System.out.println("인서트 프리");
		int result = sqlSession.insert("free.insertBoard", free);
		System.out.println(result);
		return result;
	}

	@Override
	public int insertAttachment(FreeAttachment a) {
		return sqlSession.insert("free.insertAttachment", a);
	}

	@Override
	public FreeVO selectFreeOne(int freeBoardNo) {
		return sqlSession.selectOne("free.selectFreeOne", freeBoardNo);
	}
	
}
