package io.git.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.git.models.json.CountryDAO;

@RestController
public class DeleteCountryController {

	@Autowired
	CountryDAO dao;
	
	@RequestMapping("/v1/deleteCountry")
	public void deleteCountry(@RequestParam(value = "id") int id) {
		dao.deleteCountry(id);
	}
}
