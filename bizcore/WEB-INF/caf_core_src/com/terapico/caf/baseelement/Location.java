package com.terapico.caf.baseelement;

public class Location {
	private double longitude;
	private double latitude;
	private double altitude;
	private String locationName;
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Location() {}
	public Location(double longitude, double latitude, double altitude, String locationName) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.locationName = locationName;
	}
}
