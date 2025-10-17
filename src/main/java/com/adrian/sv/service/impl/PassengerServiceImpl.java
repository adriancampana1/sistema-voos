package com.adrian.sv.service.impl;

import com.adrian.sv.dto.response.PassengerResponse;
import com.adrian.sv.model.mapper.PassengerMapper;
import com.adrian.sv.dto.request.passenger.CreatePassengerRequest;
import com.adrian.sv.dto.request.passenger.UpdatePassengerRequest;
import com.adrian.sv.model.entity.Passageiro;
import com.adrian.sv.repository.PassengerRepository;
import com.adrian.sv.service.PassengerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;

    @Override
    public PassengerResponse create(CreatePassengerRequest request) {
        try {
            Passageiro passenger = this.passengerMapper.toEntity(request);
            Passageiro savedPassenger = this.passengerRepository.save(passenger);
            return this.passengerMapper.toResponseDTO(savedPassenger);
        } catch (Exception e) {
            log.error("Falha ao criar passageiro. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar passageiro.");
        }
    }

    @Override
    public List<PassengerResponse> findAll() {
        try {
            List<Passageiro> passengers = this.passengerRepository.findAll();
            return passengers.stream().map(this.passengerMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar passageiros. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar passageiro.");
        }
    }

    @Override
    public PassengerResponse findById(Long id) {
        try {
            Passageiro passenger = this.passengerRepository.findById(id).orElseThrow(() -> new BadRequestException("Passageiro não encontrado"));
            return this.passengerMapper.toResponseDTO(passenger);
        } catch (Exception e) {
            log.error("Falha ao buscar passageiro. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar passageiro.");
        }
    }

    @Override
    public PassengerResponse update(Long id, UpdatePassengerRequest request) {
        try {
            Passageiro passenger = this.passengerRepository.findById(id).orElseThrow(() -> new BadRequestException("Passageiro não encontrado."));
            this.passengerMapper.updateEntity(request, passenger);

            Passageiro savedPassenger = this.passengerRepository.save(passenger);
            return this.passengerMapper.toResponseDTO(savedPassenger);
        } catch (Exception e) {
            log.error("Falha ao atualizar passageiro. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar passageiro.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Passageiro passenger = this.passengerRepository.findById(id).orElseThrow(() -> new BadRequestException("Passageiro não encontrado."));
            this.passengerRepository.delete(passenger);
        } catch (Exception e) {
            log.error("Falha ao deletar passageiro. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao deletar passageiro.");
        }
    }
}
