package com.adrian.sv.dto.request.flighttype;

import jakarta.validation.constraints.NotBlank;

public record CreateFlightTypeRequest(
        @NotBlank String type,
        String description
) {
}
