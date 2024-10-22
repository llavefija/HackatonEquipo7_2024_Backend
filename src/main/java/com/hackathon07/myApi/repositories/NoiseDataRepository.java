package com.hackathon07.myApi.repositories;

import com.hackathon07.myApi.model.NoiseDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface NoiseDataRepository extends JpaRepository<NoiseDataModel, Long> {

    // Metodo para buscar por fecha y hora ubicaciones y sonidos
    List<NoiseDataModel> findByDateAndHour(Date date, int hour);
    List<NoiseDataModel> findByDateAndUbicationId(Date fecha, Long idUbicacion);

}
