package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.airport.CreateAirportRequest;
import com.adrian.sv.dto.request.airport.UpdateAirportRequest;
import com.adrian.sv.dto.response.AirportResponse;
import com.adrian.sv.model.entity.Aeroporto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AirportMapper {
    Aeroporto toEntity(CreateAirportRequest request);

    AirportResponse toResponseDTO(Aeroporto aeroporto);

    void updateEntity (UpdateAirportRequest request, @MappingTarget Aeroporto aeroporto);
}
