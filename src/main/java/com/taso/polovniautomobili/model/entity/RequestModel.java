package com.taso.polovniautomobili.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
    @Id
    @Column(name = "mod_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mod_name", nullable = false)
    @Size(min = 1, max = 22, message = "Model name must be between 1 and 22 characters")
    private String name;

    @NotNull(message = "Model must have mark")
    private Long markId;


}
