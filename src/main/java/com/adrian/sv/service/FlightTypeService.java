package com.adrian.sv.service;

import com.adrian.sv.dto.request.flighttype.CreateFlightTypeRequest;
import com.adrian.sv.dto.request.flighttype.UpdateFlightTypeRequest;
import com.adrian.sv.dto.response.FlightTypeResponse;

import java.util.List;

public interface FlightTypeService {
    FlightTypeResponse create(CreateFlightTypeRequest request);
    List<FlightTypeResponse> findAll();
    FlightTypeResponse findById(Long id);
    FlightTypeResponse update(Long id, UpdateFlightTypeRequest request);
    void delete(Long id);
}
