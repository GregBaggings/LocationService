package io.git.unit.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.git.controllers.UpdateCountryController;
import io.git.models.json.CountryDAO;

public class UpdateCountyControllerTest {

	@InjectMocks
	private UpdateCountryController sut;
	private MockMvc mock;

	@Mock
	CountryDAO dao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.standaloneSetup(sut).build();
	}

	@Test
	public void updateCountryTest() throws Exception {
		// TODO: Ugly thing - finish later.
		// this.mock.perform(get("/v1/updateCountry/16?continent=Europe&country=Turkey&capital=Ankara&locale=Example")).andExpect(status().is2xxSuccessful());
	}

}
