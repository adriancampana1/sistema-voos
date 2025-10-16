package com.adrian.sv.dto.request.flighttype;

public record UpdateFlightTypeRequest(
        String type,
        String description
) {
}
