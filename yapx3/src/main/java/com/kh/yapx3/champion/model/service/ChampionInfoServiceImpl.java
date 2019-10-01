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
import com.kh.yapx3.champion.model.vo.MatchInfoVO;
import com.kh.yapx3.match.model.vo.SortChampionVo;

@Service
public class ChampionInfoServiceImpl implements ChampionInfoService{
	
	URLConnection connection; 
	Logger logger = LoggerFactory.getLogger(getClass());
	private String encrypteSummonerName;
	RestTemplate restTemplate = new RestTemplate();
	String api = "api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074";
	
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
	
	//챔피언의 통계(아이템, 룬, 스펠, 스킬)을 가져온다.
	public int championInfo(int id) {
		JSONObject resultJobj = new JSONObject();
		int championCount = championDAO.championCount(id);
		
		
		return championCount;
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

	@Override
	public int championWin(int championId) {
		int championWin =  championDAO.championWin(championId);
		return championWin;
	}

	@Override
	public int championLineTop(int championId) {
		int championLineTop = championDAO.championLineTop(championId);
		return championLineTop;
	}

	@Override
	public int championLineBottom(int championId) {
		int championLineBottom = championDAO.championLineBottom(championId);
		return championLineBottom;
	}

	@Override
	public List<Integer> championLine(int championId) {
//		List<Integer> championLine = championDAO.championLine(championId);
		return null;
	}
	
}
