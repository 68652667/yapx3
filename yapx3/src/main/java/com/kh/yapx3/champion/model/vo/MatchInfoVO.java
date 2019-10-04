package com.kh.yapx3.champion.model.vo;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

public class MatchInfoVO {

	private int championId;
	private JSONArray participantIdOrItem;

	public MatchInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchInfoVO(int championId, JSONArray participantIdOrItem) {
		super();
		this.championId = championId;
		this.participantIdOrItem = participantIdOrItem;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public JSONArray getParticipantIdOrItem() {
		return participantIdOrItem;
	}

	public void setParticipantIdOrItem(JSONArray participantIdOrItem) {
		this.participantIdOrItem = participantIdOrItem;
	}

	@Override
	public String toString() {
		return "MatchInfoVO [championId=" + championId + ", participantId=" + participantIdOrItem + "]";
	}

}
