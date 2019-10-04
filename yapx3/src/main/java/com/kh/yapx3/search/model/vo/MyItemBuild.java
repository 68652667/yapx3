package com.kh.yapx3.search.model.vo;

public class MyItemBuild {
	
	private String timeStamp;
	private String type;
	private String itemId;
	
	
	
	public MyItemBuild() {
		super();
	}



	public MyItemBuild(String timeStamp, String type, String itemId) {
		super();
		this.timeStamp = timeStamp;
		this.type = type;
		this.itemId = itemId;
	}



	public String getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	@Override
	public String toString() {
		return "MatchBuild [timeStamp=" + timeStamp + ", type=" + type + ", itemId=" + itemId + "]";
	}
	
	

}
