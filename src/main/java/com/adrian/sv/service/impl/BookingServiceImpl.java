package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.booking.CreateBookingRequest;
import com.adrian.sv.dto.request.booking.UpdateBookingRequest;
import com.adrian.sv.dto.response.BookingResponse;
import com.adrian.sv.model.entity.Passageiro;
import com.adrian.sv.model.entity.Reserva;
import com.adrian.sv.model.entity.Voo;
import com.adrian.sv.model.mapper.BookingMapper;
import com.adrian.sv.repository.BookingRepository;
import com.adrian.sv.repository.PassengerRepository;
import com.adrian.sv.repository.FlightRepository;
import com.adrian.sv.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    @Override
    public BookingResponse create(CreateBookingRequest request) {
        try {
            Passageiro passageiro = this.passengerRepository.findById(request.idPassenger())
                    .orElseThrow(() -> new BadRequestException("Passageiro não encontrado"));

            Voo voo = this.flightRepository.findById(request.idFlight())
                    .orElseThrow(() -> new BadRequestException("Voo não encontrado"));

            Reserva booking = this.bookingMapper.toEntity(request);
            booking.setPassageiro(passageiro);
            booking.setVoo(voo);

            if (booking.getBookingNumber() == null || booking.getBookingNumber().isBlank()) {
                booking.setBookingNumber(generateBookingNumber());
            }

            // Normalize payment method to lowercase
            if (booking.getPaymentMethod() != null) {
                booking.setPaymentMethod(booking.getPaymentMethod().toLowerCase());
            }

            Reserva savedBooking = this.bookingRepository.save(booking);
            return this.bookingMapper.toResponseDTO(savedBooking);
        } catch (Exception e) {
            log.error("Falha ao criar reserva. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar reserva.");
        }
    }

    private String generateBookingNumber() {
        return "BK" + Instant.now().getEpochSecond() + "-" + UUID.randomUUID().toString().substring(0, 8);
    }

    @Override
    public List<BookingResponse> findAll() {
        try {
            List<Reserva> bookings = this.bookingRepository.findAll();
            return bookings.stream().map(this.bookingMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar reservas. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar reservas.");
        }
    }

    @Override
    public BookingResponse findById(Long id) {
        try {
            Reserva booking = this.bookingRepository.findById(id).orElseThrow(() -> new BadRequestException("Reserva não encontrada"));
            return this.bookingMapper.toResponseDTO(booking);
        } catch (Exception e) {
            log.error("Falha ao buscar reserva. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar reserva.");
        }
    }

    @Override
    public BookingResponse update(Long id, UpdateBookingRequest request) {
        try {
            Reserva booking = this.bookingRepository.findById(id).orElseThrow(() -> new BadRequestException("Reserva não encontrada"));
            this.bookingMapper.updateEntity(request, booking);
            Reserva updatedBooking = this.bookingRepository.save(booking);
            return this.bookingMapper.toResponseDTO(updatedBooking);
        } catch (Exception e) {
            log.error("Falha ao atualizar reserva. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar reserva.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Reserva booking = this.bookingRepository.findById(id).orElseThrow(() -> new BadRequestException("Reserva não encontrada"));
            this.bookingRepository.delete(booking);
        } catch (Exception e) {
            log.error("Falha ao deletar reserva. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao deletar reserva.");
        }
    }
}
