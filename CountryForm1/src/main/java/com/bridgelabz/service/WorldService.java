package com.bridgelabz.service;

import java.util.Collection;
import com.bridgelabz.model.Country;

public interface WorldService {

	public Collection<Country> getAllCountries();

	public Country getCountryById(int countryId);

	public Country getCountryByName(String countryName);

	public void saveCountry(Country country);

	public void deleteCountry(Country country);

}
