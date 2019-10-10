package com.kh.yapx3.board.free.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<FreeWithFileCount> selectFreeMyList(String memberId) {
		return sqlSession.selectList("free.selectFreeMyList", memberId );
	}

	@Override
	public Object increaseReadCount(int freeBoardNo) {
		return sqlSession.update("free.increaseReadCount", freeBoardNo);
	}

	@Override
	public String likeUserList(String freeboardNo) {
		return sqlSession.selectOne("free.likeUserList", freeboardNo);
	}

	@Override
	public void likeincrease(String userEmail, String freeboardNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userEmail", userEmail);
		map.put("freeboardNo", freeboardNo);
		sqlSession.update("free.likeincrease", map);
	}

	@Override
	public void likeincrease2(String likeUserList, String freeboardNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("likeUserList", likeUserList);
		map.put("freeboardNo", freeboardNo);
		sqlSession.update("free.likeincrease2", map);
	}

	@Override
	public void deleteList(String likeUserList, String freeboardNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("likeUserList", likeUserList);
		map.put("freeboardNo", freeboardNo);
		sqlSession.update("free.deleteList", map);
	}

	@Override
	public int likeValue(String freeboardNo) {
		return sqlSession.selectOne("free.likeValue", freeboardNo);
	}

	@Override
	public int selectFreeTotal() {
		return sqlSession.selectOne( "free.selectFreeTotal" );
	}

	@Override
	public int selectCommentNumber(int freeBoardNo) {
		return sqlSession.selectOne("free.selectCommentNumber", freeBoardNo);
	}
	
}
