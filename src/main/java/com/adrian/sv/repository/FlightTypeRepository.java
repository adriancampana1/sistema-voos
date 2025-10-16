package com.adrian.sv.repository;

import com.adrian.sv.model.entity.TipoVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTypeRepository extends JpaRepository<TipoVoo, Long> {
}
