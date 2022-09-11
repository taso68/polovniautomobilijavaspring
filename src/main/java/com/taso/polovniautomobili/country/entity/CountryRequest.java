package com.taso.polovniautomobili.country.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CountryRequest {
    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name cant be blank")
    @Size(min = 2, max = 22, message = "Length of name must be between 2 and 22 characters")
    private String name;
    @NotNull
    @NumberFormat
    private long countrtId;
}
