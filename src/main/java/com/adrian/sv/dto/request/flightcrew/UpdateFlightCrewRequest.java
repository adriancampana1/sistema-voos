package com.adrian.sv.dto.request.flightcrew;

public record UpdateFlightCrewRequest(
        Long idFlight,
        Long idEmployee,
        String role
) {
}
