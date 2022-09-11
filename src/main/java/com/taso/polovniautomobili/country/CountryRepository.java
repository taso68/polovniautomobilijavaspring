package com.taso.polovniautomobili.country;

import com.taso.polovniautomobili.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByNameOrderByName(String name);
}
