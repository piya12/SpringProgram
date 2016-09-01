package levelup.world.domain.service;

import java.util.Collection;
import levelup.world.domain.Country;

public interface WorldService {

  public Collection<Country> getAllCountries();

  public Country getCountryById(int countryId);

  public Country getCountryByName(String countryName);

  public void saveCountry(Country country);

  public void deleteCountry(Country country);

}