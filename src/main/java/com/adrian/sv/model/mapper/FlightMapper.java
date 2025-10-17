package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.flight.CreateFlightRequest;
import com.adrian.sv.dto.request.flight.UpdateFlightRequest;
import com.adrian.sv.dto.response.FlightResponse;
import com.adrian.sv.model.entity.Voo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FlightMapper {
    Voo toEntity(CreateFlightRequest request);
    FlightResponse toResponseDTO(Voo flight);
    void updateEntity(UpdateFlightRequest request, @MappingTarget Voo flight);
}
