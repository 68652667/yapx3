package com.kh.yapx3.board.summonerJobs.model.service;

import java.util.List;

import com.kh.yapx3.board.summonerJobs.model.vo.ChatRoom;
import com.kh.yapx3.board.summonerJobs.model.vo.summonerJobsChatRoom;
import com.kh.yapx3.board.summonerJobs.model.vo.summonerJobsMsg;

public interface StompService {
	
	List<summonerJobsChatRoom> viewRoom();

	int createRoom(summonerJobsChatRoom chatRoom);

	summonerJobsChatRoom selectRobi(int partnerBoardNo);

	summonerJobsChatRoom findUserEmail(String userEmail);

	List<summonerJobsChatRoom> visitRoom(String roomId);

	summonerJobsChatRoom selectRoom(int boardNo);

	int selectUserId(String userId);

	int boardPersonnelNo(String roomId);

	int updateRoom(summonerJobsChatRoom robiRoom);

	int outRoomboardPersonnelNo(String roomId);

	int deleteRoom(String roomId);

	int checkBoardNo(String roomId);

}
