package unow.np.springws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unow.np.springws.domain.entity.CountryEntity;

import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {
    CountryEntity getByName(String name);

    CountryEntity findByName(String name);

    CountryEntity getByCodename(String codename);
}
