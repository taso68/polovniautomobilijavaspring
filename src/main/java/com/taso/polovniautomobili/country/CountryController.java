package com.taso.polovniautomobili.country;

import com.taso.polovniautomobili.country.entity.Country;
import com.taso.polovniautomobili.country.entity.CountryRequest;
import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;


    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries(){
        return ResponseEntity.ok(countryService.allCountries());
    }
    @GetMapping("/{countryId}")
    public ResponseEntity<Country> getCountryById(@PathVariable long countryId) throws NotFoundException {
        return ResponseEntity.ok(countryService.getCountryById(countryId));
    }
    @PostMapping
    public ResponseEntity<Country> saveCountry(@RequestBody @Valid  CountryRequest countryRequest) throws AlreadyExistException {
        return new ResponseEntity<>(countryService.saveCountry(countryRequest), HttpStatus.CREATED);
    }
    @PutMapping("/{countryId}")
    public ResponseEntity<Country> updateCountryById(@PathVariable long countryId,
                                                     @RequestBody @Valid CountryRequest countryRequest) throws NotFoundException, AlreadyExistException {
       return new ResponseEntity<Country>(countryService.updateCountry(countryId, countryRequest), HttpStatus.OK);

    }
    @DeleteMapping("/{countryId}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable long countryId) throws NotFoundException {
        countryService.deleteCountryById(countryId);
        return ResponseEntity.ok().build();
    }
}
