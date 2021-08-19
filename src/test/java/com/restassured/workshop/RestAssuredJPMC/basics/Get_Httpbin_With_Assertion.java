package com.restassured.workshop.RestAssuredJPMC.basics;

import io.restassured.RestAssured;

public class Get_Httpbin_With_Assertion {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://httpbin.org";
		
		RestAssured
			.given() 				//Arrage
				.queryParam("company", "JPMC")
			
			.when()					//Act
				.get("/get")

			.then() 				//Assert
				.assertThat().statusCode(200) //This is expected!
				.extract().response()
				.prettyPrint();
	}

}
