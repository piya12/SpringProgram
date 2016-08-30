package com.bridgelabz.validation;

import com.bridgelabz.model.Country;
import com.bridgelabz.service.MockWorldService;
import com.bridgelabz.service.WorldService;

import org.springframework.validation.Errors;

public class CountryValidator {

	private WorldService worldService = new MockWorldService();

	public void validate(Country country, Errors errors) {

		if (country.getArea() != null && country.getArea() <= 0) {
			errors.rejectValue("area", "validation.negative", "must be > 0");
		}

		if (country.getPopulation() != null && country.getPopulation() <= 0) {
			errors.rejectValue("population", "validation.negative", "must be > 0");
		}

		if (!errors.hasFieldErrors("name")) {
			Country existingCountry = worldService.getCountryByName(country.getName());
			if (existingCountry != null && (country.isNew() || !country.getId().equals(existingCountry.getId()))) {
				errors.rejectValue("name", "validation.exists", "exists");
			}
		}
	}

}
