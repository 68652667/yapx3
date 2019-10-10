package com.kh.yapx3.search.model.vo;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Spectator {
	
	private String gameMode;
	private JSONObject observers;
	private List<Spectator_participant> participant;
	private List<Spectator_banned> banned;
	
	
	
	public Spectator() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Spectator(String gameMode, JSONObject observers, List<Spectator_participant> participant, List<Spectator_banned> banned) {
		super();
		this.gameMode = gameMode;
		this.observers = observers;
		this.participant = participant;
		this.banned = banned;
	}



	public String getGameMode() {
		return gameMode;
	}



	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}



	public JSONObject getObservers() {
		return observers;
	}



	public void setObservers(JSONObject observers) {
		this.observers = observers;
	}



	public List<Spectator_participant> getParticipant() {
		return participant;
	}



	public void setParticipant(List<Spectator_participant> participant) {
		this.participant = participant;
	}



	public List<Spectator_banned> getBanned() {
		return banned;
	}



	public void setBanned(List<Spectator_banned> banned) {
		this.banned = banned;
	}



	@Override
	public String toString() {
		return "Spectator [gameMode=" + gameMode + ", observers=" + observers + ", participant=" + participant
				+ ", banned=" + banned + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
