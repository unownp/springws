package unow.np.springws.domain;

import unow.np.springws.domain.entity.CountryEntity;

import java.util.UUID;

public class Country {
    private String name;
    private String codename;
    private UUID id;

    public static Country countryFromCountryEntity(CountryEntity countryEntity) {
        Country country = new Country();
        country.setId(countryEntity.getId());
        country.setName(countryEntity.getName());
        country.setCodename(countryEntity.getCodename());
        return country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
