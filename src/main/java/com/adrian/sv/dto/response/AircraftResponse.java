package com.adrian.sv.dto.response;

import java.time.LocalDateTime;

public record AircraftResponse(
        Long id,
        AircraftTypeResponse aircraftType,
        String registration,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
