package com.kh.yapx3.champion.model.vo;

public class ChampionInfoVO {

	private String championLane;
	private String championLaneCount;
	private String summonerSpell1id;
	private String summonerSpell2id;
	private String summonerSpellCountStr;
	private String summonerSpellWinCountStr;
	private String itemStartPercent;

	// DB받기용 필드
	private int count;
	// 메인룬
	private int perkPrimaryStyle;
	private int perk0;
	private int perk1;
	private int perk2;
	private int perk3;
	// 서브룬
	private int perkSubStyle;
	private int perk4;
	private int perk5;
	// 보조룬
	private int statPerk0;
	private int statPerk1;
	private int statPerk2;
	// 아이템
	private String startItem;
	private String startItem1;
	private String startItem2;
	private String startItem3;
	private int item0;
	private int item1;
	private int item2;
	private int item3;
	private int item4;
	private int item5;
	private int item6;
	public ChampionInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChampionInfoVO(String championLane, String championLaneCount, String summonerSpell1id,
			String summonerSpell2id, String summonerSpellCountStr, String summonerSpellWinCountStr,
			String itemStartPercent, int count, int perkPrimaryStyle, int perk0, int perk1, int perk2, int perk3,
			int perkSubStyle, int perk4, int perk5, int statPerk0, int statPerk1, int statPerk2, String startItem,
			String startItem1, String startItem2, String startItem3, int item0, int item1, int item2, int item3,
			int item4, int item5, int item6) {
		super();
		this.championLane = championLane;
		this.championLaneCount = championLaneCount;
		this.summonerSpell1id = summonerSpell1id;
		this.summonerSpell2id = summonerSpell2id;
		this.summonerSpellCountStr = summonerSpellCountStr;
		this.summonerSpellWinCountStr = summonerSpellWinCountStr;
		this.itemStartPercent = itemStartPercent;
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
		this.startItem = startItem;
		this.startItem1 = startItem1;
		this.startItem2 = startItem2;
		this.startItem3 = startItem3;
		this.item0 = item0;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
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
	public String getSummonerSpell1id() {
		return summonerSpell1id;
	}
	public void setSummonerSpell1id(String summonerSpell1id) {
		this.summonerSpell1id = summonerSpell1id;
	}
	public String getSummonerSpell2id() {
		return summonerSpell2id;
	}
	public void setSummonerSpell2id(String summonerSpell2id) {
		this.summonerSpell2id = summonerSpell2id;
	}
	public String getSummonerSpellCountStr() {
		return summonerSpellCountStr;
	}
	public void setSummonerSpellCountStr(String summonerSpellCountStr) {
		this.summonerSpellCountStr = summonerSpellCountStr;
	}
	public String getSummonerSpellWinCountStr() {
		return summonerSpellWinCountStr;
	}
	public void setSummonerSpellWinCountStr(String summonerSpellWinCountStr) {
		this.summonerSpellWinCountStr = summonerSpellWinCountStr;
	}
	public String getItemStartPercent() {
		return itemStartPercent;
	}
	public void setItemStartPercent(String itemStartPercent) {
		this.itemStartPercent = itemStartPercent;
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
	public String getStartItem() {
		return startItem;
	}
	public void setStartItem(String startItem) {
		this.startItem = startItem;
	}
	public String getStartItem1() {
		return startItem1;
	}
	public void setStartItem1(String startItem1) {
		this.startItem1 = startItem1;
	}
	public String getStartItem2() {
		return startItem2;
	}
	public void setStartItem2(String startItem2) {
		this.startItem2 = startItem2;
	}
	public String getStartItem3() {
		return startItem3;
	}
	public void setStartItem3(String startItem3) {
		this.startItem3 = startItem3;
	}
	public int getItem0() {
		return item0;
	}
	public void setItem0(int item0) {
		this.item0 = item0;
	}
	public int getItem1() {
		return item1;
	}
	public void setItem1(int item1) {
		this.item1 = item1;
	}
	public int getItem2() {
		return item2;
	}
	public void setItem2(int item2) {
		this.item2 = item2;
	}
	public int getItem3() {
		return item3;
	}
	public void setItem3(int item3) {
		this.item3 = item3;
	}
	public int getItem4() {
		return item4;
	}
	public void setItem4(int item4) {
		this.item4 = item4;
	}
	public int getItem5() {
		return item5;
	}
	public void setItem5(int item5) {
		this.item5 = item5;
	}
	public int getItem6() {
		return item6;
	}
	public void setItem6(int item6) {
		this.item6 = item6;
	}
	
	
}
