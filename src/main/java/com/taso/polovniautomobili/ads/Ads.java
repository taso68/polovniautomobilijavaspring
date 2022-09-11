package com.taso.polovniautomobili.ads;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taso.polovniautomobili.body.Body;
import com.taso.polovniautomobili.city.entity.City;
import com.taso.polovniautomobili.model.entity.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ads")
@Accessors(chain = true)
public class Ads implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ads_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mod_id", nullable = false)
    private Model model;

    @Column(name = "usr_id", nullable = false)
    private Long usrId;

    @ManyToOne
    @JoinColumn(name = "bod_id", nullable = false)
    private Body body;

    @ManyToOne
    @JoinColumn(name = "cit_id", nullable = false)
    private City city;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "ads_created")
    private Date created;

    @Column(name = "ads_title")
    private String title;

    @Column(name = "ads_price")
    private Long price;

    @Column(name = "ads_cm3")
    private Long cm3;


    @Column(name = "ads_productionyear")
    private Integer productionyear;

    @Column(name = "ads_numberofseats", nullable = false)
    private Integer numberofseats;

    @Column(name = "ads_power")
    private Integer power;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "ads_sold")
    private Date soldDate;

    @Column(name = "ads_description")
    private String description;

    @Transient
    private List<Ads> photoUrls;

}
