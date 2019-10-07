package com.kh.yapx3.champion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.yapx3.champion.common.URLConnection;
import com.kh.yapx3.champion.model.service.ChampionInfoService;
import com.kh.yapx3.champion.model.vo.ChampionInfoVO;

@Controller
@RequestMapping("/champion")
public class ChampionInfoController{
	
	@Autowired
	ChampionInfoService championInfoService;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/championView")
	public String viewPage() {
		
		return "champion/championView";
	}
	
	
	@RequestMapping(value="/championInfo", method=RequestMethod.GET)
	public ModelAndView championInfoMathod(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		int championId = Integer.parseInt(request.getParameter("championId"));
		
		ModelAndView mav = new ModelAndView();
		
//챔피언 lane통계
		List<ChampionInfoVO> championLaneList = championInfoService.championInfo(championId);
		
//해당 챔피언 소환사 스킬 순위 리스트
		List<ChampionInfoVO> summonerSkillList = championInfoService.summonerSkillList(championId);
		
// 챔피언 시작탬 가져오기
		List<ChampionInfoVO> championItemListSum =  championInfoService.championStartItem(championId);
		
// 챔피언 룬 통계
		//메인 룬 서브룬 보조룬
		List<ChampionInfoVO> championPerkList =  championInfoService.championRune(championId);
		
// 챔피언 아이템 리스트
		List<ChampionInfoVO> championItemList = championInfoService.championItem(championId);
		
		
		mav.setViewName("/champion/championInfo");
		mav.addObject("championLaneList", championLaneList);
		mav.addObject("summonerSkillList", summonerSkillList);
		mav.addObject("championPerkList", championPerkList);
		mav.addObject("championItemListSum", championItemListSum);
		
		return mav;
		
	}
	
	@RequestMapping("/mastery")
	public void chMastery(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			String searchMastery = request.getParameter("searchMastery");
			Map<String, String> map = championInfoService.chMastery(searchMastery);
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
			Map<String,String> map = championInfoService.apiTest(searchName);
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
        	list = championInfoService.championAll();
        	logger.info("championList :" + list );
        	response.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ResponseEntity.ok(list);
	}
}
