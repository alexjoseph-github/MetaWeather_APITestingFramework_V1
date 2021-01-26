package com.data.yaml;

public class LocationSearchTestData extends TestData {

	String location;
	int expectedStatusCode;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getExpectedStatusCode() {
		return expectedStatusCode;
	}

	public void setExpectedStatusCode(int expectedStatusCode) {
		this.expectedStatusCode = expectedStatusCode;
	}

	@Override
	public String toString() {
		return "LocationSearchTestData [location=" + location + ", expectedStatusCode=" + expectedStatusCode + "]";
	}

}
