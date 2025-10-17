package com.adrian.sv.service;

import com.adrian.sv.dto.request.airport.CreateAirportRequest;
import com.adrian.sv.dto.request.airport.UpdateAirportRequest;
import com.adrian.sv.dto.response.AirportResponse;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    AirportResponse create(CreateAirportRequest request);
    List<AirportResponse> findAll();
    AirportResponse findById(Long id);
    AirportResponse update(Long id, UpdateAirportRequest request);
    void delete(Long id);
}
