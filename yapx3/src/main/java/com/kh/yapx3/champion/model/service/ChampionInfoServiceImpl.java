package com.kh.yapx3.champion.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
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

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.vo.ChampionInfoVO;
import com.kh.yapx3.champion.model.vo.ChampionKoN;
import com.kh.yapx3.champion.model.vo.ChampionSkillInfo;



@Service
public class ChampionInfoServiceImpl {
	
	
	Logger logger = LoggerFactory.getLogger(getClass());

//챔피언 라인 통계
	public List<ChampionInfoVO> championInfo(int championId) {
			try(FileReader reader = new FileReader("/Users/anchangho/git/yapx3/yapx3/json파일/championLane.json");
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
		try(FileReader reader = new FileReader("/Users/anchangho/git/yapx3/yapx3/json파일/skill.json");
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
			try(FileReader reader = new FileReader("/Users/anchangho/git/yapx3/yapx3/json파일/championFinalItem.json");
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
				logger.info("sortedMap: " + sortedMap);
				return sortedMap;
//				logger.info("jobj: " + jobj);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	    return null;
	}
	
//챔피언 스팰 통계
	public List<ChampionInfoVO> summonerSkillList(int championId) {
		try(FileReader reader = new FileReader("/Users/anchangho/git/yapx3/yapx3/json파일/championSpell.json");
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
						logger.info("jsonObject: " + jarr.getJSONObject(i).getInt("key"));
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
		try(FileReader reader = new FileReader("/Users/anchangho/git/yapx3/yapx3/json파일/championRune.json");
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
		try(FileReader reader = new FileReader("/Users/anchangho/git/yapx3/yapx3/json파일/championStartItem.json");
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

	

	

	
	
}
