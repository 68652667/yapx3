package com.kh.yapx3.match.model.vo;

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
	private String largestMultiKill;
	private String totalDamageDealtToChampions;
	private String goldEarned;
	private String totalMinionsKilled;
	private String champLevel;
	private String perk0;
	private String perk0Var1;
	private String perk0Var2;
	private String perk0Var3;
	private String perk1;
	private String perk1Var1;
	private String perk1Var2;
	private String perk1Var3;
	private String perk2;
	private String perk2Var1;
	private String perk2Var2;
	private String perk2Var3;
	private String perk3;
	private String perk3Var1;
	private String perk3Var2;
	private String perk3Var3;
	private String perk4;
	private String perk4Var1;
	private String perk4Var2;
	private String perk4Var3;
	private String perk5;
	private String perk5Var1;
	private String perk5Var2;
	private String perk5Var3;
	private String perkPrimaryStyle;
	private String perkSubStyle;
	private String statPerk0;
	private String statPerk1;
	private String statPerk2;
	private String accountId;
	private String summonerName;
	private String timestamp;
	private String type;
	private String afterId;
	private String levelUpType;
	private String skillSlot;
	
	public Participant() {}

	public Participant(String participantId, String teamId, String championId, String spell1Id, String spell2Id,
			String win, String item0, String item1, String item2, String item3, String item4, String item5,
			String item6, String kills, String deaths, String assists, String largestMultiKill,
			String totalDamageDealtToChampions, String goldEarned, String totalMinionsKilled, String champLevel,
			String perk0, String perk0Var1, String perk0Var2, String perk0Var3, String perk1, String perk1Var1,
			String perk1Var2, String perk1Var3, String perk2, String perk2Var1, String perk2Var2, String perk2Var3,
			String perk3, String perk3Var1, String perk3Var2, String perk3Var3, String perk4, String perk4Var1,
			String perk4Var2, String perk4Var3, String perk5, String perk5Var1, String perk5Var2, String perk5Var3,
			String perkPrimaryStyle, String perkSubStyle, String statPerk0, String statPerk1, String statPerk2,
			String accountId, String summonerName, String timestamp, String type, String afterId, String levelUpType,
			String skillSlot) {
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
		this.largestMultiKill = largestMultiKill;
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
		this.goldEarned = goldEarned;
		this.totalMinionsKilled = totalMinionsKilled;
		this.champLevel = champLevel;
		this.perk0 = perk0;
		this.perk0Var1 = perk0Var1;
		this.perk0Var2 = perk0Var2;
		this.perk0Var3 = perk0Var3;
		this.perk1 = perk1;
		this.perk1Var1 = perk1Var1;
		this.perk1Var2 = perk1Var2;
		this.perk1Var3 = perk1Var3;
		this.perk2 = perk2;
		this.perk2Var1 = perk2Var1;
		this.perk2Var2 = perk2Var2;
		this.perk2Var3 = perk2Var3;
		this.perk3 = perk3;
		this.perk3Var1 = perk3Var1;
		this.perk3Var2 = perk3Var2;
		this.perk3Var3 = perk3Var3;
		this.perk4 = perk4;
		this.perk4Var1 = perk4Var1;
		this.perk4Var2 = perk4Var2;
		this.perk4Var3 = perk4Var3;
		this.perk5 = perk5;
		this.perk5Var1 = perk5Var1;
		this.perk5Var2 = perk5Var2;
		this.perk5Var3 = perk5Var3;
		this.perkPrimaryStyle = perkPrimaryStyle;
		this.perkSubStyle = perkSubStyle;
		this.statPerk0 = statPerk0;
		this.statPerk1 = statPerk1;
		this.statPerk2 = statPerk2;
		this.accountId = accountId;
		this.summonerName = summonerName;
		this.timestamp = timestamp;
		this.type = type;
		this.afterId = afterId;
		this.levelUpType = levelUpType;
		this.skillSlot = skillSlot;
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

	public String getLargestMultiKill() {
		return largestMultiKill;
	}

	public void setLargestMultiKill(String largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}

	public String getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(String totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public String getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(String goldEarned) {
		this.goldEarned = goldEarned;
	}

	public String getTotalMinionsKilled() {
		return totalMinionsKilled;
	}

	public void setTotalMinionsKilled(String totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}

	public String getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(String champLevel) {
		this.champLevel = champLevel;
	}

	public String getPerk0() {
		return perk0;
	}

	public void setPerk0(String perk0) {
		this.perk0 = perk0;
	}

	public String getPerk0Var1() {
		return perk0Var1;
	}

	public void setPerk0Var1(String perk0Var1) {
		this.perk0Var1 = perk0Var1;
	}

	public String getPerk0Var2() {
		return perk0Var2;
	}

	public void setPerk0Var2(String perk0Var2) {
		this.perk0Var2 = perk0Var2;
	}

	public String getPerk0Var3() {
		return perk0Var3;
	}

	public void setPerk0Var3(String perk0Var3) {
		this.perk0Var3 = perk0Var3;
	}

	public String getPerk1() {
		return perk1;
	}

	public void setPerk1(String perk1) {
		this.perk1 = perk1;
	}

	public String getPerk1Var1() {
		return perk1Var1;
	}

	public void setPerk1Var1(String perk1Var1) {
		this.perk1Var1 = perk1Var1;
	}

	public String getPerk1Var2() {
		return perk1Var2;
	}

	public void setPerk1Var2(String perk1Var2) {
		this.perk1Var2 = perk1Var2;
	}

	public String getPerk1Var3() {
		return perk1Var3;
	}

	public void setPerk1Var3(String perk1Var3) {
		this.perk1Var3 = perk1Var3;
	}

	public String getPerk2() {
		return perk2;
	}

	public void setPerk2(String perk2) {
		this.perk2 = perk2;
	}

	public String getPerk2Var1() {
		return perk2Var1;
	}

	public void setPerk2Var1(String perk2Var1) {
		this.perk2Var1 = perk2Var1;
	}

	public String getPerk2Var2() {
		return perk2Var2;
	}

	public void setPerk2Var2(String perk2Var2) {
		this.perk2Var2 = perk2Var2;
	}

	public String getPerk2Var3() {
		return perk2Var3;
	}

	public void setPerk2Var3(String perk2Var3) {
		this.perk2Var3 = perk2Var3;
	}

	public String getPerk3() {
		return perk3;
	}

	public void setPerk3(String perk3) {
		this.perk3 = perk3;
	}

	public String getPerk3Var1() {
		return perk3Var1;
	}

	public void setPerk3Var1(String perk3Var1) {
		this.perk3Var1 = perk3Var1;
	}

	public String getPerk3Var2() {
		return perk3Var2;
	}

	public void setPerk3Var2(String perk3Var2) {
		this.perk3Var2 = perk3Var2;
	}

	public String getPerk3Var3() {
		return perk3Var3;
	}

	public void setPerk3Var3(String perk3Var3) {
		this.perk3Var3 = perk3Var3;
	}

	public String getPerk4() {
		return perk4;
	}

	public void setPerk4(String perk4) {
		this.perk4 = perk4;
	}

	public String getPerk4Var1() {
		return perk4Var1;
	}

	public void setPerk4Var1(String perk4Var1) {
		this.perk4Var1 = perk4Var1;
	}

	public String getPerk4Var2() {
		return perk4Var2;
	}

	public void setPerk4Var2(String perk4Var2) {
		this.perk4Var2 = perk4Var2;
	}

	public String getPerk4Var3() {
		return perk4Var3;
	}

	public void setPerk4Var3(String perk4Var3) {
		this.perk4Var3 = perk4Var3;
	}

	public String getPerk5() {
		return perk5;
	}

	public void setPerk5(String perk5) {
		this.perk5 = perk5;
	}

	public String getPerk5Var1() {
		return perk5Var1;
	}

	public void setPerk5Var1(String perk5Var1) {
		this.perk5Var1 = perk5Var1;
	}

	public String getPerk5Var2() {
		return perk5Var2;
	}

	public void setPerk5Var2(String perk5Var2) {
		this.perk5Var2 = perk5Var2;
	}

	public String getPerk5Var3() {
		return perk5Var3;
	}

	public void setPerk5Var3(String perk5Var3) {
		this.perk5Var3 = perk5Var3;
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAfterId() {
		return afterId;
	}

	public void setAfterId(String afterId) {
		this.afterId = afterId;
	}

	public String getLevelUpType() {
		return levelUpType;
	}

	public void setLevelUpType(String levelUpType) {
		this.levelUpType = levelUpType;
	}

	public String getSkillSlot() {
		return skillSlot;
	}

	public void setSkillSlot(String skillSlot) {
		this.skillSlot = skillSlot;
	}

	@Override
	public String toString() {
		return "{ participantId:\"" + participantId + "\", teamId:\"" + teamId + "\", championId:\"" + championId
				+ "\", spell1Id:\"" + spell1Id + "\", spell2Id:\"" + spell2Id + "\", win:\"" + win + "\", item0:\""
				+ item0 + "\", item1:\"" + item1 + "\", item2:\"" + item2 + "\", item3:\"" + item3 + "\", item4:\""
				+ item4 + "\", item5:\"" + item5 + "\", item6:\"" + item6 + "\", kills:\"" + kills + "\", deaths:\""
				+ deaths + "\", assists:\"" + assists + "\", largestMultiKill:\"" + largestMultiKill
				+ "\", totalDamageDealtToChampions:\"" + totalDamageDealtToChampions + "\", goldEarned:\"" + goldEarned
				+ "\", totalMinionsKilled:\"" + totalMinionsKilled + "\", champLevel:\"" + champLevel + "\", perk0:\""
				+ perk0 + "\", perk0Var1:\"" + perk0Var1 + "\", perk0Var2:\"" + perk0Var2 + "\", perk0Var3:\""
				+ perk0Var3 + "\", perk1:\"" + perk1 + "\", perk1Var1:\"" + perk1Var1 + "\", perk1Var2:\"" + perk1Var2
				+ "\", perk1Var3:\"" + perk1Var3 + "\", perk2:\"" + perk2 + "\", perk2Var1:\"" + perk2Var1
				+ "\", perk2Var2:\"" + perk2Var2 + "\", perk2Var3:\"" + perk2Var3 + "\", perk3:\"" + perk3
				+ "\", perk3Var1:\"" + perk3Var1 + "\", perk3Var2:\"" + perk3Var2 + "\", perk3Var3:\"" + perk3Var3
				+ "\", perk4:\"" + perk4 + "\", perk4Var1:\"" + perk4Var1 + "\", perk4Var2:\"" + perk4Var2
				+ "\", perk4Var3:\"" + perk4Var3 + "\", perk5:\"" + perk5 + "\", perk5Var1:\"" + perk5Var1
				+ "\", perk5Var2:\"" + perk5Var2 + "\", perk5Var3:\"" + perk5Var3 + "\", perkPrimaryStyle:\""
				+ perkPrimaryStyle + "\", perkSubStyle:\"" + perkSubStyle + "\", statPerk0:\"" + statPerk0
				+ "\", statPerk1:\"" + statPerk1 + "\", statPerk2:\"" + statPerk2 + "\", accountId:\"" + accountId
				+ "\", summonerName:\"" + summonerName + "\", timestamp:\"" + timestamp + "\", type:\"" + type
				+ "\", afterId:\"" + afterId + "\", levelUpType:\"" + levelUpType + "\", skillSlot:\"" + skillSlot
				+ "\"}";
	}

}
