package openweathermap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherFunctionality extends OpenWeatherBase{

	public static Response getWeatherByID(int cityid) {
		return RestAssured
				.given()
					.spec(commonspec)
					.queryParam("id", cityid)
				.when()
					.get("/data/2.5/weather")
				.then()
					//.log().all()
					.extract().response();		
	}

	public static Response getWeatherByCity(String cityname) {
		return RestAssured
			.given()
				.spec(commonspec)
				.queryParam("q", cityname)
			.when()
				.get("/data/2.5/weather")
			.then()
				//.log().all()
				.extract().response();		
	}
}
