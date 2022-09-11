package com.taso.polovniautomobili.country.entity;

import com.taso.polovniautomobili.city.entity.City;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Table(name = "country")
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cou_id", nullable = false)
    private long id;
    @Column(name = "cou_name", nullable = false, unique = true)
    @NotNull(message = "City name cannot be null")
    private String name;
    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Country(String name) {
        this.name = name;
    }
}
