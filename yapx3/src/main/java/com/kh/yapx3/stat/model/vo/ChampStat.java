package com.kh.yapx3.stat.model.vo;

public class ChampStat {
	
	private int championNo;
	private String championName;
	private int pick;
	private int ban;
	private int win;
	private int lose;
	
	public ChampStat() {}

	public ChampStat(int championNo, String championName, int pick, int ban, int win, int lose) {
		super();
		this.championNo = championNo;
		this.championName = championName;
		this.pick = pick;
		this.ban = ban;
		this.win = win;
		this.lose = lose;
	}

	public int getChampionNo() {
		return championNo;
	}

	public void setChampionNo(int championNo) {
		this.championNo = championNo;
	}

	public String getChampionName() {
		return championName;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public int getPick() {
		return pick;
	}

	public void setPick(int pick) {
		this.pick = pick;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	@Override
	public String toString() {
		return "{ championNo:\"" + championNo + "\", championName:\"" + championName + "\", pick:\"" + pick
				+ "\", ban:\"" + ban + "\", win:\"" + win + "\", lose:\"" + lose + "}";
	}
	
	

}
