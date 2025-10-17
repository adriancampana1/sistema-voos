package com.adrian.sv.service.impl;

import com.adrian.sv.dto.response.AirportResponse;
import com.adrian.sv.model.mapper.AirportMapper;
import com.adrian.sv.dto.request.airport.CreateAirportRequest;
import com.adrian.sv.dto.request.airport.UpdateAirportRequest;
import com.adrian.sv.model.entity.Aeroporto;
import com.adrian.sv.repository.AirportRepository;
import com.adrian.sv.service.AirportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Override
    public AirportResponse create(CreateAirportRequest request) {
        try {
            Aeroporto airport = this.airportMapper.toEntity(request);
            Aeroporto savedAirport = this.airportRepository.save(airport);
            return this.airportMapper.toResponseDTO(savedAirport);
        } catch (Exception e) {
            log.error("Falha ao criar aeroporto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar aeroporto.");
        }
    }

    @Override
    public List<AirportResponse> findAll() {
        List<Aeroporto> airports = this.airportRepository.findAll();
        return airports.stream().map(this.airportMapper::toResponseDTO).toList();
    }

    @Override
    public AirportResponse findById(Long id) {
        try {
            Aeroporto airport = this.airportRepository.findById(id).orElseThrow(() -> new BadRequestException("Aeroporto não encontrado"));
            return this.airportMapper.toResponseDTO(airport);
        } catch (Exception e) {
            log.error("Falha ao encontrar aeroporto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao encontrar aeroporto.");
        }
    }

    @Override
    public AirportResponse update(Long id, UpdateAirportRequest request) {
        try {
            Aeroporto airport = this.airportRepository.findById(id).orElseThrow(() -> new BadRequestException("Aeroporto não encontrado."));
            this.airportMapper.updateEntity(request, airport);
            Aeroporto savedAirport = this.airportRepository.save(airport);
            return this.airportMapper.toResponseDTO(savedAirport);
        } catch (Exception e) {
            log.error("Falha ao atualizar aeroporto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar aeroporto.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Aeroporto aeroporto = this.airportRepository.findById(id).orElseThrow(() -> new BadRequestException("Aeroporto não encontrado."));
            this.airportRepository.delete(aeroporto);
        } catch (Exception e) {
            log.error("Falha ao deletar aeroporto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao deletar aeroporto.");
        }
    }
}
