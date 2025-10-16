package com.adrian.sv.repository;

import com.adrian.sv.model.entity.TripulacaoVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightCrewRepository extends JpaRepository<TripulacaoVoo, Long> {
}
