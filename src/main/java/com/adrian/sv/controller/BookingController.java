package com.adrian.sv.controller;

import com.adrian.sv.dto.request.booking.CreateBookingRequest;
import com.adrian.sv.dto.request.booking.UpdateBookingRequest;
import com.adrian.sv.dto.response.BookingResponse;
import com.adrian.sv.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public BookingResponse create(@RequestBody() CreateBookingRequest request) {
        return this.bookingService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public List<BookingResponse> findAll() {
        return this.bookingService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public BookingResponse findById(@PathVariable("id") Long id) {
        return this.bookingService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public BookingResponse update(@PathVariable("id") Long id, @RequestBody()UpdateBookingRequest request) {
        return this.bookingService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void delete(@PathVariable("id") Long id) {
        this.bookingService.delete(id);
    }
}
