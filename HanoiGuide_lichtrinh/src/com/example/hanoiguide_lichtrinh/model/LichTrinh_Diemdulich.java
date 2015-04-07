package com.example.hanoiguide_lichtrinh.model;

import java.util.Date;

public class LichTrinh_Diemdulich {
	private String maLichTrinh;
	private String maDiemDL;
	private String thoigian;
	
	public LichTrinh_Diemdulich() {
		
	}

	public LichTrinh_Diemdulich(String maLichTrinh, String maDiemDL,
			String thoigian) {
		super();
		this.maLichTrinh = maLichTrinh;
		this.maDiemDL = maDiemDL;
		this.thoigian = thoigian;
	}

	public String getMaLichTrinh() {
		return maLichTrinh;
	}

	public void setMaLichTrinh(String maLichTrinh) {
		this.maLichTrinh = maLichTrinh;
	}

	public String getMaDiemDL() {
		return maDiemDL;
	}

	public void setMaDiemD(String maDiemD) {
		this.maDiemDL = maDiemD;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	
	
}
