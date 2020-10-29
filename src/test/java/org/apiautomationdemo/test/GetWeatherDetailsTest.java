package org.apiautomationdemo.test;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath

public class GetWeatherDetailsTest {

	@Test
	public void GetWeatherDetails()	{   
		//RestAssured.defaultParser = Parser.JSON;
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = Request.queryParam("q","Delhi")
				.queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
				.get("/weather");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Correct status code returned");

		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals(bodyAsString.contains("Delhi"), true, "Response body contains Delhi");

		JsonPath jsonPathEvaluator = response.jsonPath();
		String city = jsonPathEvaluator.get("City");
		System.out.println("City received from Response " + city);

		// Validate the response
		Assert.assertEquals(city, "Delhi", "Correct city name received in the Response");
	}

}
