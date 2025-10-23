package com.adrian.sv.controller;

import com.adrian.sv.dto.request.flight.CreateFlightRequest;
import com.adrian.sv.dto.request.flight.UpdateFlightRequest;
import com.adrian.sv.dto.response.FlightResponse;
import com.adrian.sv.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@AllArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public FlightResponse create(@RequestBody() CreateFlightRequest request) {
        return this.flightService.create(request);
    }

    @GetMapping
    public List<FlightResponse> findAll() {
        return this.flightService.findAll();
    }

    @GetMapping("/{id}")
    public FlightResponse findById(@PathVariable("id") Long id) {
        return this.flightService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public FlightResponse update(@PathVariable("id") Long id, @RequestBody() UpdateFlightRequest request) {
        return this.flightService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.flightService.delete(id);
    }
}
