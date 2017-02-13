package io.git.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.git.models.json.Country;
import io.git.models.json.CountryDAO;

@RestController
public class AddCountryController {

	private final static Logger LOGGER = LoggerFactory.getLogger(AddCountryController.class);

	@Autowired
	CountryDAO dao;

	@RequestMapping("/v1/addCountry")
	public void saveLocation(@RequestParam(value = "continent") String continent, @RequestParam(value = "locale") String locale,
			@RequestParam(value = "country") String country, @RequestParam(value = "capital") String capital) {
		Country entry = new Country();
		entry.setCapital(capital);
		entry.setContinent(continent);
		entry.setCountry(country);
		entry.setLocale(locale);

		List<Country> dbContent = dao.findAll();
		LOGGER.debug("Items in the DB are: "+dbContent);
		if (dbContent.toString().contains(entry.getCountry())) {
			
			throw new Error(entry.getCountry() + " is already in the Database, in the table of Countries.");
		}
		dao.saveCountry(entry);
	}
}
