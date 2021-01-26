package com.pojos;

public class WeatherByLocationAndDatePOJO {
	
	String id;
	String weather_state_name;
	String weather_state_abbr;
	String wind_direction_compass;
	String created;
	String applicable_date;
	String min_temp;
	String max_temp;
	String the_temp;
	String wind_speed;
	String wind_direction;
	String air_pressure;
	String humidity;
	String visibility;
	String predictability;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWeather_state_name() {
		return weather_state_name;
	}
	public void setWeather_state_name(String weather_state_name) {
		this.weather_state_name = weather_state_name;
	}
	public String getWeather_state_abbr() {
		return weather_state_abbr;
	}
	public void setWeather_state_abbr(String weather_state_abbr) {
		this.weather_state_abbr = weather_state_abbr;
	}
	public String getWind_direction_compass() {
		return wind_direction_compass;
	}
	public void setWind_direction_compass(String wind_direction_compass) {
		this.wind_direction_compass = wind_direction_compass;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getApplicable_date() {
		return applicable_date;
	}
	public void setApplicable_date(String applicable_date) {
		this.applicable_date = applicable_date;
	}
	public String getMin_temp() {
		return min_temp;
	}
	public void setMin_temp(String min_temp) {
		this.min_temp = min_temp;
	}
	public String getMax_temp() {
		return max_temp;
	}
	public void setMax_temp(String max_temp) {
		this.max_temp = max_temp;
	}
	public String getThe_temp() {
		return the_temp;
	}
	public void setThe_temp(String the_temp) {
		this.the_temp = the_temp;
	}
	public String getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(String wind_speed) {
		this.wind_speed = wind_speed;
	}
	public String getWind_direction() {
		return wind_direction;
	}
	public void setWind_direction(String wind_direction) {
		this.wind_direction = wind_direction;
	}
	public String getAir_pressure() {
		return air_pressure;
	}
	public void setAir_pressure(String air_pressure) {
		this.air_pressure = air_pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getPredictability() {
		return predictability;
	}
	public void setPredictability(String predictability) {
		this.predictability = predictability;
	}
	@Override
	public String toString() {
		return "WeatherByLocationAndDatePOJO [id=" + id + ", weather_state_name=" + weather_state_name
				+ ", weather_state_abbr=" + weather_state_abbr + ", wind_direction_compass=" + wind_direction_compass
				+ ", created=" + created + ", applicable_date=" + applicable_date + ", min_temp=" + min_temp
				+ ", max_temp=" + max_temp + ", the_temp=" + the_temp + ", wind_speed=" + wind_speed
				+ ", wind_direction=" + wind_direction + ", air_pressure=" + air_pressure + ", humidity=" + humidity
				+ ", visibility=" + visibility + ", predictability=" + predictability + "]";
	}
	
	
	
	
/*
	long id;
	String weather_state_name;
	String weather_state_abbr;
	String wind_direction_compass;
	String created;
	String applicable_date;
	float min_temp;
	float max_temp;
	float the_temp;
	double wind_speed;
	double wind_direction;
	int air_pressure;
	int humidity;
	double visibility;
	int predictability;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWeather_state_name() {
		return weather_state_name;
	}

	public void setWeather_state_name(String weather_state_name) {
		this.weather_state_name = weather_state_name;
	}

	public String getWeather_state_abbr() {
		return weather_state_abbr;
	}

	public void setWeather_state_abbr(String weather_state_abbr) {
		this.weather_state_abbr = weather_state_abbr;
	}

	public String getWind_direction_compass() {
		return wind_direction_compass;
	}

	public void setWind_direction_compass(String wind_direction_compass) {
		this.wind_direction_compass = wind_direction_compass;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getApplicable_date() {
		return applicable_date;
	}

	public void setApplicable_date(String applicable_date) {
		this.applicable_date = applicable_date;
	}

	public float getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(float min_temp) {
		this.min_temp = min_temp;
	}

	public float getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(float max_temp) {
		this.max_temp = max_temp;
	}

	public float getThe_temp() {
		return the_temp;
	}

	public void setThe_temp(float the_temp) {
		this.the_temp = the_temp;
	}

	public double getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}

	public double getWind_direction() {
		return wind_direction;
	}

	public void setWind_direction(double wind_direction) {
		this.wind_direction = wind_direction;
	}

	public int getAir_pressure() {
		return air_pressure;
	}

	public void setAir_pressure(int air_pressure) {
		this.air_pressure = air_pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public int getPredictability() {
		return predictability;
	}

	public void setPredictability(int predictability) {
		this.predictability = predictability;
	}

	@Override
	public String toString() {
		return "WeatherByLocationAndDatePOJO [id=" + id + ", weather_state_name=" + weather_state_name
				+ ", weather_state_abbr=" + weather_state_abbr + ", wind_direction_compass=" + wind_direction_compass
				+ ", created=" + created + ", applicable_date=" + applicable_date + ", min_temp=" + min_temp
				+ ", max_temp=" + max_temp + ", the_temp=" + the_temp + ", wind_speed=" + wind_speed
				+ ", wind_direction=" + wind_direction + ", air_pressure=" + air_pressure + ", humidity=" + humidity
				+ ", visibility=" + visibility + ", predictability=" + predictability + "]";
	}

*/
}
