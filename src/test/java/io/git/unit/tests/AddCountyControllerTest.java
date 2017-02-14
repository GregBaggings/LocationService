package io.git.unit.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.git.controllers.AddCountryController;
import io.git.models.json.CountryDAO;

public class AddCountyControllerTest {
	@InjectMocks
	private AddCountryController sut;
	private MockMvc mock;
	
	@Mock
	CountryDAO dao;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.standaloneSetup(sut).build();
	}
	
	@Test
	public void AddCountryTest() throws Exception{
		this.mock.perform(get("/v1/addCountry?continent=Europe&locale=ne_NE&country=Netherlands&capital=Amsterdam")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void AddCountryNegativeTest() throws Exception{
		this.mock.perform(get("/v1/addCountry")).andExpect(status().is4xxClientError());
	}
}
