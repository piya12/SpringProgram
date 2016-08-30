package com.bridgelabz.hibernate;

import java.util.Collection;

import com.bridgelabz.model.Country;

public interface CountryDao {

	public Collection<Country> getAll();

	public Country getById(int countryId);

	public Country getByName(String countryName);

	public void save(Country country);

	public void delete(Country country);

}
