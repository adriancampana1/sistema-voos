package com.adrian.sv.dto.request.aircraft;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAircraftRequest(
        @NotNull Long idAircraftType,
        @NotBlank String registration
) {
}
