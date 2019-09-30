package com.kh.yapx3.board.free.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.board.free.model.service.FreeService;
import com.kh.yapx3.board.free.model.vo.Free;
import com.kh.yapx3.board.free.model.vo.FreeAttachment;
import com.kh.yapx3.board.free.model.vo.FreeComment;
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
		int result = sqlSession.insert("free.insertBoard", free);
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

	@Override
	public int freeCommentUp(FreeComment freeComment) {
		return sqlSession.insert("free.freeCommentUp", freeComment);
	}

	@Override
	public List<FreeComment> selectCommentList(int freeBoardNo) {
		return sqlSession.selectList("free.selectCommentList", freeBoardNo);
	}

	@Override
	public int freeCommentDel(int commentNo) {
		return sqlSession.delete("free.freeCommentDel", commentNo);
	}
	
}
