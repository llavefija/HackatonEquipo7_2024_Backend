package com.hackathon07.myApi.repositories;

import com.hackathon07.myApi.model.UbicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicationRepository extends JpaRepository<UbicationModel, Long> {
}
