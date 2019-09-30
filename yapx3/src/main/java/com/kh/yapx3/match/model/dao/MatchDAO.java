package com.kh.yapx3.match.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.champion.model.vo.ChampionKoN;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@Repository
public class MatchDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
    Logger logger = LoggerFactory.getLogger(getClass());
    
    public  List<JSONObject> mybatisTest(List<String> keyList) {
    	logger.info("mybatisTest: " + sqlSession);
    	return sqlSession.selectList("item.itemList");
    }
    
    //ojdbc 버젼
 	public JSONArray participant(int championId) {
 		String driver = "oracle.jdbc.OracleDriver"; // 오라클 드라이버 클래스 파일명
 	    String url = "jdbc:oracle:thin:@aglpbook.ctffmf4kluru.ap-northeast-2.rds.amazonaws.com:1521:ORCL"; // 오라클 위치,포트번호,DB정보
 	    String id = "aglpbook"; // 오라클 접속 계정
 	    String password = "aglp1234567890bookkh"; // 오라클 접속 비밀번호
		
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        List<String> participant1 = new ArrayList<String>();
        List<String> participant2 = new ArrayList<String>();
        List<String> participant3 = new ArrayList<String>();
        List<String> participant4 = new ArrayList<String>();
        List<String> participant5 = new ArrayList<String>();
        List<String> participant6 = new ArrayList<String>();
        List<String> participant7 = new ArrayList<String>();
        List<String> participant8 = new ArrayList<String>();
        List<String> participant9 = new ArrayList<String>();
        List<String> participant10 = new ArrayList<String>();
        JSONObject jobj1 = new JSONObject();
        JSONObject jobj2 = new JSONObject();
        JSONObject jobj3 = new JSONObject();
        JSONObject jobj4 = new JSONObject();
        JSONObject jobj5 = new JSONObject();
        JSONObject jobj6 = new JSONObject();
        JSONObject jobj7 = new JSONObject();
        JSONObject jobj8 = new JSONObject();
        JSONObject jobj9 = new JSONObject();
        JSONObject jobj10 = new JSONObject();
        
        JSONArray jarr = new JSONArray();
        Map<String, JSONObject> map = new HashMap<String, JSONObject>();
        try {
            Class.forName(driver); // 드라이버 로딩
            con = DriverManager.getConnection(url, id, password); // DB 커넥션 맺기
 
            for(int i = 1; i < 11; i++) {
            	//선택한 챔피언을 픽률
//            	String sql = "select PARTICIPANT" + i +" from(select rownum rnum, A.* from(select PARTICIPANT" + i + " from match where participant" + i + " like '%championId:\""+ championId +"\"%' ) A ) A where rnum between 1 and 50";
//            	String sql = "select participant" + i +" from(select  rownum rnum, A.* from (select PARTICIPANT" + i + " from match where PARTICIPANT" + i + " like  '%championId:\""+ championId +"\"%' and PARTICIPANT" + i + " like '%spell1Id:\"4\"%' ) A ) A where rnum between 1 and 10";
//            	String sql = "select participant" + i +" from match where PARTICIPANT" + i + " like  '%championId:\"" + championId + "\"%' and (PARTICIPANT" + i + " like '%spell1Id:\"4\"%' or PARTICIPANT" + i + " like '%spell2Id:\"4\"%')";
            	//모든 챔피언 픽률
            	String sql = "select PARTICIPANT" + i +" from testmatch";
//            	String sql = "select PARTICIPANT1 from testmatch";
            	logger.info(sql);
            	stmt = con.createStatement();
            	rs = stmt.executeQuery(sql);
            	
            	while (rs.next()) {
            		if(i == 1) {participant1.add(rs.getString("participant1")); logger.info("participant1처리중...");}
            		else if(i == 2) {participant2.add(rs.getString("participant2")); logger.info("participant2처리중...");}
            		else if(i == 3) {participant3.add(rs.getString("participant3")); logger.info("participant3처리중...");}
            		else if(i == 4) {participant4.add(rs.getString("participant4")); logger.info("participant4처리중...");}
            		else if(i == 5) {participant5.add(rs.getString("participant5")); logger.info("participant5처리중...");}
            		else if(i == 6) {participant6.add(rs.getString("participant6")); logger.info("participant6처리중...");}
            		else if(i == 7) {participant7.add(rs.getString("participant7")); logger.info("participant7처리중...");}
            		else if(i == 8) {participant8.add(rs.getString("participant8")); logger.info("participant8처리중...");}
            		else if(i == 9) {participant9.add(rs.getString("participant9")); logger.info("participant9처리중...");}
            		else if(i == 10) {participant10.add(rs.getString("participant10")); logger.info("participant10처리중...");}
            	}
            }
            jobj1.accumulate("participant1", participant1);
        	jobj2.accumulate("participant2", participant2); 
        	jobj3.accumulate("participant3", participant3); 
        	jobj4.accumulate("participant4", participant4); 
        	jobj5.accumulate("participant5", participant5); 
        	jobj6.accumulate("participant6", participant6); 
        	jobj7.accumulate("participant7", participant7); 
        	jobj8.accumulate("participant8", participant8); 
        	jobj9.accumulate("participant9", participant9);
        	jobj10.accumulate("participant10", participant10); 
            jarr.add(jobj1);
            jarr.add(jobj2);
            jarr.add(jobj3);
            jarr.add(jobj4);
            jarr.add(jobj5);
            jarr.add(jobj6);
            jarr.add(jobj7);
            jarr.add(jobj8);
            jarr.add(jobj9);
            jarr.add(jobj10);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { // 자원 반납
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return jarr;
	}

 	//ojdbc 버젼
 	public JSONArray participant() {
 	   String driver = "oracle.jdbc.OracleDriver"; // 오라클 드라이버 클래스 파일명
 	   String url = "jdbc:oracle:thin:@aglpbook.ctffmf4kluru.ap-northeast-2.rds.amazonaws.com:1521:ORCL"; // 오라클 위치,포트번호,DB정보
 	   String id = "aglpbook"; // 오라클 접속 계정
 	   String password = "aglp1234567890bookkh"; // 오라클 접속 비밀번호
 		
 	   Connection con = null;
       Statement stmt = null;
       ResultSet rs = null;
       
       List<String> participant1 = new ArrayList<String>();
       JSONObject jobj1 = new JSONObject();
       JSONArray jarr = new JSONArray();
       
       try {
           Class.forName(driver); // 드라이버 로딩
           con = DriverManager.getConnection(url, id, password); // DB 커넥션 맺기

           String sql = "select PARTICIPANT10 from testmatch";
           logger.info(sql);
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           
           while(rs.next()) {
        	   participant1.add(rs.getString("participant10")); 
        	   logger.info("participant10처리중...");           		
           }
           
           jobj1.accumulate("participant10", participant1);
           jarr.add(jobj1);
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           try { // 자원 반납
               if (rs != null)
                   rs.close();
               if (stmt != null)
                   stmt.close();
               if (con != null)
                   con.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
	return jarr;
 	}
 	
 	
 	//mybatis 버젼
 	public JSONArray participant(String championId) {
		
        JSONArray participantJarr = new JSONArray();
        //데이터로 리턴 받을떄
//        List<String> participantList1 = new ArrayList<String>();
//        List<String> participantList2 = new ArrayList<String>();
//        List<String> participantList3 = new ArrayList<String>();
//        List<String> participantList4 = new ArrayList<String>();
//        List<String> participantList5 = new ArrayList<String>();
//        List<String> participantList6 = new ArrayList<String>();
//        List<String> participantList7 = new ArrayList<String>();
//        List<String> participantList8 = new ArrayList<String>();
//        List<String> participantList9 = new ArrayList<String>();
//        List<String> participantList10 = new ArrayList<String>();
        //갯수로 리턴 받을때
        int count = 0;
        List<Integer> participantList1 = new ArrayList<Integer>();
        List<Integer> participantList2 = new ArrayList<Integer>();
        List<Integer> participantList3 = new ArrayList<Integer>();
        List<Integer> participantList4 = new ArrayList<Integer>();
        List<Integer> participantList5 = new ArrayList<Integer>();
        List<Integer> participantList6 = new ArrayList<Integer>();
        List<Integer> participantList7 = new ArrayList<Integer>();
        List<Integer> participantList8 = new ArrayList<Integer>();
        List<Integer> participantList9 = new ArrayList<Integer>();
        List<Integer> participantList10 = new ArrayList<Integer>();
        
        JSONObject jobj1 = new JSONObject();
        JSONObject jobj2 = new JSONObject();
        JSONObject jobj3 = new JSONObject();
        JSONObject jobj4 = new JSONObject();
        JSONObject jobj5 = new JSONObject();
        JSONObject jobj6 = new JSONObject();
        JSONObject jobj7 = new JSONObject();
        JSONObject jobj8 = new JSONObject();
        JSONObject jobj9 = new JSONObject();
        JSONObject jobj10 = new JSONObject();
        List<Map<String, Object>> champList = new ArrayList<Map<String, Object>>();
        Map<String, Object> champMap;
        Map<String, Object> paramMap = new HashMap<String, Object>();
        Map<String, String> sqlMap = new HashMap<String, String>();
        String sql = null;
        sqlMap.clear();
        participantJarr.clear();
        for(int i = 1; i < 11; i++) {
//        	sql = "select participant"+ i + " from(select  rownum rnum, A.* from (select participant"+ i + " from match where participant"+ i + " like  '%championId:\"" + championId + "\"%') A ) A where rnum between 1 and 10";
        		for(int k = 0; k < 7; k++) {
        			sql = "select participant"+i+" from testmatch where participant" +i;
        			sqlMap.put("sql", sql);
        			//갯수를 리턴 받을때
        			logger.info("matchDAO SQLSessionTemplate: " + sqlSession);
//        			if(i == 1) {participantList1.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList1...");participantJarr.add(jobj1.accumulate("participant1", participantList1));}
//        			if(i == 2) {participantList2.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList2...");participantJarr.add(jobj2.accumulate("participant2", participantList2));}
//        			if(i == 3) {participantList3.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList3...");participantJarr.add(jobj3.accumulate("participant3", participantList3));}
//        			if(i == 4) {participantList4.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList4...");participantJarr.add(jobj4.accumulate("participant4", participantList4));}
//        			if(i == 5) {participantList5.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList5...");participantJarr.add(jobj5.accumulate("participant5", participantList5));}
//        			if(i == 6) {participantList6.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList6...");participantJarr.add(jobj6.accumulate("participant6", participantList6));}
//        			if(i == 7) {participantList7.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList7...");participantJarr.add(jobj7.accumulate("participant7", participantList7));}
//        			if(i == 8) {participantList8.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList8...");participantJarr.add(jobj8.accumulate("participant8", participantList8));}
//        			if(i == 9) {participantList9.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList9...");participantJarr.add(jobj9.accumulate("participant9", participantList9));}
//        			if(i == 10) {participantList10.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList10...");participantJarr.add(jobj10.accumulate("participant10", participantList10));}
//        		}
        	
        	//데이터를 리턴 받을때
        	if(i == 1) {participantList1 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList1...");participantJarr.add(jobj1.accumulate("participant1", participantList1));}
        	if(i == 2) {participantList2 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList2...");participantJarr.add(jobj2.accumulate("participant2", participantList2));}
        	if(i == 3) {participantList3 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList3...");participantJarr.add(jobj3.accumulate("participant3", participantList3));}
        	if(i == 4) {participantList4 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList4...");participantJarr.add(jobj4.accumulate("participant4", participantList4));}
        	if(i == 5) {participantList5 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList5...");participantJarr.add(jobj5.accumulate("participant5", participantList5));}
        	if(i == 6) {participantList6 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList6...");participantJarr.add(jobj6.accumulate("participant6", participantList6));}
        	if(i == 7) {participantList7 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList7...");participantJarr.add(jobj7.accumulate("participant7", participantList7));}
        	if(i == 8) {participantList8 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList8...");participantJarr.add(jobj8.accumulate("participant8", participantList8));}
        	if(i == 9) {participantList9 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList9...");participantJarr.add(jobj9.accumulate("participant9", participantList9));}
        	if(i == 10) {participantList10 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList10...");participantJarr.add(jobj10.accumulate("participant10", participantList10));}
        		}
        	//갯수를 리턴 받을때
//        	if(i == 1) {participantList1 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList1...");participantJarr.add(jobj1.accumulate("participant1", participantList1));}
//        	if(i == 2) {participantList2 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList2...");participantJarr.add(jobj2.accumulate("participant2", participantList2));}
//        	if(i == 3) {participantList3 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList3...");participantJarr.add(jobj3.accumulate("participant3", participantList3));}
//        	if(i == 4) {participantList4 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList4...");participantJarr.add(jobj4.accumulate("participant4", participantList4));}
//        	if(i == 5) {participantList5 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList5...");participantJarr.add(jobj5.accumulate("participant5", participantList5));}
//        	if(i == 6) {participantList6 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList6...");participantJarr.add(jobj6.accumulate("participant6", participantList6));}
//        	if(i == 7) {participantList7 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList7...");participantJarr.add(jobj7.accumulate("participant7", participantList7));}
//        	if(i == 8) {participantList8 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList8...");participantJarr.add(jobj8.accumulate("participant8", participantList8));}
//        	if(i == 9) {participantList9 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList9...");participantJarr.add(jobj9.accumulate("participant9", participantList9));}
//        	if(i == 10) {participantList10 = sqlSession.selectOne("item.participant",sqlMap);logger.info("participantList10...");participantJarr.add(jobj10.accumulate("participant10", participantList10));}
        }
        logger.info("participantJarr: " + participantJarr);
        
		return participantJarr;
	}
 	
	public JSONArray champion() {
		
		return null;
	}

	public void championInsert(List<String> championName, List<Integer> championKey) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Object> championMap = new HashMap<String, Object>();
		List<ChampionKoN> champ = new ArrayList<ChampionKoN>();
		
		for(int i = 0 ; i < championName.size(); i++) {
			ChampionKoN ch = new ChampionKoN();
			ch.setChampionKey(championKey.get(i));
			ch.setChampionName(championName.get(i));
			champ.add(ch);
		}
		championMap.put("map", map);
		List<ChampionKoN> champ2 = (List<ChampionKoN>) championMap.get("map"); 
		for(ChampionKoN kon : champ2) {
			sqlSession.insert("champion.champInsert", kon);
		}
	}

	public List<String> getGameIdAllMethod() {
		logger.info("sqlSession: " + sqlSession);
		List<String> gameIdAll = new ArrayList<String>();
		gameIdAll = sqlSession.selectList("matchlist.gameIdAll");
//		String game = sqlSession.selectOne("matchlll.gameIdAll");
		return gameIdAll;
	}

//	public void createParticipant(List<String> keyList) {
//		String driver = "oracle.jdbc.OracleDriver"; // 오라클 드라이버 클래스 파일명
// 	    String url = "jdbc:oracle:thin:@aglpbook.ctffmf4kluru.ap-northeast-2.rds.amazonaws.com:1521:ORCL"; // 오라클 위치,포트번호,DB정보
// 	    String id = "aglpbook"; // 오라클 접속 계정
// 	    String password = "aglp1234567890bookkh"; // 오라클 접속 비밀번호
//		
//        
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//        	Class.forName(driver); // 드라이버 로딩
//            con = DriverManager.getConnection(url, id, password); // DB 커넥션 맺기
//			stmt = con.createStatement();
//			String sql = "create table participantall (" +
//					"datano number primary key, ";
//			for(int i = 0; i < keyList.size(); i++) {
//				if(i == keyList.size() -1) {
//					sql = sql + keyList.get(i)+" varchar2(100) )" ;
//				}
//				else {
//					sql = sql + keyList.get(i) +" varchar2(100), ";
//				}
//			}
//			rs = stmt.executeQuery(sql);
//			stmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		String sql = "select participant1 from testmatch";
////    	Map<String, String> map = new HashMap<String, String>();
////    	logger.info("createTable map : " + map  );
////    	map.put("sql", sql);
////    	logger.info("sql: " + sql);
////    	logger.info("sqlSeesionTemplet : " + sqlSession);
////    	List<String> list = sqlSession.selectList("item.createparticipant", map);
////    	logger.info("list: " + list);
// catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	
}
