package com.example.hanoiguide_lichtrinh.model;

public class User_Group {
	private String user_id;
	private String maGroup;
	private String ghichu;
	private String traithai;
	
	public User_Group() {
		
	}

	public User_Group(String user_id, String maGroup, String ghichu,
			String traithai) {
		super();
		this.user_id = user_id;
		this.maGroup = maGroup;
		this.ghichu = ghichu;
		this.traithai = traithai;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMaGroup() {
		return maGroup;
	}

	public void setMaGroup(String maGroup) {
		this.maGroup = maGroup;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getTraithai() {
		return traithai;
	}

	public void setTraithai(String traithai) {
		this.traithai = traithai;
	}
	
}
