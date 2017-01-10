package io.git.models.json;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryDAO {

	@Autowired
	private CountryRepository countriesRepo;

	public List<Country> findAll() {
		return countriesRepo.findAll();
	}

	public List<Country> findCapitalByCountry(String country) {
		return countriesRepo.findAllCapitalByCountry(country);
	}

	public List<Country> findByContinent(String continent) {
		return countriesRepo.findAllByContinent(continent);
	}

	public void saveCountry(Country entry) {
		countriesRepo.save(entry);
	}

	public void updateCountry(Country entry) {
		countriesRepo.save(entry);
	}

	public void deleteCountry(int id) {
		countriesRepo.delete(id);
	}

	public Country findByID(int id) {
		return countriesRepo.findOne(id);
	}
}
