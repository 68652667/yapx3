package com.kh.yapx3.stat.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.yapx3.match.model.vo.Match;
import com.kh.yapx3.stat.model.service.StatService;
import com.kh.yapx3.stat.model.vo.Champ;
import com.kh.yapx3.stat.model.vo.ChampStat;
import com.kh.yapx3.stat.model.vo.MatchString;

@Controller
@RequestMapping("/stat")
public class StatController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	StatService statService;
	
	@RequestMapping("/statChamp.do")
	public ModelAndView statChamp() {
		ModelAndView mav = new ModelAndView();
		
		List<ChampStat> list = statService.selectChampStat();
		List<String> imgList = new ArrayList<String>();
		
		Map<String, String> chap = new HashMap<String, String>();
		
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		URL url;
		try {
			url = new URL(urlStr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
			String sb = br.readLine();
			JSONObject chapdata = new JSONObject(sb.toString());
			JSONObject chapdataObject = chapdata.getJSONObject("data");
			
			Iterator num1 = chapdataObject.keys();
			
			while(num1.hasNext()) {
				String dataKey = num1.next().toString();
				JSONObject data = chapdataObject.getJSONObject(dataKey);
				chap.put(data.getString("id"), data.getString("name"));
			}
			for(ChampStat c : list) {
				imgList.add(c.getChampionName());
				c.setChampionName(chap.get(c.getChampionName()));
			}
		} catch (Exception e) {}
		
		mav.addObject("list", list);
		mav.addObject("imgList", imgList);
		
		return mav;
	}
	
	@RequestMapping("/statTear.do")
	public ModelAndView statTear() {
		ModelAndView mav = new ModelAndView();
				
		return mav;
	}
	
	@RequestMapping("/champStatWin.do")
	public void champStatWin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		
		List<ChampStat> list = statService.selectChampStat();
		List<Champ> champList = new ArrayList<Champ>();
		
		Map<String, String> chap = new HashMap<String, String>();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject chapdata = new JSONObject(sb.toString());
		JSONObject chapdataObject = chapdata.getJSONObject("data");
		
		Iterator num1 = chapdataObject.keys();
		
		while(num1.hasNext()) {
			String dataKey = num1.next().toString();
			JSONObject data = chapdataObject.getJSONObject(dataKey);
			chap.put(data.getString("id"), data.getString("name"));
		}
		
		for(ChampStat c : list) {
			Champ ch = new Champ(chap.get(c.getChampionName()));
			ch.setChampionNo(c.getChampionNo());
			ch.setChampionName(c.getChampionName());
			ch.setBan(c.getBan());
			ch.setWin(c.getWin());
			ch.setPick(c.getPick());
			ch.setLose(c.getLose());
			champList.add(ch);
		}
		
		new Gson().toJson(champList, response.getWriter());
	}
	
	@RequestMapping("/champStatPick.do")
	public void champStatPick(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		
		List<ChampStat> list = statService.selectChampPick();
		List<Champ> champList = new ArrayList<Champ>();
		
		Map<String, String> chap = new HashMap<String, String>();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject chapdata = new JSONObject(sb.toString());
		JSONObject chapdataObject = chapdata.getJSONObject("data");
		
		Iterator num1 = chapdataObject.keys();
		
		while(num1.hasNext()) {
			String dataKey = num1.next().toString();
			JSONObject data = chapdataObject.getJSONObject(dataKey);
			chap.put(data.getString("id"), data.getString("name"));
		}
		
		for(ChampStat c : list) {
			Champ ch = new Champ(chap.get(c.getChampionName()));
			ch.setChampionNo(c.getChampionNo());
			ch.setChampionName(c.getChampionName());
			ch.setBan(c.getBan());
			ch.setWin(c.getWin());
			ch.setPick(c.getPick());
			ch.setLose(c.getLose());
			champList.add(ch);
		}
		
		new Gson().toJson(champList, response.getWriter());
	}
	
	@RequestMapping("/champStatBan.do")
	public void champStatBan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		
		List<ChampStat> list = statService.selectChampBan();
		List<Champ> champList = new ArrayList<Champ>();
		
		Map<String, String> chap = new HashMap<String, String>();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject chapdata = new JSONObject(sb.toString());
		JSONObject chapdataObject = chapdata.getJSONObject("data");
		
		Iterator num1 = chapdataObject.keys();
		
		while(num1.hasNext()) {
			String dataKey = num1.next().toString();
			JSONObject data = chapdataObject.getJSONObject(dataKey);
			chap.put(data.getString("id"), data.getString("name"));
		}
		
		for(ChampStat c : list) {
			Champ ch = new Champ(chap.get(c.getChampionName()));
			ch.setChampionNo(c.getChampionNo());
			ch.setChampionName(c.getChampionName());
			ch.setBan(c.getBan());
			ch.setWin(c.getWin());
			ch.setPick(c.getPick());
			ch.setLose(c.getLose());
			champList.add(ch);
		}
		
		new Gson().toJson(champList, response.getWriter());
	}
	
	@RequestMapping("/champStatWinB.do")
	public void champStatWinB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		
		List<ChampStat> list = statService.selectChampStatB();
		List<Champ> champList = new ArrayList<Champ>();
		
		Map<String, String> chap = new HashMap<String, String>();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject chapdata = new JSONObject(sb.toString());
		JSONObject chapdataObject = chapdata.getJSONObject("data");
		
		Iterator num1 = chapdataObject.keys();
		
		while(num1.hasNext()) {
			String dataKey = num1.next().toString();
			JSONObject data = chapdataObject.getJSONObject(dataKey);
			chap.put(data.getString("id"), data.getString("name"));
		}
		
		for(ChampStat c : list) {
			Champ ch = new Champ(chap.get(c.getChampionName()));
			ch.setChampionNo(c.getChampionNo());
			ch.setChampionName(c.getChampionName());
			ch.setBan(c.getBan());
			ch.setWin(c.getWin());
			ch.setPick(c.getPick());
			ch.setLose(c.getLose());
			champList.add(ch);
		}
		
		new Gson().toJson(champList, response.getWriter());
	}
	
	@RequestMapping("/champStatPickB.do")
	public void champStatPickB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		
		List<ChampStat> list = statService.selectChampPickB();
		List<Champ> champList = new ArrayList<Champ>();
		
		Map<String, String> chap = new HashMap<String, String>();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject chapdata = new JSONObject(sb.toString());
		JSONObject chapdataObject = chapdata.getJSONObject("data");
		
		Iterator num1 = chapdataObject.keys();
		
		while(num1.hasNext()) {
			String dataKey = num1.next().toString();
			JSONObject data = chapdataObject.getJSONObject(dataKey);
			chap.put(data.getString("id"), data.getString("name"));
		}
		
		for(ChampStat c : list) {
			Champ ch = new Champ(chap.get(c.getChampionName()));
			ch.setChampionNo(c.getChampionNo());
			ch.setChampionName(c.getChampionName());
			ch.setBan(c.getBan());
			ch.setWin(c.getWin());
			ch.setPick(c.getPick());
			ch.setLose(c.getLose());
			champList.add(ch);
		}
		
		new Gson().toJson(champList, response.getWriter());
	}
	
	@RequestMapping("/champStatBanB.do")
	public void champStatBanB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		
		List<ChampStat> list = statService.selectChampBanB();
		List<Champ> champList = new ArrayList<Champ>();
		
		Map<String, String> chap = new HashMap<String, String>();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		URL url = new URL(urlStr);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		String sb = br.readLine();
		JSONObject chapdata = new JSONObject(sb.toString());
		JSONObject chapdataObject = chapdata.getJSONObject("data");
		
		Iterator num1 = chapdataObject.keys();
		
		while(num1.hasNext()) {
			String dataKey = num1.next().toString();
			JSONObject data = chapdataObject.getJSONObject(dataKey);
			chap.put(data.getString("id"), data.getString("name"));
		}
		
		for(ChampStat c : list) {
			Champ ch = new Champ(chap.get(c.getChampionName()));
			ch.setChampionNo(c.getChampionNo());
			ch.setChampionName(c.getChampionName());
			ch.setBan(c.getBan());
			ch.setWin(c.getWin());
			ch.setPick(c.getPick());
			ch.setLose(c.getLose());
			champList.add(ch);
		}
		
		new Gson().toJson(champList, response.getWriter());
	}
	
}
