package com.kh.chap03.map.part01.hashMap.model.vo;

public class Snack {
	// ÇÊµåºÎ
	private String flavor;
	private int Calory;
	
	public Snack() {
		super();
	}

	public Snack(String flavor, int calory) {
		super();
		this.flavor = flavor;
		Calory = calory;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getCalory() {
		return Calory;
	}

	public void setCalory(int calory) {
		Calory = calory;
	}

	
	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", Calory=" + Calory + "]";
	}
	
	
	
}
