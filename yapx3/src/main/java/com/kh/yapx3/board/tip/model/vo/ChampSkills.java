package com.kh.yapx3.board.tip.model.vo;

public class ChampSkills {
	
	private String id;
	private String passive;
	private String q;
	private String w;
	private String e;
	private String r;
	
	public ChampSkills() {}

	public ChampSkills(String id, String passive, String q, String w, String e, String r) {
		super();
		this.id = id;
		this.passive = passive;
		this.q = q;
		this.w = w;
		this.e = e;
		this.r = r;
	}
	
	@Override
	public String toString() {
		return "ChampSkills [id=" + id + ", passive=" + passive + ", q=" + q + ", w=" + w + ", e=" + e + ", r=" + r
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassive() {
		return passive;
	}

	public void setPassive(String passive) {
		this.passive = passive;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}


	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}
	
	

}
