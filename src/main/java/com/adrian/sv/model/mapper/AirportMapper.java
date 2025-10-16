package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.airport.CreateAirportRequest;
import com.adrian.sv.dto.request.airport.UpdateAirportRequest;
import com.adrian.sv.dto.response.AirportResponse;
import com.adrian.sv.model.entity.Aeroporto;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper {
    public Aeroporto toEntity(CreateAirportRequest request) {
        return Aeroporto
                .builder()
                .code(request.code())
                .name(request.name())
                .city(request.city())
                .state(request.state())
                .country(request.country())
                .build();
    }

    public AirportResponse toResponseDTO(Aeroporto aeroporto) {
        return new AirportResponse(
                aeroporto.getId(),
                aeroporto.getCode(),
                aeroporto.getName(),
                aeroporto.getCity(),
                aeroporto.getState(),
                aeroporto.getCountry(),
                aeroporto.getCreatedAt(),
                aeroporto.getUpdatedAt()
        );
    }

    public void updateEntity (UpdateAirportRequest request, Aeroporto aeroporto) {
        if (request.code() != null && !request.code().isBlank()) {
             aeroporto.setCode(request.code());
        }
        if (request.name() != null && !request.name().isBlank()) {
            aeroporto.setName(request.name());
        }
        if (request.city() != null && !request.city().isBlank()) {
            aeroporto.setCity(request.city());
        }
        if (request.state() != null && !request.state().isBlank()) {
            aeroporto.setState(request.state());
        }
        if (request.country() != null && !request.country().isBlank()) {
            aeroporto.setCountry(request.country());
        }
    }
}
