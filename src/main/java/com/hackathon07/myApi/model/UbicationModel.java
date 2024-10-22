package com.hackathon07.myApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// NOMBRE DE LA TABLA
@Table(name = "ubication") // Especifica el nombre de la tabla en la base de datos
@Entity // Indica que esta clase es una entidad de JPA
public class UbicationModel {

    // NOMBRE DE COLUMNAS
    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id; // Identificador único de la ubicación

    private String name; // Nombre de la ubicación

    private double longitude; // Longitud de la ubicación

    private double latitude; // Latitud de la ubicación

    @Column(columnDefinition = "TEXT") // Especifica que este campo puede contener texto largo
    private String description; // Descripción de la ubicación

    private String image; // URL o ruta de la imagen asociada a la ubicación

    private String link; // Enlace relacionado con la ubicación

    @OneToMany(mappedBy = "ubication") // Relación uno a muchos con NoiseDataModel
    List<NoiseDataModel> noiseData; // Lista de datos de ruido asociados a esta ubicación

    // Método para comparar si dos ubicaciones son iguales basándose en el nombre
    @Override
    public boolean equals(Object o){
        // Verifica si el objeto es una instancia de UbicationModel y compara los nombres ignorando mayúsculas
        if (o instanceof UbicationModel) return this.name.equalsIgnoreCase(((UbicationModel) o).getName());
        return false; // Si no es del mismo tipo, devuelve false
    }

    // Método para calcular el hashcode de la ubicación basado en el nombre
    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode(); // Genera un hashcode usando el nombre en minúsculas
    }

    // GET & SETTERS

    // ID
    public Long getId() {
        return id; // Devuelve el ID de la ubicación
    }

    public void setId(Long id) {
        this.id = id; // Establece el ID de la ubicación
    }

    // NAME
    public String getName() {
        return name; // Devuelve el nombre de la ubicación
    }

    public void setName(String name) {
        this.name = name; // Establece el nombre de la ubicación
    }

    // LONGITUDE
    public double getLongitude() {
        return longitude; // Devuelve la longitud de la ubicación
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude; // Establece la longitud de la ubicación
    }

    // LATITUDE
    public double getLatitude() {
        return latitude; // Devuelve la latitud de la ubicación
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude; // Establece la latitud de la ubicación
    }

    // DESCRIPTION
    public String getDescription() {
        return description; // Devuelve la descripción de la ubicación
    }

    public void setDescription(String description) {
        this.description = description; // Establece la descripción de la ubicación
    }

    // IMAGE
    public String getImage() {
        return image; // Devuelve la URL o ruta de la imagen de la ubicación
    }

    public void setImage(String image) {
        this.image = image; // Establece la URL o ruta de la imagen de la ubicación
    }

    // LINK
    public String getLink() {
        return link; // Devuelve el enlace relacionado con la ubicación
    }

    public void setLink(String link) {
        this.link = link; // Establece el enlace relacionado con la ubicación
    }

    // NOISE DATA
    public List<NoiseDataModel> getNoiseData() {
        return noiseData; // Devuelve la lista de datos de ruido asociados
    }

    public void setNoiseData(List<NoiseDataModel> noiseData) {
        this.noiseData = noiseData; // Establece la lista de datos de ruido asociados
    }
}
