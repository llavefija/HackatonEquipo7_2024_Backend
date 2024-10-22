package com.hackathon07.myApi.services;

import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.repositories.UbicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicationService {

    @Autowired
    private UbicationRepository ubicationRepo;


    public UbicationModel addUbication(UbicationModel ubication) {
        return ubicationRepo.save(ubication);
    }
}
