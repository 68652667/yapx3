package com.kh.yapx3.board.summonerJobs.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.board.summonerJobs.model.dao.StompDAO;
import com.kh.yapx3.board.summonerJobs.model.vo.summonerJobsChatRoom;

@Service
public class StompServiceImpl implements StompService {

	@Autowired
	StompDAO stomDAO;

	@Override
	public List<summonerJobsChatRoom> viewRoom() {
		return stomDAO.viewRoom();
	}

	@Override
	public int createRoom(summonerJobsChatRoom chatRoom) {
		return stomDAO.createRoom( chatRoom );
	}

	@Override
	public summonerJobsChatRoom selectRobi(int partnerBoardNo) {
		return stomDAO.selectRobi( partnerBoardNo );
	}

	@Override
	public summonerJobsChatRoom findUserEmail(String userEmail) {
		return stomDAO.findUserEmail( userEmail );
	}

	@Override
	public List<summonerJobsChatRoom> visitRoom(String roomId) {
		return stomDAO.visitRoom( roomId );
	}

	@Override
	public summonerJobsChatRoom selectRoom(int boardNo) {
		return stomDAO.selectRoom( boardNo );
	}

	@Override
	public int selectUserId(String userId) {
		return stomDAO.selectUserId(userId);
	}

	@Override
	public int boardPersonnelNo( String roomId ) {
		return stomDAO.boardPersonnelNo( roomId );
	}

	@Override
	public int updateRoom(summonerJobsChatRoom robiRoom) {
		return stomDAO.updateRoom( robiRoom );
	}

	@Override
	public int outRoomboardPersonnelNo(String roomId) {
		return stomDAO.outRoomboardPersonnelNo( roomId );
	}

	@Override
	public int deleteRoom(String roomId) {
		return stomDAO.deleteRoom( roomId );
	}

	@Override
	public int checkBoardNo(String roomId) {
		return stomDAO.checkBoardNo( roomId );
	}

}
