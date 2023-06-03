package unow.np.springws.service;

import unow.np.springws.domain.Country;

import java.util.List;

public interface ICountryService {

    Country getCountry();
    List<String> getAllCountries();
    String getCountryNameByCode();
}
