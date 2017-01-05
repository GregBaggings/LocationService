package io.git.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.git.models.Location;

@RestController
public class LocationListController {

	@Autowired
	@Qualifier("countriesDAO")
	CountriesDAO dao;
	
	@RequestMapping("/capital")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Location capital(@RequestParam(value = "country") String country) {
		String capital = "";
		if (country.equals("Hungary")) {
			capital = "Budapest";
		}
		return new Location(country, capital);
	}

	@RequestMapping("/location")
	public Location location(@RequestParam(value = "continent") String continent,
			@RequestParam(value = "locale") String locale, @RequestParam(value = "country") String country,
			@RequestParam(value = "capital") String capital) {
		return new Location(continent, locale, country, capital);
	}

	@RequestMapping(value="/listLocations/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void listLocations() {
		dao.findAll();
	}

	
}
