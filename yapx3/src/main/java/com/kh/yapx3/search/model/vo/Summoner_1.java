package com.kh.yapx3.search.model.vo;

public class Summoner_1 {
	
	private String accountId;
	private String id;
	private String name;
	private String profileIconId;
	private String puuid;
	private String revisionDate;
	private String summonerLevel;
	
	public Summoner_1() {}
	
	public Summoner_1(String accountId, String id, String name,String profileIconId, String puuid, String revisionDate,
			String summonerLevel) {
		super();
		this.accountId = accountId;
		this.id = id;
		this.name = name;
		this.profileIconId = profileIconId;
		this.puuid = puuid;
		this.revisionDate = revisionDate;
		this.summonerLevel = summonerLevel;
	}

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(String profileIconId) {
		this.profileIconId = profileIconId;
	}
	public String getPuuid() {
		return puuid;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public String getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(String revisionDate) {
		this.revisionDate = revisionDate;
	}
	public String getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(String summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	@Override
	public String toString() {
		return "Summoner_1 [accountId=" + accountId + ", id=" + id + ", name=" + name + ", profileIconId="
				+ profileIconId + ", puuid=" + puuid + ", revisionDate=" + revisionDate + ", summonerLevel="
				+ summonerLevel + "]";
	}


}
