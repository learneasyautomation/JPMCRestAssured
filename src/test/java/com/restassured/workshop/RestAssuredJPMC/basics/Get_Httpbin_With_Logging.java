package com.restassured.workshop.RestAssuredJPMC.basics;

import io.restassured.RestAssured;

public class Get_Httpbin_With_Logging {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://httpbin.org";
		
		RestAssured
			.given() 				//Arrage
				.queryParam("company", "JPMC")
				.header("Accept","json")
			
			.when()					//Act
				.get("/get")

			.then() 				//Assert
				//.log().all()
				.assertThat().statusCode(200)
				.extract().response().prettyPrint();
	}

}
