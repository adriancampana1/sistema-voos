package com.adrian.sv.service.impl;

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
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Override
    public Aeroporto create(CreateAirportRequest request) {
        try {
            Aeroporto aeroporto = this.airportMapper.toEntity(request);
            return this.airportRepository.save(aeroporto);
        } catch (Exception e) {
            log.error("Falha ao criar aeroporto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar aeroporto.");
        }
    }

    @Override
    public List<Aeroporto> findAll() {
        return this.airportRepository.findAll();
    }

    @Override
    public Optional<Aeroporto> findById(Long id) {
        try {
            return this.airportRepository.findById(id);
        } catch (Exception e) {
            log.error("Falha ao encontrar aeroporto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao encontrar aeroporto.");
        }
    }

    @Override
    public Aeroporto update(Long id, UpdateAirportRequest request) {
        try {
            Aeroporto aeroporto = this.airportRepository.findById(id).orElseThrow(() -> new BadRequestException("Aeroporto não encontrado."));
            this.airportMapper.updateEntity(request, aeroporto);

            return this.airportRepository.save(aeroporto);
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
