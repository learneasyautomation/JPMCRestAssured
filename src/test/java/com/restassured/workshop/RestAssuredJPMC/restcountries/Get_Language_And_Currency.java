package com.restassured.workshop.RestAssuredJPMC.restcountries;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Language_And_Currency {
	
	@Test
	public void testLanguageAndCurrency() {
		
		RestAssured.baseURI = "https://restcountries.eu";
		
		String resourcepath = "/rest/v2/name/{name}";
		
		Response r = RestAssured
			.given()
				.pathParam("name", "India")
			.when()
				.get(resourcepath)
			.then()
				//.log().all()
				.extract().response();
		
		//System.out.println(r.prettyPrint());
		
		
		List<Map<String, ?>> countriesObject = r.jsonPath().getList("$");
		
 		for (Map<String, ?> countryObject : countriesObject) {
 			
 			List<Map<String, String>> languageObjects = (List<Map<String, String>>) countryObject.get("languages");
 			
 			for (Map<String, ?> language : languageObjects) {
				if(language.get("name").equals("Hindi")) {
					
					List<Map<String, String>> currencyObjects = (List<Map<String, String>>) countryObject.get("currencies");
					for (Map<String, ?> currency : currencyObjects) {
						System.out.println(currency.get("name"));
					}					
				}
			}
			
		}
		
	}

}
