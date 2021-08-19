package com.restassured.workshop.RestAssuredJPMC.basics;

import io.restassured.RestAssured;

public class Get_GitHub_Repos {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://api.github.com";
		String resourcepath = "/users/{username}/repos";
		String user = "tom";
		
		RestAssured
			.given()
				.queryParam("sort", "pushed")
				.pathParam("username", user)
			.when()
				.get(resourcepath)
			.then()
				.log().all()
				.assertThat().statusCode(200)
				.assertThat().contentType("application/json");
	}
}
