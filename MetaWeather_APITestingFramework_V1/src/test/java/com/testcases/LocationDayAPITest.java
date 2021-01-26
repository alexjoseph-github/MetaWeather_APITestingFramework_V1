package com.testcases;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.businesslayer.LocationDayAPI;
import com.data.DataProviderClass;
import com.data.yaml.VerifyLocationDayAPIResponseTestData;
import com.data.yaml.WeatherByLocationAndDateTestData;
import com.listeners.ExtentListeners;
import com.pojos.WeatherByLocationAndDatePOJO;

import io.restassured.response.Response;

/**
 * This class contains all the test cases related to API
 * We are separating test cases so that they will be easy to manage
 * 
 */
public class LocationDayAPITest {

	private static final Logger LOGGER = Logger.getLogger(LocationDayAPITest.class);

	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class, enabled = true)
	public void verifyLocationDayAPIResponse(VerifyLocationDayAPIResponseTestData apitestdata) {
		ExtentTest extentTest = ExtentListeners.getExtentTest();
		String locationName = apitestdata.getLocation();
		String date = apitestdata.getDate();

		Response response = LocationDayAPI.geWeatherByLocationAndDateResponse(locationName, date);
		
		Assert.assertEquals(response.getStatusCode(), apitestdata.getExpectedStatusCode(),"Status Code mismtach found - ");
		Assert.assertEquals(response.getContentType(), apitestdata.getExpectedContentType(),
				"ContentType mismatch found - ");

		extentTest.log(Status.PASS, "Verified that the Status Code is " + apitestdata.getExpectedStatusCode());
		extentTest.log(Status.PASS, "Verified that the Content Type is " + apitestdata.getExpectedContentType());

	}
	
	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class, enabled = true)
	public void checkWeatherByLocationAndDate(WeatherByLocationAndDateTestData apitestdata) {
		ExtentTest extentTest = ExtentListeners.getExtentTest();
		String locationName = apitestdata.getLocation();
		String date = apitestdata.getDate();

		List<WeatherByLocationAndDatePOJO> weatherByLocationAndDatePOJO = LocationDayAPI
				.geWeatherByLocationAndDate(locationName, date);

		extentTest.log(Status.INFO, "Weather forecast for " + locationName + " is "
				+ weatherByLocationAndDatePOJO.get(0).getWeather_state_name());

	}

	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class, enabled = true)
	public void verifyLocationDayAPIResponseFieldsAreNotNull(WeatherByLocationAndDateTestData apitestdata) {
		ExtentTest extentTest = ExtentListeners.getExtentTest();
		String locationName = apitestdata.getLocation();
		String date = apitestdata.getDate();

		List<WeatherByLocationAndDatePOJO> weatherByLocationAndDatePOJO = LocationDayAPI
				.geWeatherByLocationAndDate(locationName, date);

		// Check for null field values
		SoftAssert softAssert = new SoftAssert();
		for (int i = 0; i < weatherByLocationAndDatePOJO.size(); i++) {
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getId(),
					"ID field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getWeather_state_name(),
					"WEATHER_STATE_NAME field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getWeather_state_abbr(),
					"WEATHER_STATE_ABBR field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getCreated(),
					"CREATED field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getApplicable_date(),
					"APPLICABLE field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getMin_temp(),
					"MIN_TEMP field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getMax_temp(),
					"MAX_TEMP field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getThe_temp(),
					"THE_TEMP field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getWind_speed(),
					"WIND_SPEED field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getWind_direction(),
					"WIND_DIRECTION field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getAir_pressure(),
					"AIR_PRESSURE field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getHumidity(),
					"HUMIDITY field at position " + i + " of JSON object empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getVisibility(),
					"VISIBILITY field at position " + i + " of JSON object is empty - ");
			softAssert.assertNotNull(weatherByLocationAndDatePOJO.get(i).getPredictability(),
					"PREDICTABILITY field at position " + i + " of JSON object is empty - ");

		}
		softAssert.assertAll();
		;

	}

}
