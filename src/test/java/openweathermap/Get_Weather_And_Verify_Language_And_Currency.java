package openweathermap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Get_Weather_And_Verify_Language_And_Currency extends OpenWeatherBase{
	
	@Test
	public void testLanguageAndCurrencyInfo() {
		String inputcity = "New Delhi";
		Response res = OpenWeatherFunctionality.getWeatherByCity(inputcity);
		System.out.println(res.asPrettyString());
	}

}
