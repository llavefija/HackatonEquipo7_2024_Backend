package com.hackathon07.myApi.repositories;

import com.hackathon07.myApi.model.UbicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UbicationRepository extends JpaRepository<UbicationModel, Long> {
    Optional<UbicationModel> findById(Long id);

}
