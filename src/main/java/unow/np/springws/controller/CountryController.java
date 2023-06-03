package unow.np.springws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unow.np.springws.domain.Country;
import unow.np.springws.service.ICountryService;

import java.util.List;

@RestController
@RequestMapping("/api/internal")
public class CountryController {
    private final ICountryService iCountryService;
//    private final CountryService iCountryService;

    @Autowired
    public CountryController(ICountryService iCountryService) {
        this.iCountryService = iCountryService;
    }

    @GetMapping("/country")
    public Country getCountry() {
        return iCountryService.getCountry();
    }

    @GetMapping("/allCountries")
    public List<String> getAllCurrencies() {
        return iCountryService.getAllCountries();
    }

    @GetMapping("/countryByCode")
    public String getCountryByCode() {
        return iCountryService.getCountryNameByCode();
    }

}
