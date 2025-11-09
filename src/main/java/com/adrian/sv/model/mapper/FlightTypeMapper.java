package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.flighttype.CreateFlightTypeRequest;
import com.adrian.sv.dto.request.flighttype.UpdateFlightTypeRequest;
import com.adrian.sv.dto.response.FlightTypeResponse;
import com.adrian.sv.model.entity.TipoVoo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FlightTypeMapper {
    TipoVoo toEntity(CreateFlightTypeRequest request);

    FlightTypeResponse toResponseDTO(TipoVoo flightType);

    void updateEntity(UpdateFlightTypeRequest request, @MappingTarget TipoVoo flightType);
}
