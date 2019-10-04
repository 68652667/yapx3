package com.kh.yapx3.ranking.model.vo;

public class Ranking {
	
	private int rank;
	private String summonerName;
	private String playNumber;
	
	public Ranking() {}

	public Ranking(int rank, String summonerName, String playNumber) {
		super();
		this.rank = rank;
		this.summonerName = summonerName;
		this.playNumber = playNumber;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public String getPlayNumber() {
		return playNumber;
	}

	public void setPlayNumber(String playNumber) {
		this.playNumber = playNumber;
	}

	@Override
	public String toString() {
		return "Ranking [rank=" + rank + ", summonerName=" + summonerName + ", playNumber=" + playNumber + "]";
	}
}
