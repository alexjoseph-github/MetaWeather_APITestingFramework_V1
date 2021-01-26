package com.testcases;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.businesslayer.LocationSearchAPI;
import com.data.DataProviderClass;
import com.data.yaml.LocationSearchTestData;
import com.data.yaml.WeatherByLocationAndDateTestData;
import com.listeners.ExtentListeners;
import com.pojos.LocationSearchPOJO;
import com.pojos.WeatherByLocationAndDatePOJO;

/**
 * This class contains all the test cases related to API
 * We are separating test cases so that they will be easy to manage
 * 
 */
public class LocationSearchTest {

	private static final Logger LOGGER = Logger.getLogger(LocationSearchTest.class);

	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class, enabled = false)
	public void validateLocationSearchResponseForNotNull(LocationSearchTestData apitestdata) {
		ExtentTest extentTest = ExtentListeners.getExtentTest();
		String locationName = apitestdata.getLocation();
		int expectedStatusCode = apitestdata.getExpectedStatusCode();

		List<LocationSearchPOJO> locationSearchPOJO = LocationSearchAPI.getWhereOnEarthID(locationName);

		Assert.assertTrue(locationSearchPOJO != null, "Response body is empty - ");
		extentTest.log(Status.INFO, "Number of elements in Location Search response: " + locationSearchPOJO.size());
		extentTest.log(Status.INFO,
				"First element inside Location Search response array: " + locationSearchPOJO.get(0).toString());

		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < locationSearchPOJO.size(); i++) {
			softAssert.assertNotNull(locationSearchPOJO.get(i).getTitle(), "TITLE field is empty - ");
			softAssert.assertNotNull(locationSearchPOJO.get(i).getLocation_type(), "LOCATION_TYPE field is empty - ");
			softAssert.assertNotNull(locationSearchPOJO.get(i).getWoeid(), "WOEID field is empty - ");
			softAssert.assertNotNull(locationSearchPOJO.get(i).getLatt_long(), "LATT_LONG field is empty - ");
		}
		softAssert.assertAll();

	}

	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class, enabled = true)
	public void validateWeatherByLocationAndDate(WeatherByLocationAndDateTestData apitestdata) {
		ExtentTest extentTest = ExtentListeners.getExtentTest();
		String locationName = apitestdata.getLocation();
		String date = apitestdata.getDate();

		List<WeatherByLocationAndDatePOJO> weatherByLocationAndDatePOJO = LocationSearchAPI
				.geWeatherByLocationAndDate(locationName, date);

		extentTest.log(Status.INFO, "Weather forecast for " + locationName + " is "
				+ weatherByLocationAndDatePOJO.get(0).getWeather_state_name());
		
		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < weatherByLocationAndDatePOJO.size(); i++) {
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getId(), "ID field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getWeather_state_name(), "WEATHER_STATE_NAME field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getWeather_state_abbr(), "WEATHER_STATE_ABBR field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getCreated(), "CREATED field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getApplicable_date(), "APPLICABLE field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getMin_temp(), "MIN_TEMP field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getMax_temp(), "MAX_TEMP field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getThe_temp(), "THE_TEMP field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getWind_speed(), "WIND_SPEED field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getWind_direction(), "WIND_DIRECTION field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getAir_pressure(), "AIR_PRESSURE field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getHumidity(), "HUMIDITY field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getVisibility(), "VISIBILITY field at position " + i + " of JSON object is empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getPredictability(), "PREDICTABILITY field at position " + i + " of JSON object is empty - ");
			
		}
		softAssert.assertAll();;

	}

}
