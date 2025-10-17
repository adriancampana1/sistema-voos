package com.adrian.sv.dto.request.flightcrew;

import jakarta.validation.constraints.NotBlank;

public record CreateFlightCrewRequest(
        @NotBlank Long idFlight,
        @NotBlank Long idEmployee,
        @NotBlank String role
) {
}
