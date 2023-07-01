package unow.np.springws.service;

import unow.np.springws.domain.Country;

import java.util.List;

public interface ICountryService {


    List<String> getAllCountries();

    String getCountryNameByCode(String countryCode);

    String getCountryCodeByName(String countryName);
}
