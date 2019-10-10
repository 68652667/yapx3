package com.kh.yapx3.champion.model.vo;

import java.sql.Date;

public class ChampionTipBoardVO {
	
	private int champTipNo;
	private int championNo;
	private String userEmail;
	private String userNickName;
	private String champTipContent;
	private Date champTipDate;
	private int champTipLike;
	private String champiTipLikeList;
	private int count;
	public ChampionTipBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChampionTipBoardVO(int champTipNo, int championNo, String userEmail, String userNickName,
			String champTipContent, Date champTipDate, int champTipLike, String champiTipLikeList, int count) {
		super();
		this.champTipNo = champTipNo;
		this.championNo = championNo;
		this.userEmail = userEmail;
		this.userNickName = userNickName;
		this.champTipContent = champTipContent;
		this.champTipDate = champTipDate;
		this.champTipLike = champTipLike;
		this.champiTipLikeList = champiTipLikeList;
		this.count = count;
	}
	public int getChampTipNo() {
		return champTipNo;
	}
	public void setChampTipNo(int champTipNo) {
		this.champTipNo = champTipNo;
	}
	public int getChampionNo() {
		return championNo;
	}
	public void setChampionNo(int championNo) {
		this.championNo = championNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getChampTipContent() {
		return champTipContent;
	}
	public void setChampTipContent(String champTipContent) {
		this.champTipContent = champTipContent;
	}
	public Date getChampTipDate() {
		return champTipDate;
	}
	public void setChampTipDate(Date champTipDate) {
		this.champTipDate = champTipDate;
	}
	public int getChampTipLike() {
		return champTipLike;
	}
	public void setChampTipLike(int champTipLike) {
		this.champTipLike = champTipLike;
	}
	public String getChampiTipLikeList() {
		return champiTipLikeList;
	}
	public void setChampiTipLikeList(String champiTipLikeList) {
		this.champiTipLikeList = champiTipLikeList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	
}
