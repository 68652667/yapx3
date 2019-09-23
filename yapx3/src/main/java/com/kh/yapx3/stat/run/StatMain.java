package com.kh.yapx3.stat.run;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.kh.yapx3.stat.model.vo.MatchString;

public class StatMain {

	public static void main(String[] args) throws Exception {
//		new StatMain().statTest();
		new StatMain().champTest();
	}
	
	private void champTest() throws Exception {
		
		String urlStr2 = "http://ddragon.leagueoflegends.com/cdn/9.18.1/data/en_US/champion.json";
		URL url2 = new URL(urlStr2);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openConnection().getInputStream()));
		String sb2 = br2.readLine();
		JSONObject jobj2 = new JSONObject(sb2.toString());
		
		
		
	}

	public void statTest() throws Exception {
		
		List<MatchString> list = new ArrayList<MatchString>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@aglpbook.ctffmf4kluru.ap-northeast-2.rds.amazonaws.com:1521:ORCL", "aglpbook", "aglp1234567890bookkh");
			
		String sql = "select m.GAMEID, m.GAMECREATION, m.GAMEDURATION, m.QUEUEID, m.MAPID, m.SEASONID, m.TEAM1, m.TEAM2, m.PARTICIPANT1, m.PARTICIPANT2, m.PARTICIPANT3, m.PARTICIPANT4, m.PARTICIPANT5, m.PARTICIPANT6, m.PARTICIPANT7, m.PARTICIPANT8, m.PARTICIPANT9, m.PARTICIPANT10 from (select rownum num, m.* from (select m.* from match m order by m.gameid) m) m where num between 1 and 10";
		
		pstmt = conn.prepareStatement(sql);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			MatchString match = new MatchString();
			match.setGameId(rset.getString("GAMEID"));
			match.setGameCreation(rset.getString("GAMECREATION"));
			match.setGameDuration(rset.getString("GAMEDURATION"));
			match.setQueueId(rset.getString("QUEUEID"));
			match.setMapId(rset.getString("MAPID"));
			match.setSeasonId(rset.getString("SEASONID"));
			match.setTeam1(rset.getString("TEAM1"));
			match.setTeam2(rset.getString("TEAM2"));
			match.setparticipant1(rset.getString("PARTICIPANT1"));
			match.setparticipant2(rset.getString("PARTICIPANT2"));
			match.setparticipant3(rset.getString("PARTICIPANT3"));
			match.setparticipant4(rset.getString("PARTICIPANT4"));
			match.setparticipant5(rset.getString("PARTICIPANT5"));
			match.setparticipant6(rset.getString("PARTICIPANT6"));
			match.setparticipant7(rset.getString("PARTICIPANT7"));
			match.setparticipant8(rset.getString("PARTICIPANT8"));
			match.setparticipant9(rset.getString("PARTICIPANT9"));
			match.setparticipant10(rset.getString("PARTICIPANT10"));
			list.add(match);
		}
		
		conn.close();
		rset.close();
		pstmt.close();
		
		for(MatchString m : list) {
			JSONObject t1 = new JSONObject(m.getTeam1());
			JSONObject t2 = new JSONObject(m.getTeam2());
			JSONObject p1 = new JSONObject(m.getparticipant1());
			JSONObject p2 = new JSONObject(m.getparticipant2());
			JSONObject p3 = new JSONObject(m.getparticipant3());
			JSONObject p4 = new JSONObject(m.getparticipant4());
			JSONObject p5 = new JSONObject(m.getparticipant5());
			JSONObject p6 = new JSONObject(m.getparticipant6());
			JSONObject p7 = new JSONObject(m.getparticipant7());
			JSONObject p8 = new JSONObject(m.getparticipant8());
			JSONObject p9 = new JSONObject(m.getparticipant9());
			JSONObject p10 = new JSONObject(m.getparticipant10());
		}
	}

}
