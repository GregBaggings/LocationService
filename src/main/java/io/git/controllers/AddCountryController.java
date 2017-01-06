package io.git.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.git.models.Country;
import io.git.models.CountryDAO;

@RestController
public class AddCountryController {

	@Autowired
	CountryDAO dao;

	@RequestMapping("/v1/addCountry")
	public void saveLocation(@RequestParam(value = "continent") String continent,
			@RequestParam(value = "locale") String locale, @RequestParam(value = "country") String country,
			@RequestParam(value = "capital") String capital) {
		Country entry = new Country();
		entry.setCapital(capital);
		entry.setContinent(continent);
		entry.setCountry(country);
		entry.setLocale(locale);

		/*
		 * TODO: Check if Country exists, if not => insert 
		 * 								  else	 => return validation error
		 */
		
		dao.saveCountry(entry);
	}
}
