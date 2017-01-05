package io.git.controllers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.git.models.Country;

public interface CountriesRepository extends CrudRepository<Country, Integer> {

	List<Country> findAll();

	List<Country> findAllByContinent(String continent);
	
	
}
