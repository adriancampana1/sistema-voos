package com.adrian.sv.controller;

import com.adrian.sv.dto.request.flightcrew.CreateFlightCrewRequest;
import com.adrian.sv.dto.request.flightcrew.UpdateFlightCrewRequest;
import com.adrian.sv.dto.response.FlightCrewResponse;
import com.adrian.sv.service.FlightCrewService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight-crews")
@AllArgsConstructor
public class FlightCrewController {

    private final FlightCrewService flightCrewService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public FlightCrewResponse create(@RequestBody() CreateFlightCrewRequest request) {
        return this.flightCrewService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public List<FlightCrewResponse> findAll() {
        return this.flightCrewService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public FlightCrewResponse findById(@PathVariable("id") Long id) {
        return this.flightCrewService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public FlightCrewResponse update(@PathVariable("id") Long id, @RequestBody() UpdateFlightCrewRequest request) {
        return this.flightCrewService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.flightCrewService.delete(id);
    }
}
