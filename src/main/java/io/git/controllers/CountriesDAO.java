package io.git.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import io.git.models.Country;

@RestController
public class CountriesDAO {

	@Autowired
	private CountriesRepository countriesRepo;

	public List<Country> findAll() {
		return countriesRepo.findAll();
	}

	public List<Country> findByContinent(String continent) {
		return countriesRepo.findAllByContinent(continent);
	}

	public void saveLocation(Country entry) {	
		countriesRepo.save(entry);
	}

}
