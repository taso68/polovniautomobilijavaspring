package com.taso.polovniautomobili.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taso.polovniautomobili.mark.Mark;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "model")
@Accessors(chain = true)
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mod_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mod_name", nullable = false)
    @Size(min = 1, max = 22, message = "Model name must be between 1 and 22 characters")
    private String name;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "mar_id", nullable = false)
    private Mark mark;

    public Model(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }
}
