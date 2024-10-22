package com.hackathon07.myApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "noise_data")
public class NoiseDataModel {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDBs() {
        return dBs;
    }

    public void setDBs(double dBs) {
        this.dBs = dBs;
    }

    public int getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public UbicationModel getUbication() {
        return ubication;
    }

    public void setUbication(UbicationModel ubication) {
        this.ubication = ubication;
    }

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
