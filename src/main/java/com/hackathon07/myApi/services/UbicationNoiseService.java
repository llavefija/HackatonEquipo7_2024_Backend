package com.hackathon07.myApi.services;

import com.hackathon07.myApi.model.NoiseDataModel;
import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.repositories.NoiseDataRepository;
import com.hackathon07.myApi.repositories.UbicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UbicationNoiseService {

    @Autowired
    private NoiseDataRepository noiseRepo;

    @Autowired
    private UbicationRepository ubicationRepo;

    public List<Map<String, Object>> listarUbiYColors() {
        List<NoiseDataModel> noises = noiseRepo.findAll();
        List<UbicationModel> ubications = ubicationRepo.findAll();
        List<Map<String, Object>> combinedData = new ArrayList<>();

        // Usar el tamaño más pequeño para evitar errores de índices
        int minSize = Math.min(noises.size(), ubications.size());

        for (int i = 0; i < minSize; i++) {
            NoiseDataModel noise = noises.get(i);
            UbicationModel ubication = ubications.get(i);

            Map<String, Object> feature = new HashMap<>();
            Map<String, Object> properties = new HashMap<>();
            Map<String, Object> geometry = new HashMap<>();

            // Rellenar properties con los campos de ambas tablas
            properties.put("id", ubication.getId());
            properties.put("name", ubication.getName());
            properties.put("db", noise.getDBs());
            properties.put("dbColor", noise.getNoiseLevel());

            // Rellenar geometry con latitud y longitud
            geometry.put("type", "Point");
            geometry.put("coordinates", Arrays.asList(ubication.getLongitude(), ubication.getLatitude()));

            // Añadir todo al feature
            feature.put("type", "Feature");
            feature.put("properties", properties);
            feature.put("geometry", geometry);

            combinedData.add(feature);
        }

        return combinedData;
    }
}
