package com.kh.yapx3.board.free.model.vo;

import java.sql.Date;

public class FreeComment {
	
	private int commentNo;
	private int freeBoardNo;
	private String userEmail;
	private String userNickname;
	private String commentContent;
	private Date date;
	private int commentLevel;
	private int commentRef;
	
	public FreeComment() {}

	public FreeComment(int commentNo, int freeBoardNo, String userEmail, String userNickname, String commentContent,
			Date date, int commentLevel, int commentRef) {
		super();
		this.commentNo = commentNo;
		this.freeBoardNo = freeBoardNo;
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

	@Override
	public String toString() {
		return "{ commentNo:\"" + commentNo + "\", freeBoardNo:\"" + freeBoardNo + "\", userEmail:\"" + userEmail
				+ "\", userNickname:\"" + userNickname + "\", commentContent:\"" + commentContent + "\", date:\"" + date
				+ "\", commentLevel:\"" + commentLevel + "\", commentRef:\"" + commentRef + "}";
	}

}
