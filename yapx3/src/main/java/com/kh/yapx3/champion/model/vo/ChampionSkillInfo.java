package com.kh.yapx3.champion.model.vo;

public class ChampionSkillInfo extends ChampionInfoVO{
	private String passive;
	private String qSkill;
	private String wSkill;
	private String eSkill;
	private String rSkill;
	private String tollTip;
	private String description;
	private String qSkillTolltip;
	private String wSkillTolltip;
	private String eSkillTolltip;
	private String rSkillTolltip;
	private String passivSkillTolltip;
	
	public ChampionSkillInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChampionSkillInfo(String championLane, String championLaneCount, String summonerSpell1id,
			String summonerSpell2id, String summonerSpellCountStr, String summonerSpellWinCountStr,
			String itemStartPercent1, String itemStartPercent2, String championRunePercenter, int count,
			int perkPrimaryStyle, int perk0, int perk1, int perk2, int perk3, int perkSubStyle, int perk4, int perk5,
			int statPerk0, int statPerk1, int statPerk2, String startItem, String startItem1, String startItem2,
			String startItem3, int item0, int item1, int item2, int item3, int item4, int item5, int item6,
			String championName, String championId) {
		super(championLane, championLaneCount, summonerSpell1id, summonerSpell2id, summonerSpellCountStr,
				summonerSpellWinCountStr, itemStartPercent1, itemStartPercent2, championRunePercenter, count, perkPrimaryStyle,
				perk0, perk1, perk2, perk3, perkSubStyle, perk4, perk5, statPerk0, statPerk1, statPerk2, startItem, startItem1,
				startItem2, startItem3, item0, item1, item2, item3, item4, item5, item6, championName, championId);
		// TODO Auto-generated constructor stub
	}
	public ChampionSkillInfo(String passive, String qSkill, String wSkill, String eSkill, String rSkill, String tollTip,
			String description, String qSkillTolltip, String wSkillTolltip, String eSkillTolltip, String rSkillTolltip,
			String passivSkillTolltip) {
		super();
		this.passive = passive;
		this.qSkill = qSkill;
		this.wSkill = wSkill;
		this.eSkill = eSkill;
		this.rSkill = rSkill;
		this.tollTip = tollTip;
		this.description = description;
		this.qSkillTolltip = qSkillTolltip;
		this.wSkillTolltip = wSkillTolltip;
		this.eSkillTolltip = eSkillTolltip;
		this.rSkillTolltip = rSkillTolltip;
		this.passivSkillTolltip = passivSkillTolltip;
	}
	public String getPassive() {
		return passive;
	}
	public void setPassive(String passive) {
		this.passive = passive;
	}
	public String getqSkill() {
		return qSkill;
	}
	public void setqSkill(String qSkill) {
		this.qSkill = qSkill;
	}
	public String getwSkill() {
		return wSkill;
	}
	public void setwSkill(String wSkill) {
		this.wSkill = wSkill;
	}
	public String geteSkill() {
		return eSkill;
	}
	public void seteSkill(String eSkill) {
		this.eSkill = eSkill;
	}
	public String getrSkill() {
		return rSkill;
	}
	public void setrSkill(String rSkill) {
		this.rSkill = rSkill;
	}
	public String getTollTip() {
		return tollTip;
	}
	public void setTollTip(String tollTip) {
		this.tollTip = tollTip;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getqSkillTolltip() {
		return qSkillTolltip;
	}
	public void setqSkillTolltip(String qSkillTolltip) {
		this.qSkillTolltip = qSkillTolltip;
	}
	public String getwSkillTolltip() {
		return wSkillTolltip;
	}
	public void setwSkillTolltip(String wSkillTolltip) {
		this.wSkillTolltip = wSkillTolltip;
	}
	public String geteSkillTolltip() {
		return eSkillTolltip;
	}
	public void seteSkillTolltip(String eSkillTolltip) {
		this.eSkillTolltip = eSkillTolltip;
	}
	public String getrSkillTolltip() {
		return rSkillTolltip;
	}
	public void setrSkillTolltip(String rSkillTolltip) {
		this.rSkillTolltip = rSkillTolltip;
	}
	public String getPassivSkillTolltip() {
		return passivSkillTolltip;
	}
	public void setPassivSkillTolltip(String passivSkillTolltip) {
		this.passivSkillTolltip = passivSkillTolltip;
	}

	
}
