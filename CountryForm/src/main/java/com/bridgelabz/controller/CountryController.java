package com.bridgelabz.controller;




import com.bridgelabz.service.WorldService;

import com.bridgelabz.model.Country;
import com.bridgelabz.service.MockWorldService;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

	private WorldService worldService = new MockWorldService();

	@RequestMapping("/countryList.html")
	@ModelAttribute("countries")
	public Collection<Country> getCountries() {
		return worldService.getAllCountries();
	}

	@RequestMapping("/countryDetails.html")
	public Country getCountry(@RequestParam(value = "id", required = true) int countryId) {
		return worldService.getCountryById(countryId);
	}
}

