package com.adrian.sv.dto.request.aircraft;

public record UpdateAircraftRequest(
        Long idAircraftType,
        String registration
) {
}
