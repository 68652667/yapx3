package com.kh.yapx3.search.model.vo;

public class MyItemBuild {
	
	private int timeStamp;
	private String type;
	private int itemId;
	private int paritipantId;
	
	
	
	public MyItemBuild() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyItemBuild(int timeStamp, String type, int itemId, int paritipantId) {
		super();
		this.timeStamp = timeStamp;
		this.type = type;
		this.itemId = itemId;
		this.paritipantId = paritipantId;
	}
	
	public int getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getParitipantId() {
		return paritipantId;
	}
	public void setParitipantId(int paritipantId) {
		this.paritipantId = paritipantId;
	}
	@Override
	public String toString() {
		return "MyItemBuild [timeStamp=" + timeStamp + ", type=" + type + ", itemId=" + itemId + ", paritipantId="
				+ paritipantId + "]";
	}
	
	
	
	
	
	

}
