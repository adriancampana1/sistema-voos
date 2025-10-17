package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.aircrafttype.CreateAircraftTypeRequest;
import com.adrian.sv.dto.request.aircrafttype.UpdateAircraftTypeRequest;
import com.adrian.sv.dto.response.AircraftTypeResponse;
import com.adrian.sv.model.entity.TipoAeronave;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AircraftTypeMapper {
    TipoAeronave toEntity(CreateAircraftTypeRequest request);

    AircraftTypeResponse toResponseDTO(TipoAeronave aircraftType);

    void updateEntity(UpdateAircraftTypeRequest request, @MappingTarget TipoAeronave aircraftType);
}
