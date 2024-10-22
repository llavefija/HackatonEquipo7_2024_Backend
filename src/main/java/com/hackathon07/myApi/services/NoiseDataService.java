package com.hackathon07.myApi.services;

import com.hackathon07.myApi.repositories.NoiseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoiseDataService {

    @Autowired
    private NoiseDataRepository NoiseRepo;


}
