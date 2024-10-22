package com.hackathon07.myApi.model;

// Clase que representa un modelo de datos para ubicaciones (DTO - Data Transfer Object)
public class UbicationDTOModel {

    // PARÁMETROS
    private Double latitude; // Latitud de la ubicación
    private Double longitude; // Longitud de la ubicación
    private String name; // Nombre de la ubicación

    // CONSTRUCTOR
    public UbicationDTOModel(Double latitude, Double longitude, String name) {
        // Inicializa los parámetros de la ubicación
        this.latitude = latitude; // Establece la latitud
        this.longitude = longitude; // Establece la longitud
        this.name = name; // Establece el nombre
    }

    // GETTERS
    public Double getLatitude() {
        return latitude; // Devuelve la latitud de la ubicación
    }

    public Double getLongitude() {
        return longitude; // Devuelve la longitud de la ubicación
    }

    public String getName() {
        return name; // Devuelve el nombre de la ubicación
    }
}
