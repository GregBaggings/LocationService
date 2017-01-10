package io.git.models.json;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

	List<Country> findAll();

	List<Country> findAllByContinent(String continent);

	List<Country> findAllCapitalByCountry(String country);
	
}
