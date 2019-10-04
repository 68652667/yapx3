package com.kh.yapx3.champion.model.matchline;

public class MatchVO {

	private String accountId;
	private String lane;
	private int championId;
	private String gameId;
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String summonerName) {
		this.accountId = summonerName;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	
}
