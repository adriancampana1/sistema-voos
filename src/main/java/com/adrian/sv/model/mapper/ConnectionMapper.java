package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.connection.CreateConnectionRequest;
import com.adrian.sv.dto.request.connection.UpdateConnectionRequest;
import com.adrian.sv.dto.response.ConnectionResponse;
import com.adrian.sv.model.entity.Aeroporto;
import com.adrian.sv.model.entity.EscalaVoo;
import com.adrian.sv.model.entity.Voo;
import com.adrian.sv.repository.AirportRepository;
import com.adrian.sv.repository.FlightRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class ConnectionMapper {

    @Autowired
    protected FlightRepository flightRepository;

    @Autowired
    protected AirportRepository airportRepository;

    @Autowired
    protected FlightMapper flightMapper;

    @Autowired
    protected AirportMapper airportMapper;

    @Mapping(source = "idFlight", target = "voo", qualifiedByName = "mapFlight")
    @Mapping(source = "idAirport", target = "aeroporto", qualifiedByName = "mapAirport")
    @Mapping(source = "stopOrder", target = "ordemEscala")
    public abstract EscalaVoo toEntity(CreateConnectionRequest request);

    public ConnectionResponse toResponseDTO(EscalaVoo connection) {
        if (connection == null) {
            return null;
        }
        return new ConnectionResponse(
                connection.getId(),
                flightMapper.toResponseDTO(connection.getVoo()),
                airportMapper.toResponseDTO(connection.getAeroporto()),
                connection.getOrdemEscala(),
                connection.getDepartureDate(),
                connection.getScheduledDepartureTime(),
                connection.getArrivalDate(),
                connection.getScheduledArrivalTime(),
                connection.getCreatedAt(),
                connection.getUpdatedAt()
        );
    }

    @Mapping(source = "idFlight", target = "voo", qualifiedByName = "mapFlight")
    @Mapping(source = "idAirport", target = "aeroporto", qualifiedByName = "mapAirport")
    @Mapping(source = "stopOrder", target = "ordemEscala")
    public abstract void updateEntity(UpdateConnectionRequest request, @MappingTarget EscalaVoo connection);

    @Named("mapFlight")
    protected Voo mapFlight(Long idFlight) {
        if (idFlight == null) {
            return null;
        }
        return flightRepository.findById(idFlight).orElse(null);
    }

    @Named("mapAirport")
    protected Aeroporto mapAirport(Long idAirport) {
        if (idAirport == null) {
            return null;
        }
        return airportRepository.findById(idAirport).orElse(null);
    }
}
