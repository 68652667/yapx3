package com.kh.yapx3.board.gontip.model.vo;

import java.sql.Date;

public class Gontip {
	
	@Override
	public String toString() {
		return "{ gontipBoardNo:\"" + gontipBoardNo + "\", userEmail:\"" + userEmail + "\", gontipBoardTitle:\""
				+ gontipBoardTitle + "\", userNickName:\"" + userNickName + "\", champion:\"" + champion
				+ "\", header:\"" + header + "\", rune:\"" + rune + "\", spells:\"" + spells + "\", skills:\"" + skills
				+ "\", items:\"" + items + "\", countersEasy:\"" + countersEasy + "\", countersHard:\"" + countersHard
				+ "\", gontipBoardContent:\"" + gontipBoardContent + "\", gontipBoardDate:\"" + gontipBoardDate
				+ "\", gontipBoardViews:\"" + gontipBoardViews + "\", gontipBoardLike:\"" + gontipBoardLike
				+ "\", gontipBoardLikeList:\"" + gontipBoardLikeList + "}";
	}

	protected int gontipBoardNo;
	protected String userEmail;
	protected String gontipBoardTitle;
	protected String userNickName;
	protected String champion;
	protected String header;
	protected String rune;
	protected String spells;
	protected String skills;
	protected String items;
	protected String countersEasy;
	protected String countersHard;
	protected String gontipBoardContent;
	protected Date gontipBoardDate;
	protected int gontipBoardViews;
	protected int gontipBoardLike;
	protected String gontipBoardLikeList;
	
	public Gontip() {
		
	}

	public Gontip(int gontipBoardNo, String userEmail, String gontipBoardTitle, String userNickName, String champion,
			String header, String rune, String spells, String skills, String items, String countersEasy,
			String countersHard, String gontipBoardContent, Date gontipBoardDate, int gontipBoardViews,
			int gontipBoardLike, String gontipBoardLikeList) {
		super();
		this.gontipBoardNo = gontipBoardNo;
		this.userEmail = userEmail;
		this.gontipBoardTitle = gontipBoardTitle;
		this.userNickName = userNickName;
		this.champion = champion;
		this.header = header;
		this.rune = rune;
		this.spells = spells;
		this.skills = skills;
		this.items = items;
		this.countersEasy = countersEasy;
		this.countersHard = countersHard;
		this.gontipBoardContent = gontipBoardContent;
		this.gontipBoardDate = gontipBoardDate;
		this.gontipBoardViews = gontipBoardViews;
		this.gontipBoardLike = gontipBoardLike;
		this.gontipBoardLikeList = gontipBoardLikeList;
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

	public String getGontipBoardTitle() {
		return gontipBoardTitle;
	}

	public void setGontipBoardTitle(String gontipBoardTitle) {
		this.gontipBoardTitle = gontipBoardTitle;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getRune() {
		return rune;
	}

	public void setRune(String rune) {
		this.rune = rune;
	}

	public String getSpells() {
		return spells;
	}

	public void setSpells(String spells) {
		this.spells = spells;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getCountersEasy() {
		return countersEasy;
	}

	public void setCountersEasy(String countersEasy) {
		this.countersEasy = countersEasy;
	}

	public String getCountersHard() {
		return countersHard;
	}

	public void setCountersHard(String countersHard) {
		this.countersHard = countersHard;
	}

	public String getGontipBoardContent() {
		return gontipBoardContent;
	}

	public void setGontipBoardContent(String gontipBoardContent) {
		this.gontipBoardContent = gontipBoardContent;
	}

	public Date getGontipBoardDate() {
		return gontipBoardDate;
	}

	public void setGontipBoardDate(Date gontipBoardDate) {
		this.gontipBoardDate = gontipBoardDate;
	}

	public int getGontipBoardViews() {
		return gontipBoardViews;
	}

	public void setGontipBoardViews(int gontipBoardViews) {
		this.gontipBoardViews = gontipBoardViews;
	}

	public int getGontipBoardLike() {
		return gontipBoardLike;
	}

	public void setGontipBoardLike(int gontipBoardLike) {
		this.gontipBoardLike = gontipBoardLike;
	}

	public String getGontipBoardLikeList() {
		return gontipBoardLikeList;
	}

	public void setGontipBoardLikeList(String gontipBoardLikeList) {
		this.gontipBoardLikeList = gontipBoardLikeList;
	}
	
	
}
