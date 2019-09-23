package com.kh.yapx3.match.model.service;

import java.util.List;

import com.kh.yapx3.match.model.gamelist.MatchGameList;

import net.sf.json.JSONArray;

public interface MatchService {

	JSONArray participantData();

	List<MatchGameList> gameList(List<String> gameId);

}
