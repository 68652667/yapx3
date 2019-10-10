package com.kh.yapx3.champion.model.vo;

import java.sql.Date;

public class ChampionTipBoardVO {
	
	private int champTipNo;
	private int championNo;
	private String userEmail;
	private String userNickName;
	private String champTipContent;
	private String userId;
	private Date champTipDate;
	private int champTipLike;
	private String championTipLikeList;
	private int count;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getChampionTipLikeList() {
		return championTipLikeList;
	}
	public void setChampionTipLikeList(String championTipLikeList) {
		this.championTipLikeList = championTipLikeList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	
		
}