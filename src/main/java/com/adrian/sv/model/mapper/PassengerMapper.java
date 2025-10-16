package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.passenger.CreatePassengerRequest;
import com.adrian.sv.dto.request.passenger.UpdatePassengerRequest;
import com.adrian.sv.dto.response.PassengerResponse;
import com.adrian.sv.model.entity.Passageiro;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    public Passageiro toEntity(CreatePassengerRequest request) {
        return Passageiro
                .builder()
                .email(request.email())
                .password(request.password())
                .username(request.username())
                .cpf(request.cpf())
                .build();
    }

    public PassengerResponse toResponseDTO(Passageiro passageiro) {
        return new PassengerResponse(
                passageiro.getId(),
                passageiro.getEmail(),
                passageiro.getUsername(),
                passageiro.getCpf(),
                passageiro.getCreatedAt(),
                passageiro.getUpdatedAt()
        );
    }

    public void updateEntity(UpdatePassengerRequest updateRequest, Passageiro passageiro) {
        if (updateRequest.email() != null && !updateRequest.email().isBlank()) {
            passageiro.setEmail(updateRequest.email());
        }
        if (updateRequest.username() != null && !updateRequest.username().isBlank()) {
            passageiro.setUsername(updateRequest.username());
        }
        if (updateRequest.password() != null && !updateRequest.password().isBlank()) {
            passageiro.setPassword(updateRequest.password());
        }
        if (updateRequest.cpf() != null && !updateRequest.cpf().isBlank()) {
            passageiro.setCpf(updateRequest.cpf());
        }
    }
}
