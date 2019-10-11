package com.kh.yapx3.item.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.service.ChampValue;
import com.kh.yapx3.champion.model.vo.Camp;
import com.kh.yapx3.item.common.URLConnection;
import com.kh.yapx3.item.model.dao.ItemDAO;
import com.kh.yapx3.item.model.vo.participant.Participant;

@Service
public class ItemsExportService {

	Logger logger = LoggerFactory.getLogger(getClass());
	URLConnection connection = new URLConnection();
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	ItemDAO itemDAO;

	public List<JSONObject> item() {
		List<JSONObject> jobj = new ArrayList<JSONObject>();
		jobj = itemDAO.items();
		JSONArray jarr = new JSONArray(jobj);

		List<String> itemList = new ArrayList<String>();
		for (int i = 0; i < jarr.length(); i++) {
			itemList.add(jarr.getJSONObject(i).getString("itemId"));
			//logger.info("jobj:" + jarr.getJSONObject(i).getString("itemId"));
		}
		return jobj;
	}

	public net.sf.json.JSONArray pickitem(String championId) {
		// itmeList 불러오기
		List<JSONObject> jobj = new ArrayList<JSONObject>();
		jobj = itemDAO.items();
		JSONArray jarr = new JSONArray(jobj);

		List<String> itemList = new ArrayList<String>();
		for (int i = 0; i < jarr.length(); i++) {
			itemList.add(jarr.getJSONObject(i).getString("itemId"));
			//logger.info("jobj:" + jarr.getJSONObject(i).getString("itemId"));
		}

		net.sf.json.JSONArray list = new net.sf.json.JSONArray();
		list = itemDAO.pickItems(championId, itemList);

		// participant별 챔피언 픽률
//		net.sf.json.JSONArray list = new net.sf.json.JSONArray();
//		list = itemDAO.pickItems(championId);
//		//logger.info("listSize: " + list.size());
//		for(int i = 0 ; i <list.size(); i++) {
//			//logger.info("list: " + list.getJSONObject(i).get("participant" + i));
//		}
		return list;
	}

	// 아이템 이름 넣는 메소드
//	public void insertItem() {
//		List<JSONObject> jobj = new ArrayList<JSONObject>();
//		jobj = itemDAO.items();
//		JSONArray jarr = new JSONArray(jobj);
//		
//		List<String> itemList = new ArrayList<String>();
//		for(int i = 0; i< jarr.length(); i++) {
//			itemList.add(jarr.getJSONObject(i).getString("itemId"));
//		}
//		itemDAO.insertItem(itemList);
//	}

	public void updateItem() {

	}

	public void participant() {
		List<Map<String, JSONObject>> jobjList = itemDAO.participant();

		for(int i = 0; i<jobjList.size(); i++) {
			JSONObject jobj = (JSONObject) jobjList.get(i);
			//logger.info("jobjList: " + jobjList.get(i));
			//logger.info("jobj: " + jobj);
			
		}
		
	}
}
