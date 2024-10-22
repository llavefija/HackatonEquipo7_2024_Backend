package com.hackathon07.myApi.controllers;

import com.hackathon07.myApi.services.NoiseDataService;
import com.hackathon07.myApi.services.UbicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private NoiseDataService noiseDataService;

    @Autowired
    private UbicationService ubicationService;
}
