package com.restassured.workshop.RestAssuredJPMC.basics;

import io.restassured.RestAssured;

public class Get_HttpBin_With_BDD_Format {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://httpbin.org";

		RestAssured
			.given()
				.param("company name","JPMC")
				.header("MyHeader1","Custom Header Value 1")
				.cookie("MyCookie1", "Custom Cookie Value 1")
			.when()
				.get("/get")
			.then()
				.extract()
				.response()
				.prettyPrint();
	}

}
