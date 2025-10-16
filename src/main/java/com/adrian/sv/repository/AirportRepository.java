package com.adrian.sv.repository;

import com.adrian.sv.model.entity.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Aeroporto, Long> {
}
