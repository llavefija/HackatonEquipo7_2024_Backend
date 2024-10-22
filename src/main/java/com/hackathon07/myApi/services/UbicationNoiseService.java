package com.hackathon07.myApi.services; // Define el paquete donde se encuentra el servicio

import com.hackathon07.myApi.model.NoiseDataModel; // Importa el modelo de datos de ruido
import com.hackathon07.myApi.model.UbicationModel; // Importa el modelo de datos de ubicación
import com.hackathon07.myApi.repositories.NoiseDataRepository; // Importa el repositorio de datos de ruido
import com.hackathon07.myApi.repositories.UbicationRepository; // Importa el repositorio de datos de ubicación
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para la inyección de dependencias
import org.springframework.stereotype.Service; // Importa la anotación para marcar la clase como un servicio

import java.util.*; // Importa las clases de utilidades, como List y Map

// Indica que esta clase es un servicio en la capa de negocio de la aplicación
@Service
public class UbicationNoiseService {

    // Inyección del repositorio de datos de ruido mediante la anotación @Autowired
    @Autowired
    private NoiseDataRepository noiseRepo;

    // Inyección del repositorio de datos de ubicación mediante la anotación @Autowired
    @Autowired
    private UbicationRepository ubicationRepo;

    // Método para listar ubicaciones y colores de ruido según fecha y hora
    public List<Map<String, Object>> listarUbiYColors(Date fecha, int hora) {
        // Buscar los datos de ruido que coincidan con la fecha y hora
        List<NoiseDataModel> noises = noiseRepo.findByDateAndHour(fecha, hora);

        // Obtener todas las ubicaciones
        List<UbicationModel> ubications = ubicationRepo.findAll();

        // Crear una lista para almacenar los datos combinados
        List<Map<String, Object>> combinedData = new ArrayList<>();

        // Usar el tamaño más pequeño para evitar errores de índices al iterar
        int minSize = Math.min(noises.size(), ubications.size());

        // Iterar a través de los datos de ruido y ubicaciones
        for (int i = 0; i < minSize; i++) {
            NoiseDataModel noise = noises.get(i); // Obtener el objeto de ruido
            UbicationModel ubication = ubications.get(i); // Obtener el objeto de ubicación

            // Crear un mapa para representar una característica geográfica
            Map<String, Object> feature = new HashMap<>();
            Map<String, Object> properties = new HashMap<>();
            Map<String, Object> geometry = new HashMap<>();

            // Rellenar el mapa de propiedades con los campos de ambas tablas
            properties.put("id", ubication.getId());
            properties.put("name", ubication.getName());
            properties.put("db", noise.getDBs());
            properties.put("dbColor", noise.getNoiseLevel());

            // Rellenar el mapa de geometría con latitud y longitud
            geometry.put("type", "Point"); // Tipo de geometría
            geometry.put("coordinates", Arrays.asList(ubication.getLongitude(), ubication.getLatitude())); // Coordenadas

            // Añadir el tipo, propiedades y geometría al mapa de características
            feature.put("type", "Feature");
            feature.put("properties", properties);
            feature.put("geometry", geometry);

            // Agregar la característica combinada a la lista
            combinedData.add(feature);
        }

        // Devolver la lista de datos combinados
        return combinedData;
    }

    // Método para listar ubicaciones y colores de ruido según fecha y ID de ubicación
    public List<Map<String, Object>> listarUbiYColorsByUbication(Date fecha, Long idUbicacion) {
        // Buscar los datos de ruido que coincidan con la fecha y el ID de ubicación
        List<NoiseDataModel> noises = noiseRepo.findByDateAndUbicationId(fecha, idUbicacion);

        // Obtener la ubicación específica mediante el ID
        UbicationModel ubication = ubicationRepo.findById(idUbicacion).orElse(null);

        // Crear una lista para almacenar los datos combinados
        List<Map<String, Object>> combinedData = new ArrayList<>();

        // Solo agregar datos si se encontró la ubicación y hay datos de ruido
        if (ubication != null && !noises.isEmpty()) {
            for (NoiseDataModel noise : noises) { // Iterar a través de los datos de ruido
                // Crear un mapa para representar una característica geográfica
                Map<String, Object> feature = new HashMap<>();
                Map<String, Object> properties = new HashMap<>();
                Map<String, Object> geometry = new HashMap<>();

                // Rellenar el mapa de propiedades con los campos de ambas tablas
                properties.put("id", ubication.getId());
                properties.put("name", ubication.getName());
                properties.put("db", noise.getDBs());
                properties.put("dbColor", noise.getNoiseLevel());

                // Rellenar el mapa de geometría con latitud y longitud
                geometry.put("type", "Point"); // Tipo de geometría
                geometry.put("coordinates", Arrays.asList(ubication.getLongitude(), ubication.getLatitude())); // Coordenadas

                // Añadir el tipo, propiedades y geometría al mapa de características
                feature.put("type", "Feature");
                feature.put("properties", properties);
                feature.put("geometry", geometry);

                // Agregar la característica combinada a la lista
                combinedData.add(feature);
            }
        }

        // Devolver la lista de datos combinados
        return combinedData;
    }
}
