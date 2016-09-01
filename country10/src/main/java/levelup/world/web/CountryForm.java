package levelup.world.web;

import java.text.SimpleDateFormat;

import java.util.Date;

import levelup.world.domain.Country;
import levelup.world.domain.service.WorldService;
import levelup.world.domain.validation.CountryValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/countryForm.html")
@SessionAttributes("country")
public class CountryForm {

  @Autowired
  private CountryValidator countryValidator;

  @Autowired
  private WorldService worldService;

  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {

    dataBinder.setDisallowedFields(new String[] {"id"});
    dataBinder.setRequiredFields(new String[] {"name", "area", "population", "currency"});
    dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    dateFormat.setLenient(false);
    dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
  }

  @RequestMapping(method = RequestMethod.GET)
  public Country setUpForm(@RequestParam(value="id", required = false) Integer countryId) {
    if (countryId == null) {
      return new Country();
    } else {
      return worldService.getCountryById(countryId);
    }
  }

  @RequestMapping(params = "create", method = RequestMethod.POST)
  public String create(Country country, BindingResult result, SessionStatus status) {
    return update(country, result, status);
  }

  @RequestMapping(params = "update", method = RequestMethod.POST)
  public String update(Country country,
                       BindingResult result,
                       SessionStatus status) {
    countryValidator.validate(country, result);
    if (result.hasErrors()) {
      return "countryForm";
    } else {
      worldService.saveCountry(country);
      status.setComplete();
      return "redirect:countryList.html";
    }
  }

  @RequestMapping(params = "delete", method = RequestMethod.POST)
  public String delete(Country country, BindingResult result, SessionStatus status) {
    worldService.deleteCountry(country);
    status.setComplete();
    return "redirect:countryList.html";
  }

}