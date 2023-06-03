package unow.np.springws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unow.np.springws.domain.Country;
import unow.np.springws.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

import static unow.np.springws.domain.Country.countryFromCountryEntity;

@Service
public class CountryService implements ICountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country getCountry() {
        return countryFromCountryEntity(countryRepository.getByName("Tanzania"));
    }

    public List<String> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(Country::countryFromCountryEntity).map(Country::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String getCountryNameByCode(String countryCode) {
        return countryFromCountryEntity(countryRepository.getByCodename(countryCode)).getName();
    }
}
