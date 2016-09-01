package levelup.world.web;

import java.util.Collection;

import levelup.world.domain.Country;
import levelup.world.domain.service.WorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CountryController {

  @Autowired
  private WorldService worldService;

  @RequestMapping("/countryList.html")
  @ModelAttribute("countries")
  public Collection<Country> getCountries() {
    return worldService.getAllCountries();
  }

  @RequestMapping("/countryDetails.html")
  public Country getCountry(@RequestParam(value="id", required=true) int countryId) {
    return worldService.getCountryById(countryId);
  }

}