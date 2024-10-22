package com.hackathon07.myApi.services; // Define el paquete donde se encuentra el servicio

import com.hackathon07.myApi.model.NoiseDataModel; // Importa el modelo de datos de ruido
import com.hackathon07.myApi.model.UbicationModel; // Importa el modelo de datos de ubicación
import com.hackathon07.myApi.repositories.NoiseDataRepository; // Importa el repositorio de datos de ruido
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para la inyección de dependencias
import org.springframework.stereotype.Service; // Importa la anotación para marcar la clase como un servicio

import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas

// Indica que esta clase es un servicio en la capa de negocio de la aplicación
@Service
public class NoiseDataService {

    // Inyección del repositorio de datos de ruido mediante la anotación @Autowired
    @Autowired
    private NoiseDataRepository noiseRepo;

    // Método para listar todos los datos de ruido en forma de ArrayList
    public ArrayList<NoiseDataModel> listarNoises() {
        // Llama al método findAll del repositorio y convierte el resultado a ArrayList
        return (ArrayList<NoiseDataModel>) noiseRepo.findAll();
    }
}
