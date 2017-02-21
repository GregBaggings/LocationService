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

import io.git.controllers.DeleteCountryController;
import io.git.models.json.CountryDAO;

public class DeleteCountryControllerTest {

	@InjectMocks
	private DeleteCountryController sut;
	private MockMvc mock;

	@Mock
	CountryDAO dao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.standaloneSetup(sut).build();
	}

	@Test
	public void DeleteCountryTest() throws Exception {
		this.mock.perform(get("/v1/deleteCountry?id=1")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void DeleteCountryNegativeTest() throws Exception {
		this.mock.perform(get("/v1/deleteCountry?id=asdasdasd")).andExpect(status().is4xxClientError());
	}
}
