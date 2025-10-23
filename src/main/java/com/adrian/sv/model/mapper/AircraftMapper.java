package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.aircraft.CreateAircraftRequest;
import com.adrian.sv.dto.request.aircraft.UpdateAircraftRequest;
import com.adrian.sv.dto.response.AircraftResponse;
import com.adrian.sv.model.entity.Aeronave;
import com.adrian.sv.model.entity.TipoAeronave;
import com.adrian.sv.repository.AircraftTypeRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AircraftMapper {

    @Autowired
    protected AircraftTypeRepository aircraftTypeRepository;

    @Autowired
    protected AircraftTypeMapper aircraftTypeMapper;

    @Mapping(source = "idAircraftType", target = "tipoAeronave", qualifiedByName = "mapAircraftType")
    public abstract Aeronave toEntity(CreateAircraftRequest request);

    public AircraftResponse toResponseDTO(Aeronave aircraft) {
        if (aircraft == null) {
            return null;
        }
        return new AircraftResponse(
                aircraft.getId(),
                aircraftTypeMapper.toResponseDTO(aircraft.getTipoAeronave()),
                aircraft.getRegistration(),
                aircraft.getCreatedAt(),
                aircraft.getUpdatedAt()
        );
    }

    @Mapping(source = "idAircraftType", target = "tipoAeronave", qualifiedByName = "mapAircraftType")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(UpdateAircraftRequest request, @MappingTarget Aeronave aircraft);

    @Named("mapAircraftType")
    protected TipoAeronave mapAircraftType(Long idAircraftType) {
        if (idAircraftType == null) {
            return null;
        }
        return aircraftTypeRepository.findById(idAircraftType).orElse(null);
    }
}