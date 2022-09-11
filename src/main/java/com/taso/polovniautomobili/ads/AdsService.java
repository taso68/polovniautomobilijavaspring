package com.taso.polovniautomobili.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsService {

    private final AdsRepository adsRepository;
    @Autowired
    public AdsService(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    public List<Ads> allAds() {
        return adsRepository.findAll();
    }
    public void loadAdPhotoUrls(Ads ads){

    }
}
