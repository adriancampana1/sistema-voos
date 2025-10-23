package com.adrian.sv.dto.response;

import com.adrian.sv.model.entity.AircraftCategory;

import java.time.LocalDateTime;

public record AircraftTypeResponse(
        Long id,
        String type,
        String description,
        Short passengerCapacity,
        AircraftCategory aircraftCategory,
        Integer maxSpeed,
        Integer rangeKm,
        Long cargoCapacityKg,
        Integer maxAltitudeFt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
