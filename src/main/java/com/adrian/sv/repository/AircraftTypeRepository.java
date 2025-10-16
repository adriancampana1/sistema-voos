package com.adrian.sv.repository;

import com.adrian.sv.model.entity.TipoAeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftTypeRepository extends JpaRepository<TipoAeronave, Long> {
}
