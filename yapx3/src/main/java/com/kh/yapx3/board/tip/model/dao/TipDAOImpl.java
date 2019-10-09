package com.kh.yapx3.board.tip.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.board.tip.model.service.TipService;
import com.kh.yapx3.board.tip.model.vo.Tip;
import com.kh.yapx3.board.tip.model.vo.TipAttachment;
import com.kh.yapx3.board.tip.model.vo.TipComment;
import com.kh.yapx3.board.tip.model.vo.TipVO;
import com.kh.yapx3.board.tip.model.vo.TipWithFileCount;

@Repository
public class TipDAOImpl implements TipDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<TipWithFileCount> selectTipList(int cPage) {
		int offset = (cPage-1)*TipService.NUM_PER_PAGE;
		int limit = TipService.NUM_PER_PAGE;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("tip.selectTipList",null,rowBounds);
	}

	@Override
	public int insertBoard(Tip tip) {
		return sqlSession.insert("tip.insertBoard", tip);
	}

	@Override
	public int insertAttachment(TipAttachment a) {
		return sqlSession.insert("tip.insertAttachment", a);
	}

	@Override
	public TipVO selectTipOne(int tipBoardNo) {
		return sqlSession.selectOne("tip.selectTipOne", tipBoardNo);
	}

	@Override
	public int tipCommentUp(TipComment tipComment) {
		return sqlSession.insert("tip.tipCommentUp", tipComment);
	}

	@Override
	public int tipCommentDel(int commentNo) {
		return sqlSession.delete("tip.tipCommentDel", commentNo);
	}

	@Override
	public List<TipComment> selectCommentList(int tipBoardNo) {
		return sqlSession.selectList("tip.selectCommentList", tipBoardNo);
	}

	@Override
	public List<TipWithFileCount> selectTipMyList(String memberId) {
		return sqlSession.selectList("tip.selectTipMyList",memberId);
	}
	
}
