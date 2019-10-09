package com.kh.yapx3.champion.model.vo;

public class ChampionSkillInfo extends ChampionInfoVO{
	private String passive;
	private String qSkill;
	private String wSkill;
	private String eSkill;
	private String rSkill;
	private String tollTip;
	private String description;
	public ChampionSkillInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChampionSkillInfo(String passive, String qSkill, String wSkill, String eSkill, String rSkill, String tollTip,
			String description) {
		super();
		this.passive = passive;
		this.qSkill = qSkill;
		this.wSkill = wSkill;
		this.eSkill = eSkill;
		this.rSkill = rSkill;
		this.tollTip = tollTip;
		this.description = description;
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
	
}
