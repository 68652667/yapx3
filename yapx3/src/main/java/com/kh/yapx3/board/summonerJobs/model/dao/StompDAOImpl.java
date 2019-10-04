package com.kh.yapx3.board.summonerJobs.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.board.summonerJobs.model.vo.ChatRoom;
import com.kh.yapx3.board.summonerJobs.model.vo.summonerJobsChatRoom;
import com.kh.yapx3.board.summonerJobs.model.vo.summonerJobsMsg;

@Repository
public class StompDAOImpl implements StompDAO {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<summonerJobsChatRoom> viewRoom() {
		
		List<summonerJobsChatRoom> rlist = sqlSession.selectList("summonerjobschatroom.viewRoom");
		logger.info("rlist={}", rlist);
		
		return rlist;
	}

	@Override
	public int createRoom(summonerJobsChatRoom chatRoom) {
		
		logger.info("chatRoom={}", chatRoom);
		
		return sqlSession.insert("summonerjobschatroom.createRoom", chatRoom);
	}

	@Override
	public summonerJobsChatRoom selectRobi(int partnerBoardNo) {
		return sqlSession.selectOne("summonerjobschatroom.selectRobi", partnerBoardNo);
	}

	@Override
	public summonerJobsChatRoom findUserEmail(String userEmail) {
		return sqlSession.selectOne("summonerjobschatroom.findUserEmail", userEmail);
	}

	@Override
	public List<summonerJobsChatRoom> visitRoom(String roomId) {
		return sqlSession.selectList("summonerjobschatroom.visitRoom", roomId);
	}

	@Override
	public summonerJobsChatRoom selectRoom(int boardNo) {
		return sqlSession.selectOne("summonerjobschatroom.selectRoom", boardNo);
		
	}
	
	@Override
	public int selectUserId(String userId) {
		return sqlSession.selectOne("summonerjobschatroom.selectUserId", userId);
	}

	@Override
	public int boardPersonnelNo( String roomId ) {
		return sqlSession.update("summonerjobschatroom.boardPersonnelNo", roomId);
	}

	@Override
	public int updateRoom(summonerJobsChatRoom robiRoom) {
		
		logger.info("robiRoom={}", robiRoom);
		
		return sqlSession.update("summonerjobschatroom.updateRoom", robiRoom);
	}

	@Override
	public int outRoomboardPersonnelNo(String roomId) {
		return sqlSession.update("summonerjobschatroom.outRoomboardPersonnelNo", roomId);
	}

	@Override
	public int deleteRoom(String roomId) {
		return sqlSession.update("summonerjobschatroom.deleteRoom", roomId);
	}

	@Override
	public int checkBoardNo(String roomId) {
		return sqlSession.selectOne("summonerjobschatroom.checkBoardNo", roomId);
	}


}
