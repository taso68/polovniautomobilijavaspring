package com.taso.polovniautomobili.ads;

import com.taso.polovniautomobili.country.CountryService;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import com.taso.polovniautomobili.files.FileService;
import com.taso.polovniautomobili.mark.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsService {
    @Autowired
    private final AdsRepository adsRepository;
    @Autowired
    private FileService fileService;
    @Autowired
    public AdsService(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    public List<Ads> allAds() {
        return adsRepository.findAll();
    }
    public void loadAdPhotoUrls(Ads ads){

    }

    public Ads newAd(Ads ads) {
        return adsRepository.save(ads);
    }

    private AdsDto convertEntityToDto(Ads ads) {
        AdsDto adsDto = new AdsDto();
        adsDto.setId(ads.getId());
        adsDto.setMarkId(ads.getCity().getCountry().getId());
        adsDto.setMarkName(ads.getModel().getMark().getName());
        adsDto.setModelId(ads.getModel().getId());
        adsDto.setModelName(ads.getModel().getName());
        adsDto.setBodyId(ads.getBody().getId());
        adsDto.setBodyName(ads.getBody().getName());
        adsDto.setCountryId(ads.getCity().getCountry().getId());
        adsDto.setCountryName(ads.getCity().getCountry().getName());
        adsDto.setCityId(ads.getCity().getId());
        adsDto.setCityName(ads.getCity().getName());
        adsDto.setCreated(ads.getCreated());
        adsDto.setTitle(ads.getTitle());
        adsDto.setDescription(ads.getDescription());
        adsDto.setPrice(ads.getPrice());
        adsDto.setCm3(ads.getCm3());
        adsDto.setProductionYear(ads.getProductionyear());
        adsDto.setNumberofSeats(ads.getNumberofseats());
        adsDto.setSoldDate(ads.getSoldDate());
        adsDto.setFuelId(ads.getFuel().getId());
        adsDto.setFuelName(ads.getFuel().getName());
        adsDto.setPhotos(fileService.urlsForAds(ads.getId()));
        return adsDto;
    }

    public AdsDto singleAd(Long id) throws NotFoundException {
        return convertEntityToDto(adsRepository.findById(id).get());
    }
}
