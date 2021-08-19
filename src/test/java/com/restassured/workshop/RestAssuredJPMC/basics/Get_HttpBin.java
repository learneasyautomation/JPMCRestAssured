package com.restassured.workshop.RestAssuredJPMC.basics;

import io.restassured.RestAssured;

public class Get_HttpBin {

	public static void main(String[] args) {

		RestAssured.get("https://httpbin.org/get").prettyPrint();
		
	}

}
