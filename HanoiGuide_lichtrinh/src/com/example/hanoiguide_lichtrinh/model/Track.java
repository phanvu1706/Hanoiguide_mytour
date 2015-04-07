package com.example.hanoiguide_lichtrinh.model;

import java.util.Date;

public class Track {
	private String maLichTrinh;
	private String trackID;
	private String ten;
	private String thoiGianTao;
	
	public Track() {
		
	}

	public Track(String maLichTrinh, String trackID, String ten,
			String thoiGianTao) {
		super();
		this.maLichTrinh = maLichTrinh;
		this.trackID = trackID;
		this.ten = ten;
		this.thoiGianTao = thoiGianTao;
	}

	public String getMaLichTrinh() {
		return maLichTrinh;
	}

	public void setMaLichTrinh(String maLichTrinh) {
		this.maLichTrinh = maLichTrinh;
	}

	public String getTrackID() {
		return trackID;
	}

	public void setTrackID(String trackID) {
		this.trackID = trackID;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(String thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	
	
}
