package com.kh.yapx3.search.model.vo;

public class Spectator_banned {
	
	private int teamId;
	private String bannedchampion;
	
	
	
	
	public Spectator_banned() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Spectator_banned(int teamId, String bannedchampion) {
		super();
		this.teamId = teamId;
		this.bannedchampion = bannedchampion;
	}



	public int getTeamId() {
		return teamId;
	}



	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}



	public String getBannedchampion() {
		return bannedchampion;
	}



	public void setBannedchampion(String bannedchampion) {
		this.bannedchampion = bannedchampion;
	}



	@Override
	public String toString() {
		return "Spectator_banned [teamId=" + teamId + ", bannedchampion=" + bannedchampion + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
