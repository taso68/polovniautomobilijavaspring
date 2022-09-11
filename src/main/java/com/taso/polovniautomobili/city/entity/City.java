package com.taso.polovniautomobili.city.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taso.polovniautomobili.country.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "city")
@Entity(name = "City")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cit_id")
    private long id;
    @Column(name = "cit_name")
    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name cant be blank")
    @Size(min = 2, max = 22, message = "Length of name must be between 2 and 22 characters")
    private String name;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cou_id")
    @NotNull(message = "City must have Country")
    private Country country;


    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
