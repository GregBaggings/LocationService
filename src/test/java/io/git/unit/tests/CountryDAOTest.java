package io.git.unit.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.git.models.json.Country;
import io.git.models.json.CountryDAO;
import io.git.models.json.CountryRepository;

public class CountryDAOTest {

	@Mock
	CountryRepository mock;
	CountryDAO dao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		dao = new CountryDAO(mock);
	}

	@Test
	public void addCountry() {
		Country dummyItem = new Country();
		dao.saveCountry(dummyItem);
		Mockito.verify(mock).save(dummyItem);
	}

	@Test
	public void listCountries() {
		dao.findAll();
		Mockito.verify(mock).findAll();
	}

	@Test
	public void listCapitalOf() {
		String dummyCapital = "Finnland";
		dao.findCapitalByCountry(dummyCapital);
		Mockito.verify(mock).findAllCapitalByCountry(dummyCapital);
	}

	@Test
	public void deleteCountry() {
		int dummyID = 1;
		dao.deleteCountry(dummyID);
		Mockito.verify(mock).delete(dummyID);
	}

	@Test
	public void updateCountry() {

	}

}
