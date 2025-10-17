package com.adrian.sv.service;

import com.adrian.sv.dto.request.flightcrew.CreateFlightCrewRequest;
import com.adrian.sv.dto.request.flightcrew.UpdateFlightCrewRequest;
import com.adrian.sv.dto.response.FlightCrewResponse;

import java.util.List;

public interface FlightCrewService {
    FlightCrewResponse create(CreateFlightCrewRequest request);
    List<FlightCrewResponse> findAll();
    FlightCrewResponse findById(Long id);
    FlightCrewResponse update(Long id, UpdateFlightCrewRequest request);
    void delete(Long id);
}
