package com.adrian.sv.dto.request.airport;

import jakarta.validation.constraints.NotBlank;

public record CreateAirportRequest(
        @NotBlank String code,
        @NotBlank String name,
        @NotBlank String city,
        @NotBlank String state,
        @NotBlank String country
) {
}
