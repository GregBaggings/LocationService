package io.git.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.git.models.Country;

@RestController
public class AddLocationController {
	
	@Autowired
	CountriesDAO dao;
	
	@RequestMapping("/addLocation")
	public void saveLocation(@RequestParam(value = "continent") String continent,
			@RequestParam(value = "locale") String locale, @RequestParam(value = "country") String country,
			@RequestParam(value = "capital") String capital) {
		dao.saveLocation(new Country());
	}

}
