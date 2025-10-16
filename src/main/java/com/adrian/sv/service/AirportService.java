package com.adrian.sv.service;

import com.adrian.sv.dto.request.airport.CreateAirportRequest;
import com.adrian.sv.dto.request.airport.UpdateAirportRequest;
import com.adrian.sv.model.entity.Aeronave;
import com.adrian.sv.model.entity.Aeroporto;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    Aeroporto create(CreateAirportRequest request);
    List<Aeroporto> findAll();
    Optional<Aeroporto> findById(Long id);
    Aeroporto update(Long id, UpdateAirportRequest request);
    void delete(Long id);
}
