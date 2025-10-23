package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.flightcrew.CreateFlightCrewRequest;
import com.adrian.sv.dto.request.flightcrew.UpdateFlightCrewRequest;
import com.adrian.sv.dto.response.FlightCrewResponse;
import com.adrian.sv.model.entity.TripulacaoVoo;
import com.adrian.sv.model.mapper.FlightCrewMapper;
import com.adrian.sv.repository.FlightCrewRepository;
import com.adrian.sv.service.FlightCrewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FlightCrewServiceImpl implements FlightCrewService {

    private final FlightCrewRepository flightCrewRepository;
    private final FlightCrewMapper flightCrewMapper;

    @Override
    public FlightCrewResponse create(CreateFlightCrewRequest request) {
        try {
            TripulacaoVoo flightCrew = this.flightCrewMapper.toEntity(request);
            TripulacaoVoo savedFlightCrew = this.flightCrewRepository.save(flightCrew);
            return this.flightCrewMapper.toResponseDTO(savedFlightCrew);
        } catch (Exception e) {
            log.error("Falha ao criar tripulacao de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar tripulacao de voo.");
        }
    }

    @Override
    public List<FlightCrewResponse> findAll() {
        try {
            List<TripulacaoVoo> flightCrewList = this.flightCrewRepository.findAll();
            return flightCrewList.stream().map(this.flightCrewMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar tripulacao de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar tripulacao de voo.");
        }
    }

    @Override
    public FlightCrewResponse findById(Long id) {
        try {
            TripulacaoVoo flightCrew = this.flightCrewRepository.findById(id).orElseThrow(() -> new BadRequestException("Tripulação não encontrada"));
            return this.flightCrewMapper.toResponseDTO(flightCrew);
        } catch (Exception e) {
            log.error("Falha ao buscar tripulacao de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar tripulacao de voo.");
        }
    }

    @Override
    public FlightCrewResponse update(Long id, UpdateFlightCrewRequest request) {
        try {
            TripulacaoVoo flightCrew = this.flightCrewRepository.findById(id).orElseThrow(() -> new BadRequestException("Tripulação não encontrada"));
            this.flightCrewMapper.updateEntity(request, flightCrew);
            TripulacaoVoo updatedFlightCrew = this.flightCrewRepository.save(flightCrew);
            return this.flightCrewMapper.toResponseDTO(updatedFlightCrew);
        } catch (Exception e) {
            log.error("Falha ao atualizar tripulacao de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar tripulacao de voo.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            TripulacaoVoo flightCrew = this.flightCrewRepository.findById(id).orElseThrow(() -> new BadRequestException("Tripulação não encontrada"));
            this.flightCrewRepository.delete(flightCrew);
        } catch (Exception e) {
            log.error("Falha ao remover tripulacao de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao remover tripulacao de voo.");
        }
    }
}
