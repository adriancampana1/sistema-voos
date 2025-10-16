package com.adrian.sv.dto.request.passenger;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CreatePassengerRequest(
        @NotBlank @Email String email,
        @NotBlank String username,
        @NotBlank @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres") String password,
        @NotBlank @CPF(message = "Insira um CPF válido") String cpf
) {}
