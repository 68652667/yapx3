package com.kh.yapx3.match.model.service;

import java.util.List;
import java.util.Map;

import com.kh.yapx3.match.model.gamelist.MatchGameList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface MatchService {

	//ojdbc버젼
	JSONArray participantData(int id) throws InterruptedException;

	//mybatis버젼
	JSONArray participantData(String id);
	
	List<MatchGameList> gameList(List<String> gameId);
	
	List<JSONObject> itemLits();

	Map<String, Integer> championAll();

	JSONArray participantInsert(int id);

	List<String> getGameIdAll();

	org.json.JSONObject gameMatch(List<String> gameIdAll);

}
