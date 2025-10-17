package com.adrian.sv.service;

import com.adrian.sv.dto.request.aircrafttype.CreateAircraftTypeRequest;
import com.adrian.sv.dto.request.aircrafttype.UpdateAircraftTypeRequest;
import com.adrian.sv.dto.response.AircraftTypeResponse;

import java.util.List;
import java.util.Optional;

public interface AircraftTypeService {
    AircraftTypeResponse create(CreateAircraftTypeRequest request);
    List<AircraftTypeResponse> findAll();
    AircraftTypeResponse findById(Long id);
    AircraftTypeResponse update(Long id, UpdateAircraftTypeRequest request);
    void delete(Long id);
}
