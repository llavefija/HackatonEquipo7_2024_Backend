package com.hackathon07.myApi.services; // Define el paquete donde se encuentra el servicio

import com.hackathon07.myApi.model.UbicationDTOModel; // Importa el modelo de DTO para ubicaciones
import com.hackathon07.myApi.model.UbicationModel; // Importa el modelo de datos de ubicación
import com.hackathon07.myApi.repositories.UbicationRepository; // Importa el repositorio de datos de ubicación
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para la inyección de dependencias
import org.springframework.stereotype.Service; // Importa la anotación para marcar la clase como un servicio

import java.util.ArrayList; // Importa la clase ArrayList
import java.util.List; // Importa la interfaz List

// Indica que esta clase es un servicio en la capa de negocio de la aplicación
@Service
public class UbicationService {

    // Inyección del repositorio de datos de ubicación mediante la anotación @Autowired
    @Autowired
    private UbicationRepository ubicationRepo;

    // Método que lista todas las ubicaciones (solo el nombre y las coordenadas)
    public List<UbicationDTOModel> listarUbiName() {
        // Obtener todas las ubicaciones desde el repositorio
        List<UbicationModel> ubicaciones = (List<UbicationModel>) ubicationRepo.findAll();

        // Crear una lista para almacenar solo los campos deseados
        List<UbicationDTOModel> filteredUbications = new ArrayList<>();

        // Recorrer las ubicaciones y agregar solo los campos deseados a la lista de DTOs
        for (UbicationModel ubicacion : ubicaciones) {
            // Crear un nuevo objeto DTO con la información de la ubicación
            UbicationDTOModel dto = new UbicationDTOModel(
                    ubicacion.getLatitude(), // Obtener la latitud
                    ubicacion.getLongitude(), // Obtener la longitud
                    ubicacion.getName() // Obtener el nombre
            );
            // Añadir el DTO a la lista filtrada
            filteredUbications.add(dto);
        }

        // Retornar la lista de DTOs que contienen solo el nombre y las coordenadas
        return filteredUbications;
    }

    // Método que lista todas las ubicaciones con toda la información
    public ArrayList<UbicationModel> listarAllInfoUbi() {
        // Retorna todas las ubicaciones desde el repositorio en forma de ArrayList
        return (ArrayList<UbicationModel>) ubicationRepo.findAll();
    }

    // Método que lista todas las ubicaciones (puede ser para otra funcionalidad similar)
    public ArrayList<UbicationModel> listarUbiColors() {
        // Retorna todas las ubicaciones desde el repositorio en forma de ArrayList
        return (ArrayList<UbicationModel>) ubicationRepo.findAll();
    }
}
