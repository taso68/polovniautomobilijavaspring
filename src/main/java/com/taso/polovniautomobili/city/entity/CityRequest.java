package com.taso.polovniautomobili.city.entity;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
public class CityRequest{
    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name cant be blank")
    @Size(min = 2, max = 22, message = "Length of name must be between 2 and 22 characters")
    private String name;
    @NotNull(message = "City must have Country!")
    private long countryId;

    public CityRequest(String name, long countryId) {
        this.name = name;
        this.countryId = countryId;
    }
}
