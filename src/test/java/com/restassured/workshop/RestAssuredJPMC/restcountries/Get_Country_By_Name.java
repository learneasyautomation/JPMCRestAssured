package com.restassured.workshop.RestAssuredJPMC.restcountries;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.text.MatchesPattern;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Country_By_Name {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://restcountries.eu";
		
		String resourcepath = "/rest/v2/name/{name}";
		
		Response r = RestAssured
			.given()
				.pathParam("name", "India")
			.when()
				.get(resourcepath)
			.then()
				.log().all()
				.extract().response();
		
		String name = r.body().jsonPath().getString("[0].name");
		System.out.println("First Country name is : "+name);
		
		String currency = r.body().jsonPath().getString("[0].currencies[0].name");
		System.out.println("Currency of "+name+ " is: "+currency);
		
		String body = r.body().asString();
		int index = r.body().asString().indexOf("population");
		String population = body.substring(index+12, index+17);
		System.out.println("Population of first country is: "+population);
		
		RestAssured
				.given()
					.pathParam("name", "India")
				.when()
					.get(resourcepath)
				.then()
					.log().all()
					.assertThat()
					.body("[0].currencies[0].name", Matchers.equalToIgnoringCase("United State Dollar"));
		
	}

}
