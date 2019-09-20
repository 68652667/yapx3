package com.kh.yapx3.match.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.kh.yapx3.match.model.vo.Team;

@Controller
@RequestMapping("/match")
public class MatchController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/test")
	public void apiTest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("application/json; charset=utf-8");
		
		Team team = new Team("teamid", "win", "ban1", "ban2", "ban3", "ban4", "ban5");
		
		logger.info(team.toString());
		
		JSONObject teamObject = new JSONObject(team.toString());

		logger.info(teamObject.toString());
		
		new Gson().toJson(teamObject, response.getWriter());
	}
	
}
