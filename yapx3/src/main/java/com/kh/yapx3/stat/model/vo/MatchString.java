package com.kh.yapx3.stat.model.vo;

import java.util.List;

public class MatchString {
	
	private String gameId;
	private String gameCreation;
	private String gameDuration;
	private String queueId;
	private String mapId;
	private String seasonId;
	private String team1;
	private String team2;
	private String participant1;
	private String participant2;
	private String participant3;
	private String participant4;
	private String participant5;
	private String participant6;
	private String participant7;
	private String participant8;
	private String participant9;
	private String participant10;

	public MatchString() {}

	public MatchString(String gameId, String gameCreation, String gameDuration, String queueId, String mapId, String seasonId,
			String team1, String team2, String participant1, String participant2, String participant3,
			String participant4, String participant5, String participant6, String participant7,
			String participant8, String participant9, String participant10) {
		super();
		this.gameId = gameId;
		this.gameCreation = gameCreation;
		this.gameDuration = gameDuration;
		this.queueId = queueId;
		this.mapId = mapId;
		this.seasonId = seasonId;
		this.team1 = team1;
		this.team2 = team2;
		this.participant1 = participant1;
		this.participant2 = participant2;
		this.participant3 = participant3;
		this.participant4 = participant4;
		this.participant5 = participant5;
		this.participant6 = participant6;
		this.participant7 = participant7;
		this.participant8 = participant8;
		this.participant9 = participant9;
		this.participant10 = participant10;
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

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getparticipant1() {
		return participant1;
	}

	public void setparticipant1(String participant1) {
		this.participant1 = participant1;
	}

	public String getparticipant2() {
		return participant2;
	}

	public void setparticipant2(String participant2) {
		this.participant2 = participant2;
	}

	public String getparticipant3() {
		return participant3;
	}

	public void setparticipant3(String participant3) {
		this.participant3 = participant3;
	}

	public String getparticipant4() {
		return participant4;
	}

	public void setparticipant4(String participant4) {
		this.participant4 = participant4;
	}

	public String getparticipant5() {
		return participant5;
	}

	public void setparticipant5(String participant5) {
		this.participant5 = participant5;
	}

	public String getparticipant6() {
		return participant6;
	}

	public void setparticipant6(String participant6) {
		this.participant6 = participant6;
	}

	public String getparticipant7() {
		return participant7;
	}

	public void setparticipant7(String participant7) {
		this.participant7 = participant7;
	}

	public String getparticipant8() {
		return participant8;
	}

	public void setparticipant8(String participant8) {
		this.participant8 = participant8;
	}

	public String getparticipant9() {
		return participant9;
	}

	public void setparticipant9(String participant9) {
		this.participant9 = participant9;
	}

	public String getparticipant10() {
		return participant10;
	}

	public void setparticipant10(String participant10) {
		this.participant10 = participant10;
	}

	@Override
	public String toString() {
		return "{ gameId:\"" + gameId + "\", gameCreation:\"" + gameCreation + "\", gameDuration:\"" + gameDuration
				+ "\", queueId:\"" + queueId + "\", mapId:\"" + mapId + "\", seasonId:\"" + seasonId + "\", String1:\""
				+ team1 + "\", String2:\"" + team2 + "\", participant1:\"" + participant1 + "\", participant2:\""
				+ participant2 + "\", participant3:\"" + participant3 + "\", participant4:\"" + participant4
				+ "\", participant5:\"" + participant5 + "\", participant6:\"" + participant6
				+ "\", participant7:\"" + participant7 + "\", participant8:\"" + participant8
				+ "\", participant9:\"" + participant9 + "\", participant10:\"" + participant10 + "\"}";
	}
	
	
}
