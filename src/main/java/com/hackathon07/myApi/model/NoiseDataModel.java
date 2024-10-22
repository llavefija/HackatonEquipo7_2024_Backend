package com.hackathon07.myApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // Importación para ignorar el campo durante la serialización JSON
import jakarta.persistence.*; // Importación de anotaciones para la persistencia
import lombok.Getter; // Importación de la anotación Getter de Lombok
import lombok.Setter; // Importación de la anotación Setter de Lombok

import java.util.Date; // Importación de la clase Date para manejar fechas

// Clase que representa un modelo de datos de ruido
@Entity // Indica que esta clase es una entidad JPA
@Table(name = "noise_data") // Especifica el nombre de la tabla en la base de datos
public class NoiseDataModel {

    // NOMBRES DE COLUMNAS
    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private long id; // Identificador único para cada registro de ruido

    private Date date; // Fecha en la que se registró el ruido

    private int hour; // Hora en la que se registró el ruido

    private double dBs; // Nivel de ruido en decibelios

    private int noiseLevel; // Nivel de ruido (puede representar categorías de ruido)

    @ManyToOne // Relación muchos a uno con la entidad UbicationModel
    @JsonIgnore // Ignora este campo en la serialización JSON para evitar ciclos
    @JoinColumn(name = "ubication_id", nullable = false) // Especifica la columna de unión en la base de datos
    private UbicationModel ubication; // Referencia a la ubicación asociada con el registro de ruido

    // GETTERS & SETTERS

    // ID
    public long getId() {
        return id; // Devuelve el ID del registro de ruido
    }

    public void setId(long id) {
        this.id = id; // Establece el ID del registro de ruido
    }

    // HOUR
    public int getHour() {
        return hour; // Devuelve la hora del registro de ruido
    }

    public void setHour(int hour) {
        this.hour = hour; // Establece la hora del registro de ruido
    }

    // DATE
    public Date getDate() {
        return date; // Devuelve la fecha del registro de ruido
    }

    public void setDate(Date date) {
        this.date = date; // Establece la fecha del registro de ruido
    }

    // DECIBELIOS
    public double getDBs() {
        return dBs; // Devuelve el nivel de ruido en decibelios
    }

    public void setDBs(double dBs) {
        this.dBs = dBs; // Establece el nivel de ruido en decibelios
    }

    // NOISE LEVEL
    public int getNoiseLevel() {
        return noiseLevel; // Devuelve el nivel de ruido
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel; // Establece el nivel de ruido
    }

    // UBICATION MODEL
    public UbicationModel getUbication() {
        return ubication; // Devuelve la ubicación asociada
    }

    public void setUbication(UbicationModel ubication) {
        this.ubication = ubication; // Establece la ubicación asociada
    }
}
