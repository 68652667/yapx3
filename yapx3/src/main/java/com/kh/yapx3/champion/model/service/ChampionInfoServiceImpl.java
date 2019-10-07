package com.kh.yapx3.champion.model.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import com.kh.yapx3.champion.model.vo.MatchInfoVO;
import com.kh.yapx3.match.model.vo.SortChampionVo;

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
		ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity,
				ChampionAll.class);

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
		double championCount = championDAO.championCount(championId);
		
		List<Map<String, String>> lineList = new ArrayList<Map<String,String>>();
		lineList = championLine(championId);
		
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
			if(championLanePosition.get(i).equals("TOP")) {
				championLane.setChampionLane("탑");
			}else if(championLanePosition.get(i).equals("BOTTOM")) {
				championLane.setChampionLane("바텀");
			}else if(championLanePosition.get(i).equals("JUNGLE")) {
				championLane.setChampionLane("정글");
			}else if(championLanePosition.get(i).equals("MIDDLE")) {
				championLane.setChampionLane("미드");
			}
			championLane.setChampionLaneCount(championLineCountStr);
			championLaneList.add(championLane);
		}
		return championLaneList;
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

		List<ChampionInfoVO> spellList = championDAO.summonerSkill(championId);
		List<Integer> winCountList = summonerWinSkillList(championId);
		int count = 0;
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0 ; i < spellList.size(); i++) {
			for(int j = 0; j < spellList.size(); j++) {
				if(spellList.get(i).getSummonerSpell1id().equals(spellList.get(j).getSummonerSpell2id()) &&
				   spellList.get(i).getSummonerSpell2id().equals(spellList.get(j).getSummonerSpell1id())) {
						count = spellList.get(i).getCount() + spellList.get(j).getCount();
						map.put(count, String.valueOf(spellList.get(i).getSummonerSpell2id())+","+String.valueOf(spellList.get(i).getSummonerSpell1id()) );
				}
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
			
			
			if(spellKey.size() <= 1 ) {
				for(int i = 0 ; i < 1; i++) {
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
					logger.info("count: " + spellCount.get(i) + ", spell: " + spellKey.get(i));
				}
			}else {
				for(int i = 0 ; i < 2; i++) {
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
					championSpellList.add(championSpell);
					logger.info("count: " + spellCount.get(i) + ", spell: " + spellKey.get(i));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return championSpellList;
	}

//해당 챔피언의 가장 승률이 좋은 소환사 스킬
	public List<Integer> summonerWinSkillList(int championId) {
		List<ChampionInfoVO> spellList = championDAO.summonerWinSkillRank(championId);
		int count = 0;
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0 ; i < spellList.size(); i++) {
			for(int j = 0; j < spellList.size(); j++) {
				if(spellList.get(i).getSummonerSpell1id().equals(spellList.get(j).getSummonerSpell2id()) &&
				   spellList.get(i).getSummonerSpell2id().equals(spellList.get(j).getSummonerSpell1id())) {
						count = spellList.get(i).getCount() + spellList.get(j).getCount();
						map.put(count, String.valueOf(spellList.get(i).getSummonerSpell2id())+","+String.valueOf(spellList.get(i).getSummonerSpell1id()) );
				}
			}
		}
		List<Integer> spellCount = new ArrayList<Integer>();
		List<String> spellKey = new ArrayList<String>();
		TreeMap<Integer, String> sortMap = new TreeMap<Integer, String>(map);
		Iterator<Integer> iter = sortMap.descendingKeySet().iterator();
		
		while(iter.hasNext()) {
			count = iter.next();
			logger.info("count" + count);
			totalCount += count;
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
		List<ChampionInfoVO> championPerkList = championDAO.championRune(championId);
		List<ChampionInfoVO> sendChampionPerkList = new ArrayList<ChampionInfoVO>();
		for(int i = 0; i<2; i++) {
			sendChampionPerkList.add(championPerkList.get(i));
		}
		return sendChampionPerkList;
	}

//해당 챔피언으로 가장 많이 쓴 아이템 
	
//챔피언 시작 아이템 리스트
	@Override
	public List<ChampionInfoVO> championStartItem(int championId) {
		List<ChampionInfoVO> championItemList = championDAO.championStartItem(championId);
		List<ChampionInfoVO> championItemListSum = new ArrayList<ChampionInfoVO>();
		List<Integer> championItemCount = new ArrayList<Integer>();
		ChampionInfoVO championItemVo1 = new ChampionInfoVO();
		ChampionInfoVO championItemVo2 = new ChampionInfoVO();
		int itemTotal = 0;
		for(int i = 0; i < championItemList.size(); i++) {
			itemTotal += championItemList.get(i).getCount();
			championItemCount.add(championItemList.get(i).getCount());
		}
		championItemVo1.setStartItem1(championItemList.get(0).getStartItem());
		championItemVo1.setStartItem2(championItemList.get(1).getStartItem());
		championItemVo1.setItemStartPercent(String.format("%.2f", ((championItemCount.get(0).floatValue()+championItemCount.get(1).floatValue())*100/itemTotal))+"%");
		championItemListSum.add(championItemVo1);
		
		
		championItemVo2.setStartItem1(championItemList.get(0).getStartItem());
		championItemVo2.setStartItem2(championItemList.get(2).getStartItem());
		championItemVo2.setItemStartPercent(String.format("%.2f", ((championItemCount.get(0).floatValue()+championItemCount.get(2).floatValue())*100/itemTotal))+"%");
		championItemListSum.add(championItemVo2);
		
		for(int i = 0 ; i < championItemListSum.size(); i++) {
			logger.info(championItemListSum.get(i).getStartItem1());
			logger.info(championItemListSum.get(i).getStartItem2());
			logger.info(championItemListSum.get(i).getStartItem3());
		}
		return championItemListSum;
	}

	@Override
	public List<ChampionInfoVO> championItem(int championId){
		List<ChampionInfoVO> championItem0List = new ArrayList<ChampionInfoVO>();
		List<ChampionInfoVO> championItem1List = new ArrayList<ChampionInfoVO>();
		List<ChampionInfoVO> championItem2List = new ArrayList<ChampionInfoVO>();
		List<ChampionInfoVO> championItem3List = new ArrayList<ChampionInfoVO>();
		List<ChampionInfoVO> championItem4List = new ArrayList<ChampionInfoVO>();
		List<ChampionInfoVO> championItem5List = new ArrayList<ChampionInfoVO>();
		List<ChampionInfoVO> championItem6List = new ArrayList<ChampionInfoVO>();
		for(int i = 0; i < 7; i++){
			switch (i) {
			case 0:championItem0List = championDAO.championItem(championId, i);break;
			case 1:championItem1List = championDAO.championItem(championId, i);break;
			case 2:championItem2List = championDAO.championItem(championId, i);break;
			case 3:championItem3List = championDAO.championItem(championId, i);break;
			case 4:championItem4List = championDAO.championItem(championId, i);break;
			case 5:championItem5List = championDAO.championItem(championId, i);break;
			case 6:championItem6List = championDAO.championItem(championId, i);break;
			default: break;
			}
		}
		
		
		for(int i = 0 ; i < championItem0List.size(); i++) {
			for(int j = 0 ; j < championItem1List.size(); j++) {
				
			}
		}
		logger.info("championItem1List: " + championItem1List.get(0).getItem1());
		logger.info("championItem2List: " + championItem2List.get(0).getItem2());
		logger.info("championItem3List: " + championItem3List.get(0).getItem3());
		logger.info("championItem4List: " + championItem4List.get(0).getItem4());
		logger.info("championItem5List: " + championItem5List.get(0).getItem5());
		logger.info("championItem6List: " + championItem6List.get(0).getItem6());
		
		return null;
	}
}
