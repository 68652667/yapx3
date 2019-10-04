package com.kh.yapx3.board.summonerJobs.model.vo;

public class summonerJobsChatRoom {
	private int partnerBoardNo;
	private String userEmail;
	private String roomId;
	private String partnerBoardTitle;
	private String userNickname;
	private String summonerNickname;
	private String summonerTier;
	private int partnerBoardMaxno;
	private int boardPersonnelNo;
	private String chatContent;
	private String expulisionList;
	private String leaderYn;
	private String finishYn;
	
	public summonerJobsChatRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public summonerJobsChatRoom(int partnerBoardNo, String userEmail, String roomId, String partnerBoardTitle,
			String userNickname, String summonerNickname, String summonerTier, int partnerBoardMaxno,
			int boardPersonnelNo, String chatContent, String expulisionList, String leaderYn, String finishYn) {
		super();
		this.partnerBoardNo = partnerBoardNo;
		this.userEmail = userEmail;
		this.roomId = roomId;
		this.partnerBoardTitle = partnerBoardTitle;
		this.userNickname = userNickname;
		this.summonerNickname = summonerNickname;
		this.summonerTier = summonerTier;
		this.partnerBoardMaxno = partnerBoardMaxno;
		this.boardPersonnelNo = boardPersonnelNo;
		this.chatContent = chatContent;
		this.expulisionList = expulisionList;
		this.leaderYn = leaderYn;
		this.finishYn = finishYn;
	}

	public int getPartnerBoardNo() {
		return partnerBoardNo;
	}

	public void setPartnerBoardNo(int partnerBoardNo) {
		this.partnerBoardNo = partnerBoardNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getPartnerBoardTitle() {
		return partnerBoardTitle;
	}

	public void setPartnerBoardTitle(String partnerBoardTitle) {
		this.partnerBoardTitle = partnerBoardTitle;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getSummonerNickname() {
		return summonerNickname;
	}

	public void setSummonerNickname(String summonerNickname) {
		this.summonerNickname = summonerNickname;
	}

	public String getSummonerTier() {
		return summonerTier;
	}

	public void setSummonerTier(String summonerTier) {
		this.summonerTier = summonerTier;
	}

	public int getPartnerBoardMaxno() {
		return partnerBoardMaxno;
	}

	public void setPartnerBoardMaxno(int partnerBoardMaxno) {
		this.partnerBoardMaxno = partnerBoardMaxno;
	}

	public int getBoardPersonnelNo() {
		return boardPersonnelNo;
	}

	public void setBoardPersonnelNo(int boardPersonnelNo) {
		this.boardPersonnelNo = boardPersonnelNo;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public String getExpulisionList() {
		return expulisionList;
	}

	public void setExpulisionList(String expulisionList) {
		this.expulisionList = expulisionList;
	}

	public String getLeaderYn() {
		return leaderYn;
	}

	public void setLeaderYn(String leaderYn) {
		this.leaderYn = leaderYn;
	}

	public String getFinishYn() {
		return finishYn;
	}

	public void setFinishYn(String finishYn) {
		this.finishYn = finishYn;
	}

	@Override
	public String toString() {
		return "summonerJobsChatRoom [partnerBoardNo=" + partnerBoardNo + ", userEmail=" + userEmail + ", roomId="
				+ roomId + ", partnerBoardTitle=" + partnerBoardTitle + ", userNickname=" + userNickname
				+ ", summonerNickname=" + summonerNickname + ", summonerTier=" + summonerTier + ", partnerBoardMaxno="
				+ partnerBoardMaxno + ", boardPersonnelNo=" + boardPersonnelNo + ", chatContent=" + chatContent
				+ ", expulisionList=" + expulisionList + ", leaderYn=" + leaderYn + ", finishYn=" + finishYn + "]";
	}
	
	
}
