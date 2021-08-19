package com.restassured.workshop.RestAssuredJPMC.basics;

import io.restassured.RestAssured;

public class Get_HttpBin_With_Param {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://httpbin.org";

		RestAssured
			.given()
				.param("company","JPMC")
			.get("/get")
			.prettyPrint();
		
	}

}
