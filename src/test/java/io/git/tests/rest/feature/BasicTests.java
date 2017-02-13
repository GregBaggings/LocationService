package io.git.tests.rest.feature;

import org.junit.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class BasicTests {

	public static final String ADD_COUNTRY_ENDPOINT= "http://localhost:8090/loc-svc/v1/addCountry";
	public static final String LIST_COUNTRIES_ENDPOINT= "http://localhost:8090/loc-svc/v1/listCountries/";
	public static final String CAPITAL_OF_COUNTRY_ENDPOINT= "http://localhost:8090/loc-svc/v1/capital/{country}";
	public static final int CORRECT_STATUS_CODE= 200;
	
	@Test
	public void addCountryTest(){
		Map <String, String> params = new HashMap<>();
		params.put("country", "Finnland");
		params.put("capital", "Helsinki");
		params.put("continent", "Europe");
		params.put("locale", "fi_FI");
		
		given().when().parameters(params).expect().statusCode(CORRECT_STATUS_CODE).then().get(ADD_COUNTRY_ENDPOINT);
		Response respCheck = given().when().parameters(params).expect().statusCode(200).then().get(LIST_COUNTRIES_ENDPOINT);
		
		System.out.println("The response is: "+ respCheck.asString());
		assertThat(respCheck.asString(), containsString("Finnland"));
	}
	
	@Test
	public void listCountries(){
		Response resp = given().when().expect().statusCode(CORRECT_STATUS_CODE).then().get(LIST_COUNTRIES_ENDPOINT);
		System.out.println("The response is: "+ resp.asString());
		assertNotNull(resp.asString());
	}
	
	@Test
	public void capitalOfHungaryTest(){
		Map <String, String> params = new HashMap<>();
		params.put("country", "Hungary");
		
		Response resp = given().when().pathParameters(params).expect().statusCode(CORRECT_STATUS_CODE).then().get(CAPITAL_OF_COUNTRY_ENDPOINT);
		System.out.println("The response is: "+ resp.asString());
		assertThat(resp.asString(), containsString("Budapest"));
	}
}
