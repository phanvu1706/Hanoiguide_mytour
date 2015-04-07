package com.example.hanoiguide_lichtrinh.model;

import java.util.Date;

public class Group {
	private String maGroup;
	private String tenGoup;
	private String userId_admin;
	private String avatar;
	private String mota;
	private String hoatDongCuoi;
	private String isPublic;
	
	public Group() {
		
	}

	public Group(String maGroup, String tenGoup, String userId_admin,
			String avatar, String mota, String hoatDongCuoi, String isPublic) {
		super();
		this.maGroup = maGroup;
		this.tenGoup = tenGoup;
		this.userId_admin = userId_admin;
		this.avatar = avatar;
		this.mota = mota;
		this.hoatDongCuoi = hoatDongCuoi;
		this.isPublic = isPublic;
	}

	public String getMaGroup() {
		return maGroup;
	}

	public void setMaGroup(String maGroup) {
		this.maGroup = maGroup;
	}

	public String getTenGoup() {
		return tenGoup;
	}

	public void setTenGoup(String tenGoup) {
		this.tenGoup = tenGoup;
	}

	public String getUserId_admin() {
		return userId_admin;
	}

	public void setUserId_admin(String userId_admin) {
		this.userId_admin = userId_admin;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHoatDongCuoi() {
		return hoatDongCuoi;
	}

	public void setHoatDongCuoi(String hoatDongCuoi) {
		this.hoatDongCuoi = hoatDongCuoi;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	
	
}
