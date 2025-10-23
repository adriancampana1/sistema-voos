package com.adrian.sv.dto.response;

public record AircraftTypeSimpleResponse(
        Long id,
        String type,
        String description,
        Short passengerCapacity,
        String aircraftCategory,
        Integer maxSpeed,
        Integer rangeKm,
        Long cargoCapacityKg,
        Integer maxAltitudeFt
) {
}
