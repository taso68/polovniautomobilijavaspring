package com.taso.polovniautomobili.mark;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.taso.polovniautomobili.model.entity.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "mark")
@Accessors(chain = true)
public class Mark implements Serializable {


    @Id
    @Column(name = "mar_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mar_name")
    @Size(min = 1, max = 22, message = "Mark name must be between 1 and 22 characters!")
    private String name;


    @JsonManagedReference
    @OneToMany(mappedBy = "mark")
    private List<Model> models;



}
