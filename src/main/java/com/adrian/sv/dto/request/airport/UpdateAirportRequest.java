package com.adrian.sv.dto.request.airport;

public record UpdateAirportRequest(
        String code,
        String name,
        String city,
        String state,
        String country
) {
}
