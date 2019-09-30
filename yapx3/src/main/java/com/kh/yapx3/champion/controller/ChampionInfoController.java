package com.kh.yapx3.champion.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.yapx3.champion.model.service.ChampionInfoService;
import com.kh.yapx3.champion.model.vo.Camp;

@Controller
@RequestMapping("/champion")
public class ChampionInfoController{
	
	@Autowired
	ChampionInfoService apiService;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/championView")
	public String viewPage() {
		
		return "champion/championView";
	}
	
	
	@RequestMapping("/championInfo")
	public String championInfoMathod(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		int championId = Integer.parseInt(request.getParameter("championId"));
		
		ModelAndView mvn = new ModelAndView();
		
		int championCount = apiService.championInfo(championId);
		int championWin = apiService.championWin(championId);
		List<Integer> championLine = apiService.championLine(championId);
		int championLineTop = apiService.championLineTop(championId);
		int championLineBottom = apiService.championLineBottom(championId);
		
		logger.info("ChampionInfoController: " + championCount);
		logger.info("ChampionInfoController: " + championWin );
		logger.info("ChampionInfoController: " + championLineTop);
		logger.info("ChampionInfoController: " + championLineBottom);
		
		return "/champion/test";
		
	}
	
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
	
	@RequestMapping("/allChampion")
	public ResponseEntity<?> championMethod(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Integer> list = new HashMap<String, Integer>();
        try {
        	list = apiService.championAll();
        	logger.info("championList :" + list );
        	response.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return ResponseEntity.ok(list);
	}
}
