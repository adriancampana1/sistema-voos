package com.adrian.sv.dto.request.aircrafttype;

import jakarta.validation.constraints.NotBlank;

public record CreateAircraftTypeRequest(
        @NotBlank String type,
        String description,
        @NotBlank Short passengerCapacity
) {}
