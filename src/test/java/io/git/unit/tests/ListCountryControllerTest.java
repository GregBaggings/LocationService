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

import io.git.controllers.ListCountryController;
import io.git.models.json.CountryDAO;

public class ListCountryControllerTest {

	@InjectMocks
	private ListCountryController sut;
	private MockMvc mock;

	@Mock
	CountryDAO dao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.standaloneSetup(sut).build();
	}

	@Test
	public void ListCountriesTest() throws Exception {
		this.mock.perform(get("/v1/listCountries/")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void CapitalOfCountryTest() throws Exception {
		this.mock.perform(get("/v1/capital/Russia")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void CapitalOfCountryNegativeTest() throws Exception {
		this.mock.perform(get("/v1/capital/")).andExpect(status().is4xxClientError());
	}
}
