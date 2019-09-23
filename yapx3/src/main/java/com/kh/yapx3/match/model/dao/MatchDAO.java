package com.kh.yapx3.match.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@Repository
public class MatchDAO {
	
//	@Autowired
//	private SqlSessionTemplate sqlSession;
	String driver = "oracle.jdbc.OracleDriver"; // 오라클 드라이버 클래스 파일명
    String url = "jdbc:oracle:thin:@aglpbook.ctffmf4kluru.ap-northeast-2.rds.amazonaws.com:1521:ORCL"; // 오라클 위치,포트번호,DB정보
    String id = "aglpbook"; // 오라클 접속 계정
    String password = "aglp1234567890bookkh"; // 오라클 접속 비밀번호
    Logger logger = LoggerFactory.getLogger(getClass());
	public JSONArray participant() {
       
        
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
        List<String> participants = new ArrayList<String>();
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
            	String sql = "select PARTICIPANT" + i +" from(select rownum rnum, A.* from(select PARTICIPANT" + i + " from match A ) A ) A where rnum between 1 and 3";
            	stmt = con.createStatement();
            	rs = stmt.executeQuery(sql);
            	
            	while (rs.next()) {
            		if(i == 1) {participant1.add(rs.getString("participant1")); logger.info("participant1처리중");}
            		else if(i == 2) {participant2.add(rs.getString("participant2")); logger.info("participant2처리중");}
            		else if(i == 3) {participant3.add(rs.getString("participant3")); logger.info("participant3처리중");}
            		else if(i == 4) {participant4.add(rs.getString("participant4")); logger.info("participant4처리중");}
            		else if(i == 5) {participant5.add(rs.getString("participant5")); logger.info("participant5처리중");}
            		else if(i == 6) {participant6.add(rs.getString("participant6")); logger.info("participant6처리중");}
            		else if(i == 7) {participant7.add(rs.getString("participant7")); logger.info("participant7처리중");}
            		else if(i == 8) {participant8.add(rs.getString("participant8")); logger.info("participant8처리중");}
            		else if(i == 9) {participant9.add(rs.getString("participant9")); logger.info("participant9처리중");}
            		else if(i == 10) {participant10.add(rs.getString("participant10")); logger.info("participant10처리중");}
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

	public JSONArray champion() {
		
		return null;
	}
}
