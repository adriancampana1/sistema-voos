package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.aircraft.CreateAircraftRequest;
import com.adrian.sv.dto.request.aircraft.UpdateAircraftRequest;
import com.adrian.sv.dto.response.AircraftResponse;
import com.adrian.sv.model.entity.Aeronave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AircraftMapper {

    @Mapping(source = "idAircraftType", target = "tipoAeronave.id")
    Aeronave toEntity(CreateAircraftRequest request);

    AircraftResponse toResponseDTO(Aeronave aircraft);

    void updateEntity(UpdateAircraftRequest request, @MappingTarget Aeronave aircraft);
}
