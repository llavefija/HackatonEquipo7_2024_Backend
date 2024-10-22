package com.hackathon07.myApi.controllers;

import com.hackathon07.myApi.model.NoiseDataModel;
import com.hackathon07.myApi.model.UbicationDTOModel;
import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.services.NoiseDataService;
import com.hackathon07.myApi.services.UbicationNoiseService;
import com.hackathon07.myApi.services.UbicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private NoiseDataService noiseDataService;

    @Autowired
    private UbicationService ubicationService;

    @Autowired
    private UbicationNoiseService ubicationNoiseService;

    @PostMapping("/ubication")
    private ResponseEntity<UbicationModel> addUbication(@RequestBody UbicationModel ubication) {
        return ResponseEntity.ok().body(ubicationService.addUbication(ubication));
    }

    @PostMapping("/noise")
    private ResponseEntity<NoiseDataModel> addNoises(@RequestBody NoiseDataModel noise) {
        return ResponseEntity.ok().body(noiseDataService.addNoise(noise));
    }

    @GetMapping("/ubications")
    private ArrayList<UbicationDTOModel> listarUbiName(){
        return (ArrayList<UbicationDTOModel>) ubicationService.listarUbiName();
    }

    @GetMapping("/noises")
    private ArrayList<NoiseDataModel> listarNoises(){
        return (ArrayList<NoiseDataModel>) noiseDataService.listarNoises();
    }

    @GetMapping("/ubicationsAllInfo")
    private ArrayList<UbicationModel> listarAllInfoUbi(){
        return (ArrayList<UbicationModel>) ubicationService.listarAllInfoUbi();
    }

    @GetMapping("/ubicationsAllInfo/dbcolors")
    public ResponseEntity<List<Map<String, Object>>> getCombinedData() {
        List<Map<String, Object>> data = ubicationNoiseService.listarUbiYColors();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
