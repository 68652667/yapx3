package com.kh.yapx3.board.tip.model.vo;

import java.sql.Date;

public class Tip {
	
	protected int tipBoardNo;
	protected String userEmail;
	protected String tipBoardTitle;
	protected String userNickName;
	protected String tipBoardContent;
	protected Date tipBoardDate;
	protected int tipBoardViews;
	protected int tipBoardLike;
	protected String tipBoardLikeList;
	protected String YL;
	
	public Tip() {
		
	}

	public Tip(int tipBoardNo, String userEmail, String tipBoardTitle, String userNickName, String tipBoardContent,
			Date tipBoardDate, int tipBoardViews, int tipBoardLike, String tipBoardLikeList, String yL) {
		super();
		this.tipBoardNo = tipBoardNo;
		this.userEmail = userEmail;
		this.tipBoardTitle = tipBoardTitle;
		this.userNickName = userNickName;
		this.tipBoardContent = tipBoardContent;
		this.tipBoardDate = tipBoardDate;
		this.tipBoardViews = tipBoardViews;
		this.tipBoardLike = tipBoardLike;
		this.tipBoardLikeList = tipBoardLikeList;
		YL = yL;
	}

	public int getTipBoardNo() {
		return tipBoardNo;
	}

	public void setTipBoardNo(int tipBoardNo) {
		this.tipBoardNo = tipBoardNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getTipBoardTitle() {
		return tipBoardTitle;
	}

	public void setTipBoardTitle(String tipBoardTitle) {
		this.tipBoardTitle = tipBoardTitle;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getTipBoardContent() {
		return tipBoardContent;
	}

	public void setTipBoardContent(String tipBoardContent) {
		this.tipBoardContent = tipBoardContent;
	}

	public Date getTipBoardDate() {
		return tipBoardDate;
	}

	public void setTipBoardDate(Date tipBoardDate) {
		this.tipBoardDate = tipBoardDate;
	}

	public int getTipBoardViews() {
		return tipBoardViews;
	}

	public void setTipBoardViews(int tipBoardViews) {
		this.tipBoardViews = tipBoardViews;
	}

	public int getTipBoardLike() {
		return tipBoardLike;
	}

	public void setTipBoardLike(int tipBoardLike) {
		this.tipBoardLike = tipBoardLike;
	}

	public String getTipBoardLikeList() {
		return tipBoardLikeList;
	}

	public void setTipBoardLikeList(String tipBoardLikeList) {
		this.tipBoardLikeList = tipBoardLikeList;
	}

	public String getYL() {
		return YL;
	}

	public void setYL(String yL) {
		YL = yL;
	}

	@Override
	public String toString() {
		return "{ tipBoardNo:\"" + tipBoardNo + "\", userEmail:\"" + userEmail + "\", tipBoardTitle:\"" + tipBoardTitle
				+ "\", userNickName:\"" + userNickName + "\", tipBoardContent:\"" + tipBoardContent
				+ "\", tipBoardDate:\"" + tipBoardDate + "\", tipBoardViews:\"" + tipBoardViews + "\", tipBoardLike:\""
				+ tipBoardLike + "\", tipBoardLikeList:\"" + tipBoardLikeList + "\", YL:\"" + YL + "}";
	}

	
}
