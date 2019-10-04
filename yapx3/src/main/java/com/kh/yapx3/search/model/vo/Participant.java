package com.kh.yapx3.search.model.vo;

import java.util.List;

public class Participant {
	
	private String participantId;
	private String teamId;
	private String championId;
	private String spell1Id;
	private String spell2Id;
	private String win;
	private String item0;
	private String item1;
	private String item2;
	private String item3;
	private String item4;
	private String item5;
	private String item6;
	private String kills;
	private String deaths;
	private String assists;
	private String largestKillingSpree;
	private String largestMultiKill;
	private String totalDamageTaken;
	private String totalMinionsKilled;
	private String accountId;
	private String summonerName;
	private String summonerId;
	private String currentAccountId;
	private String matchHistoryUri;
	private String champLevel;
	
	private String perkPrimaryStyle;
	private String perkSubStyle;
	
	private String perk0;
	private String perk1;
	private String perk2;
	private String perk3;
	private String perk4;
	private String perk5;
	
	private String statPerk0;
	private String statPerk1;
	private String statPerk2;
	
	private List<MyItemBuild> myItemBuild;
	private List<MySkillBuild> mySkillBuild;
	
	
	
	
	public Participant() {
		super();
	}




	public Participant(String participantId, String teamId, String championId, String spell1Id, String spell2Id,
			String win, String item0, String item1, String item2, String item3, String item4, String item5,
			String item6, String kills, String deaths, String assists, String largestKillingSpree,
			String largestMultiKill, String totalDamageTaken, String totalMinionsKilled, String accountId,
			String summonerName, String summonerId, String currentAccountId, String matchHistoryUri, String champLevel,
			String perkPrimaryStyle, String perkSubStyle, String perk0, String perk1, String perk2, String perk3,
			String perk4, String perk5, String statPerk0, String statPerk1, String statPerk2,
			List<MyItemBuild> myItemBuild, List<MySkillBuild> mySkillBuild) {
		super();
		this.participantId = participantId;
		this.teamId = teamId;
		this.championId = championId;
		this.spell1Id = spell1Id;
		this.spell2Id = spell2Id;
		this.win = win;
		this.item0 = item0;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
		this.largestKillingSpree = largestKillingSpree;
		this.largestMultiKill = largestMultiKill;
		this.totalDamageTaken = totalDamageTaken;
		this.totalMinionsKilled = totalMinionsKilled;
		this.accountId = accountId;
		this.summonerName = summonerName;
		this.summonerId = summonerId;
		this.currentAccountId = currentAccountId;
		this.matchHistoryUri = matchHistoryUri;
		this.champLevel = champLevel;
		this.perkPrimaryStyle = perkPrimaryStyle;
		this.perkSubStyle = perkSubStyle;
		this.perk0 = perk0;
		this.perk1 = perk1;
		this.perk2 = perk2;
		this.perk3 = perk3;
		this.perk4 = perk4;
		this.perk5 = perk5;
		this.statPerk0 = statPerk0;
		this.statPerk1 = statPerk1;
		this.statPerk2 = statPerk2;
		this.myItemBuild = myItemBuild;
		this.mySkillBuild = mySkillBuild;
	}




	public String getParticipantId() {
		return participantId;
	}




	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}




	public String getTeamId() {
		return teamId;
	}




	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}




	public String getChampionId() {
		return championId;
	}




	public void setChampionId(String championId) {
		this.championId = championId;
	}




	public String getSpell1Id() {
		return spell1Id;
	}




	public void setSpell1Id(String spell1Id) {
		this.spell1Id = spell1Id;
	}




	public String getSpell2Id() {
		return spell2Id;
	}




	public void setSpell2Id(String spell2Id) {
		this.spell2Id = spell2Id;
	}




	public String getWin() {
		return win;
	}




	public void setWin(String win) {
		this.win = win;
	}




	public String getItem0() {
		return item0;
	}




	public void setItem0(String item0) {
		this.item0 = item0;
	}




	public String getItem1() {
		return item1;
	}




	public void setItem1(String item1) {
		this.item1 = item1;
	}




	public String getItem2() {
		return item2;
	}




	public void setItem2(String item2) {
		this.item2 = item2;
	}




	public String getItem3() {
		return item3;
	}




	public void setItem3(String item3) {
		this.item3 = item3;
	}




	public String getItem4() {
		return item4;
	}




	public void setItem4(String item4) {
		this.item4 = item4;
	}




	public String getItem5() {
		return item5;
	}




	public void setItem5(String item5) {
		this.item5 = item5;
	}




	public String getItem6() {
		return item6;
	}




	public void setItem6(String item6) {
		this.item6 = item6;
	}




	public String getKills() {
		return kills;
	}




	public void setKills(String kills) {
		this.kills = kills;
	}




	public String getDeaths() {
		return deaths;
	}




	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}




	public String getAssists() {
		return assists;
	}




	public void setAssists(String assists) {
		this.assists = assists;
	}




	public String getLargestKillingSpree() {
		return largestKillingSpree;
	}




	public void setLargestKillingSpree(String largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}




	public String getLargestMultiKill() {
		return largestMultiKill;
	}




	public void setLargestMultiKill(String largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}




	public String getTotalDamageTaken() {
		return totalDamageTaken;
	}




	public void setTotalDamageTaken(String totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}




	public String getTotalMinionsKilled() {
		return totalMinionsKilled;
	}




	public void setTotalMinionsKilled(String totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}




	public String getAccountId() {
		return accountId;
	}




	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}




	public String getSummonerName() {
		return summonerName;
	}




	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}




	public String getSummonerId() {
		return summonerId;
	}




	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}




	public String getCurrentAccountId() {
		return currentAccountId;
	}




	public void setCurrentAccountId(String currentAccountId) {
		this.currentAccountId = currentAccountId;
	}




	public String getMatchHistoryUri() {
		return matchHistoryUri;
	}




	public void setMatchHistoryUri(String matchHistoryUri) {
		this.matchHistoryUri = matchHistoryUri;
	}




	public String getChampLevel() {
		return champLevel;
	}




	public void setChampLevel(String champLevel) {
		this.champLevel = champLevel;
	}




	public String getPerkPrimaryStyle() {
		return perkPrimaryStyle;
	}




	public void setPerkPrimaryStyle(String perkPrimaryStyle) {
		this.perkPrimaryStyle = perkPrimaryStyle;
	}




	public String getPerkSubStyle() {
		return perkSubStyle;
	}




	public void setPerkSubStyle(String perkSubStyle) {
		this.perkSubStyle = perkSubStyle;
	}




	public String getPerk0() {
		return perk0;
	}




	public void setPerk0(String perk0) {
		this.perk0 = perk0;
	}




	public String getPerk1() {
		return perk1;
	}




	public void setPerk1(String perk1) {
		this.perk1 = perk1;
	}




	public String getPerk2() {
		return perk2;
	}




	public void setPerk2(String perk2) {
		this.perk2 = perk2;
	}




	public String getPerk3() {
		return perk3;
	}




	public void setPerk3(String perk3) {
		this.perk3 = perk3;
	}




	public String getPerk4() {
		return perk4;
	}




	public void setPerk4(String perk4) {
		this.perk4 = perk4;
	}




	public String getPerk5() {
		return perk5;
	}




	public void setPerk5(String perk5) {
		this.perk5 = perk5;
	}




	public String getStatPerk0() {
		return statPerk0;
	}




	public void setStatPerk0(String statPerk0) {
		this.statPerk0 = statPerk0;
	}




	public String getStatPerk1() {
		return statPerk1;
	}




	public void setStatPerk1(String statPerk1) {
		this.statPerk1 = statPerk1;
	}




	public String getStatPerk2() {
		return statPerk2;
	}




	public void setStatPerk2(String statPerk2) {
		this.statPerk2 = statPerk2;
	}




	public List<MyItemBuild> getMyItemBuild() {
		return myItemBuild;
	}




	public void setMyItemBuild(List<MyItemBuild> myItemBuild) {
		this.myItemBuild = myItemBuild;
	}




	public List<MySkillBuild> getMySkillBuild() {
		return mySkillBuild;
	}




	public void setMySkillBuild(List<MySkillBuild> mySkillBuild) {
		this.mySkillBuild = mySkillBuild;
	}




	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", teamId=" + teamId + ", championId=" + championId
				+ ", spell1Id=" + spell1Id + ", spell2Id=" + spell2Id + ", win=" + win + ", item0=" + item0 + ", item1="
				+ item1 + ", item2=" + item2 + ", item3=" + item3 + ", item4=" + item4 + ", item5=" + item5 + ", item6="
				+ item6 + ", kills=" + kills + ", deaths=" + deaths + ", assists=" + assists + ", largestKillingSpree="
				+ largestKillingSpree + ", largestMultiKill=" + largestMultiKill + ", totalDamageTaken="
				+ totalDamageTaken + ", totalMinionsKilled=" + totalMinionsKilled + ", accountId=" + accountId
				+ ", summonerName=" + summonerName + ", summonerId=" + summonerId + ", currentAccountId="
				+ currentAccountId + ", matchHistoryUri=" + matchHistoryUri + ", champLevel=" + champLevel
				+ ", perkPrimaryStyle=" + perkPrimaryStyle + ", perkSubStyle=" + perkSubStyle + ", perk0=" + perk0
				+ ", perk1=" + perk1 + ", perk2=" + perk2 + ", perk3=" + perk3 + ", perk4=" + perk4 + ", perk5=" + perk5
				+ ", statPerk0=" + statPerk0 + ", statPerk1=" + statPerk1 + ", statPerk2=" + statPerk2
				+ ", myItemBuild=" + myItemBuild + ", mySkillBuild=" + mySkillBuild + "]";
	}
	
	
	
	
	
	
	


}
