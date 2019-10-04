package com.kh.yapx3.champion.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.yapx3.champion.model.service.ChampionInfoService;
import com.kh.yapx3.champion.model.vo.Camp;
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
		double championCount = championInfoService.championInfo(championId);
		
		List<Map<String, String>> lineList = new ArrayList<Map<String,String>>();
		lineList = championInfoService.championLine(championId);
		
		int championLineCount = 0;
		String championLineStr = "";
		List<Integer> championLaneCountList = new ArrayList<Integer>();
		List<String> championLanePosition = new ArrayList<String>();
		
//list 초기화
		championLaneCountList.clear();
		championLanePosition.clear();
		for(int i = 0; i < lineList.size(); i++) {
			championLineCount =  Integer.parseInt(String.valueOf(lineList.get(i).get("COUNT(*)")));
			championLineStr = lineList.get(i).get("LANE");
			championLaneCountList.add(championLineCount);
			championLanePosition.add(championLineStr);
		}
		
		
		List<String> championLine = new ArrayList<String>();
		
		for( int i = 0 ; i < championLaneCountList.size(); i++) {
			championLine.add(String.format("%.2f", championLaneCountList.get(i)*100/championCount) + "%");
		}
		
//통계데이터 객체에 담기
		ChampionInfoVO championLane;
		List<ChampionInfoVO> championLaneList = new ArrayList<ChampionInfoVO>();
		for( int i = 0 ; i < championLine.size(); i++) {
			championLane = new ChampionInfoVO();
			String championLineCountStr = String.format("%.2f", championLaneCountList.get(i)*100/championCount) + "%";
			championLane.setChampionLane(championLanePosition.get(i));
			championLane.setChampionLaneCount(championLineCountStr);
			championLaneList.add(championLane);
		}
		
//해당 챔피언 소환사 스킬 순위 리스트
		Map<Integer, String> summonerSkillList = new HashMap<Integer, String>();
		summonerSkillList = championInfoService.summonerSkillList(championId);
		
		List<Integer> spellCount = new ArrayList<Integer>();
		List<String> spellKey = new ArrayList<String>();
		TreeMap<Integer, String> sortMap = new TreeMap<Integer, String>(summonerSkillList);
		Iterator<Integer> iter = sortMap.descendingKeySet().iterator();
		int totalCount = 0;
		while(iter.hasNext()) {
			int count = iter.next();
			totalCount += count;
			spellCount.add(count);
			spellKey.add(sortMap.get(count));
		}
		
		ChampionInfoVO championSpell;
		List<ChampionInfoVO> championSpellList = new ArrayList<ChampionInfoVO>();
		
		if(spellKey.size() <= 1 ) {
			for(int i = 0 ; i < 1; i++) {
				championSpell = new ChampionInfoVO();
				String[] spellId = spellKey.get(i).split(",");
				String championSpellCountStr = String.format("%.2f", spellCount.get(i).floatValue()*100/totalCount) + "%";
				championSpell.setSummonerSpell1id(Integer.parseInt(spellId[0]));
				championSpell.setSummonerSpell2id(Integer.parseInt(spellId[1]));
				championSpell.setSummonerSpellCountStr(championSpellCountStr);
				championSpellList.add(championSpell);
				logger.info("count: " + spellCount.get(i) + ", spell: " + spellKey.get(i));
			}
		}else {
			for(int i = 0 ; i < 2; i++) {
				championSpell = new ChampionInfoVO();
				String[] spellId = spellKey.get(i).split(",");
				String championSpellCountStr = String.format("%.2f", spellCount.get(i).floatValue()*100/totalCount) + "%";
				championSpell.setSummonerSpell1id(Integer.parseInt(spellId[0]));
				championSpell.setSummonerSpell2id(Integer.parseInt(spellId[1]));
				championSpell.setSummonerSpellCountStr(championSpellCountStr);
				championSpellList.add(championSpell);
				logger.info("count: " + spellCount.get(i) + ", spell: " + spellKey.get(i));
			}
		}
		
		
// 챔피언 룬 통계
		List<ChampionInfoVO> championPerkList =  championInfoService.championRune(championId);
		
		
		mav.setViewName("/champion/championInfo");
		mav.addObject("championLaneList", championLaneList);
		mav.addObject("championSpellList", championSpellList);
		mav.addObject("championPerkList", championPerkList);
		
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
