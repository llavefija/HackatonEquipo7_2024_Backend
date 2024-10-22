package com.hackathon07.myApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// NOMBRE DE LA TABLA
@Entity
@Table(name = "noise-data")
public class NoiseDataModel {

    // NOMBRES DE COLUMNAS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;

    private int hour;

    private double dBs;

    private int noiseLevel;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ubication_id", nullable = false)
    private UbicationModel ubication;

    // GET & SETTERS

    // ID
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // HOUR
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    // DATE
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // DECIBELIOS
    public double getDBs() {
        return dBs;
    }

    public void setDBs(double dBs) {
        this.dBs = dBs;
    }

    // NOISE LEVEL
    public int getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    // UBICATION MODEL
    public UbicationModel getUbication() {
        return ubication;
    }

    public void setUbication(UbicationModel ubication) {
        this.ubication = ubication;
    }




}
