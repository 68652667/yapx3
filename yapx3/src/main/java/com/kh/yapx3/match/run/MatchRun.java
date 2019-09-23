package com.kh.yapx3.match.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.kh.yapx3.match.model.vo.Match;
import com.kh.yapx3.match.model.vo.Participant;
import com.kh.yapx3.match.model.vo.Summoner_1;
import com.kh.yapx3.match.model.vo.Team;

public class MatchRun {

	public static void main(String[] args) throws Exception {
		new MatchRun().Matches("RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f");
	}
	
	public void Matches(String key) throws Exception {
		List<String> matchList = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@aglpbook.ctffmf4kluru.ap-northeast-2.rds.amazonaws.com:1521:ORCL", "aglpbook", "aglp1234567890bookkh");
		
			
		String sql = "select gameid from (select rownum num, gameid from (select m.* from match m order by m.gameid)) where num between 30226 and 42234";
		
		pstmt = conn.prepareStatement(sql);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			matchList.add(rset.getString("gameid"));
		}
		
		for(int i=0; i<matchList.size(); i++) {
			
			if(i != 0 && i%90 == 0) {
				if(key == "RGAPI-e91563a2-e6d2-41e9-9803-42fc0d55ee59") {
					System.out.println("멈출게요 : "+(i+1)+"번째");
					Thread.sleep(150001);
				}
				System.out.println("현재 키 : "+key);
				switch(key) {
				case "RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f" : key = "RGAPI-e91563a2-e6d2-41e9-9803-42fc0d55ee59"; break;
				case "RGAPI-e91563a2-e6d2-41e9-9803-42fc0d55ee59" : key = "RGAPI-75b06c3a-71bc-4298-ad56-5f64414b6e8f"; break;
				}
				System.out.println("변경 키 : "+key);
			}
			
			String urlStr = "https://kr.api.riotgames.com/lol/match/v4/matches/"+matchList.get(i)+"?api_key="+key;
			URL url = new URL(urlStr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
			String sb = br.readLine();
			JSONObject j = new JSONObject(sb.toString());
			if(j.get("queueId").toString().equals("420") || j.get("queueId").toString().equals("430") || j.get("queueId").toString().equals("440") || j.get("queueId").toString().equals("450") || j.get("queueId").toString().equals("840") || j.get("queueId").toString().equals("900")){
				Match m = new Match();
				try { m.setGameId(j.get("gameId").toString()); } catch(Exception e) {}
				try { m.setGameCreation(j.get("gameCreation").toString()); } catch(Exception e) {}
				try { m.setGameDuration(j.get("gameDuration").toString()); } catch(Exception e) {}
				try { m.setQueueId(j.get("queueId").toString()); } catch(Exception e) {}
				try { m.setMapId(j.get("mapId").toString()); } catch(Exception e) {}
				try { m.setSeasonId(j.get("seasonId").toString()); } catch(Exception e) {}
				
				JSONArray ja = j.getJSONArray("teams");
				JSONObject team = ja.getJSONObject(0);
				Team t = new Team();
				JSONArray bans = team.getJSONArray("bans");
				if(bans.length() == 5) {
					try { t.setBan1(bans.getJSONObject(0).get("championId").toString()); } catch(Exception e) {}
					try { t.setBan2(bans.getJSONObject(1).get("championId").toString()); } catch(Exception e) {}
					try { t.setBan3(bans.getJSONObject(2).get("championId").toString()); } catch(Exception e) {}
					try { t.setBan4(bans.getJSONObject(3).get("championId").toString()); } catch(Exception e) {}
					try { t.setBan5(bans.getJSONObject(4).get("championId").toString()); } catch(Exception e) {}
				}
				t.setTeamId(team.get("teamId").toString());
				try { t.setWin(team.getString("win")); } catch(Exception e) {}
				m.setTeam1(t);
				
				team = ja.getJSONObject(1);
				t = new Team();
				bans = team.getJSONArray("bans");
				if(bans.length() == 5) {
					try { t.setBan1(bans.getJSONObject(0).get("championId").toString()); } catch(Exception e) {}
					try { t.setBan2(bans.getJSONObject(1).get("championId").toString()); } catch(Exception e) {}
					try { t.setBan3(bans.getJSONObject(2).get("championId").toString()); } catch(Exception e) {}
					try { t.setBan4(bans.getJSONObject(3).get("championId").toString()); } catch(Exception e) {}
					try { t.setBan5(bans.getJSONObject(4).get("championId").toString()); } catch(Exception e) {}
				}
				t.setTeamId(team.get("teamId").toString());
				try { t.setWin(team.getString("win")); } catch(Exception e) {}
				m.setTeam2(t);
				
				JSONArray ja_1 = j.getJSONArray("participants");
				JSONArray ja_2 = j.getJSONArray("participantIdentities");
				
				JSONObject participant = (JSONObject) ja_1.get(0);
				JSONObject participantIdentities = (JSONObject) ja_2.get(0);
				JSONObject stats = participant.getJSONObject("stats");
				JSONObject player = participantIdentities.getJSONObject("player");
//			Participant p = new Participant(participant.get("participantId").toString(), participant.get("teamId").toString(), participant.get("championId").toString(), participant.get("spell1Id").toString(), participant.get("spell2Id").toString(), stats.get("win").toString(), stats.get("item0").toString(), stats.get("item1").toString(), stats.get("item2").toString(), stats.get("item3").toString(), stats.get("item4").toString(), stats.get("item5").toString(), stats.get("item6").toString(), stats.get("kills").toString(), stats.get("deaths").toString(), stats.get("assists").toString(), stats.get("largestMultiKill").toString(), stats.get("totalDamageDealtToChampions").toString(), stats.get("goldEarned").toString(), stats.get("totalMinionsKilled").toString(), stats.get("champLevel").toString(), stats.get("perk0").toString(), stats.get("perk0Var1").toString(), stats.get("perk0Var2").toString(), stats.get("perk0Var3").toString(), stats.get("perk1").toString(), stats.get("perk1Var1").toString(), stats.get("perk1Var2").toString(), stats.get("perk1Var3").toString(), stats.get("perk2").toString(), stats.get("perk2Var1").toString(), stats.get("perk2Var2").toString(), stats.get("perk2Var3").toString(), stats.get("perk3").toString(), stats.get("perk3Var1").toString(), stats.get("perk3Var2").toString(), stats.get("perk3Var3").toString(), stats.get("perk4").toString(), stats.get("perk4Var1").toString(), stats.get("perk4Var2").toString(), stats.get("perk4Var3").toString(), stats.get("perk5").toString(), stats.get("perk5Var1").toString(), stats.get("perk5Var2").toString(), stats.get("perk5Var3").toString(), stats.get("perkPrimaryStyle").toString(), null, stats.get("statPerk0").toString(), stats.get("statPerk1").toString(), stats.get("statPerk2").toString(), player.getString("summonerName"), null, null, null, null, null);
				Participant p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants1(p);
				
				participant = (JSONObject) ja_1.get(1);
				participantIdentities = (JSONObject) ja_2.get(1);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants2(p);
				
				participant = (JSONObject) ja_1.get(2);
				participantIdentities = (JSONObject) ja_2.get(2);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants3(p);
				
				participant = (JSONObject) ja_1.get(3);
				participantIdentities = (JSONObject) ja_2.get(3);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants4(p);
				
				participant = (JSONObject) ja_1.get(4);
				participantIdentities = (JSONObject) ja_2.get(4);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants5(p);
				
				participant = (JSONObject) ja_1.get(5);
				participantIdentities = (JSONObject) ja_2.get(5);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants6(p);
				
				participant = (JSONObject) ja_1.get(6);
				participantIdentities = (JSONObject) ja_2.get(6);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants7(p);
				
				participant = (JSONObject) ja_1.get(7);
				participantIdentities = (JSONObject) ja_2.get(7);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants8(p);
				
				participant = (JSONObject) ja_1.get(8);
				participantIdentities = (JSONObject) ja_2.get(8);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants9(p);
				
				participant = (JSONObject) ja_1.get(9);
				participantIdentities = (JSONObject) ja_2.get(9);
				stats = participant.getJSONObject("stats");
				player = participantIdentities.getJSONObject("player");
				p = new Participant();
				try { p.setParticipantId(participant.get("participantId").toString()); } catch(Exception e) {}
				try { p.setTeamId(participant.get("teamId").toString()); } catch(Exception e) {}
				try { p.setChampionId(participant.get("championId").toString()); } catch(Exception e) {}
				try { p.setSpell1Id(participant.get("spell1Id").toString()); } catch(Exception e) {}
				try { p.setSpell2Id(participant.get("spell2Id").toString()); } catch(Exception e) {}
				try { p.setWin(stats.get("win").toString()); } catch(Exception e) {}
				try { p.setItem0(stats.get("item0").toString()); } catch(Exception e) {}
				try { p.setItem1(stats.get("item1").toString()); } catch(Exception e) {}
				try { p.setItem2(stats.get("item2").toString()); } catch(Exception e) {}
				try { p.setItem3(stats.get("item3").toString()); } catch(Exception e) {}
				try { p.setItem4(stats.get("item4").toString()); } catch(Exception e) {}
				try { p.setItem5(stats.get("item5").toString()); } catch(Exception e) {}
				try { p.setItem6(stats.get("item6").toString()); } catch(Exception e) {}
				try { p.setKills(stats.get("kills").toString()); } catch(Exception e) {}
				try { p.setDeaths(stats.get("deaths").toString()); } catch(Exception e) {}
				try { p.setAssists(stats.get("assists").toString()); } catch(Exception e) {}
				try { p.setLargestMultiKill(stats.get("largestMultiKill").toString()); } catch(Exception e) {}
				try { p.setTotalDamageDealtToChampions(stats.get("totalDamageDealtToChampions").toString()); } catch(Exception e) {}
				try { p.setGoldEarned(stats.get("goldEarned").toString()); } catch(Exception e) {}
				try { p.setTotalMinionsKilled(stats.get("totalMinionsKilled").toString()); } catch(Exception e) {}
				try { p.setChampLevel(stats.get("champLevel").toString()); } catch(Exception e) {}
				try { p.setPerk0(stats.get("perk0").toString()); } catch(Exception e) {}
				try { p.setPerk0Var1(stats.get("perk0Var1").toString()); } catch(Exception e) {}
				try { p.setPerk0Var2(stats.get("perk0Var2").toString()); } catch(Exception e) {}
				try { p.setPerk0Var3(stats.get("perk0Var3").toString()); } catch(Exception e) {}
				try { p.setPerk1(stats.get("perk1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var1(stats.get("perk1Var1").toString()); } catch(Exception e) {}
				try { p.setPerk1Var2(stats.get("perk1Var2").toString()); } catch(Exception e) {}
				try { p.setPerk1Var3(stats.get("perk1Var3").toString()); } catch(Exception e) {}
				try { p.setPerk2(stats.get("perk2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var1(stats.get("perk2Var1").toString()); } catch(Exception e) {}
				try { p.setPerk2Var2(stats.get("perk2Var2").toString()); } catch(Exception e) {}
				try { p.setPerk2Var3(stats.get("perk2Var3").toString()); } catch(Exception e) {}
				try { p.setPerk3(stats.get("perk3").toString()); } catch(Exception e) {}
				try { p.setPerk3Var1(stats.get("perk3Var1").toString()); } catch(Exception e) {}
				try { p.setPerk3Var2(stats.get("perk3Var2").toString()); } catch(Exception e) {}
				try { p.setPerk3Var3(stats.get("perk3Var3").toString()); } catch(Exception e) {}
				try { p.setPerk4(stats.get("perk4").toString()); } catch(Exception e) {}
				try { p.setPerk4Var1(stats.get("perk4Var1").toString()); } catch(Exception e) {}
				try { p.setPerk4Var2(stats.get("perk4Var2").toString()); } catch(Exception e) {}
				try { p.setPerk4Var3(stats.get("perk4Var3").toString()); } catch(Exception e) {}
				try { p.setPerk5(stats.get("perk5").toString()); } catch(Exception e) {}
				try { p.setPerk5Var1(stats.get("perk5Var1").toString()); } catch(Exception e) {}
				try { p.setPerk5Var2(stats.get("perk5Var2").toString()); } catch(Exception e) {}
				try { p.setPerk5Var3(stats.get("perk5Var3").toString()); } catch(Exception e) {}
				try { p.setPerkSubStyle(stats.get("perkSubStyle").toString()); } catch(Exception e) {}
				try { p.setPerkPrimaryStyle(stats.get("perkPrimaryStyle").toString()); } catch(Exception e) {}
				try { p.setStatPerk0(stats.get("statPerk0").toString()); } catch(Exception e) {}
				try { p.setStatPerk1(stats.get("statPerk1").toString()); } catch(Exception e) {}
				try { p.setStatPerk2(stats.get("statPerk2").toString()); } catch(Exception e) {}
				try { p.setLane(participant.getJSONObject("timeline").getString("lane")); } catch(Exception e) {}
				try { p.setSummonerName(player.getString("summonerName")); } catch(Exception e) {}
				m.setParticipants10(p);
				
				File file = new File("Matches.sql");
				
				FileWriter fw = new FileWriter(file, true);
				
				fw.write("update match set GAMECREATION = '"+m.getGameCreation()+"', GAMEDURATION = '"+m.getGameDuration()+"', QUEUEID = '"+m.getQueueId()+"', MAPID = '"+m.getMapId()+"', SEASONID = '"+m.getSeasonId()+"', TEAM1 = '"+m.getTeam1().toString()+"', TEAM2 = '"+m.getTeam2().toString()+"', PARTICIPANT1 = '"+m.getParticipants1().toString()+"', PARTICIPANT2 = '"+m.getParticipants2().toString()+"', PARTICIPANT3 = '"+m.getParticipants3().toString()+"', PARTICIPANT4 = '"+m.getParticipants4().toString()+"', PARTICIPANT5 = '"+m.getParticipants5().toString()+"', PARTICIPANT6 = '"+m.getParticipants6().toString()+"', PARTICIPANT7 = '"+m.getParticipants7().toString()+"', PARTICIPANT8 = '"+m.getParticipants8().toString()+"', PARTICIPANT9 = '"+m.getParticipants9().toString()+"', PARTICIPANT10 = '"+m.getParticipants10().toString()+"' where GAMEID = '"+m.getGameId()+"';\n");
				
				fw.close();
			}
		}
		
		System.out.println("끝");
		
	}

}
