package com.kh.yapx3.board.gontip.model.vo;

import java.sql.Date;

public class GontipComment {
	
	private int commentNo;
	private int gontipBoardNo;
	private String userEmail;
	private String userNickname;
	private String commentContent;
	private Date date;
	private int commentLevel;
	private int commentRef;
	
	public GontipComment() {}

	public GontipComment(int commentNo, int gontipBoardNo, String userEmail, String userNickname, String commentContent,
			Date date, int commentLevel, int commentRef) {
		super();
		this.commentNo = commentNo;
		this.gontipBoardNo = gontipBoardNo;
		this.userEmail = userEmail;
		this.userNickname = userNickname;
		this.commentContent = commentContent;
		this.date = date;
		this.commentLevel = commentLevel;
		this.commentRef = commentRef;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getGontipBoardNo() {
		return gontipBoardNo;
	}

	public void setGontipBoardNo(int gontipBoardNo) {
		this.gontipBoardNo = gontipBoardNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	public int getCommentRef() {
		return commentRef;
	}

	public void setCommentRef(int commentRef) {
		this.commentRef = commentRef;
	}

}
