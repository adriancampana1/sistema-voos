package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.flight.CreateFlightRequest;
import com.adrian.sv.dto.request.flight.UpdateFlightRequest;
import com.adrian.sv.dto.response.FlightResponse;
import com.adrian.sv.dto.response.FlightTypeResponse;
import com.adrian.sv.dto.response.AircraftTypeSimpleResponse;
import com.adrian.sv.dto.response.AirportResponse;
import com.adrian.sv.model.entity.Aeroporto;
import com.adrian.sv.model.entity.TipoAeronave;
import com.adrian.sv.model.entity.TipoVoo;
import com.adrian.sv.model.entity.Voo;
import com.adrian.sv.repository.FlightTypeRepository;
import com.adrian.sv.repository.AircraftTypeRepository;
import com.adrian.sv.repository.AirportRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class FlightMapper {

    @Autowired
    protected FlightTypeRepository flightTypeRepository;

    @Autowired
    protected AircraftTypeRepository aircraftTypeRepository;

    @Autowired
    protected AirportRepository airportRepository;

    @Mapping(source = "idFlightType", target = "tipoVoo")
    @Mapping(source = "idAircraftType", target = "tipoAeronave")
    @Mapping(source = "idOriginAirport", target = "aeroportoOrigem")
    @Mapping(source = "idDestinationAirport", target = "aeroportoDestino")
    public abstract Voo toEntity(CreateFlightRequest request);

    public FlightResponse toResponseDTO(Voo flight) {
        if (flight == null) {
            return null;
        }
        return new FlightResponse(
                flight.getId(),
                toFlightTypeResponse(flight.getTipoVoo()),
                toAircraftTypeSimpleResponse(flight.getTipoAeronave()),
                toAirportResponse(flight.getAeroportoOrigem()),
                toAirportResponse(flight.getAeroportoDestino()),
                flight.getDepartureDate(),
                flight.getScheduledDepartureTime(),
                flight.getArrivalDate(),
                flight.getScheduledArrivalTime(),
                flight.getScheduledDurationMin(),
                flight.getStatus(),
                flight.getCreatedAt(),
                flight.getUpdatedAt()
        );
    }

    @Mapping(source = "idFlightType", target = "tipoVoo")
    @Mapping(source = "idAircraftType", target = "tipoAeronave")
    @Mapping(source = "idOriginAirport", target = "aeroportoOrigem")
    @Mapping(source = "idDestinationAirport", target = "aeroportoDestino")
    public abstract void updateEntity(UpdateFlightRequest request, @MappingTarget Voo flight);

    protected TipoVoo mapTipoVoo(Long id) {
        if (id == null) {
            return null;
        }
        return flightTypeRepository.findById(id).orElse(null);
    }

    protected TipoAeronave mapTipoAeronave(Long id) {
        if (id == null) {
            return null;
        }
        return aircraftTypeRepository.findById(id).orElse(null);
    }

    protected Aeroporto mapAeroporto(Long id) {
        if (id == null) {
            return null;
        }
        return airportRepository.findById(id).orElse(null);
    }

    private FlightTypeResponse toFlightTypeResponse(TipoVoo tipoVoo) {
        if (tipoVoo == null) {
            return null;
        }
        return new FlightTypeResponse(
                tipoVoo.getId(),
                tipoVoo.getType(),
                tipoVoo.getDescription(),
                tipoVoo.getCreatedAt(),
                tipoVoo.getUpdatedAt()
        );
    }

    private AircraftTypeSimpleResponse toAircraftTypeSimpleResponse(TipoAeronave tipoAeronave) {
        if (tipoAeronave == null) {
            return null;
        }
        return new AircraftTypeSimpleResponse(
                tipoAeronave.getId(),
                tipoAeronave.getType(),
                tipoAeronave.getDescription(),
                tipoAeronave.getPassengerCapacity(),
                tipoAeronave.getAircraftCategory() != null ? tipoAeronave.getAircraftCategory().toString() : null,
                tipoAeronave.getMaxSpeed(),
                tipoAeronave.getRangeKm(),
                tipoAeronave.getCargoCapacityKg(),
                tipoAeronave.getMaxAltitudeFt()
        );
    }

    private AirportResponse toAirportResponse(Aeroporto aeroporto) {
        if (aeroporto == null) {
            return null;
        }
        return new AirportResponse(
                aeroporto.getId(),
                aeroporto.getCode(),
                aeroporto.getName(),
                aeroporto.getCity(),
                aeroporto.getState(),
                aeroporto.getCountry(),
                aeroporto.getCreatedAt(),
                aeroporto.getUpdatedAt()
        );
    }
}
