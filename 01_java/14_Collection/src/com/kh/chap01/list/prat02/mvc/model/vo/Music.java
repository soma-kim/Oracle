package com.kh.chap01.list.prat02.mvc.model.vo;

public class Music {
	// 필드부
	private String title; // 노래 제목
	private String artist; // 가수명
	
	// 생성자부
	public Music() {
		super();
	}

	public Music(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	// 메소드부
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
