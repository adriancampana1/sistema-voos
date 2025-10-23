package com.adrian.sv.dto.request.aircrafttype;

import com.adrian.sv.model.entity.AircraftCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAircraftTypeRequest(
        @NotBlank String type,
        String description,
        @NotBlank Short passengerCapacity,
        @NotNull AircraftCategory aircraftCategory,
        @NotNull Integer maxSpeed,
        @NotNull Integer rangeKm,
        @NotNull Long cargoCapacityKg,
        @NotNull Integer maxAltitudeFt
) {}
