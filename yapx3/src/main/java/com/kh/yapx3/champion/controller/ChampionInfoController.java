package com.kh.yapx3.champion.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.yapx3.champion.model.service.ChampionInfoServiceImpl;
import com.kh.yapx3.champion.model.vo.ChampionInfoVO;
import com.kh.yapx3.champion.model.vo.ChampionKoN;
import com.kh.yapx3.champion.model.vo.ChampionSkillInfo;
import com.kh.yapx3.champion.model.vo.ChampionTipBoardVO;

@Controller
@RequestMapping("/champion")
public class ChampionInfoController{
	
//	@Autowired
//	ChampionInfoService championInfoService;
	private static final char INITIAL_SOUND_BEGIN_UNICODE = 12593;  
	private static final char INITIAL_SOUND_LAST_UNICODE = 12622;
	private static final char HANGUL_BEGIN_UNICODE = 44032;
	private static final char HANGUL_LAST_UNICODE = 55203;
	private static final char NUMBER_BEGIN_UNICODE = 48;
	private static final char NUMBER_LAST_UNICODE = 57; 
	private static final char ENGLISH_ROWER_BEGIN_UNICODE = 65;
	private static final char ENGLIS_ROWER_LAST_UNICODE = 90;
	private static final char ENGLIS_UPPER_BEGIN_UNICODE = 97;
	private static final char ENGLIS_UPPER_LAST_UNICODE = 122;
	private static final char HANGUL_BASE_UNIT = 588;
	private static final char[] INITIAL_SOUND = 
        {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ'
       , 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
	
	private int championKey;
	@Autowired
	ChampionInfoServiceImpl championInfoService;
	
	@Autowired
	ServletContext servletContext;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/championView")
	public String viewPage() {
		
		return "champion/championView";
	}
	
	
	@RequestMapping(value="/championInfo", method=RequestMethod.GET)
	public ModelAndView championInfoMathod(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		int championId = Integer.parseInt(request.getParameter("championId"));
		
		championKey = championId;
		
		ModelAndView mav = new ModelAndView();
//챔피언 스킬 이미지 
		ChampionSkillInfo championSkillInfo = championInfoService.championInfoSkill(championId);
		
//챔피언 스킬 설명
		String championName = championInfoService.championGetName(championId);
		ChampionSkillInfo championSkillToolTip = championInfoService.championInfoSkillTool(championName);
		
//챔피언 lane통계
		List<ChampionInfoVO> championLaneList =  championInfoService.championInfo(championId);
		
//해당 챔피언 소환사 스킬 순위 리스트
		List<ChampionInfoVO> summonerSkillList = championInfoService.summonerSkillList(championId);
		
// 챔피언 시작탬 가져오기
		ChampionInfoVO championItemListSum = championInfoService.championStartItem(championId);
		
// 챔피언 룬 통계
		//메인 룬 서브룬 보조룬
		List<ChampionInfoVO> championPerkList = championInfoService.championRune(championId);
		
// 챔피언 아이템 리스트
		Map<String, Integer> championItemList = championInfoService.championFinalItem(championId);
		
// 챔피언 팁 리스트
		List<ChampionTipBoardVO> championTipList = championInfoService.championGetTipList(championId);
		
		List<String> itemCountList = new ArrayList<String>();
		Iterator<String> iter = championItemList.keySet().iterator();
		int count = 0;
		while(iter.hasNext()) {
			if(count == 12) {
				break;
			}
			itemCountList.add(iter.next());
			count++;
		}
	
		mav.setViewName("/champion/championInfo");
		mav.addObject("championSkillToolTip", championSkillToolTip);
		mav.addObject("championTipListCount", championTipList.size());
		mav.addObject("championTipList", championTipList);
		mav.addObject("championLaneList", championLaneList);
		mav.addObject("summonerSkillList", summonerSkillList);
		mav.addObject("championPerkList", championPerkList);
		mav.addObject("championItemListSum", championItemListSum);
		mav.addObject("itemCountList", itemCountList);
		mav.addObject("championSkillInfo", championSkillInfo);
		
		return mav;
		
	}
//팁 게시판 등록
	@RequestMapping("/championTipWrite")
	public ModelAndView championTipMethod(HttpServletRequest request, HttpServletResponse response) {
		String tipWriter = request.getParameter("tipWriter");
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		
		ChampionTipBoardVO tipBoard = new ChampionTipBoardVO();
		tipBoard.setChampionNo(championKey);
		tipBoard.setUserNickName(tipWriter);
		tipBoard.setChampTipContent(content);
		tipBoard.setUserEmail(email);
		
		int result = championInfoService.championTipInsert(tipBoard);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/champion/championInfo?championId=" + championKey);
		
		return mav;
		
	}
	
//팁 게시판 좋아요
	@RequestMapping("/championTipLike")
	public ModelAndView championTipLikeMethod(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		int tipNo = Integer.parseInt(request.getParameter("tipNo"));
		int like = Integer.parseInt(request.getParameter("like"));
		String likeType = request.getParameter("likeType");
		String userEmail = request.getParameter("userEmail");
		

		int idx = userEmail.indexOf("@");
		String emailId = userEmail.substring(0, idx);
		
		ChampionTipBoardVO tip = new ChampionTipBoardVO();
		tip.setChampTipNo(tipNo);
		tip.setUserId(emailId);
		tip.setChampTipLike(like);
		
		String[] checkuser =  championInfoService.championTipLike(tip, likeType);
		mav.setViewName("redirect:/champion/championInfo?championId=" + championKey);
		mav.addObject("checkuser", checkuser);
		
		return mav;
		
	}
	
//아이템 정보 가져오기
	@RequestMapping(value="/itemInfo",produces = "application/String; charset=utf8")
	public ResponseEntity<?> itemDescriptionMethod(HttpServletRequest request, HttpServletResponse reponse){
		int itemNo = Integer.parseInt( request.getParameter("itemId"));
		
		String description = championInfoService.itemDescription(itemNo);
		return ResponseEntity.ok(description);
	}
//소환사 스킬 정보 가져오기
	@RequestMapping(value="/summonerInfo", produces = "application/String; charset=utf8")
	public ResponseEntity<?> summonerDescriptionMethod(HttpServletRequest request, HttpServletResponse response){
		String spellName = request.getParameter("spellName");
		String description = championInfoService.summonerSpellDescription(spellName);
		return ResponseEntity.ok(description);
		
	}
	
	
//모든 챔피언 가져오기, 선택한 포지션의 챔피언 가져오기
	@RequestMapping("/allChampion")
 	public ResponseEntity<?> championMethod(HttpServletRequest request, HttpServletResponse response) {
		List<ChampionKoN> list = new ArrayList<ChampionKoN>();
        try {
        	list = championInfoService.championAll();
        	try(FileReader reader = new FileReader(servletContext.getRealPath("/resources/json/championLane.json"));
    				BufferedReader br = new BufferedReader(reader);){
    			list = championInfoService.championAll();
    			Map<String, String> championLane = new HashMap<String, String>();
    			String line;
    			String jj="";
    			ChampionInfoVO championInfo;
    			while((line = br.readLine()) != null) {
    				jj += line;
    			}
    			JSONArray jarr = new JSONArray(jj.toString());
    			for(int i = 0 ; i < jarr.length(); i++) {
    				for(int j = 0 ; j < list.size(); j++) {
    					
    					if(list.get(j).getChampionKey() == jarr.getJSONObject(i).getInt("key")) {
    						Iterator<String> iter = jarr.getJSONObject(i).keySet().iterator();
    						int cnt =0;
    						String[] str = new String[3];
    						while(iter.hasNext()) {
    							str[cnt] = iter.next();
    							cnt++;
    						}
    						list.get(j).setLane1(str[0]);
    						list.get(j).setLane2(str[1]);
    					}
    				}
    			}
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	response.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ResponseEntity.ok(list);
	}

//챔피언 이름 검색(초성, 풀네임)
	@RequestMapping(value="/searchChampion", method=RequestMethod.GET)
	public ResponseEntity<?> championSearchMethod(HttpServletRequest request, HttpServletResponse response){
		String[] itemTitle = new String[145];
		List<ChampionKoN> searchList = new ArrayList<ChampionKoN>();
		try {
			request.setCharacterEncoding("UTF-8");
			String keyword = request.getParameter("searchChampionName");
			//logger.info(keyword);
			int[] macholl = new int[20];
			ChampionKoN championKon;
			
			List<ChampionKoN> list = championInfoService.championAll();
			
			for(int i=0; i < list.size(); i++) {
				if(matchString(keyword, list.get(i).getChampionName().replace(" ", ""))) {
					championKon = new ChampionKoN();
					//logger.info("sss" + list.get(i).getChampionName());
					itemTitle[i] = list.get(i).getChampionId();
					championKon.setChampionId(list.get(i).getChampionId());
					championKon.setChampionKey(list.get(i).getChampionKey());
					championKon.setChampionName(list.get(i).getChampionName());
					searchList.add(championKon);
				}
 			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(searchList);
		
	}
	
	private char getInitialSound(char c) {
		int hanBegin = (c - HANGUL_BEGIN_UNICODE);
		int index = hanBegin / HANGUL_BASE_UNIT;
		return INITIAL_SOUND[index];
	}
	
	private boolean isHangul(char c) {
		return HANGUL_BEGIN_UNICODE <= c && c <= HANGUL_LAST_UNICODE;
	}
	
	private boolean checkUnicode(char c) {
		if(((c >= HANGUL_BEGIN_UNICODE && c<=HANGUL_LAST_UNICODE))
		  ||(c >= INITIAL_SOUND_BEGIN_UNICODE && c <= INITIAL_SOUND_LAST_UNICODE)) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isInitialSound(char c) {
		for(int i = 0; i <INITIAL_SOUND.length; i++) {
			if(INITIAL_SOUND[i] == c) {
				return true;
			}
		}
		return false;
	}
	
	public boolean matchString(String keyword, String value) {
		int t = 0;
		int seof = value.length() - keyword.length();
		int slen = keyword.length();
		
		
		if(seof < 0 || keyword.length() < 1) {
			return false;
		}
		for(int i = 0 ; i <= seof; i++) {
			t = 0;
			while (t < slen) {
				if(!checkUnicode(keyword.charAt(t))) {
					return false;
				}
				
				if(isInitialSound(keyword.charAt(t)) && isHangul(value.charAt(t+i))) {
					if(getInitialSound(value.charAt(t+i)) == keyword.charAt(t)) {
						t++;
					}else {
						break;
					}
				}else {
					if(value.charAt(i+t) == keyword.charAt(t)) {
						t++; 
					}else {
						break;
					}
				}
			}
			if(t == slen) {
				return true;
			}
		}
		return false;
	}
}
