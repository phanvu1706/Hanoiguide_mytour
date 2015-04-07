package com.example.hanoiguide_lichtrinh.model;

import java.util.Date;

public class Waypoint {
	private String waypointID;
	private String latitude;
	private String longtitude;
	private String time;
	private String accuracy;
	private String speed;
	private String trackID;
	
	public Waypoint() {
		
	}

	public Waypoint(String waypointID, String latitude, String longtitude,
			String time, String accuracy, String speed, String trackID) {
		super();
		this.waypointID = waypointID;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.time = time;
		this.accuracy = accuracy;
		this.speed = speed;
		this.trackID = trackID;
	}

	public String getWaypointID() {
		return waypointID;
	}

	public void setWaypointID(String waypointID) {
		this.waypointID = waypointID;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getTrackID() {
		return trackID;
	}

	public void setTrackID(String trackID) {
		this.trackID = trackID;
	}

}
