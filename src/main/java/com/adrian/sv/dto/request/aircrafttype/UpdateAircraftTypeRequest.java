package com.adrian.sv.dto.request.aircrafttype;

import com.adrian.sv.model.entity.AircraftCategory;

public record UpdateAircraftTypeRequest(
        String type,
        String description,
        Short passengerCapacity,
        AircraftCategory aircraftCategory,
        Integer maxSpeed,
        Integer rangeKm,
        Long cargoCapacityKg,
        Integer maxAltitudeFt
) {}
