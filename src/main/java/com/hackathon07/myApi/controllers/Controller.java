package com.hackathon07.myApi.controllers;

// Importación de los modelos y servicios necesarios
import com.hackathon07.myApi.model.NoiseDataModel;
import com.hackathon07.myApi.model.UbicationDTOModel;
import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.services.NoiseDataService;
import com.hackathon07.myApi.services.UbicationNoiseService;
import com.hackathon07.myApi.services.UbicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

// Indica que esta clase es un controlador REST
@RestController
public class Controller {

    // Inyección de dependencias para los servicios
    @Autowired
    private NoiseDataService noiseDataService; // Servicio para manejar datos de ruido

    @Autowired
    private UbicationService ubicationService; // Servicio para manejar ubicaciones

    @Autowired
    private UbicationNoiseService ubicationNoiseService; // Servicio para manejar la combinación de ubicaciones y datos de ruido

    // Método para listar nombres de ubicaciones
    @GetMapping("/ubications")
    private ArrayList<UbicationDTOModel> listarUbiName() {
        // Llama al servicio para obtener la lista de nombres de ubicaciones y la devuelve
        return (ArrayList<UbicationDTOModel>) ubicationService.listarUbiName();
    }

    // Método para listar datos de ruido
    @GetMapping("/noises")
    private ArrayList<NoiseDataModel> listarNoises() {
        // Llama al servicio para obtener la lista de datos de ruido y la devuelve
        return (ArrayList<NoiseDataModel>) noiseDataService.listarNoises();
    }

    // Método para obtener datos combinados por fecha y hora
    @GetMapping("/ubicationsAllInfo/dbcolors/{fecha}/{hora}")
    public ResponseEntity<List<Map<String, Object>>> getCombinedData(
            @PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, // Extrae la fecha de la URL
            @PathVariable("hora") int hora) { // Extrae la hora de la URL

        // Llama al servicio para obtener datos de ubicaciones y colores basados en la fecha y hora
        List<Map<String, Object>> data = ubicationNoiseService.listarUbiYColors(fecha, hora);
        // Devuelve los datos obtenidos con un estado HTTP 200 (OK)
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    // Método para obtener datos combinados por fecha y ID de ubicación
    @GetMapping("/ubicationsAllInfo/dbcolorsByUbication/{fecha}/{idUbicacion}")
    public ResponseEntity<List<Map<String, Object>>> getCombinedDataByUbication(
            @PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, // Extrae la fecha de la URL
            @PathVariable("idUbicacion") Long idUbicacion) { // Extrae el ID de ubicación de la URL

        // Llama al servicio para obtener datos de ubicaciones y colores basados en la fecha y el ID de ubicación
        List<Map<String, Object>> data = ubicationNoiseService.listarUbiYColorsByUbication(fecha, idUbicacion);
        // Devuelve los datos obtenidos con un estado HTTP 200 (OK)
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
