package io.git.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.git.models.gpb.CountryGBPRepository;
import io.git.models.gpb.CountryProtos;

@RestController
public class ListCountriesGPBController {

	@Autowired
	CountryGBPRepository repo;

	@RequestMapping(value = "/v1/gpb/listCountries/")
	CountryProtos.Country listAllCountries() {
		return this.repo.findAll();
	}
}
