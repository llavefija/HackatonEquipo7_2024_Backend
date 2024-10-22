package com.hackathon07.myApi.repositories;

import com.hackathon07.myApi.model.NoiseDataModel; // Importa el modelo de datos de ruido
import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository para acceso a datos
import org.springframework.stereotype.Repository; // Importa la anotación Repository

import java.util.Date; // Importa la clase Date para manejar fechas
import java.util.List; // Importa la clase List para manejar listas de resultados

// Indica que esta interfaz es un repositorio de datos
@Repository
public interface NoiseDataRepository extends JpaRepository<NoiseDataModel, Long> {

    // Método para buscar registros de ruido por fecha y hora
    List<NoiseDataModel> findByDateAndHour(Date date, int hour);

    // Método para buscar registros de ruido por fecha y el ID de la ubicación
    List<NoiseDataModel> findByDateAndUbicationId(Date fecha, Long idUbicacion);
}
