package com.kh.yapx3.search.model.vo;

import org.json.JSONArray;
import org.json.JSONObject;

public class Spectator_participant {
	private String championId;
	private String summonerName;
	private JSONArray perks;
	private int perkSubStyle;
	private String spell1;
	private String spell2;
	private int teamId;
	private String tier;
	private String rank;
	private int LP;
	
	
	
	
	
	public Spectator_participant() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Spectator_participant(String championId, String summonerName, JSONArray perks, int perkSubStyle,
			String spell1, String spell2, int teamId, String tier, String rank, int lP) {
		super();
		this.championId = championId;
		this.summonerName = summonerName;
		this.perks = perks;
		this.perkSubStyle = perkSubStyle;
		this.spell1 = spell1;
		this.spell2 = spell2;
		this.teamId = teamId;
		this.tier = tier;
		this.rank = rank;
		LP = lP;
	}





	public String getChampionId() {
		return championId;
	}





	public void setChampionId(String championId) {
		this.championId = championId;
	}





	public String getSummonerName() {
		return summonerName;
	}





	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}





	public JSONArray getPerks() {
		return perks;
	}





	public void setPerks(JSONArray perks) {
		this.perks = perks;
	}





	public int getPerkSubStyle() {
		return perkSubStyle;
	}





	public void setPerkSubStyle(int perkSubStyle) {
		this.perkSubStyle = perkSubStyle;
	}





	public String getSpell1() {
		return spell1;
	}





	public void setSpell1(String spell1) {
		this.spell1 = spell1;
	}





	public String getSpell2() {
		return spell2;
	}





	public void setSpell2(String spell2) {
		this.spell2 = spell2;
	}





	public int getTeamId() {
		return teamId;
	}





	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}





	public String getTier() {
		return tier;
	}





	public void setTier(String tier) {
		this.tier = tier;
	}





	public String getRank() {
		return rank;
	}





	public void setRank(String rank) {
		this.rank = rank;
	}





	public int getLP() {
		return LP;
	}





	public void setLP(int lP) {
		LP = lP;
	}





	@Override
	public String toString() {
		return "Spectator_participant [championId=" + championId + ", summonerName=" + summonerName + ", perks=" + perks
				+ ", perkSubStyle=" + perkSubStyle + ", spell1=" + spell1 + ", spell2=" + spell2 + ", teamId=" + teamId
				+ ", tier=" + tier + ", rank=" + rank + ", LP=" + LP + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
	
	
	
	
	
}
