package com.kh.yapx3.champion.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kh.yapx3.champion.model.match.GetMatch;
import com.kh.yapx3.champion.model.matchline.MatchVO;
import com.kh.yapx3.champion.model.service.ApiService;
import com.kh.yapx3.champion.model.service.NewObject;
import com.kh.yapx3.champion.model.service.TestService;
import com.kh.yapx3.champion.model.vo.Camp;

@RestController
@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	ApiService apiService;
	
	@Inject
	private TestService testService;

	@GetMapping("/")
	public ResponseEntity<?> getMatchIndex() {
		GetMatch getMatchVO = testService.getResponseEntity();
		NewObject newObject = new NewObject();
		newObject.setGameId(getMatchVO.getGameId());
		newObject.setGameMode(getMatchVO.getGameMode());
		newObject.setGameType(getMatchVO.getGameType());
		return ResponseEntity.ok(newObject);
	}
	
	@RequestMapping("/allChampion")
	public ResponseEntity<?> championAll() {
		List<Camp> champ = apiService.championAll();
		champ.sort(Comparator.comparing(Camp::getName));
		return ResponseEntity.ok(champ);
	}
	
	@RequestMapping("/champion/info/{id}")
	@ResponseBody
	public ModelAndView playGame(@PathVariable("id") int championId, ModelAndView mav){
		Map<String, String> challengerLegue = apiService.challengerLegue();
		List<MatchVO> play = new ArrayList<MatchVO>();
		String summonerAccountId = null;
		for(Map.Entry<String, String> entry : challengerLegue.entrySet()) {
			System.out.println("-----------------------------소환사!---------------------------");
			System.out.println("소화사 닉네임: " + entry.getKey());
			summonerAccountId = apiService.summonerSearch(entry.getKey());
			play = apiService.playGame(summonerAccountId, championId);
			System.out.println("-------------------------------------------------------------");
		}
		
		mav.addObject("play", play);
		mav.setViewName("champion/test");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/champion/test/{id}")
	public ModelAndView test(@PathVariable("id") String championId, ModelAndView mav){
		System.out.println(championId);
		mav.setViewName("champion/test");
		mav.addObject("championId",championId);
		return mav;
	}
}
