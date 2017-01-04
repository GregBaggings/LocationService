package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;

import model.Location;

@RestController
public class LocationListController {

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
}
