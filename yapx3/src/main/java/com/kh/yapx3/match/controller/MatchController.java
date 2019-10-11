package com.kh.yapx3.match.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.yapx3.match.model.service.MatchService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//@RestController
@Controller
@RequestMapping("/match")
public class MatchController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MatchService matchService;
	
	
	//ojdbc버젼
	@RequestMapping("/matchList/{id}")
	public ResponseEntity<?> matchList(@PathVariable("id") int id){
		JSONArray participantDataAll = new JSONArray();
		JSONArray participatnOnse = new JSONArray();
		participatnOnse = matchService.participantInsert(id);
//		try {
//			participantDataAll = matchService.participantData(id);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return ResponseEntity.ok(participantDataAll);
	}
	
	
	
	public List<String> gameIdAll() {
		List<String> gameIdAll = new ArrayList<String>();
		gameIdAll = matchService.getGameIdAll();
		return gameIdAll;
	}
	
//	@RequestMapping("/gameMatch")
	public String gameMatchEvent() {
		String gameId = "3847361739";
		org.json.JSONObject jobj = new org.json.JSONObject();
		List<String> gameIdAll = gameIdAll();
		jobj = matchService.gameMatch(gameIdAll);
		return "";
	}

	//mybatis버젼
//	@RequestMapping("/matchList/{id}")
//	public ResponseEntity<?> matchList(@PathVariable("id") String id){
//		JSONArray participantDataAll = new JSONArray();
//		participantDataAll = matchService.participantData(id);
//		
//		return ResponseEntity.ok(participantDataAll);
//	}
	
	@RequestMapping("/itemList")
	public ResponseEntity<?> itemList(){
		List<JSONObject> jobj = matchService.itemLits();
		//logger.info("matchController: "  + jobj);
		
		return ResponseEntity.ok(jobj);
	}
	
	@RequestMapping("/championInsert")
	public ResponseEntity<?> championIn() {
		Map<String, Integer> champ =  matchService.championAll();
		
		return ResponseEntity.ok(champ);
	}
	
	
}
