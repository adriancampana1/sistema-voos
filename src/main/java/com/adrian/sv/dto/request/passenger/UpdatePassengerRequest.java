package com.adrian.sv.dto.request.passenger;

public record UpdatePassengerRequest(
        String email,
        String username,
        String password,
        String cpf
) {}
