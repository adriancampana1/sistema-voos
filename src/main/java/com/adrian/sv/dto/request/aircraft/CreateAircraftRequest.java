package com.adrian.sv.dto.request.aircraft;

import jakarta.validation.constraints.NotBlank;

public record CreateAircraftRequest(
        @NotBlank Long idAircraftType,
        @NotBlank String registration
) {
}
