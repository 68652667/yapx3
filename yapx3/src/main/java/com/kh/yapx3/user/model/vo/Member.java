package com.kh.yapx3.user.model.vo;

import java.sql.Date;

public class Member {
	
	private String userEmail;
	private String userNickname;
	private int userCode;
	private String userActivationKey;
	private String userPassword;
	private Date userEnrollDate;
	private String favoriteSummoner;
	private String favoriteChampion;
	private String userYn;
	
	
	public Member(String userEmail, String userNickname, int userCode, String userActivationKey, String userPassword,
			Date userEnrollDate, String favoriteSummoner, String favoriteChampion, String userYn) {
		super();
		this.userEmail = userEmail;
		this.userNickname = userNickname;
		this.userCode = userCode;
		this.userActivationKey = userActivationKey;
		this.userPassword = userPassword;
		this.userEnrollDate = userEnrollDate;
		this.favoriteSummoner = favoriteSummoner;
		this.favoriteChampion = favoriteChampion;
		this.userYn = userYn;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserYn() {
		return userYn;
	}

	public void setUserYn(String userYn) {
		this.userYn = userYn;
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

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getUserActivationKey() {
		return userActivationKey;
	}

	public void setUserActivationKey(String userActivationKey) {
		this.userActivationKey = userActivationKey;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getUserEnrollDate() {
		return userEnrollDate;
	}

	public void setUserEnrollDate(Date userEnrollDate) {
		this.userEnrollDate = userEnrollDate;
	}

	public String getFavoriteSummoner() {
		return favoriteSummoner;
	}

	public void setFavoriteSummoner(String favoriteSummoner) {
		this.favoriteSummoner = favoriteSummoner;
	}

	public String getFavoriteChampion() {
		return favoriteChampion;
	}

	public void setFavoriteChampion(String favoriteChampion) {
		this.favoriteChampion = favoriteChampion;
	}

	@Override
	public String toString() {
		return "Member [userEmail=" + userEmail + ", userNickname=" + userNickname + ", userCode=" + userCode
				+ ", userActivationKey=" + userActivationKey + ", userPassword=" + userPassword + ", userEnrollDate="
				+ userEnrollDate + ", favoriteSummoner=" + favoriteSummoner + ", favoriteChampion=" + favoriteChampion
				+ ", userYn=" + userYn + "]";
	}

	
	
	
}
