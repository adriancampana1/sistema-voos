package com.adrian.sv.service;

import com.adrian.sv.dto.request.passenger.CreatePassengerRequest;
import com.adrian.sv.dto.request.passenger.UpdatePassengerRequest;
import com.adrian.sv.dto.response.PassengerResponse;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    PassengerResponse create(CreatePassengerRequest request);
    List<PassengerResponse> findAll();
    PassengerResponse findById(Long id);
    PassengerResponse update(Long id, UpdatePassengerRequest request);
    void delete(Long id);
}
