package com.kh.yapx3.champion.model.vo;

public class ChampionKoN {
	
	private int championKey;
	private String championName;
	private String championId;
	private String lane1;
	private String lane2;
	public ChampionKoN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChampionKoN(int championKey, String championName, String championId, String lane1, String lane2) {
		super();
		this.championKey = championKey;
		this.championName = championName;
		this.championId = championId;
		this.lane1 = lane1;
		this.lane2 = lane2;
	}
	public int getChampionKey() {
		return championKey;
	}
	public void setChampionKey(int championKey) {
		this.championKey = championKey;
	}
	public String getChampionName() {
		return championName;
	}
	public void setChampionName(String championName) {
		this.championName = championName;
	}
	public String getChampionId() {
		return championId;
	}
	public void setChampionId(String championId) {
		this.championId = championId;
	}
	public String getLane1() {
		return lane1;
	}
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	public String getLane2() {
		return lane2;
	}
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	
	
	
	

}
