package com.taso.polovniautomobili.country;

import com.taso.polovniautomobili.country.entity.Country;
import com.taso.polovniautomobili.country.entity.CountryRequest;
import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public List<Country> allCountries(){
        return countryRepository.findAll();
    }
    public Country getCountryById(long countryId) throws NotFoundException {
        Optional<Country> byId = countryRepository.findById(countryId);
        if(byId.isEmpty())
            throw new NotFoundException("Country with id: "+countryId+ " not found");

        return byId.get();
    }
    public Country saveCountry(CountryRequest countryRequest) throws AlreadyExistException {
        System.out.println();
        if (countryRepository.findByNameOrderByName(countryRequest.getName()) != null)
            throw new AlreadyExistException("Country with with name "+countryRequest.getName()+ " already exist");
        Country c = new Country(countryRequest.getName());
        return countryRepository.save(c);
    }

    public void deleteCountryById(long countryId) throws NotFoundException {
        if(countryRepository.findById(countryId) != null){
            countryRepository.deleteById(countryId);
        }else
            throw new NotFoundException("Country with id: "+countryId+ " not found");
    }


    public Country updateCountry(long countryId, CountryRequest countryRequest) throws NotFoundException, AlreadyExistException {
        Country country = countryRepository.findById(countryId).get();
        if (countryRepository.findByNameOrderByName(countryRequest.getName()) != null)
            throw new AlreadyExistException("Country with with name "+countryRequest.getName()+ " already exist");
        if(country != null){
            country.setName(countryRequest.getName());
            countryRepository.save(country);
            return country;
        }else throw new NotFoundException("Country with id: "+countryId+" not found");
    }
}
