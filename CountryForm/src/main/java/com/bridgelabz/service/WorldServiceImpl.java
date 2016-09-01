package com.bridgelabz.service;

import java.util.Collection;

import com.bridgelabz.hibernate.CountryDao;
import com.bridgelabz.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldServiceImpl implements WorldService {

	@Autowired
	private CountryDao countryDao;

	public Collection<Country> getAllCountries() {
		return countryDao.getAll();
	}

	public Country getCountryById(int countryId) {
		return countryDao.getById(countryId);
	}

	public Country getCountryByName(String countryName) {
		return countryDao.getByName(countryName);
	}

	public void saveCountry(Country country) {
		countryDao.save(country);
	}

	public void deleteCountry(Country country) {
		countryDao.delete(country);
	}

}
