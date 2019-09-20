package com.kh.yapx3.match.model.vo;

public class Team {
	
	private String teamId;
	private String win;
	private String ban1;
	private String ban2;
	private String ban3;
	private String ban4;
	private String ban5;
	
	public Team() {}

	public Team(String teamId, String win, String ban1, String ban2, String ban3, String ban4, String ban5) {
		super();
		this.teamId = teamId;
		this.win = win;
		this.ban1 = ban1;
		this.ban2 = ban2;
		this.ban3 = ban3;
		this.ban4 = ban4;
		this.ban5 = ban5;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public String getBan1() {
		return ban1;
	}

	public void setBan1(String ban1) {
		this.ban1 = ban1;
	}

	public String getBan2() {
		return ban2;
	}

	public void setBan2(String ban2) {
		this.ban2 = ban2;
	}

	public String getBan3() {
		return ban3;
	}

	public void setBan3(String ban3) {
		this.ban3 = ban3;
	}

	public String getBan4() {
		return ban4;
	}

	public void setBan4(String ban4) {
		this.ban4 = ban4;
	}

	public String getBan5() {
		return ban5;
	}

	public void setBan5(String ban5) {
		this.ban5 = ban5;
	}

	@Override
	public String toString() {
		return "{ teamId:\"" + teamId + "\", win:\"" + win + "\", ban1:\"" + ban1 + "\", ban2:\"" + ban2 + "\", ban3:\""
				+ ban3 + "\", ban4:\"" + ban4 + "\", ban5:\"" + ban5 + "\"}";
	}
	
}
