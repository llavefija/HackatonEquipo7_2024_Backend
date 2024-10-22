package com.hackathon07.myApi.services;

import com.hackathon07.myApi.model.UbicationDTOModel;
import com.hackathon07.myApi.model.UbicationModel;
import com.hackathon07.myApi.repositories.UbicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UbicationService {

    @Autowired
    private UbicationRepository ubicationRepo;


    public UbicationModel addUbication(UbicationModel ubication) {
        return ubicationRepo.save(ubication);
    }


    public List<UbicationDTOModel> listarUbiName() {
        // Obtener todas las ubicaciones desde el repositorio
        List<UbicationModel> ubicaciones = (List<UbicationModel>) ubicationRepo.findAll();

        // Crear una lista para almacenar solo los campos deseados
        List<UbicationDTOModel> filteredUbications = new ArrayList<>();

        // Recorrer las ubicaciones y agregar solo los campos deseados
        for (UbicationModel ubicacion : ubicaciones) {
            UbicationDTOModel dto = new UbicationDTOModel(
                    ubicacion.getLatitude(),  // Aquí se asume que tienes un método getLatitude()
                    ubicacion.getLongitude(), // Aquí se asume que tienes un método getLongitude()
                    ubicacion.getName()       // Aquí se asume que tienes un método getName()
            );
            filteredUbications.add(dto);
        }

        return filteredUbications; // Retornar la lista de DTOs
    }

    public ArrayList<UbicationModel> listarAllInfoUbi() {
        return (ArrayList<UbicationModel>) ubicationRepo.findAll();
    }
}
