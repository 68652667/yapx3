package com.kh.yapx3.search.model.vo;

public class RotationCham {
	private String ChamName;
	private String ChamNum;
	
	
	
	
	public RotationCham() {
		super();
		// TODO Auto-generated constructor stub
	}




	public RotationCham(String chamName, String chamNum) {
		super();
		ChamName = chamName;
		ChamNum = chamNum;
	}




	public String getChamName() {
		return ChamName;
	}




	public void setChamName(String chamName) {
		ChamName = chamName;
	}




	public String getChamNum() {
		return ChamNum;
	}




	public void setChamNum(String chamNum) {
		ChamNum = chamNum;
	}




	@Override
	public String toString() {
		return "RotationCham [ChamName=" + ChamName + ", ChamNum=" + ChamNum + "]";
	}
	
	
	
}
