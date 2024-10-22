package com.hackathon07.myApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "noise-data")
public class NoiseDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;

    private int hour;

    private double dBs;

    private int noiseLevel;

    @ManyToOne
    @JoinColumn(name = "ubication_id", nullable = false)
    private UbicationModel ubication;


}
