package com.kh.yapx3.search.model.vo;

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
	
	public Participant() {}

	public Participant(String participantId, String teamId, String championId, String spell1Id, String spell2Id,
			String win, String item0, String item1, String item2, String item3, String item4, String item5,
			String item6, String kills, String deaths, String assists, String largestKillingSpree,
			String largestMultiKill, String totalDamageTaken, String totalMinionsKilled, String accountId,
			String summonerName, String summonerId, String currentAccountId, String matchHistoryUri, String champLevel) {
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

	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", teamId=" + teamId + ", championId=" + championId
				+ ", spell1Id=" + spell1Id + ", spell2Id=" + spell2Id + ", win=" + win + ", item0=" + item0 + ", item1="
				+ item1 + ", item2=" + item2 + ", item3=" + item3 + ", item4=" + item4 + ", item5=" + item5 + ", item6="
				+ item6 + ", kills=" + kills + ", deaths=" + deaths + ", assists=" + assists + ", largestKillingSpree="
				+ largestKillingSpree + ", largestMultiKill=" + largestMultiKill + ", totalDamageTaken="
				+ totalDamageTaken + ", totalMinionsKilled=" + totalMinionsKilled + ", accountId=" + accountId
				+ ", summonerName=" + summonerName + ", summonerId=" + summonerId + ", currentAccountId="
				+ currentAccountId + ", matchHistoryUri=" + matchHistoryUri + ", champLevel=" + champLevel + "]";
	}


}
