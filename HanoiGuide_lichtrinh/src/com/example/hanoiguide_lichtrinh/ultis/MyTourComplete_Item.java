package com.example.hanoiguide_lichtrinh.ultis;

public class MyTourComplete_Item {
	private String maDiemDL;
	private String tenDiemDL;
	private String thoigian;

	public MyTourComplete_Item() {
		
	}

	public MyTourComplete_Item(String maDiemDL, String tenDiemDL,
			String thoigian) {
		super();
		this.maDiemDL = maDiemDL;
		this.tenDiemDL = tenDiemDL;
		this.thoigian = thoigian;
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

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	
}
