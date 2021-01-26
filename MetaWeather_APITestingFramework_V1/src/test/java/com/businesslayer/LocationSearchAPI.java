package com.businesslayer;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.data.PropertyFileReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.listeners.ExtentListeners;
import com.pojos.LocationSearchPOJO;
import com.pojos.WeatherByLocationAndDatePOJO;

import io.restassured.response.Response;

/**
 * 
 * Business Layer : Sole purpose is to accept data and populate POJOs and
 * further perform some task related to particular domain
 * 
 **/
public class LocationSearchAPI {
	private static final Logger LOGGER = Logger.getLogger(LocationSearchAPI.class);

	/*
	 * Extract data as Response object Populate respective Response POJOs
	 */

	public static List<LocationSearchPOJO> getWhereOnEarthID(String locationName) {
		ExtentTest extentTest = ExtentListeners.getExtentTest();
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("baseURL");
		String basePath = PropertyFileReader.getPropertyData().getApis().get("basePath");
		String searchQuery = PropertyFileReader.getPropertyData().getApis().get("searchQuery");
		String url = baseURL + basePath + searchQuery + locationName;

		LOGGER.info("URL to be hit:" + url);
		//extentTest.log(Status.INFO, "URL to be hit:" + url);

		Response response = when().get(url);
		LOGGER.info("Where On Earth ID of " + locationName + " is " + response.jsonPath().get("woeid"));
		//extentTest.log(Status.INFO, "Where On Earth ID of " + locationName + " is " + response.jsonPath().get("woeid"));

		ObjectMapper mapper = new ObjectMapper();
		List<LocationSearchPOJO> locationSearchPOJO = null;

		try {
			locationSearchPOJO = mapper.readValue(response.getBody().asString(),
					new TypeReference<List<LocationSearchPOJO>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}

		// response.then().assertThat().contentType(ContentType.JSON).and().

		locationSearchPOJO.get(0).setStatusCode(response.getStatusCode());

		return locationSearchPOJO;

	}

	public static List<WeatherByLocationAndDatePOJO> geWeatherByLocationAndDate(String locationName, String date) {
		ExtentTest extentTest = ExtentListeners.getExtentTest();
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("baseURL");
		String basePath = PropertyFileReader.getPropertyData().getApis().get("basePath");
		String woeID = getWhereOnEarthID(locationName).get(0).getWoeid();
		String url = baseURL + basePath + "/" + woeID + "/" + date;

		LOGGER.info("URL to be hit :" + url);
		extentTest.log(Status.INFO, "URL to be hit :" + url);

		Response response = when().get(url);

		ObjectMapper mapper = new ObjectMapper();
		List<WeatherByLocationAndDatePOJO> weatherByLocationAndDatePOJO = null;

		try {
			weatherByLocationAndDatePOJO = mapper.readValue(response.getBody().asString(),
					new TypeReference<List<WeatherByLocationAndDatePOJO>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weatherByLocationAndDatePOJO;
	}

}
