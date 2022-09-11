package com.taso.polovniautomobili.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taso.polovniautomobili.city.entity.City;
import com.taso.polovniautomobili.files.File;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "user")
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_id")
    private long id;

    @NotNull
    @Size(min = 2, max = 22, message = "Username Must be between 2 and 22 characters")
    @Column(name = "usr_username")

    private String username;
    @Column(name = "usr_name")
    private String name;

    @NotNull
    @Email
    @Column(name = "usr_email")
    private String email;

    @Size(min = 6, max = 15)
    @NotNull
    @Column(name = "usr_phone")
    private String phone;

    @Column(name = "usr_joined")
    private LocalDate joined;

    @ManyToOne
    @JoinColumn(name = "cit_id")
    private City city;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<File> photos;

    @Transient
    private List<String> userPhotos;

}
