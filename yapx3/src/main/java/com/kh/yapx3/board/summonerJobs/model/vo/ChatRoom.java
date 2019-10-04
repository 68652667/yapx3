package com.kh.yapx3.board.summonerJobs.model.vo;

import java.util.Date;

public class ChatRoom {
	
	private String roomId;
	private String userEmail;
	private String chatContent;
	private String userKey;
	private String summonerNickname;
	private Date sendDate;
	
	public ChatRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatRoom(String roomId, String userEmail, String chatContent, String userKey, String summonerNickname,
			Date sendDate) {
		super();
		this.roomId = roomId;
		this.userEmail = userEmail;
		this.chatContent = chatContent;
		this.userKey = userKey;
		this.summonerNickname = summonerNickname;
		this.sendDate = sendDate;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getSummonerNickname() {
		return summonerNickname;
	}

	public void setSummonerNickname(String summonerNickname) {
		this.summonerNickname = summonerNickname;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	@Override
	public String toString() {
		return "ChatRoom [roomId=" + roomId + ", userEmail=" + userEmail + ", chatContent=" + chatContent + ", userKey="
				+ userKey + ", summonerNickname=" + summonerNickname + ", sendDate=" + sendDate + "]";
	}
	
	
}
