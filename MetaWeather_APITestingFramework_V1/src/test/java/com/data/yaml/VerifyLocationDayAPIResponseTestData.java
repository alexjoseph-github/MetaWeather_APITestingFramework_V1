package com.data.yaml;

public class VerifyLocationDayAPIResponseTestData extends TestData {

	String location;
	String date;
	int expectedStatusCode;
	String expectedContentType;

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

	public int getExpectedStatusCode() {
		return expectedStatusCode;
	}

	public void setExpectedStatusCode(int expectedStatusCode) {
		this.expectedStatusCode = expectedStatusCode;
	}

	public String getExpectedContentType() {
		return expectedContentType;
	}

	public void setExpectedContentType(String expectedContentType) {
		this.expectedContentType = expectedContentType;
	}

	@Override
	public String toString() {
		return "VerifyLocationDayAPIResponseTestData [location=" + location + ", date=" + date + ", expectedStatusCode="
				+ expectedStatusCode + ", expectedContentType=" + expectedContentType + "]";
	}

}
