package com.kh.yapx3.item.controller;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.service.ChampValue;
import com.kh.yapx3.item.model.dao.ItemDAO;
import com.kh.yapx3.item.model.service.ItemsExportService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ItemsExportService itemsExportService;
	
	@Autowired
	ItemDAO itemDAO;
	
	
	@RequestMapping("/data")
	public ResponseEntity<?> ItemsData(){
		List<JSONObject> itemAll = itemsExportService.item();
		return ResponseEntity.ok(itemAll);
	}
	
	@RequestMapping("/pick/{id}")
	public ResponseEntity<?> itemPick(@PathVariable("id") String id){
		String championId = id;
		//logger.info(championId);
		net.sf.json.JSONArray pickItem = itemsExportService.pickitem(championId);
		return ResponseEntity.ok(pickItem);
	}
	
	@RequestMapping("/participantCall")
	public ResponseEntity<?> participantCall(){
		
		itemsExportService.participant();
		
		return ResponseEntity.ok("ss");
	}
	
//	@RequestMapping("/test/{id}")
//	public ResponseEntity<?> testSelect(@PathVariable("id") String championId){
//		RestTemplate restTemplate = new RestTemplate();
//		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
//		String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
//		HttpHeaders header = new HttpHeaders();
//		HttpEntity<String> httpEntity = new HttpEntity<>(header);
//		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
//		Map<String, Integer> championMap = new HashMap<String, Integer>();
//		Map<String, Integer> championKON;
//		
//		List<String> championIdList;
//		List<Integer> championKey;
//		
//		championKON = new HashMap<String, Integer>();
//		championIdList = new ArrayList<String>();
//		championKey = new ArrayList<Integer>();
//		
//		for (Map.Entry<String, ChampValue> champ : championAll.getBody().getData().entrySet()) {
//			championKON.put(champ.getValue().getName(), champ.getValue().getKey());
//			championIdList.add(champ.getValue().getId());
//			championKey.add(champ.getValue().getKey());
//		}
//		
//		List<JSONObject> jobj = new ArrayList<JSONObject>();
//		jobj = itemDAO.items();
//		JSONArray jarr = new JSONArray(jobj);
//		
//		List<String> itemList = new ArrayList<String>();
//		for(int i = 0; i< jarr.length(); i++) {
//			itemList.add(jarr.getJSONObject(i).getString("itemId"));
//		}
//		
//		String sql = "";
//		try {
//			for(int x = 0; x < championIdList.size(); x ++) {
//				File file = new File("/Users/anchangho/git/yapx3/yapx3/championISQL/"+championIdList.get(x) + x + ".sql");
//				FileWriter fw = new FileWriter(file);
//				for(int i = 1; i < 11; i++) {
//		        	for(int j = 0; j < itemList.size(); j++) {
//		        		for(int k = 0; k < 7; k++) {
//		        			sql = "update championItems set " + championIdList.get(x)+ " = " + championIdList.get(x) + " + (select count(*) from match where participant"+i+" like '%championId:\""+championKey.get(x)+"\"%' and participant"+i+" like '%item"+k+":\""+itemList.get(j)+"\"%') where itemsname = " + itemList.get(j)+";";
//		        			//logger.info("sql: " + sql);
//		        			fw.write(sql +"\n");
//		        		}
//		        	}
//		        	
//		        }
//				fw.close();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return ResponseEntity.ok("dddddd");
//	}
	
//	@RequestMapping("/insertChampionName")
//	public void insertChampion() {
//		itemsExportService.insertItem();
//	}
	
	

}
