package com.taso.polovniautomobili.fuel;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "fuel")
@Accessors(chain = true)
public class Fuel implements Serializable {
    @Id
    @Column(name = "fue_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fue_name", nullable = false)
    private String name;

}
