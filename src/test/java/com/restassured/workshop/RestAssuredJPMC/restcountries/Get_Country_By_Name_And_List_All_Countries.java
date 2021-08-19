package com.restassured.workshop.RestAssuredJPMC.restcountries;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.text.MatchesPattern;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;

public class Get_Country_By_Name_And_List_All_Countries {

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
		
		 List<String> countries = r.body().jsonPath().getList("$");
		 System.out.println(countries.size());
		 
		 List<String> countrynames = r.body().jsonPath().getList("name");
		 System.out.println(countrynames);
		 
		 List<Map<String,?>> countryObjects = r.body().jsonPath().getList("$");
		 
		 for (Map<String, ?> country : countryObjects) {
			if(country.get("name").equals("India")) {
				String capitalcity = country.get("capital").toString();
				if(capitalcity.equals("New Delhi")) {
					System.out.println("Test Passed");
				} else {
					System.out.println("Test Failed");
					System.out.println("Expected capital city to be New Delhi, but got "+ country.get("capital"));
				}
			}
		 }		
	}

}
