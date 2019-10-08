package com.kh.yapx3.champion.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kh.yapx3.champion.common.URLConnection;
import com.kh.yapx3.champion.model.champion.ChampionAll;
import com.kh.yapx3.champion.model.service.ChampionInfoService;
import com.kh.yapx3.champion.model.service.ChampionInfoServiceImpl;
import com.kh.yapx3.champion.model.vo.ChampionInfoVO;

public class CreateJSONRun {

	@Autowired
	ChampionInfoService championInfoService;
	
	URLConnection connection;
	private final RestTemplate restTemplate = new RestTemplate();
	Logger logger = LoggerFactory.getLogger(getClass());
	String driver = "oracle.jdbc.OracleDriver"; // 오라클 드라이버 클래스 파일명
    String url = "jdbc:oracle:thin:@aglpbook.ctffmf4kluru.ap-northeast-2.rds.amazonaws.com:1521:ORCL"; // 오라클 위치,포트번호,DB정보
    String id = "aglpbook"; // 오라클 접속 계정
    String password = "aglp1234567890bookkh"; // 오라클 접속 비밀번호
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
	public static void main(String[] args) {
		new CreateJSONRun().createJson();
	}
	
	public void createJson() {
		
		try {
			String urlStr = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/ko_KR/champion.json";
			HttpHeaders header = new HttpHeaders();
		    HttpEntity<String> httpEntity = new HttpEntity<>(header);
			ResponseEntity<ChampionAll> championAll = restTemplate.exchange(urlStr, HttpMethod.GET, httpEntity, ChampionAll.class);
			
			Iterator<String> champid =  championAll.getBody().getData().keySet().iterator();
			List<Integer> championkey = new ArrayList<Integer>();
			while(champid.hasNext()) {
				String key = champid.next();
				logger.info("key: " + championAll.getBody().getData().get(key).getKey());
				championkey.add(championAll.getBody().getData().get(key).getKey());
			}
			
////챔피언 이미지 
				championInfoService = new ChampionInfoServiceImpl();
//				JSONObject obj = new JSONObject();
//				JSONArray jarr = new JSONArray();
//				List<JSONObject> jobjlist = new ArrayList<JSONObject>();
//				File file = new File("/Users/anchangho/git/yapx3/yapx3/json파일/skill.json");
//				FileWriter fw = new FileWriter(file, true);
//				for(int i = 0 ; i < championkey.size(); i++) {
//					ChampionSkillInfo championSkillInfo = championInfoService.championSkillInfo(championkey.get(i));
//					
//					logger.info("championKey" + championkey.get(i));
//					obj.put("key", championkey.get(i));
//					
//					logger.info("championId:" + championSkillInfo.getChampionId());
//					obj.put("championId", championSkillInfo.getChampionId());
//					
//					logger.info("championName:" + championSkillInfo.getChampionName());
//					obj.put("championName", championSkillInfo.getChampionName());
//					
//					logger.info("championQSkill: " + championSkillInfo.getqSkill());
//					obj.put("championQSkill", championSkillInfo.getqSkill());
//					
//					logger.info("championWSkill: " + championSkillInfo.getwSkill());
//					obj.put("championWSkill", championSkillInfo.getwSkill());
//					
//					logger.info("championESkill: " + championSkillInfo.geteSkill());
//					obj.put("championESkill", championSkillInfo.geteSkill());
//					
//					logger.info("championRSkill: " + championSkillInfo.getrSkill());
//					obj.put("championRSkill", championSkillInfo.getrSkill());
//					
//					logger.info("championPassiveSkill: " + championSkillInfo.getPassive());
//					obj.put("championPassiveSkill", championSkillInfo.getPassive());
//					jobjlist.add(obj);
//				}
//				jarr.put(jobjlist);
//				fw.write(jarr.toString());
//				fw.flush();
//				fw.close();
//				
//			logger.info("JSONArry: " + jarr);
		
		
//챔피언 lane통계
			
	 	  
	 	    Class.forName(driver); // 드라이버 로딩
	 	    con = DriverManager.getConnection(url, id, password); // DB 커넥션 맺기
			for(int i = 0 ; i < championkey.size(); i++) {
//				List<ChampionInfoVO> championLaneList = championInfoService.championInfo(championkey.get(i));
				String sql = "select count(*) from participantall where championid = " + championkey.get(i);
				stmt = con.createStatement();
            	rs = stmt.executeQuery(sql);
            	while(rs.next()) {
            		double championCount = Integer.parseInt(rs.getString("COUNT(*)"));
            		List<Map<String, String>> lineList = new ArrayList<Map<String,String>>();
            		lineList = championLine(championkey.get(i));
            		logger.info("lineList: " + lineList.get(0));
            		int championLineCount = 0;
            		String championLineStr = "";
            		List<Integer> championLaneCountList = new ArrayList<Integer>();
            		List<String> championLanePosition = new ArrayList<String>();
            		
            //list 초기화
            		championLaneCountList.clear();
            		championLanePosition.clear();
            		Iterator<String> iter = lineList.get(i).keySet().iterator();
            		while(iter.hasNext()) {
            			String key = iter.next();
	            		for(int j = 0; j < lineList.size(); j++) {
	            			championLineCount =  Integer.parseInt(lineList.get(j).get(key));
	            			championLineStr = lineList.get(j).get(key);
	            			championLaneCountList.add(championLineCount);
	            			championLanePosition.add(championLineStr);
	            		}
            		}
            		
            		List<String> championLine = new ArrayList<String>();
            		
            		for( int j = 0 ; j < championLaneCountList.size(); j++) {
            			championLine.add(String.format("%.2f", championLaneCountList.get(j)*100/championCount) + "%");
            		}
            		
            //통계데이터 객체에 담기
            		ChampionInfoVO championLane;
            		List<ChampionInfoVO> championLaneList = new ArrayList<ChampionInfoVO>();
            		for( int j = 0 ; j < championLine.size(); j++) {
            			championLane = new ChampionInfoVO();
            			String championLineCountStr = String.format("%.2f", championLaneCountList.get(j)*100/championCount) + "%";
            			if(championLanePosition.get(j).equals("TOP")) {
            				championLane.setChampionLane("탑");
            			}else if(championLanePosition.get(j).equals("BOTTOM")) {
            				championLane.setChampionLane("바텀");
            			}else if(championLanePosition.get(j).equals("JUNGLE")) {
            				championLane.setChampionLane("정글");
            			}else if(championLanePosition.get(j).equals("MIDDLE")) {
            				championLane.setChampionLane("미드");
            			}
            			championLane.setChampionLaneCount(championLineCountStr);
            			championLaneList.add(championLane);
            			logger.info(championLane.getChampionLane());
            		}
            	}
            	
//				logger.info(championLaneList.get(i).getChampionLane());
//				logger.info(championLaneList.get(i).getChampionLaneCount());
			}
			
////해당 챔피언 소환사 스킬 순위 리스트
//			List<ChampionInfoVO> summonerSkillList = championInfoService.summonerSkillList(championId);
//			
//// 챔피언 시작탬 가져오기
//			List<ChampionInfoVO> championItemListSum =  championInfoService.championStartItem(championId);
//			
//// 챔피언 룬 통계
//			//메인 룬 서브룬 보조룬
//			List<ChampionInfoVO> championPerkList =  championInfoService.championRune(championId);
//			
//// 챔피언 아이템 리스트
//			Map<Integer, Integer> championItemList = championInfoService.championItem(championId);
			
//			List<Integer> itemCountList = new ArrayList<Integer>();
//			Iterator<Integer> iter = championItemList.keySet().iterator();
//			int count = 0;
//			while(iter.hasNext()) {
//				if(count == 18) {
//					break;
//				}
//				itemCountList.add(iter.next());
//				count++;
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<Map<String, String>> championLine(int championId) {
		List<Map<String, String>> championLine = new ArrayList<Map<String,String>>();
		List<Map<String, String>> lineList = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, password); // DB 커넥션 맺기
			String sql = "SELECT T1.lane, COUNT(*) FROM participantall T1 where championid="+championId+" GROUP BY T1.lane order by count(*) desc";
			stmt = con.createStatement();
	    	rs = stmt.executeQuery(sql);
	    	while(rs.next()) {
	    		map.put(rs.getString("lane"), rs.getString("COUNT(*)"));
	    		championLine.add(map);
	    	}
	    	
			for(int i = 0; i < championLine.size(); i++) {
				logger.info("mapList: " + championLine.get(i).get("lane"));
			}
			for(int i = 0; i < championLine.size(); i++) {
				if(lineList.size() == 2) {
					logger.info("lineList Size = 2");
					break;
				}else {
					Iterator<String> iter = championLine.get(i).keySet().iterator();
					while(iter.hasNext()) {
						String lane = iter.next();
						if(lane.equals("NONE")) {
							logger.info("LANE: NONE");
						}else if(lineList.size() != 2){
							logger.info("LANE: anyone");
							lineList.add(championLine.get(i));
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 드라이버 로딩
 	    
		return lineList;
	}


}
