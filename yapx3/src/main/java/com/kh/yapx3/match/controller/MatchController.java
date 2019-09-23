package com.kh.yapx3.match.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.yapx3.match.model.service.MatchService;

import net.sf.json.JSONArray;


@RestController
@RequestMapping("/match")
public class MatchController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MatchService matchService;
	
	
	@RequestMapping("/matchList")
	public ResponseEntity<?> matchList(){
		JSONArray participantDataAll = new JSONArray();
		participantDataAll = matchService.participantData();
		
		return ResponseEntity.ok(participantDataAll);
	}
	
}
