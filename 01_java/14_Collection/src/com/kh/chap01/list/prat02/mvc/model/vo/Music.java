package com.kh.chap01.list.prat02.mvc.model.vo;

public class Music {
	// �ʵ��
	private String title; // �뷡 ����
	private String artist; // ������
	
	// �����ں�
	public Music() {
		super();
	}

	public Music(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	// �޼ҵ��
	public String getTilte() {
		return title;
	}

	public void setTilte(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Music [tilte=" + title + ", artist=" + artist + "]";
	}
}
