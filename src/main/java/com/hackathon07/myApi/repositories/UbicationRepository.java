package com.hackathon07.myApi.repositories; // Define el paquete donde se encuentra el repositorio

import com.hackathon07.myApi.model.UbicationModel; // Importa el modelo de datos de ubicación
import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository para acceso a datos
import org.springframework.stereotype.Repository; // Importa la anotación Repository

import java.util.List; // Importa la clase List para manejar listas
import java.util.Optional; // Importa la clase Optional para manejar valores opcionales

// Indica que esta interfaz es un repositorio de datos
@Repository
public interface UbicationRepository extends JpaRepository<UbicationModel, Long> {

    // Método para buscar una ubicación por su ID
    Optional<UbicationModel> findById(Long id);
}
