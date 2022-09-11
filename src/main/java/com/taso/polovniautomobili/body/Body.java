package com.taso.polovniautomobili.body;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@Table(name = "body")
@Entity
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bod_id", nullable = false)
    private long id;
    @Column(name = "bod_name")
    @Size(min = 2, max = 15, message = "Name size must be between 2 and 15 characters")
    private String name;

    public Body(String name) {
        this.name = name;
    }
}
