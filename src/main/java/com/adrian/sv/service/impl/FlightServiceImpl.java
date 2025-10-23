package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.flight.CreateFlightRequest;
import com.adrian.sv.dto.request.flight.UpdateFlightRequest;
import com.adrian.sv.dto.response.FlightResponse;
import com.adrian.sv.model.entity.Voo;
import com.adrian.sv.model.mapper.FlightMapper;
import com.adrian.sv.repository.FlightRepository;
import com.adrian.sv.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public FlightResponse create(CreateFlightRequest request) {
        try {
            Voo flight = this.flightMapper.toEntity(request);
            Voo savedFlight = this.flightRepository.save(flight);
            return this.flightMapper.toResponseDTO(savedFlight);
        } catch (Exception e) {
            log.error("Falha ao criar voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar voo.");
        }
    }

    @Override
    public List<FlightResponse> findAll() {
        try {
            List<Voo> flights = this.flightRepository.findAll();
            return flights.stream().map(this.flightMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar voos. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar voos.");
        }
    }

    @Override
    public FlightResponse findById(Long id) {
        try {
            Voo flight = this.flightRepository.findById(id).orElseThrow(() -> new BadRequestException("Voo não encontrado"));
            return this.flightMapper.toResponseDTO(flight);
        } catch (Exception e) {
            log.error("Falha ao buscar voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar voo.");
        }
    }

    @Override
    public FlightResponse update(Long id, UpdateFlightRequest request) {
        try {
            Voo flight = this.flightRepository.findById(id).orElseThrow(() -> new BadRequestException("Voo não encontrado"));
            this.flightMapper.updateEntity(request, flight);
            Voo updatedFlight = this.flightRepository.save(flight);
            return this.flightMapper.toResponseDTO(updatedFlight);
        } catch (Exception e) {
            log.error("Falha ao atualizar voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar voo.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Voo flight = this.flightRepository.findById(id).orElseThrow(() -> new BadRequestException("Voo não encontrado"));
            this.flightRepository.delete(flight);
        } catch (Exception e) {
            log.error("Falha ao remover voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao remover voo.");
        }
    }
}
