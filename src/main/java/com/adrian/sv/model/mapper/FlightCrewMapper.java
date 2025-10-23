package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.flightcrew.CreateFlightCrewRequest;
import com.adrian.sv.dto.request.flightcrew.UpdateFlightCrewRequest;
import com.adrian.sv.dto.response.FlightCrewResponse;
import com.adrian.sv.model.entity.Funcionario;
import com.adrian.sv.model.entity.TripulacaoVoo;
import com.adrian.sv.model.entity.Voo;
import com.adrian.sv.repository.EmployeeRepository;
import com.adrian.sv.repository.FlightRepository;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class FlightCrewMapper {

    @Autowired
    protected FlightRepository flightRepository;

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Autowired
    protected FlightMapper flightMapper;

    @Autowired
    protected EmployeeMapper employeeMapper;

    public TripulacaoVoo toEntity(CreateFlightCrewRequest request) {
        if (request == null) {
            return null;
        }
        return TripulacaoVoo.builder()
                .voo(mapFlight(request.idFlight()))
                .funcionario(mapEmployee(request.idEmployee()))
                .role(request.role())
                .build();
    }

    public FlightCrewResponse toResponseDTO(TripulacaoVoo flightCrew) {
        if (flightCrew == null) {
            return null;
        }
        return new FlightCrewResponse(
                flightCrew.getId(),
                flightMapper.toResponseDTO(flightCrew.getVoo()),
                employeeMapper.toResponseDTO(flightCrew.getFuncionario()),
                flightCrew.getRole(),
                flightCrew.getCreatedAt(),
                flightCrew.getUpdatedAt()
        );
    }

    public void updateEntity(UpdateFlightCrewRequest request, TripulacaoVoo flightCrew) {
        if (request == null || flightCrew == null) {
            return;
        }
        if (request.idFlight() != null) {
            flightCrew.setVoo(mapFlight(request.idFlight()));
        }
        if (request.idEmployee() != null) {
            flightCrew.setFuncionario(mapEmployee(request.idEmployee()));
        }
        if (request.role() != null) {
            flightCrew.setRole(request.role());
        }
    }

    protected Voo mapFlight(Long idFlight) {
        if (idFlight == null) {
            return null;
        }
        return flightRepository.findById(idFlight)
                .orElseThrow(() -> new RuntimeException("Voo com ID " + idFlight + " não encontrado"));
    }

    protected Funcionario mapEmployee(Long idEmployee) {
        if (idEmployee == null) {
            return null;
        }
        return employeeRepository.findById(idEmployee)
                .orElseThrow(() -> new RuntimeException("Funcionário com ID " + idEmployee + " não encontrado"));
    }
}
