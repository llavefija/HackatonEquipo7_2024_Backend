package com.hackathon07.myApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "ubication")
@Entity
public class UbicationModel {

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

}
