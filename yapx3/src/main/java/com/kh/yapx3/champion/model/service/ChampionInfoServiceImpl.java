package com.kh.yapx3.champion.model.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import com.kh.yapx3.champion.model.challenger.ChallengerLegue;
import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.dao.ChampionDAO;
import com.kh.yapx3.champion.model.matchline.ChampionMatchLine;
import com.kh.yapx3.champion.model.matchline.MatchVO;
import com.kh.yapx3.champion.model.summoner.Summoner;
import com.kh.yapx3.champion.model.vo.ChampionInfoVO;
import com.kh.yapx3.champion.model.vo.ChampionSkillInfo;
import com.kh.yapx3.champion.model.vo.MatchInfoVO;

@Service
public class ChampionInfoServiceImpl implements ChampionInfoService{
	
	URLConnection connection; 
	Logger logger = LoggerFactory.getLogger(getClass());
	private String encrypteSummonerName;
	RestTemplate restTemplate = new RestTemplate();
	String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
	int totalCount = 0;
	
	@Autowired
	private ChampionDAO championDAO;
	
// 소환사 아이디로 게임아이디를 찾아 아이템 리스트를 가져오는 메소드
	public MatchInfoVO game(JSONArray jarr) throws IOException{
		String gameId = null;
		MatchInfoVO mvo = new MatchInfoVO();
		int [] items;
		String [] participantId;
		String str = null;
		for(int i = 0; i<jarr.length(); i++) {
			//총 게임수
			JSONArray arr = new JSONArray();
			JSONObject jj = new JSONObject();
			gameId = jarr.getJSONArray(i).getJSONObject(0).get("gameId").toString();
			JSONObject gameJobj = connection.matchGame(gameId);
			participantId = new String[10];
			
			//게임당 총 인원수
			for(int k = 0; k < 10; k++) {
				JSONObject participantIdItems = new JSONObject();
				
				mvo.setChampionId(gameJobj.getJSONArray("participants").getJSONObject(k).getInt("championId"));
				participantId[k] = gameJobj.getJSONArray("participants").getJSONObject(k).getJSONObject("stats").get("participantId").toString();
				items = new int[7];
				for(int j = 0; j<7; j++) {
					items[j] = gameJobj.getJSONArray("participants").getJSONObject(k).getJSONObject("stats").getInt("item"+j);
					mvo.setParticipantIdOrItem(arr.put(participantIdItems.put(participantId[k], items[j]).toString()));
				}
			}
			System.out.println(str);
		}
		return mvo;
	}

//첼린져의 게임을 찾아서 가져온다.
	public Map<String, String> chMastery(String searchMastery) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		try {
			//url연결
			connection = new URLConnection();
			System.out.println(searchMastery);
			JSONObject jobj = connection.searhName(searchMastery);
			
			//암호화된 소환사 닉네임
			encrypteSummonerName =  (String) jobj.get("id");
            System.out.println(jobj);
            
            //모든 챔피언 가져오기
            JSONObject championJobj = connection.championDataOrigin();
            JSONObject championKeyJobj = (JSONObject) championJobj.get("data");
            
			JSONArray jarray = connection.chMatery(encrypteSummonerName);
			
			Iterator iter = (Iterator) championKeyJobj.keys();
			
			while(iter.hasNext()) {
				String dataKey = iter.next().toString();
				JSONObject data = championKeyJobj.getJSONObject(dataKey);
				JSONObject data_ = data.getJSONObject("image");
				String img = data_.getString("full");
				String key = data.getString("key");
				
				for(int i = 0 ; i < jarray.length(); i++) {
	                if(key.equals(jarray.getJSONObject(i).get("championId").toString())) {	                	
	                	map.put(img, jarray.getJSONObject(i).get("championPoints").toString());
	                }
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

//모든 챔피언의 리스트를 가져온다(가,나,다 순)
	public Map<String, Integer> championAll() {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);

		Map<String, Integer> championKON = new HashMap<String, Integer>();
		List<String> championName = new ArrayList<String>();
		List<Integer> championKey = new ArrayList<Integer>();

		for (Map.Entry<String, ChampValue> champ : championAll.getBody().getData().entrySet()) {
			championKON.put(champ.getValue().getId(), champ.getValue().getKey());
			championName.add(champ.getValue().getId());
			championKey.add(champ.getValue().getKey());
		}
		
//		matchDAO.championInsert(championName, championKey);

		return championKON;
	}

//소환사의 이름으로 정보를 가져온다.
	public Map<String, String> apiTest(String searchName) {
		Map<String, String> map = new HashMap<>();
		try {
			connection = new URLConnection();
			JSONObject jobj = connection.searhName(searchName);
			
			System.out.println(jobj.get(("summonerLevel")));
			map.put("name", jobj.getString("name"));
			map.put("summonerLevel", jobj.get(("summonerLevel")).toString());
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}

	@Override
	public List<String> champion() {
		// TODO Auto-generated method stub
		return null;
	}

//첼린져 유저(소환사 이름과 암호화된 소환사 이름) 
	public Map<String, String> challengerLegue() {
		String urlStr = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?" + api;
		HttpHeaders header = new HttpHeaders();
	    HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChallengerLegue> challengerLegue = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChallengerLegue.class);
		
		Map<String, String> summonerNameMap = new HashMap<String, String>();
		System.out.println(challengerLegue.getBody().getEntries().size());
//		for(int i = 0; i < challengerLegue.getBody().getEntries().size(); i++) {
		for(int i = 0; i < 30; i++) {
			
			System.out.println("암호화 전 소환사 닉네임: " + challengerLegue.getBody().getEntries().get(i).getSummonerName());
			System.out.println("암호화 된 소환사 닉네임: " + challengerLegue.getBody().getEntries().get(i).getSummonerId());
			summonerNameMap.put(challengerLegue.getBody().getEntries().get(i).getSummonerName(), challengerLegue.getBody().getEntries().get(i).getSummonerId());
		}
		System.out.println(summonerNameMap);
		return summonerNameMap;
	}
	
//첼린져 유저한명당 플레이한 게임들
	public List<MatchVO> playGame(String accountId, int championIdCheck) {
		//championIdCheck => index.jsp에서 챔피언 선택했을시의 챔피언의 아이디(key)
		String urlStr = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId + "?" + api;
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionMatchLine> championMatchLine = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionMatchLine.class);
		List<MatchVO> listMatch = new ArrayList<MatchVO>();
		MatchVO match;
		for(int i = 0; i < championMatchLine.getBody().getMatches().size(); i++) {
//		for(int i = 0; i < 10; i++) {
			if(championIdCheck == championMatchLine.getBody().getMatches().get(i).getChampion()){
				match = new MatchVO();
				match.setAccountId(accountId);
				match.setLane(championMatchLine.getBody().getMatches().get(i).getLane());
				match.setGameId(championMatchLine.getBody().getMatches().get(i).getGameId());
				match.setChampionId(championMatchLine.getBody().getMatches().get(i).getChampion());
				listMatch.add(match);
			}
		}
		return listMatch;
	}
	
//소환사 닉네임으로 AccountId 찾기
	public String summonerSearch(String summonerName) {
		String urlStr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?" + api;
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<Summoner> summonerAccountId = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, Summoner.class);
		System.out.println("getAccountId(): " + summonerAccountId.getBody().getAccountId());
		
		return summonerAccountId.getBody().getAccountId();
	}

//챔피언의 통계(아이템, 룬, 스펠, 스킬)을 가져온다.
	public List<ChampionInfoVO> championInfo(int championId) {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
		
		Iterator<String> iter =  championAll.getBody().getData().keySet().iterator();
		List<Integer> championKey = new ArrayList<Integer>();
		while(iter.hasNext()) {
			String key = iter.next();
			championKey.add(championAll.getBody().getData().get(key).getKey());
		}
		List<JSONObject> jobjList = new ArrayList<JSONObject>();
		for(int j = 0 ; j < championKey.size(); j++) {
			
			logger.info("championKey: "  + championKey.get(j));
			double championCount = championDAO.championCount(championKey.get(j));
			
			List<Map<String, String>> lineList = new ArrayList<Map<String,String>>();
			lineList = championLine(championKey.get(j));
			
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
			
			JSONObject jobj = new JSONObject();
			jobj.put("key", championKey.get(j));
			for( int i = 0 ; i < championLine.size(); i++) {
				championLane = new ChampionInfoVO();
				String championLineCountStr = String.format("%.2f", championLaneCountList.get(i)*100/championCount) + "%";
				if(championLanePosition.get(i).equals("TOP")) {
					championLane.setChampionLane("탑");
					jobj.put("탑", championLineCountStr);
				}else if(championLanePosition.get(i).equals("BOTTOM")) {
					championLane.setChampionLane("바텀");
					jobj.put("바텀", championLineCountStr);
				}else if(championLanePosition.get(i).equals("JUNGLE")) {
					championLane.setChampionLane("정글");
					jobj.put("정글", championLineCountStr);
				}else if(championLanePosition.get(i).equals("MIDDLE")) {
					championLane.setChampionLane("미드");
					jobj.put("미드", championLineCountStr);
				}
				championLane.setChampionLaneCount(championLineCountStr);
				championLaneList.add(championLane);
			}
			
			jobjList.add(jobj);
			
			logger.info("createJSONObject: " +  jobj.toString());
//			logger.info("createJSONObjectList: " +  jobjList);
		}
		try {
			File file = new File("/Users/anchangho/git/yapx3/yapx3/json파일/championLane.json");
			FileWriter fw = new FileWriter(file, true);
			fw.write(jobjList.toString());
			fw.flush();
			fw.close();
			
		}catch(Exception e) {
		}
		return null;
	}

//챔피언 라인 리스트 NONE제외 시키는 메소드
	@Override
	public List<Map<String, String>> championLine(int championId) {
		List<Map<String, String>> championLine = championDAO.championLineAll(championId);
		List<Map<String, String>> lineList = new ArrayList<Map<String, String>>();
		for(int i = 0; i < championLine.size(); i++) {
			logger.info("mapList: " + championLine.get(i).get("LANE"));
		}
		for(int i = 0; i < championLine.size(); i++) {
			if(lineList.size() == 2) {
				logger.info("lineList Size = 2");
				break;
			}else {
				if(championLine.get(i).get("LANE").toString().equals("NONE")) {
					logger.info("LANE: NONE");
				}else {
					logger.info("LANE: anyone");
					lineList.add(championLine.get(i));
				}
			}
		}
		return lineList;
	}

//해당 챔피언의 가장 많이 쓴 소환사 스킬
	@Override
	public List<ChampionInfoVO> summonerSkillList(int championId) {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
		
		Iterator<String> iter1 =  championAll.getBody().getData().keySet().iterator();
		List<Integer> championKey = new ArrayList<Integer>();
		List<String> championName = new ArrayList<String>();
		while(iter1.hasNext()) {
			String key = iter1.next();
			championKey.add(championAll.getBody().getData().get(key).getKey());
			championName.add(championAll.getBody().getData().get(key).getId());
		}
		
		List<JSONObject> jobjList = new ArrayList<JSONObject>();
		for(int a = 0 ; a < championKey.size(); a++) {
			logger.info("------------------------시작------------------------------------");
			logger.info("championKey: " + championKey.get(a));
			List<ChampionInfoVO> spellList = championDAO.summonerSkill(championKey.get(a));
			List<Integer> winCountList = summonerWinSkillList(championKey.get(a));
			int count = 0;
			Map<Integer, String> map = new HashMap<Integer, String>();
			for(int i = 0 ; i < spellList.size(); i++) {
				for(int j = i+1; j < spellList.size(); j++) {
					if(spellList.get(i).getSummonerSpell1id().equals(spellList.get(j).getSummonerSpell2id()) &&
							spellList.get(i).getSummonerSpell2id().equals(spellList.get(j).getSummonerSpell1id())) {
						count = spellList.get(i).getCount() + spellList.get(j).getCount();
						map.put(count, String.valueOf(spellList.get(i).getSummonerSpell2id())+","+String.valueOf(spellList.get(i).getSummonerSpell1id()) );
					}else {
						count = spellList.get(j).getCount();
						map.put(count, String.valueOf(spellList.get(i).getSummonerSpell2id())+","+String.valueOf(spellList.get(i).getSummonerSpell1id()) );
					}
				}
				if(i == spellList.size() -1) {
					break;
				}
			}
			List<Integer> spellCount = new ArrayList<Integer>();
			List<String> spellKey = new ArrayList<String>();
			TreeMap<Integer, String> sortMap = new TreeMap<Integer, String>(map);
			Iterator<Integer> iter = sortMap.descendingKeySet().iterator();
			totalCount = 0;
			
			while(iter.hasNext()) {
				count = iter.next();
				totalCount += count;
				spellCount.add(count);
				spellKey.add(sortMap.get(count));
			}
			
			logger.info("spellCount: " + spellCount.size());
			ChampionInfoVO championSpell;
			List<ChampionInfoVO> championSpellList = new ArrayList<ChampionInfoVO>();
			URLConnection connection = new URLConnection();
			try {
				JSONObject spellJobj = connection.summonerSpell();
				JSONObject data = spellJobj.getJSONObject("data");
				List<String> spellKeyList = new ArrayList<String>();
				Iterator<String> spellIter = data.keySet().iterator();
				while(spellIter.hasNext()) {
					String key = spellIter.next();
					spellKeyList.add(key);
				}
				
				logger.info("spell.json key: " + data.getJSONObject(spellKeyList.get(0)).get("key").toString());
				
				
				if(spellKey.size() <= 1 || winCountList.size() <= 1) {
					for(int i = 0 ; i < 1; i++) {
						JSONObject jobj = new JSONObject();
						championSpell = new ChampionInfoVO();
						logger.info("spellKey: " + spellKey.get(i));
						String[] spellId = spellKey.get(i).split(",");
						String championSpellCountStr = String.format("%.2f", spellCount.get(i).floatValue()*100/totalCount) + "%";
						String championWinSpellCountStr = String.format("%.2f", winCountList.get(i).floatValue()*100/spellCount.get(i)) + "%";
						for(int j = 0; j < spellKeyList.size(); j++) {
							for(int k = 0; k < spellId.length; k++) {
								if(data.getJSONObject(spellKeyList.get(j)).getString("key").equals(spellId[k])) {
									logger.info("if문 안: " + data.getJSONObject(spellKeyList.get(j)).getString("id"));
									spellId[k] = data.getJSONObject(spellKeyList.get(j)).getString("id");
								}
							}
						}
						championSpell.setSummonerSpell1id(spellId[0]);
						championSpell.setSummonerSpell2id(spellId[1]);
						championSpell.setSummonerSpellCountStr(championSpellCountStr);
						championSpell.setSummonerSpellWinCountStr(championWinSpellCountStr);
						championSpellList.add(championSpell);
						jobj.put("spell1id", spellId[0]);
						jobj.put("spell2id", spellId[1]);
						jobj.put("championSpellCountStr", championSpellCountStr);
						jobj.put("championWinSpellCountStr", championWinSpellCountStr);
						jobj.put("key", championKey.get(a));
						jobj.put("championName", championName.get(a));
//						logger.info("count: " + spellCount.get(i) + ", spell: " + spellKey.get(i));
						logger.info("JSONObject: " + jobj);
						jobjList.add(jobj);
					}
				}else {
					for(int i = 0 ; i < 2; i++) {
						JSONObject jobj = new JSONObject();
						championSpell = new ChampionInfoVO();
						String[] spellId = spellKey.get(i).split(",");
						String championSpellCountStr = String.format("%.2f", spellCount.get(i).floatValue()*100/totalCount) + "%";
						String championWinSpellCountStr = String.format("%.2f", winCountList.get(i).floatValue()*100/spellCount.get(i)) + "%";
						for(int j = 0; j < spellKeyList.size(); j++) {
							for(int k = 0; k < spellId.length; k++) {
								if(data.getJSONObject(spellKeyList.get(j)).getString("key").equals(spellId[k])) {
									logger.info("if문 안: " + data.getJSONObject(spellKeyList.get(j)).get("id"));
									spellId[k] = data.getJSONObject(spellKeyList.get(j)).getString("id");
								}
							}
						}
						championSpell.setSummonerSpell1id(spellId[0]);
						championSpell.setSummonerSpell2id(spellId[1]);
						championSpell.setSummonerSpellCountStr(championSpellCountStr);
						championSpell.setSummonerSpellWinCountStr(championWinSpellCountStr);
						jobj.put("spell1id", spellId[0]);
						jobj.put("spell2id", spellId[1]);
						jobj.put("championSpellCountStr", championSpellCountStr);
						jobj.put("championWinSpellCountStr", championWinSpellCountStr);
						jobj.put("key", championKey.get(a));
						jobj.put("championName", championName.get(a));
						championSpellList.add(championSpell);
//						logger.info("count: " + spellCount.get(i) + ", spell: " + spellKey.get(i));
						logger.info("JSONObject: " + jobj);
						jobjList.add(jobj);
					}
				}
				logger.info("JSONObjectList: " + jobjList.toString());
				logger.info(a + "번째 챔피언 완료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			File file = new File("/Users/anchangho/git/yapx3/yapx3/json파일/championSpell.json");
			FileWriter fw = new FileWriter(file, true);
			fw.write(jobjList.toString());
			fw.flush();
			fw.close();
			
		}catch(Exception e) {
		}
		return null;
	}

//해당 챔피언의 가장 승률이 좋은 소환사 스킬
	public List<Integer> summonerWinSkillList(int championId) {
		List<ChampionInfoVO> spellList = championDAO.summonerWinSkillRank(championId);
		int count = 0;
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0 ; i < spellList.size(); i++) {
			for(int j = i+1; j < spellList.size(); j++) {
				if(spellList.get(i).getSummonerSpell1id().equals(spellList.get(j).getSummonerSpell2id()) &&
				   spellList.get(i).getSummonerSpell2id().equals(spellList.get(j).getSummonerSpell1id())) {
						count = spellList.get(i).getCount() + spellList.get(j).getCount();
						map.put(count, String.valueOf(spellList.get(i).getSummonerSpell2id())+","+String.valueOf(spellList.get(i).getSummonerSpell1id()) );
				}else {
						count = spellList.get(j).getCount();
						map.put(count, String.valueOf(spellList.get(i).getSummonerSpell2id())+","+String.valueOf(spellList.get(i).getSummonerSpell1id()) );
				}
			}
			if(i == spellList.size()-1) {
				break;
			}
		}
		List<Integer> spellCount = new ArrayList<Integer>();
		List<String> spellKey = new ArrayList<String>();
		TreeMap<Integer, String> sortMap = new TreeMap<Integer, String>(map);
		Iterator<Integer> iter = sortMap.descendingKeySet().iterator();
		while(iter.hasNext()) {
			count = iter.next();
			logger.info("count" + count);
			spellCount.add(count);
			spellKey.add(sortMap.get(count));
		}
		
		List<Integer> winList = new ArrayList<Integer>();
		if(spellKey.size() <= 1) {
			for(int i =0 ; i < 1; i++) {
				winList.add(spellCount.get(i));
			}
		}else {
			for(int i = 0 ; i < 2; i++) {
				winList.add(spellCount.get(i));
			}
		}
		
		return winList;
	}

//챔피언 룬 통계정보	
	@Override
	public List<ChampionInfoVO> championRune(int championId) {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
		
		Iterator<String> iter1 =  championAll.getBody().getData().keySet().iterator();
		List<Integer> championKey = new ArrayList<Integer>();
		List<String> championName = new ArrayList<String>();
		while(iter1.hasNext()) {
			String key = iter1.next();
			championKey.add(championAll.getBody().getData().get(key).getKey());
			championName.add(championAll.getBody().getData().get(key).getId());
		}
		JSONArray jarr = new JSONArray();
		for(int a = 0; a < championKey.size(); a++) {
			List<ChampionInfoVO> championPerkList = championDAO.championRune(championKey.get(a));
			int total = 0;
			for(int i =0 ; i < championPerkList.size(); i++) {
				total += championPerkList.get(i).getCount();
			}
			String championRunePercenter = null;
			for(int i = 0; i < 2; i++) {
				JSONObject jobj = new JSONObject();
				championRunePercenter = String.format("%.2f", Float.parseFloat(String.valueOf(championPerkList.get(i).getCount()))*100/total) + "%";
				jobj.put("perk0", championPerkList.get(i).getPerk0());
				jobj.put("perk1", championPerkList.get(i).getPerk1());
				jobj.put("perk2", championPerkList.get(i).getPerk2());
				jobj.put("perk3", championPerkList.get(i).getPerk3());
				jobj.put("perk4", championPerkList.get(i).getPerk4());
				jobj.put("perk5", championPerkList.get(i).getPerk5());
				jobj.put("perkPrimaryStyle", championPerkList.get(i).getPerkPrimaryStyle());
				jobj.put("perkSubStyle", championPerkList.get(i).getPerkSubStyle());
				jobj.put("statPerk0", championPerkList.get(i).getStatPerk0());
				jobj.put("statPerk1", championPerkList.get(i).getStatPerk1());
				jobj.put("statPerk2", championPerkList.get(i).getStatPerk2());
				jobj.put("count", championPerkList.get(i).getCount());
				jobj.put("championRunePercenter", championRunePercenter);
				jobj.put("key", championKey.get(a));
				jobj.put("championName", championName.get(a));
				jarr.put(jobj);
				logger.info("JSONObject: " + jobj);
			}
			logger.info("JSONArray: " + jarr);
			logger.info(a+"번쨰 챔피언 완료");
			List<ChampionInfoVO> sendChampionPerkList = new ArrayList<ChampionInfoVO>();
			for(int i = 0; i<2; i++) {
				sendChampionPerkList.add(championPerkList.get(i));
			}
		}
		try {
			File file = new File("/Users/anchangho/git/yapx3/yapx3/json파일/championRune.json");
			FileWriter fw = new FileWriter(file, true);
			fw.write(jarr.toString());
			fw.flush();
			fw.close();
			
		}catch(Exception e) {
		}
		
		return null;
	}

//챔피언 시작 아이템 리스트
	@Override
	public List<ChampionInfoVO> championStartItem(int championId) {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
		
		Iterator<String> iter =  championAll.getBody().getData().keySet().iterator();
		List<Integer> championKey = new ArrayList<Integer>();
		List<String> championName = new ArrayList<String>();
		while(iter.hasNext()) {
			String key = iter.next();
			championKey.add(championAll.getBody().getData().get(key).getKey());
			championName.add(championAll.getBody().getData().get(key).getId());
		}
		List<JSONObject> jobjList = new ArrayList<JSONObject>();
		for(int a = 0 ; a<championKey.size(); a++) {
			JSONObject jobj = new JSONObject();
			List<ChampionInfoVO> championItemList = championDAO.championStartItem(championKey.get(a));
			List<ChampionInfoVO> championItemListSum = new ArrayList<ChampionInfoVO>();
			List<Integer> championItemCount = new ArrayList<Integer>();
			ChampionInfoVO championItemVo1 = new ChampionInfoVO();
			ChampionInfoVO championItemVo2 = new ChampionInfoVO();
			int itemTotal = 0;
			for(int i = 0; i < championItemList.size(); i++) {
				itemTotal += championItemList.get(i).getCount();
				championItemCount.add(championItemList.get(i).getCount());
			}
			jobj.put("startItem1", championItemList.get(0).getStartItem());
			jobj.put("startItem2", championItemList.get(1).getStartItem());
			jobj.put("startItem3", championItemList.get(2).getStartItem());
			jobj.put("startPercent1", String.format("%.2f", ((championItemCount.get(0).floatValue()+championItemCount.get(1).floatValue())*100/itemTotal))+"%");
			jobj.put("startPercent2", String.format("%.2f", ((championItemCount.get(0).floatValue()+championItemCount.get(2).floatValue())*100/itemTotal))+"%");
			jobj.put("key", championKey.get(a));
			jobj.put("championName", championName.get(a));
			logger.info("jobj: " + jobj);
			jobjList.add(jobj);
			
			championItemVo1.setStartItem1(championItemList.get(0).getStartItem());
			championItemVo1.setStartItem2(championItemList.get(1).getStartItem());
			championItemVo1.setItemStartPercent(String.format("%.2f", ((championItemCount.get(0).floatValue()+championItemCount.get(1).floatValue())*100/itemTotal))+"%");
			championItemListSum.add(championItemVo1);
			
			
			championItemVo2.setStartItem1(championItemList.get(0).getStartItem());
			championItemVo2.setStartItem2(championItemList.get(2).getStartItem());
			championItemVo2.setItemStartPercent(String.format("%.2f", ((championItemCount.get(0).floatValue()+championItemCount.get(2).floatValue())*100/itemTotal))+"%");
			championItemListSum.add(championItemVo2);
			
//			for(int i = 0 ; i < championItemListSum.size(); i++) {
//				logger.info(championItemListSum.get(i).getStartItem1());
//				logger.info(championItemListSum.get(i).getStartItem2());
//				logger.info(championItemListSum.get(i).getStartItem3());
//			}
			logger.info("jobjList: " + jobjList.toString());
			logger.info((a+1) + "번째 챔피언 완료");
		}
		try {
			File file = new File("/Users/anchangho/git/yapx3/yapx3/json파일/championLane.json");
			FileWriter fw = new FileWriter(file, true);
			fw.write(jobjList.toString());
			fw.flush();
			fw.close();
			
		}catch(Exception e) {
		}
		return null;
	}

//챰피언 최종 아이템 리스트
	@Override
	public Map<Integer, Integer> championItem(int championId){
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
		
		Iterator<String> iterK =  championAll.getBody().getData().keySet().iterator();
		List<Integer> championKey = new ArrayList<Integer>();
		List<String> championName = new ArrayList<String>();
		while(iterK.hasNext()) {
			String key = iterK.next();
			championKey.add(championAll.getBody().getData().get(key).getKey());
			championName.add(championAll.getBody().getData().get(key).getId());
		}
		
		List<List<JSONObject>> jarr = new ArrayList<List<JSONObject>>();
		for(int a = 0 ; a < championKey.size(); a++ ) {
			
			List<ChampionInfoVO> championItem0List = new ArrayList<ChampionInfoVO>();
			List<ChampionInfoVO> championItem1List = new ArrayList<ChampionInfoVO>();
			List<ChampionInfoVO> championItem2List = new ArrayList<ChampionInfoVO>();
			List<ChampionInfoVO> championItem3List = new ArrayList<ChampionInfoVO>();
			List<ChampionInfoVO> championItem4List = new ArrayList<ChampionInfoVO>();
			List<ChampionInfoVO> championItem5List = new ArrayList<ChampionInfoVO>();
			List<ChampionInfoVO> championItem6List = new ArrayList<ChampionInfoVO>();
			
			for(int i = 0 ; i < 7; i ++) {
				switch (i) {
				case 0: championItem0List = championDAO.championItem(championKey.get(a), i);break;
				case 1: championItem1List = championDAO.championItem(championKey.get(a), i);break;
				case 2: championItem2List = championDAO.championItem(championKey.get(a), i);break;
				case 3: championItem3List = championDAO.championItem(championKey.get(a), i);break;
				case 4: championItem4List = championDAO.championItem(championKey.get(a), i);break;
				case 5: championItem5List = championDAO.championItem(championKey.get(a), i);break;
				case 6: championItem6List = championDAO.championItem(championKey.get(a), i);break;
				default:break;
				}
			}
			Map<Integer, Integer> itemMap = new HashMap<Integer, Integer>();
			for(int i = 0; i < championItem0List.size(); i++) {
				itemMap.put(championItem0List.get(i).getItem0(), championItem0List.get(i).getCount());
			}
			TreeMap<Integer, Integer> itemTMap = new TreeMap<Integer, Integer>(itemMap);
			Iterator<Integer> iter1 = itemTMap.descendingKeySet().iterator();
			while(iter1.hasNext()){
				int key = iter1.next();
				for(int i = 0; i < championItem1List.size(); i++) {
					if(key == championItem1List.get(i).getItem1()) {
						itemMap.put(key, itemMap.get(key)+championItem1List.get(i).getCount());
					}
				}
			}
			Iterator<Integer> iter2 = itemTMap.descendingKeySet().iterator();
			while(iter2.hasNext()){
				int key = iter2.next();
				for(int i = 0; i < championItem2List.size(); i++) {
					if(key == championItem2List.get(i).getItem2()) {
						itemMap.put(key, itemMap.get(key)+championItem2List.get(i).getCount());
					}
				}
			}
			Iterator<Integer> iter3 = itemTMap.descendingKeySet().iterator();
			while(iter3.hasNext()){
				int key = iter3.next();
				for(int i = 0; i < championItem3List.size(); i++) {
					if(key == championItem3List.get(i).getItem3()) {
						itemMap.put(key, itemMap.get(key)+championItem3List.get(i).getCount());
					}
				}
			}
			Iterator<Integer> iter4 = itemTMap.descendingKeySet().iterator();
			while(iter4.hasNext()){
				int key = iter4.next();
				for(int i = 0; i < championItem4List.size(); i++) {
					if(key == championItem4List.get(i).getItem4()) {
						itemMap.put(key, itemMap.get(key)+championItem4List.get(i).getCount());
					}
				}
			}
			Iterator<Integer> iter5 = itemTMap.descendingKeySet().iterator();
			while(iter5.hasNext()){
				int key = iter5.next();
				for(int i = 0; i < championItem5List.size(); i++) {
					if(key == championItem5List.get(i).getItem5()) {
						itemMap.put(key, itemMap.get(key)+championItem5List.get(i).getCount());
					}
				}
			}
			Iterator<Integer> iter6 = itemTMap.descendingKeySet().iterator();
			while(iter6.hasNext()){
				int key = iter6.next();
				for(int i = 0; i < championItem6List.size(); i++) {
					if(key == championItem6List.get(i).getItem6()) {
						itemMap.put(key, itemMap.get(key)+championItem6List.get(i).getCount());
					}
				}
			}
			List<Map.Entry<Integer, Integer>> list = new LinkedList<>(itemMap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
				@Override
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
					int comparision = (o1.getValue() - o2.getValue()) * -1;
					return comparision;
				}
			});
			
			Map<Integer, Integer> sortedMap = new LinkedHashMap<>(); 
			for(Iterator<Map.Entry<Integer, Integer>> iter = list.iterator(); iter.hasNext();){
				Map.Entry<Integer, Integer> entry = iter.next();
				sortedMap.put(entry.getKey(), entry.getValue());
			}
			Iterator<Integer> iterSort = sortedMap.keySet().iterator();
			
			int count = 0 ;
			
			JSONObject jobj = new JSONObject();
			List<JSONObject> itemJobj = new ArrayList<JSONObject>();
			while(iterSort.hasNext()) {
				if(count >= 17) {
					break;
				}
				int iterKey = iterSort.next();
				jobj.put(String.valueOf(iterKey), sortedMap.get(iterKey));
				jobj.put("key", championKey.get(a));
				jobj.put("championName", championName.get(a));
				itemJobj.add(jobj);
				count++;
			}
			jarr.add(itemJobj);
			logger.info("itemJobj: " + itemJobj);
//			logger.info("jarr: " + jarr);
			logger.info((a+1)+"번쨰 챔피언 완료");
		}
		try {
			File file = new File("/Users/anchangho/git/yapx3/yapx3/json파일/championFinalItem.json");
			FileWriter fw = new FileWriter(file, true);
			fw.write(jarr.toString());
			fw.flush();
			fw.close();
			
		}catch(Exception e) {
		}
		
		return null;
	}

//챔피언 이름 가져오기
	@Override
	public ChampionSkillInfo championSkillInfo(int championId) {
		connection = new URLConnection();
		ChampionSkillInfo championVO = new ChampionSkillInfo();
		
		String name = "";
		try {
			ChampionAll championOriginData = connection.championData();
			
			logger.info("championData: " + championOriginData.getData().keySet());
			Iterator<String> iter = championOriginData.getData().keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				if(championOriginData.getData().get(key).getKey() == championId) {
					//챔피언 아이디(영어이름)로 세부정보 가져오기
					name = championOriginData.getData().get(key).getId();
					JSONObject championDetailData = connection.championDetailData(name);
					JSONObject championData = championDetailData.getJSONObject("data");
					JSONArray championSkillData = championData.getJSONObject(name).getJSONArray("spells");
					championVO.setqSkill(championSkillData.getJSONObject(0).getJSONObject("image").getString("full"));
					championVO.setwSkill(championSkillData.getJSONObject(1).getJSONObject("image").getString("full"));
					championVO.seteSkill(championSkillData.getJSONObject(2).getJSONObject("image").getString("full"));
					championVO.setrSkill(championSkillData.getJSONObject(3).getJSONObject("image").getString("full"));
					String championPassiveSkill = championData.getJSONObject(name).getJSONObject("passive").getJSONObject("image").getString("full");
					championVO.setPassive(championPassiveSkill);
					championVO.setChampionId(championOriginData.getData().get(key).getId());
					championVO.setChampionName(championOriginData.getData().get(key).getName());
					break;
				}
			}
			
		return championVO;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return championVO;
	}
}
