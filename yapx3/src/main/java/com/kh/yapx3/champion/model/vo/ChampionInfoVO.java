package com.kh.yapx3.champion.model.vo;

public class ChampionInfoVO {

	private String championLane;
	private String championLaneCount;
	private int summonerSpell1id;
	private int summonerSpell2id;
	private String summonerSpellCountStr;
	
	// DB받기용 필드
	private int count;
	//메인룬
	private int perkPrimaryStyle;
	private int perk0;
	private int perk1;
	private int perk2;
	private int perk3;
	//서브룬
	private int perkSubStyle;
	private int perk4;
	private int perk5;
	//보조룬
	private int statPerk0;
	private int statPerk1;
	private int statPerk2;

	public ChampionInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChampionInfoVO(String championLane, String championLaneCount, int summonerSpell1id, int summonerSpell2id,
			String summonerSpellCountStr, int count, int perkPrimaryStyle, int perk0, int perk1, int perk2,
			int perk3, int perkSubStyle, int perk4, int perk5, int statPerk0, int statPerk1, int statPerk2) {
		super();
		this.championLane = championLane;
		this.championLaneCount = championLaneCount;
		this.summonerSpell1id = summonerSpell1id;
		this.summonerSpell2id = summonerSpell2id;
		this.summonerSpellCountStr = summonerSpellCountStr;
		this.count = count;
		this.perkPrimaryStyle = perkPrimaryStyle;
		this.perk0 = perk0;
		this.perk1 = perk1;
		this.perk2 = perk2;
		this.perk3 = perk3;
		this.perkSubStyle = perkSubStyle;
		this.perk4 = perk4;
		this.perk5 = perk5;
		this.statPerk0 = statPerk0;
		this.statPerk1 = statPerk1;
		this.statPerk2 = statPerk2;
	}

	public String getChampionLane() {
		return championLane;
	}

	public void setChampionLane(String championLane) {
		this.championLane = championLane;
	}

	public String getChampionLaneCount() {
		return championLaneCount;
	}

	public void setChampionLaneCount(String championLaneCount) {
		this.championLaneCount = championLaneCount;
	}

	public int getSummonerSpell1id() {
		return summonerSpell1id;
	}

	public void setSummonerSpell1id(int summonerSpell1id) {
		this.summonerSpell1id = summonerSpell1id;
	}

	public int getSummonerSpell2id() {
		return summonerSpell2id;
	}

	public void setSummonerSpell2id(int summonerSpell2id) {
		this.summonerSpell2id = summonerSpell2id;
	}

	public String getSummonerSpellCountStr() {
		return summonerSpellCountStr;
	}

	public void setSummonerSpellCountStr(String summonerSpellCountStr) {
		this.summonerSpellCountStr = summonerSpellCountStr;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPerkPrimaryStyle() {
		return perkPrimaryStyle;
	}

	public void setPerkPrimaryStyle(int perkPrimaryStyle) {
		this.perkPrimaryStyle = perkPrimaryStyle;
	}

	public int getPerk0() {
		return perk0;
	}

	public void setPerk0(int perk0) {
		this.perk0 = perk0;
	}

	public int getPerk1() {
		return perk1;
	}

	public void setPerk1(int perk1) {
		this.perk1 = perk1;
	}

	public int getPerk2() {
		return perk2;
	}

	public void setPerk2(int perk2) {
		this.perk2 = perk2;
	}

	public int getPerk3() {
		return perk3;
	}

	public void setPerk3(int perk3) {
		this.perk3 = perk3;
	}

	public int getPerkSubStyle() {
		return perkSubStyle;
	}

	public void setPerkSubStyle(int perkSubStyle) {
		this.perkSubStyle = perkSubStyle;
	}

	public int getPerk4() {
		return perk4;
	}

	public void setPerk4(int perk4) {
		this.perk4 = perk4;
	}

	public int getPerk5() {
		return perk5;
	}

	public void setPerk5(int perk5) {
		this.perk5 = perk5;
	}

	public int getStatPerk0() {
		return statPerk0;
	}

	public void setStatPerk0(int statPerk0) {
		this.statPerk0 = statPerk0;
	}

	public int getStatPerk1() {
		return statPerk1;
	}

	public void setStatPerk1(int statPerk1) {
		this.statPerk1 = statPerk1;
	}

	public int getStatPerk2() {
		return statPerk2;
	}

	public void setStatPerk2(int statPerk2) {
		this.statPerk2 = statPerk2;
	}
	
}
