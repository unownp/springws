package unow.np.springws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unow.np.springws.domain.Country;
import unow.np.springws.service.ICountryService;

import java.util.List;

@RestController
@RequestMapping("/api/internal")
public class CountryController {
    private final ICountryService iCountryService;

    @Autowired
    public CountryController(ICountryService iCountryService) {
        this.iCountryService = iCountryService;
    }

    @GetMapping("/country/name/{name}")
    public ResponseEntity<String> getCountryByName(@PathVariable("name") String countryName) {
        String countryCode = iCountryService.getCountryCodeByName(countryName);
        if (countryCode != null) {
            return ResponseEntity.ok(countryCode);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allCountries")
    public List<String> getAllCurrencies() {
        return iCountryService.getAllCountries();
    }

    @GetMapping("/country/code/{code}")
    public ResponseEntity<String> getCountryByCode(@PathVariable("code") String countryCode) {
        String countryName = iCountryService.getCountryNameByCode(countryCode);
        if (countryName != null) {
            return ResponseEntity.ok(countryName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
