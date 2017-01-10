package io.git.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.git.models.json.Country;
import io.git.models.json.CountryDAO;

@RestController
public class ListCountryController {

	JSONArray dbContentInJson = new JSONArray();
	List<Country> result = new ArrayList<Country>();

	@Autowired
	@Qualifier("countryDAO")
	CountryDAO dao;

	@RequestMapping("/v1/capital/{country}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public JSONArray capital(@PathVariable("country") String country) {
		clearContent();
		result.addAll(dao.findCapitalByCountry(country));

		dbContentInJson.addAll(result);
		return dbContentInJson;
	}

	@RequestMapping(value = "/v1/listCountries/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public JSONArray listLocations() {
		clearContent();
		result.addAll(dao.findAll());

		dbContentInJson.addAll(result);
		return dbContentInJson;
	}
	
	private void clearContent() {
		result.clear();
		dbContentInJson.clear();
	}
}
