package com.example.hanoiguide_lichtrinh.model;

public class DiemDuLich {
	private String maDiemDL;
	private String tenDiemDL;
	private String img;
	private String latitude;
	private String longtitude;
	
	public DiemDuLich() {
		
	}

	public DiemDuLich(String maDiemDL, String tenDiemDL, String img,
			String latitude, String longtitude) {
		super();
		this.maDiemDL = maDiemDL;
		this.tenDiemDL = tenDiemDL;
		this.img = img;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public String getMaDiemDL() {
		return maDiemDL;
	}

	public void setMaDiemDL(String maDiemDL) {
		this.maDiemDL = maDiemDL;
	}

	public String getTenDiemDL() {
		return tenDiemDL;
	}

	public void setTenDiemDL(String tenDiemDL) {
		this.tenDiemDL = tenDiemDL;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	
	
}
