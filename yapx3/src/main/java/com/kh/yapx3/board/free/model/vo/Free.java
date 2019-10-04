package com.kh.yapx3.board.free.model.vo;

import java.sql.Date;

public class Free {
	
	protected int freeBoardNo;
	protected String userEmail;
	protected String freeBoardTitle;
	protected String userNickName;
	protected String freeBoardContent;
	protected Date freeBoardDate;
	protected int freeBoardViews;
	protected int freeBoardLike;
	protected String freeBoardLikeList;
	protected String YL;
	
	public Free() {
		
	}

	public int getFreeBoardNo() {
		return freeBoardNo;
	}

	public void setFreeBoardNo(int freeBoardNo) {
		this.freeBoardNo = freeBoardNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFreeBoardTitle() {
		return freeBoardTitle;
	}

	public void setFreeBoardTitle(String freeBoardTitle) {
		this.freeBoardTitle = freeBoardTitle;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getFreeBoardContent() {
		return freeBoardContent;
	}

	public void setFreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}

	public Date getFreeBoardDate() {
		return freeBoardDate;
	}

	public void setFreeBoardDate(Date freeBoardDate) {
		this.freeBoardDate = freeBoardDate;
	}

	public int getFreeBoardViews() {
		return freeBoardViews;
	}

	public void setFreeBoardViews(int freeBoardViews) {
		this.freeBoardViews = freeBoardViews;
	}

	public int getFreeBoardLike() {
		return freeBoardLike;
	}

	public void setFreeBoardLike(int freeBoardLike) {
		this.freeBoardLike = freeBoardLike;
	}

	public String getFreeBoardLikeList() {
		return freeBoardLikeList;
	}

	public void setFreeBoardLikeList(String freeBoardLikeList) {
		this.freeBoardLikeList = freeBoardLikeList;
	}

	public Free(int freeBoardNo, String userEmail, String freeBoardTitle, String userNickName, String freeBoardContent,
			Date freeBoardDate, int freeBoardViews, int freeBoardLike, String freeBoardLikeList, String YL) {
		super();
		this.freeBoardNo = freeBoardNo;
		this.userEmail = userEmail;
		this.freeBoardTitle = freeBoardTitle;
		this.userNickName = userNickName;
		this.freeBoardContent = freeBoardContent;
		this.freeBoardDate = freeBoardDate;
		this.freeBoardViews = freeBoardViews;
		this.freeBoardLike = freeBoardLike;
		this.freeBoardLikeList = freeBoardLikeList;
		this.YL = YL;
	}

	public String getYL() {
		return YL;
	}

	public void setYL(String yL) {
		YL = yL;
	}

	@Override
	public String toString() {
		return "{ freeBoardNo:\"" + freeBoardNo + "\", userEmail:\"" + userEmail + "\", freeBoardTitle:\""
				+ freeBoardTitle + "\", userNickName:\"" + userNickName + "\", freeBoardContent:\"" + freeBoardContent
				+ "\", freeBoardDate:\"" + freeBoardDate + "\", freeBoardViews:\"" + freeBoardViews
				+ "\", freeBoardLike:\"" + freeBoardLike + "\", freeBoardLikeList:\"" + freeBoardLikeList + "\", YL:\""
				+ YL + "}";
	}


}
