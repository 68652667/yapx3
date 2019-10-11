package com.kh.yapx3.ranking.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.yapx3.ranking.model.service.RankingService;

@Controller
@RequestMapping("/ranking")
public class RankingController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	JSONParser jsonParser = new JSONParser();
	final int NUM_PER_PAGE = 50;
	final int pageBarSize = 10;
	
	public static int apikeyuse = 0;
	String key = "RGAPI-fcefb3f5-9901-4070-9a91-48dc3f71f099";
	
	@Autowired
	RankingService rankingService;
	
	@RequestMapping("/ladder")
	public ModelAndView ladder(@RequestParam(value="page", defaultValue="1", required=false) int page) {
		ModelAndView mav = new ModelAndView();
		//System.out.println(page);
		int cPage = (page-1)*NUM_PER_PAGE;
		int view = page*NUM_PER_PAGE;
		
		String challenger1 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=1&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String challenger2 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=2&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String gMaster1 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/GRANDMASTER/I?page=1&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String gMaster2 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/GRANDMASTER/I?page=2&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String gMaster3 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/GRANDMASTER/I?page=3&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String gMaster4 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/GRANDMASTER/I?page=4&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master1 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=1&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master2 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=2&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master3 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=3&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master4 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=4&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master5 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=5&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master6 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=6&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master7 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=7&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master8 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=8&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		List<Map<String, String>> user = new ArrayList<>();
		List<Map<String, String>> list = new ArrayList<>();
		int totalRanker = 0;
		try {
			JSONArray carr1 = urlSession(challenger1);
			JSONArray carr2 = urlSession(challenger2);
			JSONArray gmarr1 = urlSession(gMaster1);
			JSONArray gmarr2 = urlSession(gMaster2);
			JSONArray gmarr3 = urlSession(gMaster3);
			JSONArray gmarr4 = urlSession(gMaster4);
			JSONArray marr1 = urlSession(master1);
			JSONArray marr2 = urlSession(master2);
			JSONArray marr3 = urlSession(master3);
			JSONArray marr4 = urlSession(master4);
			JSONArray marr5 = urlSession(master5);
			JSONArray marr6 = urlSession(master6);
			JSONArray marr7 = urlSession(master7);
			JSONArray marr8 = urlSession(master8);
			
			user.addAll(rankList(carr1));
			user.addAll(rankList(carr2));
			user.addAll(rankList(gmarr1));
			user.addAll(rankList(gmarr2));
			user.addAll(rankList(gmarr3));
			user.addAll(rankList(gmarr4));
			user.addAll(rankList(marr1));
			user.addAll(rankList(marr2));
			user.addAll(rankList(marr3));
			user.addAll(rankList(marr4));
			user.addAll(rankList(marr5));
			user.addAll(rankList(marr6));
			user.addAll(rankList(marr7));
			user.addAll(rankList(marr8));
			
			totalRanker = user.size();
			if(view>totalRanker) {
				view = totalRanker;
			}
			for(int i=cPage;i<view;i++) {
				String summonerName = user.get(i).get("summonerName").toString();
				String tier = user.get(i).get("tier").toString();
				String leaguePoints = user.get(i).get("leaguePoints").toString();
				String wins = user.get(i).get("wins").toString();
				String losses = user.get(i).get("losses").toString();
				Map<String, String> summoner = new HashMap<>();
				summoner.put("summonerName", summonerName);
				summoner.put("tier", tier);
				summoner.put("wins", wins);
				summoner.put("losses", losses);
				summoner.put("leaguePoints", leaguePoints);
				list.add(summoner);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalPage = (int) Math.ceil((double)totalRanker/NUM_PER_PAGE);
		String pageBar = "";
		int pageStart = ((page-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageStart+pageBarSize-1;
		int pageNo = pageStart;
		//a.[이전]
		if(pageNo==1) {
//			pageBar += "<span>&laquo;</span>";
			pageBar += "<a href='#' class='none'>&laquo;</a>"; 
		}
		else {
			pageBar += "<a href='/yapx3/ranking/ladder.do?page="+(pageNo-1)+"'>&laquo;</a>"; 
		}
		
		//b.page
		while(pageNo<=pageEnd && pageNo<=totalPage) {
			//현재 페이지인 경우. 링크필요없음
			if(pageNo == page) {
//				pageBar += "<span class='active'>"+pageNo+"</span>";
				pageBar += "<a href='/yapx3/ranking/ladder.do?page="+pageNo+"' class='active'>"+pageNo+"</a>"; 
			}
			else {
				pageBar += "<a href='/yapx3/ranking/ladder.do?page="+pageNo+"'>"+pageNo+"</a>"; 
			}
			pageNo++;
		}
		
		//c.[다음]
		if(pageNo>totalPage) {
			pageBar += "<span>&raquo;</span>";
		}
		else {
			pageBar += "<a href='/yapx3/ranking/ladder.do?page="+pageNo+"'>&raquo;</a>"; 
		}
		mav.addObject("page", page);
		mav.addObject("totalRanker", totalRanker);
		mav.addObject("list", list);
		mav.addObject("pageBar", pageBar);
		
		return mav;
	}
	
	@RequestMapping("/summonerSearch")
	public String summonerNameSearch(@RequestParam String searchName, Model model) {
		//System.out.println(searchName);
		
		String challenger1 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=1&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String challenger2 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=2&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String gMaster1 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/GRANDMASTER/I?page=1&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String gMaster2 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/GRANDMASTER/I?page=2&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String gMaster3 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/GRANDMASTER/I?page=3&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String gMaster4 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/GRANDMASTER/I?page=4&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master1 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=1&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master2 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=2&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master3 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=3&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master4 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=4&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master5 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=5&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master6 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=6&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master7 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=7&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		String master8 = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/MASTER/I?page=8&api_key="+key;
		apikeyuse++;
		key = apikeyuse();
		List<Map<String, String>> user = new ArrayList<>();
		List<Map<String, String>> list = new ArrayList<>();
		int totalRanker = 0;
		int page = 0;
		String equalsName = "";
		boolean equal = true;
		try {
			JSONArray carr1 = urlSession(challenger1);
			JSONArray carr2 = urlSession(challenger2);
			JSONArray gmarr1 = urlSession(gMaster1);
			JSONArray gmarr2 = urlSession(gMaster2);
			JSONArray gmarr3 = urlSession(gMaster3);
			JSONArray gmarr4 = urlSession(gMaster4);
			JSONArray marr1 = urlSession(master1);
			JSONArray marr2 = urlSession(master2);
			JSONArray marr3 = urlSession(master3);
			JSONArray marr4 = urlSession(master4);
			JSONArray marr5 = urlSession(master5);
			JSONArray marr6 = urlSession(master6);
			JSONArray marr7 = urlSession(master7);
			JSONArray marr8 = urlSession(master8);
			
			user.addAll(rankList(carr1));
			user.addAll(rankList(carr2));
			user.addAll(rankList(gmarr1));
			user.addAll(rankList(gmarr2));
			user.addAll(rankList(gmarr3));
			user.addAll(rankList(gmarr4));
			user.addAll(rankList(marr1));
			user.addAll(rankList(marr2));
			user.addAll(rankList(marr3));
			user.addAll(rankList(marr4));
			user.addAll(rankList(marr5));
			user.addAll(rankList(marr6));
			user.addAll(rankList(marr7));
			user.addAll(rankList(marr8));
			
			totalRanker = user.size();
			for(int i=0;i<totalRanker;i++) {
				page++;
				String summonerName = user.get(i).get("summonerName").toString();
				if(searchName.replaceAll(" ", "").equalsIgnoreCase(summonerName.replaceAll(" ", ""))) {
					equalsName = user.get(i).get("summonerName").toString();
					equal = false;
					break;
				}
			}
			//System.out.println(page);
			page = (int) Math.ceil((double)page/NUM_PER_PAGE);
			int cPage = (page-1)*NUM_PER_PAGE;
			int view = page*NUM_PER_PAGE;
			if(view>totalRanker) {
				view = totalRanker;
			}
			for(int i=cPage;i<view;i++) {
				String summonerName = user.get(i).get("summonerName").toString();
				String tier = user.get(i).get("tier").toString();
				String leaguePoints = user.get(i).get("leaguePoints").toString();
				String wins = user.get(i).get("wins").toString();
				String losses = user.get(i).get("losses").toString();
				Map<String, String> summoner = new HashMap<>();
				summoner.put("summonerName", summonerName);
				summoner.put("tier", tier);
				summoner.put("wins", wins);
				summoner.put("losses", losses);
				summoner.put("leaguePoints", leaguePoints);
				list.add(summoner);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("equalsName"+equalsName);
		//System.out.println("page"+page);
		int totalPage = (int) Math.ceil((double)totalRanker/NUM_PER_PAGE);
		String pageBar = "";
		int pageStart = ((page-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageStart+pageBarSize-1;
		int pageNo = pageStart;
		//a.[이전]
		if(pageNo==1) {
//			pageBar += "<span>&laquo;</span>";
			pageBar += "<a href='#' class='none'>&laquo;</a>"; 
		}
		else {
			pageBar += "<a href='/yapx3/ranking/ladder.do?page="+(pageNo-1)+"'>&laquo;</a>"; 
		}
		
		//b.page
		while(pageNo<=pageEnd && pageNo<=totalPage) {
			//현재 페이지인 경우. 링크필요없음
			if(pageNo == page) {
//				pageBar += "<span class='active'>"+pageNo+"</span>";
				pageBar += "<a href='/yapx3/ranking/ladder.do?page="+pageNo+"' class='active'>"+pageNo+"</a>"; 
			}
			else {
				pageBar += "<a href='/yapx3/ranking/ladder.do?page="+pageNo+"'>"+pageNo+"</a>"; 
			}
			pageNo++;
		}
		
		//c.[다음]
		if(pageNo>totalPage) {
			pageBar += "<span>&raquo;</span>";
		}
		else {
			pageBar += "<a href='/yapx3/ranking/ladder.do?page="+pageNo+"'>&raquo;</a>"; 
		}
		model.addAttribute("equal", equal);
		model.addAttribute("equalsName", equalsName);
		model.addAttribute("page", page);
		model.addAttribute("totalRanker", totalRanker);
		model.addAttribute("list", list);
		model.addAttribute("pageBar", pageBar);
		
		return "ranking/summonerSearch";
	}
	
	@RequestMapping("/champions")
	public String championMaster(Model model) {
		String url = "http://ddragon.leagueoflegends.com/cdn/9.19.1/data/ko_KR/champion.json";
		List<Map<String, String>> champ = new ArrayList<>();
		org.json.JSONObject jobj = urlSession2(url);
		org.json.JSONObject dataObject = (org.json.JSONObject) jobj.get("data");
		Iterator i = (Iterator) dataObject.keys();
		while(i.hasNext()) {
			String dataKey = i.next().toString();
			org.json.JSONObject data = dataObject.getJSONObject(dataKey);
			org.json.JSONObject image_ = (org.json.JSONObject) data.get("image");
			String image = (String) image_.get("full");
			String name_kr = (String) data.get("name");
			String name_en = (String) data.get("id");
			String key = (String) data.get("key");
			Map<String, String> champ_ = new HashMap<>();
			champ_.put("champName_en", name_en);
			champ_.put("champName_kr", name_kr);
			champ_.put("champImg", image);
			champ_.put("champKey", key);
			champ.add(champ_);
		}
		//챔피언 가나다순 정렬
		Collections.sort(champ, new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> map1, Map<String, String> map2) {
				return map1.get("champName_kr").compareTo(map2.get("champName_kr"));
			}
		});
		model.addAttribute("champ", champ);
		
		return "ranking/championMaster";
	}
	
	@RequestMapping("/champSearch")
	public void champSearch(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("champSearch Test!!");
		
		String srchName = request.getParameter("srchName");
		String url = "http://ddragon.leagueoflegends.com/cdn/9.19.1/data/ko_KR/champion.json";
		List<Map<String, String>> champ = new ArrayList<>();
		org.json.JSONObject jobj = urlSession2(url);
		org.json.JSONObject dataObject = (org.json.JSONObject) jobj.get("data");
		Iterator i = (Iterator) dataObject.keys();
		while(i.hasNext()) {
			String dataKey = i.next().toString();
			org.json.JSONObject data = dataObject.getJSONObject(dataKey);
			org.json.JSONObject image_ = (org.json.JSONObject) data.get("image");
			String image = (String) image_.get("full");
			String name_kr = (String) data.get("name");
			String name_en = (String) data.get("id");
			Map<String, String> champ_ = new HashMap<>();
			if(name_kr.contains(srchName)||name_en.contains(srchName)) {
				champ_.put("champName_en", name_en);
				champ_.put("champName_kr", name_kr);
				champ_.put("champImg", image);
				champ.add(champ_);
			}
		}
		//챔피언 가나다순 정렬
		Collections.sort(champ, new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> map1, Map<String, String> map2) {
				return map1.get("champName_kr").compareTo(map2.get("champName_kr"));
			}
		});
		response.setCharacterEncoding("utf-8");
		try {
			new Gson().toJson(champ, response.getWriter());
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/champMaster")
	public void champMaster(HttpServletRequest request, HttpServletResponse response) {
		if(apikeyuse%2!=0) {
			apikeyuse--;
		}
		//System.out.println("champ Click!");
		String champName = request.getParameter("champName");
		//System.out.println(champName);
//		String url = "http://ddragon.leagueoflegends.com/cdn/9.19.1/data/ko_KR/champion.json";
//		org.json.JSONObject jobj = urlSession2(url);
//		org.json.JSONObject dataObject = (org.json.JSONObject) jobj.get("data");
//		Iterator i = (Iterator) dataObject.keys();
//		while(i.hasNext()) {
//			String dataKey = i.next().toString();
////			//System.out.println(dataKey);
//			if(champName.equals(dataKey)) {
//				//System.out.println("일치함!");
//				org.json.JSONObject data = dataObject.getJSONObject(champName);
//				org.json.JSONObject image = (org.json.JSONObject) data.get("image");
//				String img = (String) image.get("full").toString();
//				//System.out.println(img);
//				Map<String, String> champ_ = new HashMap<>();
//				champ_.put("champImg", img);
//				champ.add(champ_);
//			}
//		}
		List<Map<String, String>> champ = rankingService.result(champName);
		for(Map<String, String> m : champ) {
			String summonerName = m.get("SUMMONER_NAME");
			String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+summonerName.replace(" ", "%20")+"?api_key="+key;
			apikeyuse++;
			key = apikeyuse();
			org.json.JSONObject jobj = urlSession2(url);
			String id = jobj.getString("id");
			int profileIconId_ = jobj.getInt("profileIconId");
			String profileIconId = profileIconId_ + ".png";
			m.put("PICONID", profileIconId);
			url = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+id+"?api_key="+key;
			apikeyuse++;
			key = apikeyuse();
			org.json.JSONArray jarr = urlSession1(url);
			for(int i=0;i<jarr.length();i++) {
				if("RANKED_SOLO_5x5".equals(jarr.getJSONObject(i).get("queueType"))){
					String tier = (String) jarr.getJSONObject(i).get("tier");
					m.put("TIER", tier);
				}
			}
		}
		//System.out.println(champ);
		response.setCharacterEncoding("utf-8");
		
		try {
			new Gson().toJson(champ, response.getWriter());
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public JSONArray urlSession(String url) {
		JSONArray jarr = new JSONArray();
		try {
			URL url_ = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(url_.openConnection().getInputStream()));
			String sb = br.readLine();
			jarr = (JSONArray) jsonParser.parse(sb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jarr;
	}
	
	public org.json.JSONArray urlSession1(String url) {
		org.json.JSONArray jarr = new org.json.JSONArray();
		try {
			URL url_ = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(url_.openConnection().getInputStream()));
			jarr = new org.json.JSONArray(br.readLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jarr;
	}
	
	public org.json.JSONObject urlSession2(String url) {
		org.json.JSONObject jobj = new org.json.JSONObject();
		try {
			URL url_ = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(url_.openConnection().getInputStream()));
			String sb = br.readLine();
			jobj = new org.json.JSONObject(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobj;
	}
	
	public List<Map<String, String>> rankList(JSONArray jarr){
		List<Map<String, String>> list = new ArrayList<>();
		for(int i=0;i<jarr.size();i++) {
			JSONObject jobj = (JSONObject) jarr.get(i);
			String summonerName = jobj.get("summonerName").toString();
			String tier = jobj.get("tier").toString();
			String leaguePoints = jobj.get("leaguePoints").toString();
			String wins = jobj.get("wins").toString();
			String losses = jobj.get("losses").toString();
			Map<String, String> summoner = new HashMap<String, String>();
			summoner.put("summonerName", summonerName);
			summoner.put("tier", tier);
			summoner.put("wins", wins);
			summoner.put("losses", losses);
			summoner.put("leaguePoints", leaguePoints);
			list.add(summoner);
		}
		
		return list;
	}
	
	public String apikeyuse() {
		//System.out.println("api사용 횟수 : "+apikeyuse);
			//System.out.println("현재 키 : "+key);
			String presentKey = key;
			switch(key) {
			case "RGAPI-fcefb3f5-9901-4070-9a91-48dc3f71f099" : 
				try {
					if(apikeyuse%2==0)
					key = "RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f"; 
				}catch(Exception e) {
					key = presentKey;
					apikeyuse = 0;
				}
				break;
			case "RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f" : 
				try {
					if(apikeyuse%2==0)
					key = "RGAPI-e91563a2-e6d2-41e9-9803-42fc0d55ee59"; 
				}catch(Exception e) {
					key = presentKey;
					apikeyuse = 0;
				}
				break;
			case "RGAPI-e91563a2-e6d2-41e9-9803-42fc0d55ee59" : 
				try {
					if(apikeyuse%2==0)
					key = "RGAPI-08f1e023-d233-43fd-aed0-859fd61ea839"; 
				}catch(Exception e) {
					key = presentKey;
					apikeyuse = 0;
				}
				break;
			case "RGAPI-08f1e023-d233-43fd-aed0-859fd61ea839" : 
				try {
					if(apikeyuse%2==0)
					key = "RGAPI-fcefb3f5-9901-4070-9a91-48dc3f71f099"; 
				}catch(Exception e) {
					key = presentKey;
					apikeyuse = 0;
				}
				break;
			}
			//System.out.println("바꾼 키 : "+key);
		return key;
		
	}

}
