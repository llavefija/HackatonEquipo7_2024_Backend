package com.hackathon07.myApi.services;

import com.hackathon07.myApi.model.NoiseDataModel;
import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.repositories.NoiseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NoiseDataService {

    @Autowired
    private NoiseDataRepository noiseRepo;

    public NoiseDataModel addNoise(NoiseDataModel noise) {
        return noiseRepo.save(noise);
    }

    public ArrayList<NoiseDataModel> listarNoises() {
        return (ArrayList<NoiseDataModel>) noiseRepo.findAll();
    }


}
