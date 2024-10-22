package com.hackathon07.myApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// NOMBRE DE LA TABLA
@Table(name = "ubication")
@Entity
public class UbicationModel {

    // NOMBRE DE COLUMNAS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double longitude;

    private double latitude;

    private String description;

    private String image;

    private String link;

    @OneToMany(mappedBy = "ubication")
    List<NoiseDataModel> noiseData;

    @Override
    public boolean equals(Object o){
        if (o instanceof UbicationModel) return this.name.equalsIgnoreCase(((UbicationModel) o).getName());
        return false;
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    // GET & SETTERS

    // ID
    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    // NAME
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // LONGITUDE
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // LATITUDE
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // DESCRIPTION
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // IMAGE
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // LINK
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    // NOISE DATA
    public List<NoiseDataModel> getNoiseData() {
        return noiseData;
    }

    public void setNoiseData(List<NoiseDataModel> noiseData) {
        this.noiseData = noiseData;
    }

}
