package com.adrian.sv.repository;

import com.adrian.sv.model.entity.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aeronave, Long> {
}
