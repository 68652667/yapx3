package com.kh.yapx3.board.tip.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public int updateTip(TipVO tip) {
		return sqlSession.update("tip.updateTip", tip);
	}

	@Override
	public int selectTipTotal() {
		return sqlSession.selectOne("tip.selectTipTotal");
	}

	@Override
	public int selectCommentNumber(int tipBoardNo) {
		return sqlSession.selectOne("tip.selectCommentNumber", tipBoardNo);
	}

	@Override
	public String likeUserList(String tipboardNo) {
		return sqlSession.selectOne("tip.likeUserList", tipboardNo);
	}

	@Override
	public void likeincrease(String userEmail, String tipboardNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userEmail", userEmail);
		map.put("tipboardNo", tipboardNo);
		sqlSession.update("tip.likeincrease", map);
	}

	@Override
	public void likeincrease2(String likeUserList, String tipboardNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("likeUserList", likeUserList);
		map.put("tipboardNo", tipboardNo);
		sqlSession.update("tip.likeincrease2", map);
	}

	@Override
	public void deleteLike(String likeUserList, String tipboardNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("likeUserList", likeUserList);
		map.put("tipboardNo", tipboardNo);
		sqlSession.update("tip.deleteList", map);
	}

	@Override
	public int likeValue(String tipboardNo) {
		return sqlSession.selectOne("tip.likeValue", tipboardNo);
	}

	@Override
	public int tipDel(int tipBoardNo) {
		return sqlSession.delete("tip.tipDel", tipBoardNo);
	}
	
}
