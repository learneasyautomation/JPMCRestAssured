package com.restassured.workshop.RestAssuredJPMC.basics;

import io.restassured.RestAssured;

public class Get_HttpBin_Organized {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://httpbin.org";

		RestAssured
			.get("/get")
			.prettyPrint();
		
	}

}
