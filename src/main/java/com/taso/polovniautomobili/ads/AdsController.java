package com.taso.polovniautomobili.ads;

import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/ads")
@RestController
public class AdsController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AdsService adsService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<AdsDto> singleAd(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(adsService.singleAd(id));
    }

}