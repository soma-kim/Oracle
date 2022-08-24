package com.kh.chap01.poly.part02.electronic.model.vo;

public class Desktop extends Electronic {
	public static String CPU = "intel";
	private String graphic;

//	�����ں�
	public Desktop() {
		
	}

	public Desktop(String brand, String name, int price, String graphic) {
		super(brand, name, price);
		this.graphic = graphic;
	}

//	�޼ҵ��
	public String getGraphic() {
		return graphic;
	}

	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}

//	toString
	public String toString() {
		return super.toString() + "CPU = " + CPU + ", graphic = " + graphic + "]";
	}

}
