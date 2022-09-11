package com.taso.polovniautomobili.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ads")
@RestController
public class AdsController {

    private final AdsService adsService;
    @Autowired
    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }


    @GetMapping
    public ResponseEntity<List<Ads>> allAds(){
        return ResponseEntity.ok(adsService.allAds());
    }
}
