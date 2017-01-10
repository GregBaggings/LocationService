package io.git.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.git.models.json.Country;
import io.git.models.json.CountryDAO;

@RestController
public class UpdateCountryController {

	@Autowired
	CountryDAO dao;

	@RequestMapping("/v1/updateCountry/{id}")
	public void saveLocation(@PathVariable("id") int id, @RequestParam(value = "continent") String continent,
			@RequestParam(value = "locale") String locale, @RequestParam(value = "country") String country,
			@RequestParam(value = "capital") String capital) {
		Country entry = dao.findByID(id);

		entry.setCapital(capital);
		entry.setContinent(continent);
		entry.setCountry(country);
		entry.setLocale(locale);
		dao.updateCountry(entry);
	}
}
