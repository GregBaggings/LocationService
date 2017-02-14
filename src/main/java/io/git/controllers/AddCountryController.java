package io.git.controllers;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	JSONObject result = new JSONObject();

	@RequestMapping("/v1/addCountry")
	public ResponseEntity<?> saveLocation(@RequestParam(value = "continent") String continent, @RequestParam(value = "locale") String locale,
			@RequestParam(value = "country") String country, @RequestParam(value = "capital") String capital) {
		Country entry = new Country();
		entry.setCapital(capital);
		entry.setContinent(continent);
		entry.setCountry(country);
		entry.setLocale(locale);

		List<Country> dbContent = dao.findAll();
		result.clear();

		LOGGER.debug("Items in the DB are: " + dbContent);
		if (dbContent.toString().contains(entry.getCountry())) {
			result.put("Error Message", entry.getCountry() + " is already in the Database, in the table of Countries.");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		dao.saveCountry(entry);
		result.put("Result", "OK");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
