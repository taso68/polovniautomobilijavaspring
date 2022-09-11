package com.taso.polovniautomobili.city;

import com.taso.polovniautomobili.city.entity.City;
import com.taso.polovniautomobili.city.entity.CityRequest;
import com.taso.polovniautomobili.country.CountryService;
import com.taso.polovniautomobili.country.entity.Country;
import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryService countryService;

    public CityService(CityRepository cityRepository,@Lazy CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    public City save(CityRequest cityRequest) throws AlreadyExistException, NotFoundException {
        if(cityRepository.findByName(cityRequest.getName()) != null){
            throw new AlreadyExistException("City with name " + cityRequest.getName() + " already exist");
        }

       Country country = countryService.getCountryById(cityRequest.getCountryId());
        City city = new City(cityRequest.getName(), country);
        return cityRepository.save(city);

    }

    public List<City> allCities() {
        return cityRepository.findAllByOrderByNameAsc();
    }

    public City findCityById(long cityId) throws NotFoundException {
        return cityRepository.findById(cityId).orElseThrow(() ->
                new NotFoundException("City with id: " +cityId + " not found"));
    }

    public City updateCity(long cityId, CityRequest cityRequest) throws NotFoundException {
        Optional<City> optionalCity = cityRepository.findById(cityId);
        Country countryById = countryService.getCountryById(cityRequest.getCountryId());
        if(optionalCity.isEmpty())
            throw new NotFoundException("City with id: " +cityId + " not found");

        City city = optionalCity.get();
        city.setName(cityRequest.getName());

        return city;
    }
}
