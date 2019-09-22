package com.kh.yapx3.champion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.service.ApiService;
import com.kh.yapx3.champion.model.vo.Camp;

@RestController
@RequestMapping("/api")
public class ApiMainController{
	
	@Autowired
	ApiService apiService;
	
	@RequestMapping("/champion/info")
	public String championInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		JSONObject jobj = apiService.championInfo();
		model.addAttribute("Info", jobj);
		
		return "/champion/test";
		
	}
	
//	@GetMapping("/allChampion")
//	public ResponseEntity<?> getMatchIndex() {
//		return ResponseEntity.ok(apiService.championAll());
//	}
	
	@RequestMapping("/mastery")
	public void chMastery(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			String searchMastery = request.getParameter("searchMastery");
			Map<String, String> map = apiService.chMastery(searchMastery);
			response.setCharacterEncoding("utf-8");
			new Gson().toJson(map, response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/allChampion")
	public void championAll(HttpServletResponse response) {
		try {
			List<Camp> champ = apiService.championAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/search")
	public void apiTest(HttpServletRequest request, HttpServletResponse response) {
		try {
			String searchName = request.getParameter("summonerName");
			Map<String,String> map = apiService.apiTest(searchName);
			response.setCharacterEncoding("utf-8");
			new Gson().toJson(map, response.getWriter());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	@RequestMapping("/champion")
	public void champion(HttpServletRequest request, HttpServletResponse response) {
        try {
        	List<String> list = new ArrayList<String>();
        	list = apiService.champion();
        	response.setCharacterEncoding("utf-8");
			new Gson().toJson(list, response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
