package com.example.hanoiguide_lichtrinh.model;

import java.util.Date;

public class LichTrinh {
	private String maLichTrinh;
	private String tenLichTrinh;
	private String mota;
	private String image;
	private String isPublic;
	private Date ngayDatDau;
	private Date ngayKetThuc;
	private String reminder;
	private String user_id;
	private String diemDB_lat;
	private String diemDB_lon;
	
	public LichTrinh() {
		
	}

	public LichTrinh(String maLichTrinh, String tenLichTrinh, String mota,
			String image, String isPublic, Date ngayDatDau, Date ngayKetThuc,
			String reminder, String user_id, String diemDB_lat,
			String diemDB_lon) {
		super();
		this.maLichTrinh = maLichTrinh;
		this.tenLichTrinh = tenLichTrinh;
		this.mota = mota;
		this.image = image;
		this.isPublic = isPublic;
		this.ngayDatDau = ngayDatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.reminder = reminder;
		this.user_id = user_id;
		this.diemDB_lat = diemDB_lat;
		this.diemDB_lon = diemDB_lon;
	}

	public String getMaLichTrinh() {
		return maLichTrinh;
	}

	public void setMaLichTrinh(String maLichTrinh) {
		this.maLichTrinh = maLichTrinh;
	}

	public String getTenLichTrinh() {
		return tenLichTrinh;
	}

	public void setTenLichTrinh(String tenLichTrinh) {
		this.tenLichTrinh = tenLichTrinh;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public Date getNgayDatDau() {
		return ngayDatDau;
	}

	public void setNgayDatDau(Date ngayDatDau) {
		this.ngayDatDau = ngayDatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDiemDB_lat() {
		return diemDB_lat;
	}

	public void setDiemDB_lat(String diemDB_lat) {
		this.diemDB_lat = diemDB_lat;
	}

	public String getDiemDB_lon() {
		return diemDB_lon;
	}

	public void setDiemDB_lon(String diemDB_lon) {
		this.diemDB_lon = diemDB_lon;
	}
	
	
}
