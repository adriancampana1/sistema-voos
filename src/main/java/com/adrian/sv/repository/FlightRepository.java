package com.adrian.sv.repository;

import com.adrian.sv.model.entity.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Voo, Long> {
}
