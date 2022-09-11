package com.taso.polovniautomobili.city;

import com.taso.polovniautomobili.city.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);

    List<City> findAllByOrderByNameAsc();
}
