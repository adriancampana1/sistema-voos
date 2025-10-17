package com.adrian.sv.service;

import com.adrian.sv.dto.request.aircraft.CreateAircraftRequest;
import com.adrian.sv.dto.request.aircraft.UpdateAircraftRequest;
import com.adrian.sv.dto.response.AircraftResponse;

import java.util.List;
import java.util.Optional;

public interface AircraftService {
    AircraftResponse create(CreateAircraftRequest request);
    List<AircraftResponse> findAll();
    AircraftResponse findById(Long id);
    AircraftResponse update(Long id, UpdateAircraftRequest request);
    void delete(Long id);
}
