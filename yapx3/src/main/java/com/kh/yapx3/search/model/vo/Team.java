package com.kh.yapx3.search.model.vo;

public class Team {
	
	private String teamId;
	private String win;
	
	public Team() {}

	public Team(String teamId, String win) {
		super();
		this.teamId = teamId;
		this.win = win;
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

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", win=" + win + "]";
	}
	
}
