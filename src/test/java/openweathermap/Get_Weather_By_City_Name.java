package openweathermap;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Get_Weather_By_City_Name extends OpenWeatherBase{
	
	@Test
	public void testWeatherReturnedForDelhi() {
		
		String inputcity = "New Delhi";
		
		Response res = OpenWeatherFunctionality.getWeatherByCity(inputcity);
		int actual = res.getStatusCode();
		
		Double longitude = res.jsonPath().getDouble("coord.lon");
		Double latitude = res.jsonPath().getDouble("coord.lat");
		
		System.out.println("Longitude is: "+longitude);
		System.out.println("Latitude is: "+latitude);
		
		
		Assert.assertEquals(actual, 200);
		
		Assert.assertTrue(res.jsonPath().getString("name").contains(inputcity));
		
		System.out.println(res.asString());
	}
	
	@Test
	public void testWeatherReturnedForMumbai() {
		int actual = OpenWeatherFunctionality.getWeatherByCity("Mumbai").getStatusCode();
		Assert.assertEquals(actual, 200);
	}
	
	@Test
	public void testGetIDAndSearchWeather() {
		//1. Search using city name
		Response res1 = OpenWeatherFunctionality.getWeatherByCity("Mumbai"); 
		
		//2. Extract ID of that city
		int id = res1.jsonPath().getInt("id");
		
		//3. Search using city ID
		Response res2 = OpenWeatherFunctionality.getWeatherByID(id);
		
		//4. Verify that weather in Step#1 and Step #3 is same
		String step1weather = res1.jsonPath().getString("weather[0].main");
		String step3weather = res2.jsonPath().getString("weather[0].main");
		
		Assert.assertEquals(step1weather,step3weather);
	}
	
}

