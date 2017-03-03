package io.git.tests.rest.feature;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.MDC;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.restassured.response.Response;

public class BasicTestsIT {

	public static Logger LOGGER = LoggerFactory.getLogger(BasicTestsIT.class);

	public static final String ADD_COUNTRY_ENDPOINT = "http://localhost:8090/loc-svc/v1/addCountry";
	public static final String LIST_COUNTRIES_ENDPOINT = "http://localhost:8090/loc-svc/v1/listCountries/";
	public static final String CAPITAL_OF_COUNTRY_ENDPOINT = "http://localhost:8090/loc-svc/v1/capital/{country}";
	public static final int CORRECT_STATUS_CODE = 200;

	@Before
	public void setup() {
		MDC.put("testClassName", BasicTestsIT.class.getSimpleName());
	}

	@Test
	public void addCountryTest() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, String> params = new HashMap<>();
		params.put("country", "Russia");
		params.put("capital", "Moscow");
		params.put("continent", "Asia");
		params.put("locale", "ru_RU");

		LOGGER.info("------ Step1. - Call the service for test: " + methodName + " ------");
		given().when().parameters(params).expect().statusCode(CORRECT_STATUS_CODE).then().get(ADD_COUNTRY_ENDPOINT);
		Response respCheck = given().when().parameters(params).expect().statusCode(200).then().get(LIST_COUNTRIES_ENDPOINT);

		LOGGER.info("The response is: " + respCheck.asString());
		assertThat(respCheck.asString(), containsString("Moscow"));
		LOGGER.info("------ End of " + methodName + " ------ \n");
	}

	@Test
	public void listCountries() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info("------ Step1. - Call the service for test: " + methodName + " ------");
		Response resp = given().when().expect().statusCode(CORRECT_STATUS_CODE).then().get(LIST_COUNTRIES_ENDPOINT);
		LOGGER.info("The response is: " + resp.asString());
		assertNotNull(resp.asString());
		LOGGER.info("------ End of " + methodName + " ------ \n");
	}

	@Test
	public void capitalOfHungaryTest() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, String> params = new HashMap<>();
		params.put("country", "Hungary");

		LOGGER.info("------ Step1. - Call the service for test: " + methodName + " ------");

		Response resp = given().when().pathParameters(params).expect().statusCode(CORRECT_STATUS_CODE).then().get(CAPITAL_OF_COUNTRY_ENDPOINT);
		LOGGER.info("The response is: " + resp.asString());
		assertThat(resp.asString(), containsString("Budapest"));
		LOGGER.info("------ End of " + methodName + " ------ \n");
	}
}
