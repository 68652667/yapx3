package com.kh.yapx3.champion.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.common.URLConnection;
import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.dao.ChampionDAO;
import com.kh.yapx3.champion.model.vo.ChampionInfoVO;
import com.kh.yapx3.champion.model.vo.ChampionKoN;
import com.kh.yapx3.champion.model.vo.ChampionSkillInfo;
import com.kh.yapx3.champion.model.vo.ChampionTipBoardVO;



@Service
public class ChampionInfoServiceImpl {
	
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ChampionDAO championDAO;
	
	@Autowired
	ServletContext servletContext;

//챔피언 라인 통계
	public List<ChampionInfoVO> championInfo(int championId) {
			try(FileReader reader = new FileReader(servletContext.getRealPath("/resources/json/championLane.json"));
				BufferedReader br = new BufferedReader(reader);){
				Map<String, String> championLane = new HashMap<String, String>();
				String line;
				String jj="";
				ChampionInfoVO championInfo;
				while((line = br.readLine()) != null) {
					jj += line;
				}
				JSONArray jobj = new JSONArray(jj.toString());
				List<ChampionInfoVO> championInfoList = new ArrayList<ChampionInfoVO>();
				for(int i = 0 ; i < jobj.length(); i++) {
					Iterator<String> lane = jobj.getJSONObject(i).keySet().iterator();
					while(lane.hasNext()) {
						championInfo = new ChampionInfoVO();
						String position = lane.next();
						if(jobj.getJSONObject(i).getInt("key") == championId) {
							if(position.equals("key")) {
								continue;
							}else {
								championInfo.setChampionLane(position);
								championInfo.setChampionLaneCount(jobj.getJSONObject(i).getString(position));
								championInfoList.add(championInfo);
							}
						}
					}
				}
				return championInfoList;
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}

//챔피언 스킬 이미지와 스킬 
	public ChampionSkillInfo championInfoSkill(int championId) {
		try(FileReader reader = new FileReader(servletContext.getRealPath("/resources/json/skill.json"));
				BufferedReader br = new BufferedReader(reader);){
				String line;
				String jj="";
				ChampionSkillInfo championSkillInfo = new ChampionSkillInfo();
				while((line = br.readLine()) != null) {
					jj += line;
				}
				JSONArray jarr = new JSONArray(jj.toString());
				for(int i = 0; i < jarr.length(); i++) {
					if(championId == jarr.getJSONObject(i).getInt("key")) {
						championSkillInfo.setqSkill(jarr.getJSONObject(i).getString("championQSkill"));
						championSkillInfo.setwSkill(jarr.getJSONObject(i).getString("championWSkill"));
						championSkillInfo.seteSkill(jarr.getJSONObject(i).getString("championESkill"));
						championSkillInfo.setrSkill(jarr.getJSONObject(i).getString("championRSkill"));
						championSkillInfo.setqSkillTolltip(jarr.getJSONObject(i).getString("championQSkill").substring(0, jarr.getJSONObject(i).getString("championQSkill").length()-4));
						championSkillInfo.setwSkillTolltip(jarr.getJSONObject(i).getString("championWSkill").substring(0, jarr.getJSONObject(i).getString("championWSkill").length()-4));
						championSkillInfo.seteSkillTolltip(jarr.getJSONObject(i).getString("championESkill").substring(0, jarr.getJSONObject(i).getString("championESkill").length()-4));
						championSkillInfo.setrSkillTolltip(jarr.getJSONObject(i).getString("championRSkill").substring(0, jarr.getJSONObject(i).getString("championRSkill").length()-4));
						championSkillInfo.setPassivSkillTolltip(jarr.getJSONObject(i).getString("championPassiveSkill").substring(0, jarr.getJSONObject(i).getString("championPassiveSkill").length()-4));
						championSkillInfo.setChampionId(jarr.getJSONObject(i).getString("championId"));
						championSkillInfo.setChampionName(jarr.getJSONObject(i).getString("championName"));
						championSkillInfo.setPassive(jarr.getJSONObject(i).getString("championPassiveSkill"));
					}
				}
				return championSkillInfo;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

//챔피언 최종아이템 통계
	public Map<String, Integer> championFinalItem(int championId) {
			
//			JSONParser parser = new JSONParser();
			try(FileReader reader = new FileReader(servletContext.getRealPath("/resources/json/championFinalItem.json"));
				BufferedReader br = new BufferedReader(reader);){
				
				String line;
				String jj="";
				while((line = br.readLine()) != null) {
					jj += line;
				}
				Map<String, Integer> map = new HashMap<String, Integer>();
				Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
				JSONArray jobj = new JSONArray(jj);
				for(int i = 0 ; i < jobj.length(); i ++) {
					if(championId == jobj.getJSONArray(i).getJSONObject(0).getInt("key")) {
						Iterator<String> iter  = jobj.getJSONArray(i).getJSONObject(0).keySet().iterator();
						while(iter.hasNext()) {
							String key = iter.next();
							if(key.equals("championName")|| key.equals("key")) {
								continue;
							}else {
								map.put(key, jobj.getJSONArray(i).getJSONObject(0).getInt(key));
							}
						}
						
						List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
						
						Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

							@Override
							public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
								int comparision = (o1.getValue() - o2.getValue()) * -1;
								return comparision == 0? o1.getKey().compareTo(o2.getKey()) : comparision;
							}
						});
						
						
						for(Iterator<Map.Entry<String, Integer>> itersort = list.iterator(); itersort.hasNext();) {
							Map.Entry<String, Integer> entry = itersort.next();
							sortedMap.put(entry.getKey(), entry.getValue());
						}
 					}
					
				}
				//logger.info("sortedMap: " + sortedMap);
				return sortedMap;
//				//logger.info("jobj: " + jobj);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	    return null;
	}
	
//챔피언 스팰 통계
	public List<ChampionInfoVO> summonerSkillList(int championId) {
		try(FileReader reader = new FileReader(servletContext.getRealPath("/resources/json/championSpell.json"));
				BufferedReader br = new BufferedReader(reader);){
				String line;
				String jj="";
				ChampionInfoVO championInfo;
				int count = 0;
				List<ChampionInfoVO> championInfoList = new ArrayList<ChampionInfoVO>();
				while((line = br.readLine()) != null) {
					jj += line;
				}
				JSONArray jarr = new JSONArray(jj.toString());
				
				for(int i = 0 ; i < jarr.length();i++) {
					if(jarr.getJSONObject(i).getInt("key") == championId) {
						//logger.info("jsonObject: " + jarr.getJSONObject(i).getInt("key"));
						championInfo = new ChampionInfoVO();
						championInfo.setSummonerSpell1id(jarr.getJSONObject(i).get("spell1id").toString());
						championInfo.setSummonerSpell2id(jarr.getJSONObject(i).get("spell2id").toString());
						championInfo.setSummonerSpellWinCountStr(jarr.getJSONObject(i).get("championWinSpellCountStr").toString());
						championInfo.setSummonerSpellCountStr(jarr.getJSONObject(i).get("championSpellCountStr").toString());
						championInfoList.add(championInfo);
					}
				}
					
				
				return championInfoList;
		}catch(Exception e) {
			
		}
		return null;
	}
//챔피언의 시작아이템 통계
	public List<ChampionInfoVO> championRune(int championId) {
		try(FileReader reader = new FileReader(servletContext.getRealPath("/resources/json/championRune.json"));
			BufferedReader br = new BufferedReader(reader);) {
			String line;
			String jj="";
			ChampionInfoVO championInfo;
			List<ChampionInfoVO> championInfoList = new ArrayList<ChampionInfoVO>();
			while((line = br.readLine()) != null) {
				jj += line;
			}
			JSONArray jarr = new JSONArray(jj.toString());
			for(int i = 0 ; i < jarr.length(); i++) {
				if(jarr.getJSONObject(i).getInt("key") == championId) {
					championInfo = new ChampionInfoVO();
					championInfo.setPerkPrimaryStyle(jarr.getJSONObject(i).getInt("perkPrimaryStyle"));
					championInfo.setPerkSubStyle(jarr.getJSONObject(i).getInt("perkSubStyle"));
					championInfo.setStatPerk0(jarr.getJSONObject(i).getInt("statPerk0"));
					championInfo.setStatPerk1(jarr.getJSONObject(i).getInt("statPerk1"));
					championInfo.setStatPerk2(jarr.getJSONObject(i).getInt("statPerk2"));
					championInfo.setCount(jarr.getJSONObject(i).getInt("count"));
					championInfo.setChampionRunePercenter(jarr.getJSONObject(i).get("championRunePercenter").toString());
					championInfo.setChampionName(jarr.getJSONObject(i).get("championName").toString());
					championInfo.setPerk0(jarr.getJSONObject(i).getInt("perk0"));
					championInfo.setPerk1(jarr.getJSONObject(i).getInt("perk1"));
					championInfo.setPerk2(jarr.getJSONObject(i).getInt("perk2"));
					championInfo.setPerk3(jarr.getJSONObject(i).getInt("perk3"));
					championInfo.setPerk4(jarr.getJSONObject(i).getInt("perk4"));
					championInfo.setPerk5(jarr.getJSONObject(i).getInt("perk5"));
					championInfoList.add(championInfo);
				}
			}
			return championInfoList;
		}catch(Exception e) {
			
		}
		return null;
	}
	
//챔피언의 시작탬
	public ChampionInfoVO championStartItem(int championId) {
		try(FileReader reader = new FileReader(servletContext.getRealPath("/resources/json/championStartItem.json"));
				BufferedReader br = new BufferedReader(reader);) {
				String line;
				String jj="";
				ChampionInfoVO championInfo;
				List<ChampionInfoVO> championInfoList = new ArrayList<ChampionInfoVO>();
				while((line = br.readLine()) != null) {
					jj += line;
				}
				JSONArray jarr = new JSONArray(jj.toString());
				for(int i = 0; i < jarr.length(); i++) {
					if(jarr.getJSONObject(i).getInt("key") == championId) {
						championInfo = new ChampionInfoVO();
						championInfo.setStartItem1(jarr.getJSONObject(i).get("startItem1").toString());
						championInfo.setStartItem2(jarr.getJSONObject(i).get("startItem2").toString());
						championInfo.setStartItem3(jarr.getJSONObject(i).get("startItem3").toString());
						championInfo.setItemStartPercent1(jarr.getJSONObject(i).get("startPercent1").toString());
						championInfo.setItemStartPercent2(jarr.getJSONObject(i).get("startPercent2").toString());
						return championInfo;
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//모든 챔피언의 리스트를 가져온다(가,나,다 순)
	public List<ChampionKoN> championAll() {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);

		Map<String, Integer> championKON = new HashMap<String, Integer>();
		List<String> championName = new ArrayList<String>();
		List<Integer> championKey = new ArrayList<Integer>();

		ChampionKoN championKon;
		List<ChampionKoN> championKonList = new ArrayList<ChampionKoN>();
		for (Map.Entry<String, ChampValue> champ : championAll.getBody().getData().entrySet()) {
			championKon = new ChampionKoN();
			championKon.setChampionId(champ.getValue().getId());
			championKon.setChampionName(champ.getValue().getName());
			championKon.setChampionKey(champ.getValue().getKey());
			championKonList.add(championKon);
		}
		
		Collections.sort(championKonList, new Comparator<ChampionKoN>() {

			@Override
			public int compare(ChampionKoN o1, ChampionKoN o2) {
				String championName1 = o1.getChampionName();
				String championName2 = o2.getChampionName();
				return championName1.compareToIgnoreCase(championName2);
			}
		});
		

		return championKonList;
	}
	
	public String championGetName(int championId) {
		URLConnection connection = new URLConnection();
		String name = "";
		try {
			ChampionAll champion = connection.championData();
			Iterator<String> iter = (Iterator<String>) champion.getData().keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				if(championId == champion.getData().get(key).getKey()) {
					name = champion.getData().get(key).getId();
				}
			}
			return name;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public ChampionSkillInfo championInfoSkillTool(String championName) {
		URLConnection connection = new URLConnection();
		try {
			JSONObject jobj = connection.championDetailData(championName);
			JSONArray jarr = jobj.getJSONObject("data").getJSONObject(championName).getJSONArray("spells");
			ChampionSkillInfo skilltool = new ChampionSkillInfo();
			for(int i= 0 ; i < jarr.length(); i++) {
				switch (i) {
					case 0: skilltool.setqSkillTolltip(jarr.getJSONObject(i).getString("description"));break;
					case 1: skilltool.setwSkillTolltip(jarr.getJSONObject(i).getString("description"));break;
					case 2: skilltool.seteSkillTolltip(jarr.getJSONObject(i).getString("description"));break;
					case 3: skilltool.setrSkillTolltip(jarr.getJSONObject(i).getString("description"));break;
					default:break;
				}
			}
			skilltool.setPassivSkillTolltip(jobj.getJSONObject("data").getJSONObject(championName).getJSONObject("passive").getString("description"));
			return skilltool;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int championTipInsert(ChampionTipBoardVO tipBoard) {
		int result = championDAO.championTipInsert(tipBoard);
		return result;
	}

	public List<ChampionTipBoardVO> championGetTipList(int championId) {
		List<ChampionTipBoardVO> tip = championDAO.championGetTipList(championId);
 		return tip;
	}

	public String[] championTipLike(ChampionTipBoardVO tip, String likeType) {
		
		
		String[] likeSelectIdSplit = null;
		if(likeType.equals("up")) {
			
			String likeSelectUser="";
			String likeSelectId = championDAO.championTipLikeSelect(tip.getChampTipNo());
			int result = 0;
			if(likeSelectId == null) {
				tip.setChampionTipLikeList(tip.getUserId()+", ");
				//logger.info("likeSelectId == null: " + tip.getUserId());
				result = championDAO.championTipLike(tip);
			}else {
				likeSelectIdSplit = likeSelectId.split(", ");
				for(int i= 0; i < likeSelectIdSplit.length; i++) {
					if(likeSelectIdSplit[i].equals(tip.getUserId())) {
//						logger.info(likeSelectIdSplit[i]+" == " + tip.getUserId());
						return likeSelectIdSplit;
					}
					//logger.info("likeSelectIdSplit : " + likeSelectIdSplit[i]);
					likeSelectUser += likeSelectIdSplit[i]+", "; 
				}
				//logger.info("likeSelectUser: " + likeSelectUser);
				tip.setChampionTipLikeList(likeSelectUser+tip.getUserId());
				//logger.info("tip.getChampionTipLikeList(): " + tip.getChampionTipLikeList());
				result = championDAO.championTipLike(tip);
			}
		}
		return likeSelectIdSplit;
	}

	public String itemDescription(int itemNo) {
		URLConnection connection = new URLConnection();
		String description ="";
		try {
			JSONObject jobj = connection.championItemInfoData();
			JSONObject data = jobj.getJSONObject("data");
			Iterator<String> iter = data.keySet().iterator();
			while(iter.hasNext()) {
				String itemKey = iter.next();
				if(Integer.parseInt(itemKey) == itemNo) {
					description = data.getJSONObject(itemKey).getString("description");
				}
			}
			return description;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String summonerSpellDescription(String spell) {
		URLConnection connection = new URLConnection();
		String description ="";
		try {
			JSONObject jobj = connection.summonerSpell();
			JSONObject data = jobj.getJSONObject("data");
			Iterator<String> iter = data.keySet().iterator();
			while(iter.hasNext()) {
				String spellName = iter.next();
				if(data.getJSONObject(spellName).getString("id").equals(spell)) {
					description = data.getJSONObject(spellName).getString("description");
				}
			}
			return description;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
