package openweathermap;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class OpenWeatherBase {
	
	static RequestSpecification commonspec;
	
	@BeforeTest
	public void setUp() {
		
		commonspec = new RequestSpecBuilder()
				.setBaseUri("https://api.openweathermap.org")
				.addQueryParam("appid", "63e698077095642363b2ff3af81ba3ae")
				.addHeader("ContentType", "application/json")
				.build();
	}

}
