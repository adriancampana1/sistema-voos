package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.TipoAeronave;

import java.time.LocalDateTime;

public record AircraftResponse(
        Long id,
        TipoAeronave aircraftType,
        String registration,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
