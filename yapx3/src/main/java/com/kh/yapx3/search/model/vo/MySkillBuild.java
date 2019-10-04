package com.kh.yapx3.search.model.vo;

public class MySkillBuild {
	
	private int timeStamp;
	private String type;
	private int skillSlot;
	private int participantId;
	
	
	
	public MySkillBuild() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MySkillBuild(int timeStamp, int skillSlot, String type, int participantId) {
		super();
		this.timeStamp = timeStamp;
		this.skillSlot = skillSlot;
		this.type = type;
		this.participantId = participantId;
	}



	public int getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}



	public int getSkillSlot() {
		return skillSlot;
	}



	public void setSkillSlot(int skillSlot) {
		this.skillSlot = skillSlot;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getParticipantId() {
		return participantId;
	}



	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}



	@Override
	public String toString() {
		return "MySkillBuild [timeStamp=" + timeStamp + ", skillSlot=" + skillSlot + ", type=" + type
				+ ", participantId=" + participantId + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
