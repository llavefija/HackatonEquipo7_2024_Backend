package com.hackathon07.myApi.repositories;

import com.hackathon07.myApi.model.NoiseDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoiseDataRepository extends JpaRepository<NoiseDataModel, Long> {
}
