package com.taso.polovniautomobili.ads;

import com.taso.polovniautomobili.body.Body;
import com.taso.polovniautomobili.city.entity.City;
import com.taso.polovniautomobili.country.entity.Country;
import com.taso.polovniautomobili.fuel.Fuel;
import com.taso.polovniautomobili.mark.Mark;
import com.taso.polovniautomobili.mark.MarkService;
import com.taso.polovniautomobili.model.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdsDto {
    private Long id;
    private Long markId;
    private String markName;
    private Long modelId;
    private String modelName;
    private Long bodyId;
    private String bodyName;
    private Long countryId;
    private String countryName;
    private Long cityId;
    private String cityName;
    private Date created;
    private String title;
    private String description;
    private Long price;
    private Long cm3;
    private Integer productionYear;
    private Integer numberofSeats;
    private Date soldDate;
    private Long fuelId;
    private String fuelName;
    private List<String> photos;

}
