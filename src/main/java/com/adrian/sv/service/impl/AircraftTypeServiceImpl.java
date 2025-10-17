package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.aircrafttype.CreateAircraftTypeRequest;
import com.adrian.sv.dto.request.aircrafttype.UpdateAircraftTypeRequest;
import com.adrian.sv.dto.response.AircraftTypeResponse;
import com.adrian.sv.model.entity.TipoAeronave;
import com.adrian.sv.model.mapper.AircraftTypeMapper;
import com.adrian.sv.repository.AircraftTypeRepository;
import com.adrian.sv.service.AircraftTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AircraftTypeServiceImpl implements AircraftTypeService {

    private final AircraftTypeRepository aircraftTypeRepository;
    private final AircraftTypeMapper aircraftTypeMapper;

    @Override
    public AircraftTypeResponse create(CreateAircraftTypeRequest request) {
        try {
            TipoAeronave aircraftType = this.aircraftTypeMapper.toEntity(request);
            TipoAeronave savedAircraftType = this.aircraftTypeRepository.save(aircraftType);
            return this.aircraftTypeMapper.toResponseDTO(savedAircraftType);
        } catch (Exception e) {
            log.error("Falha ao criar tipo de aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar tipo de aeronave.");
        }
    }

    @Override
    public List<AircraftTypeResponse> findAll() {
        try {
            List<TipoAeronave> aircraftTypes = this.aircraftTypeRepository.findAll();
            return aircraftTypes.stream().map(this.aircraftTypeMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar tipos de aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar tipos de aeronave.");
        }
    }

    @Override
    public AircraftTypeResponse findById(Long id) {
        try {
            TipoAeronave aircraftType = this.aircraftTypeRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Tipo de aeronave não encontrado"));
            return this.aircraftTypeMapper.toResponseDTO(aircraftType);
        } catch (Exception e) {
            log.error("Falha ao buscar tipo de aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar tipo de aeronave.");
        }
    }

    @Override
    public AircraftTypeResponse update(Long id, UpdateAircraftTypeRequest request) {
        try {
            TipoAeronave aircraftType = this.aircraftTypeRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Tipo de aeronave não encontrado"));
            this.aircraftTypeMapper.updateEntity(request, aircraftType);
            TipoAeronave updatedAircraftType = this.aircraftTypeRepository.save(aircraftType);
            return this.aircraftTypeMapper.toResponseDTO(updatedAircraftType);
        } catch (Exception e) {
            log.error("Falha ao atualizar tipo de aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar tipo de aeronave.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            TipoAeronave aircraftType = this.aircraftTypeRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Tipo de aeronave não encontrado"));
            this.aircraftTypeRepository.delete(aircraftType);
        } catch (Exception e) {
            log.error("Falha ao remover tipo de aeronave. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao remover tipo de aeronave.");
        }
    }
}
