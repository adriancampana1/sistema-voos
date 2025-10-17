package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.aircraft.CreateAircraftRequest;
import com.adrian.sv.dto.request.aircraft.UpdateAircraftRequest;
import com.adrian.sv.dto.response.AircraftResponse;
import com.adrian.sv.model.entity.Aeronave;
import com.adrian.sv.model.mapper.AircraftMapper;
import com.adrian.sv.repository.AircraftRepository;
import com.adrian.sv.service.AircraftService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AircraftMapper aircraftMapper;

    @Override
    public AircraftResponse create(CreateAircraftRequest request) {
        try {
            Aeronave aircraft = this.aircraftMapper.toEntity(request);
            Aeronave savedAircraft = this.aircraftRepository.save(aircraft);
            return this.aircraftMapper.toResponseDTO(savedAircraft);
        } catch (Exception e) {
            log.error("Falha ao criar aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar aeronave.");
        }
    }

    @Override
    public List<AircraftResponse> findAll() {
        try {
            List<Aeronave> aircrafts = this.aircraftRepository.findAll();
            return aircrafts.stream().map(this.aircraftMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar aeronaves. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar aeronaves.");
        }
    }

    @Override
    public AircraftResponse findById(Long id) {
        try {
            Aeronave aircraft = this.aircraftRepository.findById(id).orElseThrow(() -> new BadRequestException("Aeronave não encontrada!"));
            return this.aircraftMapper.toResponseDTO(aircraft);
        } catch (Exception e) {
            log.error("Falha ao buscar aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar aeronave.");
        }
    }

    @Override
    public AircraftResponse update(Long id, UpdateAircraftRequest request) {
        try {
            Aeronave aircraft = this.aircraftRepository.findById(id).orElseThrow(() -> new BadRequestException("Aeronave não encontrada"));
            this.aircraftMapper.updateEntity(request, aircraft);
            Aeronave updatedAircraft = this.aircraftRepository.save(aircraft);
            return this.aircraftMapper.toResponseDTO(updatedAircraft);
        } catch (Exception e) {
            log.error("Falha ao atualizar aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar aeronave.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Aeronave aircraft = this.aircraftRepository.findById(id).orElseThrow(() -> new BadRequestException("Aeronave não encontrada"));
            this.aircraftRepository.delete(aircraft);
        } catch (Exception e) {
            log.error("Falha ao deletar aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao deletar aeronave.");
        }
    }
}
