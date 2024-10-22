package com.hackathon07.myApi.controllers;

import com.hackathon07.myApi.model.UbicationDTOModel;
import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.services.NoiseDataService;
import com.hackathon07.myApi.services.UbicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;

@RestController
public class Controller {

    @Autowired
    private NoiseDataService noiseDataService;

    @Autowired
    private UbicationService ubicationService;

    @PostMapping("/ubication")
    private ResponseEntity<UbicationModel> addUbication(@RequestBody UbicationModel ubication) {
        return ResponseEntity.ok().body(ubicationService.addUbication(ubication));
    }

    @GetMapping("/ubications")
    private ArrayList<UbicationDTOModel> listarUbiName(){
        return (ArrayList<UbicationDTOModel>) ubicationService.listarUbiName();
    }

    @GetMapping("/ubicationsAllInfo")
    private ArrayList<UbicationModel> listarAllInfoUbi(){
        return (ArrayList<UbicationModel>) ubicationService.listarAllInfoUbi();
    }

}
