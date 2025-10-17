package com.adrian.sv.service;

import com.adrian.sv.dto.request.flight.CreateFlightRequest;
import com.adrian.sv.dto.request.flight.UpdateFlightRequest;
import com.adrian.sv.dto.response.FlightResponse;

import java.util.List;

public interface FlightService {
    FlightResponse create(CreateFlightRequest request);
    List<FlightResponse> findAll();
    FlightResponse findById(Long id);
    FlightResponse update(Long id, UpdateFlightRequest request);
    void delete(Long id);
}
