package unow.np.springws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unow.np.springws.domain.Country;
import unow.np.springws.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

import static unow.np.springws.domain.Country.countryFromEntity;

@Service
public class CountryService implements ICountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public String getCountryCodeByName(String name) {
        return countryFromEntity(countryRepository.getByName(name)).getCodename();
    }

    public List<String> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(Country::countryFromEntity).map(Country::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String getCountryNameByCode(String countryCode) {
        return countryFromEntity(countryRepository.getByCodename(countryCode)).getName();
    }
}
