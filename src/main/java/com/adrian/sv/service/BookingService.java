package com.adrian.sv.service;

import com.adrian.sv.dto.request.booking.CreateBookingRequest;
import com.adrian.sv.dto.request.booking.UpdateBookingRequest;
import com.adrian.sv.dto.response.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse create(CreateBookingRequest request);
    List<BookingResponse> findAll();
    BookingResponse findById(Long id);
    BookingResponse update(Long id, UpdateBookingRequest request);
    void delete(Long id);
}
