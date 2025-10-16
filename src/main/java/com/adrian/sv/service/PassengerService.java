package com.adrian.sv.service;

import com.adrian.sv.dto.request.passenger.CreatePassengerRequest;
import com.adrian.sv.dto.request.passenger.UpdatePassengerRequest;
import com.adrian.sv.model.entity.Passageiro;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Passageiro create(CreatePassengerRequest request);
    List<Passageiro> findAll();
    Optional<Passageiro> findById(Long id);
    Passageiro update(Long id, UpdatePassengerRequest request);
    void delete(Long id);
}
