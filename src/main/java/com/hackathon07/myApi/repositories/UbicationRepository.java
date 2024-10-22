package com.hackathon07.myApi.repositories;

import com.hackathon07.myApi.model.UbicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicationRepository extends JpaRepository<UbicationModel, Long> {

}
