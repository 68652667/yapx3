package com.kh.yapx3.match.model.vo;

public class SortChampionVo {

	private String championId;
	private int key;
	private String championName;
	public String getChampionId() {
		return championId;
	}
	public void setChampionId(String championId) {
		this.championId = championId;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getChampionName() {
		return championName;
	}
	public void setChampionName(String championName) {
		this.championName = championName;
	}
	public SortChampionVo(String championId, int key, String championName) {
		super();
		this.championId = championId;
		this.key = key;
		this.championName = championName;
	}
	
	
	
}
