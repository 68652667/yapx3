package com.kh.yapx3.item.model.vo;

import org.springframework.stereotype.Repository;

@Repository
public class ItemVO {
	
	private String itemId;
	private String name;
	private String description;
	private String imageFull;
	private String gold;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageFull() {
		return imageFull;
	}
	public void setImageFull(String imageFull) {
		this.imageFull = imageFull;
	}
	public String getGold() {
		return gold;
	}
	public void setGold(String gold) {
		this.gold = gold;
	}
	
	
	
	
	
}
