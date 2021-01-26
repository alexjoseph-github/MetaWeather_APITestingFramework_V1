package com.data.yaml;

public class WeatherByLocationAndDateTestData extends TestData {

	String location;
	String date;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "WeatherByLocationAndDateTestData [location=" + location + ", date=" + date + "]";
	}

}
