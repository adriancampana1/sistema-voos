package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.flightcrew.CreateFlightCrewRequest;
import com.adrian.sv.dto.request.flightcrew.UpdateFlightCrewRequest;
import com.adrian.sv.dto.response.FlightCrewResponse;
import com.adrian.sv.model.entity.TripulacaoVoo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FlightCrewMapper {
    TripulacaoVoo toEntity(CreateFlightCrewRequest request);
    FlightCrewResponse toResponseDTO(TripulacaoVoo flightCrew);
    void updateEntity(UpdateFlightCrewRequest request, @MappingTarget TripulacaoVoo flightCrew);
}
