package com.taso.polovniautomobili.city;

import com.taso.polovniautomobili.city.entity.City;
import com.taso.polovniautomobili.city.entity.CityRequest;
import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping
    public ResponseEntity<List<City>> allCities(){
        return ResponseEntity.ok(cityService.allCities());
    }
    @GetMapping("/{cityId}")
    public ResponseEntity<City> findCityById(@PathVariable long cityId) throws NotFoundException {
        return ResponseEntity.ok(cityService.findCityById(cityId));
    }
    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody @Valid CityRequest cityRequest) throws AlreadyExistException, NotFoundException {
        return new ResponseEntity<>(cityService.save(cityRequest), HttpStatus.CREATED);
    }
    @PutMapping("/{cityId}")
    public ResponseEntity<City> updateCity(@PathVariable long id, @RequestBody @Valid CityRequest cityRequest) throws NotFoundException {
        return ResponseEntity.ok(cityService.updateCity(id, cityRequest));
    }
}
