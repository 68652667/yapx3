package com.kh.yapx3.stat.model.vo;

public class Champ extends ChampStat {
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Champ() {}

	public Champ(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "{ id:\"" + id + "\", getChampionNo():\"" + getChampionNo() + "\", getChampionName():\""
				+ getChampionName() + "\", getPick():\"" + getPick() + "\", getBan():\"" + getBan() + "\", getWin():\""
				+ getWin() + "\", getLose():\"" + getLose() + "\"}";
	}
	

}
