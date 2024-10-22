package com.hackathon07.myApi.controllers;

import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.services.NoiseDataService;
import com.hackathon07.myApi.services.UbicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class Controller {

    @Autowired
    private NoiseDataService noiseDataService;

    @Autowired
    private UbicationService ubicationService;

    @PostMapping("/ubication")
    private ResponseEntity<UbicationModel> addUbication(@RequestBody UbicationModel ubication){
        return ResponseEntity.ok().body(ubicationService.addUbication(ubication));
    }

    @PostMapping("/import")
    private ResponseEntity<String> import(@RequestBody ){

    }


}
