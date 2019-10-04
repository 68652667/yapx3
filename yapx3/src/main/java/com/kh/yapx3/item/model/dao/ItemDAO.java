package com.kh.yapx3.item.model.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Repository
public class ItemDAO {
//	String driver = "oracle.jdbc.OracleDriver"; // 오라클 드라이버 클래스 파일명
//    String url = "jdbc:oracle:thin:@aglpbook.ctffmf4kluru.ap-northeast-2.rds.amazonaws.com:1521:ORCL"; // 오라클 위치,포트번호,DB정보
//    String id = "aglpbook"; // 오라클 접속 계정
//    String password = "aglp1234567890bookkh"; // 오라클 접속 비밀번호
//    Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    SqlSessionTemplate sqlSession;
    
    Logger logger = LoggerFactory.getLogger(getClass());
    
    public List<org.json.JSONObject> items(){
    	List<org.json.JSONObject> jobj =  sqlSession.selectList("item.itemList");
    	return jobj;
    }
    
    //아이템 수량 파악후 데이터 삽입
    public void itemsUpdate(String name, List<String> item, Map<String, Integer> map) {
    	
    }
    

//	public JSONArray pickItems(String championId) {
//		
//        JSONArray jarr = new JSONArray();
//        List<Map<String,String>> participantList1 = null;
//        List<Map<String,String>> participantList2 = null;
//        List<Map<String,String>> participantList3 = null;
//        List<Map<String,String>> participantList4 = null;
//        List<Map<String,String>> participantList5 = null;
//        List<Map<String,String>> participantList6 = null;
//        List<Map<String,String>> participantList7 = null;
//        List<Map<String,String>> participantList8 = null;
//        List<Map<String,String>> participantList9 = null;
//        List<Map<String,String>> participantList10 = null;
//        List<Map<String, Object>> champList = new ArrayList<Map<String, Object>>();
//        Map<String, Object> champMap;
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//        String sql = "";
//        for(int i = 1; i < 11; i++) {
//        	sql = "%championId:\"" + championId + "\"%";
//        	if(i == 1) {participantList1 = sqlSession.selectList("item.participant1",sql);}
//        	if(i == 2) {participantList2 = sqlSession.selectList("item.participant2",sql);}
//        	if(i == 3) {participantList3 = sqlSession.selectList("item.participant3",sql);}
//        	if(i == 4) {participantList4 = sqlSession.selectList("item.participant4",sql);}
//        	if(i == 5) {participantList5 = sqlSession.selectList("item.participant5",sql);}
//        	if(i == 6) {participantList6 = sqlSession.selectList("item.participant6",sql);}
//        	if(i == 7) {participantList7 = sqlSession.selectList("item.participant7",sql);}
//        	if(i == 8) {participantList8 = sqlSession.selectList("item.participant8",sql);}
//        	if(i == 9) {participantList9 = sqlSession.selectList("item.participant9",sql);}
//        	if(i == 10) {participantList10 = sqlSession.selectList("item.participant10",sql);}
//        }
//        logger.info("participantList1: " + participantList1);
//        logger.info("participantList2: " + participantList2);
//        logger.info("participantList3: " + participantList3);
//        logger.info("participantList4: " + participantList4);
//        logger.info("participantList5: " + participantList5);
//        logger.info("participantList6: " + participantList6);
//        logger.info("participantList7: " + participantList7);
//        logger.info("participantList8: " + participantList8);
//        logger.info("participantList9: " + participantList9);
//        logger.info("participantList10: " + participantList10);
//        
//		return jarr;
//	}
public JSONArray pickItems(String championId, List<String> itemList) {
		
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
        	for(int j = 0; j < itemList.size(); j++) {
        		for(int k = 0; k < 7; k++) {
        			sql = "select count(*) from match where participant"+i+" like '%championId:\"" + championId + "\"%' and participant"+i+" like '%item"+k+":\""+itemList.get(k)+"\"%'";
        			sqlMap.put("sql", sql);
        			//갯수를 리턴 받을때
        			if(i == 1) {participantList1.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList1...");participantJarr.add(jobj1.accumulate("participant1", participantList1));}
        			if(i == 2) {participantList2.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList2...");participantJarr.add(jobj2.accumulate("participant2", participantList2));}
        			if(i == 3) {participantList3.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList3...");participantJarr.add(jobj3.accumulate("participant3", participantList3));}
        			if(i == 4) {participantList4.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList4...");participantJarr.add(jobj4.accumulate("participant4", participantList4));}
        			if(i == 5) {participantList5.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList5...");participantJarr.add(jobj5.accumulate("participant5", participantList5));}
        			if(i == 6) {participantList6.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList6...");participantJarr.add(jobj6.accumulate("participant6", participantList6));}
        			if(i == 7) {participantList7.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList7...");participantJarr.add(jobj7.accumulate("participant7", participantList7));}
        			if(i == 8) {participantList8.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList8...");participantJarr.add(jobj8.accumulate("participant8", participantList8));}
        			if(i == 9) {participantList9.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList9...");participantJarr.add(jobj9.accumulate("participant9", participantList9));}
        			if(i == 10) {participantList10.add(sqlSession.selectOne("item.participant",sqlMap));logger.info("participantList10...");participantJarr.add(jobj10.accumulate("participant10", participantList10));}
        		}
        	}
        	
        	//데이터를 리턴 받을때
//        	if(i == 1) {participantList1 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList1...");participantJarr.add(jobj1.accumulate("participant1", participantList1));}
//        	if(i == 2) {participantList2 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList2...");participantJarr.add(jobj2.accumulate("participant2", participantList2));}
//        	if(i == 3) {participantList3 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList3...");participantJarr.add(jobj3.accumulate("participant3", participantList3));}
//        	if(i == 4) {participantList4 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList4...");participantJarr.add(jobj4.accumulate("participant4", participantList4));}
//        	if(i == 5) {participantList5 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList5...");participantJarr.add(jobj5.accumulate("participant5", participantList5));}
//        	if(i == 6) {participantList6 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList6...");participantJarr.add(jobj6.accumulate("participant6", participantList6));}
//        	if(i == 7) {participantList7 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList7...");participantJarr.add(jobj7.accumulate("participant7", participantList7));}
//        	if(i == 8) {participantList8 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList8...");participantJarr.add(jobj8.accumulate("participant8", participantList8));}
//        	if(i == 9) {participantList9 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList9...");participantJarr.add(jobj9.accumulate("participant9", participantList9));}
//        	if(i == 10) {participantList10 = sqlSession.selectList("item.participant",sqlMap);logger.info("participantList10...");participantJarr.add(jobj10.accumulate("participant10", participantList10));}
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
	public void createTableChampion() {
		sqlSession.insert("item.table");
	}
//    public int insertItem(List<ItemVO> ivo) {
//    	Connection con = null;
//    	PreparedStatement pstmt = null;
//    	int result = 0;
//        for(int i = 0; i < ivo.size(); i++) {
//        	logger.info(ivo.get(i).getItemId());
//        }
//    	try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, id, password); // DB 커넥션 맺기
//			
//			String sql = "insert into items values(?,?,?,?,?)";
//			pstmt = con.prepareStatement(sql);
//			for(int i = 0; i < ivo.size(); i++) {
//				pstmt.setString(1, ivo.get(i).getItemId());
//				pstmt.setString(2, ivo.get(i).getName());
//				pstmt.setString(3, ivo.get(i).getDescription());
//				pstmt.setString(4, ivo.get(i).getImageFull());
//				pstmt.setString(5, ivo.get(i).getGold());
//				result = pstmt.executeUpdate();
//				if(result == 1) {
//					logger.info("result: " +result);
//					con.commit();
//				}else {
//					logger.info("result: " +result);
//					con.rollback();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//			
//		}
//		return result;
//    }


	public void insertItem(List<String> itemList) {
		for(int i =0; i < itemList.size(); i++) {
			sqlSession.insert("item.itemInsert", itemList.get(i));
		}
	}

	public List<Map<String, org.json.JSONObject>> participant() {
		

		org.json.JSONArray jarr = new org.json.JSONArray();
		List<String> jobjList = sqlSession.selectList("item.participantCall");
		JSONParser parser = new JSONParser();
		Object obj = new Object();
		try {
			File file = new File("/Users/anchangho/git/yapx3/yapx3/participant/participant6.js");
			FileWriter fw = new FileWriter(file, true);
			String data = "";
	        	for(int j = 0; j < jobjList.size(); j++) {
	        		data = jobjList.get(j);
	    			fw.write(data + "\n");
	        	}
			fw.close();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
