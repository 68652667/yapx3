package com.kh.yapx3.search.model.vo;

import java.util.List;

public class Match {
	
	private String gameId;
	private String gameCreation;
	private String gameDuration;
	private String queueId;
	private String mapId;
	private String seasonId;
	private String gameVersion;
	private String gameMode;
	private String gameType;
	private Team team1;
	private Team team2;
	private Participant participants1;
	private Participant participants2;
	private Participant participants3;
	private Participant participants4;
	private Participant participants5;
	private Participant participants6;
	private Participant participants7;
	private Participant participants8;
	private Participant participants9;
	private Participant participants10;
	private MyItemBuild myIteamBuild;
	
	
	
	
	public Match() {
		super();
	}




	public Match(String gameId, String gameCreation, String gameDuration, String queueId, String mapId, String seasonId,
			String gameVersion, String gameMode, String gameType, Team team1, Team team2, Participant participants1,
			Participant participants2, Participant participants3, Participant participants4, Participant participants5,
			Participant participants6, Participant participants7, Participant participants8, Participant participants9,
			Participant participants10, MyItemBuild myIteamBuild) {
		super();
		this.gameId = gameId;
		this.gameCreation = gameCreation;
		this.gameDuration = gameDuration;
		this.queueId = queueId;
		this.mapId = mapId;
		this.seasonId = seasonId;
		this.gameVersion = gameVersion;
		this.gameMode = gameMode;
		this.gameType = gameType;
		this.team1 = team1;
		this.team2 = team2;
		this.participants1 = participants1;
		this.participants2 = participants2;
		this.participants3 = participants3;
		this.participants4 = participants4;
		this.participants5 = participants5;
		this.participants6 = participants6;
		this.participants7 = participants7;
		this.participants8 = participants8;
		this.participants9 = participants9;
		this.participants10 = participants10;
		this.myIteamBuild = myIteamBuild;
	}




	public String getGameId() {
		return gameId;
	}




	public void setGameId(String gameId) {
		this.gameId = gameId;
	}




	public String getGameCreation() {
		return gameCreation;
	}




	public void setGameCreation(String gameCreation) {
		this.gameCreation = gameCreation;
	}




	public String getGameDuration() {
		return gameDuration;
	}




	public void setGameDuration(String gameDuration) {
		this.gameDuration = gameDuration;
	}




	public String getQueueId() {
		return queueId;
	}




	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}




	public String getMapId() {
		return mapId;
	}




	public void setMapId(String mapId) {
		this.mapId = mapId;
	}




	public String getSeasonId() {
		return seasonId;
	}




	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}




	public String getGameVersion() {
		return gameVersion;
	}




	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
	}




	public String getGameMode() {
		return gameMode;
	}




	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}




	public String getGameType() {
		return gameType;
	}




	public void setGameType(String gameType) {
		this.gameType = gameType;
	}




	public Team getTeam1() {
		return team1;
	}




	public void setTeam1(Team team1) {
		this.team1 = team1;
	}




	public Team getTeam2() {
		return team2;
	}




	public void setTeam2(Team team2) {
		this.team2 = team2;
	}




	public Participant getParticipants1() {
		return participants1;
	}




	public void setParticipants1(Participant participants1) {
		this.participants1 = participants1;
	}




	public Participant getParticipants2() {
		return participants2;
	}




	public void setParticipants2(Participant participants2) {
		this.participants2 = participants2;
	}




	public Participant getParticipants3() {
		return participants3;
	}




	public void setParticipants3(Participant participants3) {
		this.participants3 = participants3;
	}




	public Participant getParticipants4() {
		return participants4;
	}




	public void setParticipants4(Participant participants4) {
		this.participants4 = participants4;
	}




	public Participant getParticipants5() {
		return participants5;
	}




	public void setParticipants5(Participant participants5) {
		this.participants5 = participants5;
	}




	public Participant getParticipants6() {
		return participants6;
	}




	public void setParticipants6(Participant participants6) {
		this.participants6 = participants6;
	}




	public Participant getParticipants7() {
		return participants7;
	}




	public void setParticipants7(Participant participants7) {
		this.participants7 = participants7;
	}




	public Participant getParticipants8() {
		return participants8;
	}




	public void setParticipants8(Participant participants8) {
		this.participants8 = participants8;
	}




	public Participant getParticipants9() {
		return participants9;
	}




	public void setParticipants9(Participant participants9) {
		this.participants9 = participants9;
	}




	public Participant getParticipants10() {
		return participants10;
	}




	public void setParticipants10(Participant participants10) {
		this.participants10 = participants10;
	}




	public MyItemBuild getMyIteamBuild() {
		return myIteamBuild;
	}




	public void setMyIteamBuild(MyItemBuild myIteamBuild) {
		this.myIteamBuild = myIteamBuild;
	}




	@Override
	public String toString() {
		return "Match [gameId=" + gameId + ", gameCreation=" + gameCreation + ", gameDuration=" + gameDuration
				+ ", queueId=" + queueId + ", mapId=" + mapId + ", seasonId=" + seasonId + ", gameVersion="
				+ gameVersion + ", gameMode=" + gameMode + ", gameType=" + gameType + ", team1=" + team1 + ", team2="
				+ team2 + ", participants1=" + participants1 + ", participants2=" + participants2 + ", participants3="
				+ participants3 + ", participants4=" + participants4 + ", participants5=" + participants5
				+ ", participants6=" + participants6 + ", participants7=" + participants7 + ", participants8="
				+ participants8 + ", participants9=" + participants9 + ", participants10=" + participants10
				+ ", myIteamBuild=" + myIteamBuild + "]";
	}

	
	
	
	
}
