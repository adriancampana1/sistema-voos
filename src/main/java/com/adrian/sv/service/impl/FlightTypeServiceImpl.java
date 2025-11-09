package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.flighttype.CreateFlightTypeRequest;
import com.adrian.sv.dto.request.flighttype.UpdateFlightTypeRequest;
import com.adrian.sv.dto.response.FlightTypeResponse;
import com.adrian.sv.model.entity.TipoVoo;
import com.adrian.sv.model.mapper.FlightTypeMapper;
import com.adrian.sv.repository.FlightTypeRepository;
import com.adrian.sv.service.FlightTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FlightTypeServiceImpl implements FlightTypeService {

    private final FlightTypeRepository flightTypeRepository;
    private final FlightTypeMapper flightTypeMapper;

    @Override
    public FlightTypeResponse create(CreateFlightTypeRequest request) {
        try {
            TipoVoo flightType = this.flightTypeMapper.toEntity(request);
            TipoVoo savedFlightType = this.flightTypeRepository.save(flightType);
            return this.flightTypeMapper.toResponseDTO(savedFlightType);
        } catch (Exception e) {
            log.error("Falha ao criar tipo de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar tipo de voo.");
        }
    }

    @Override
    public List<FlightTypeResponse> findAll() {
        try {
            List<TipoVoo> flightTypes = this.flightTypeRepository.findAll();
            return flightTypes.stream().map(this.flightTypeMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar tipos de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar tipos de voo.");
        }
    }

    @Override
    public FlightTypeResponse findById(Long id) {
        try {
            TipoVoo flightType = this.flightTypeRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Tipo de voo não encontrado"));
            return this.flightTypeMapper.toResponseDTO(flightType);
        } catch (Exception e) {
            log.error("Falha ao buscar tipo de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar tipo de voo.");
        }
    }

    @Override
    public FlightTypeResponse update(Long id, UpdateFlightTypeRequest request) {
        try {
            TipoVoo flightType = this.flightTypeRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Tipo de voo não encontrado"));
            this.flightTypeMapper.updateEntity(request, flightType);
            TipoVoo updatedFlightType = this.flightTypeRepository.save(flightType);
            return this.flightTypeMapper.toResponseDTO(updatedFlightType);
        } catch (Exception e) {
            log.error("Falha ao atualizar tipo de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar tipo de voo.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            TipoVoo flightType = this.flightTypeRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Tipo de voo não encontrado"));
            this.flightTypeRepository.delete(flightType);
        } catch (Exception e) {
            log.error("Falha ao remover tipo de voo. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao remover tipo de voo.");
        }
    }
}
