package com.adrian.sv.controller;

import com.adrian.sv.dto.request.flighttype.CreateFlightTypeRequest;
import com.adrian.sv.dto.request.flighttype.UpdateFlightTypeRequest;
import com.adrian.sv.dto.response.FlightTypeResponse;
import com.adrian.sv.service.FlightTypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight-types")
@AllArgsConstructor
public class FlightTypeController {

    private final FlightTypeService flightTypeService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public FlightTypeResponse create(@RequestBody() CreateFlightTypeRequest request) {
        return this.flightTypeService.create(request);
    }

    @GetMapping
    public List<FlightTypeResponse> findAll() {
        return this.flightTypeService.findAll();
    }

    @GetMapping("/{id}")
    public FlightTypeResponse findById(@PathVariable("id") Long id) {
        return this.flightTypeService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public FlightTypeResponse update(@PathVariable("id") Long id, @RequestBody UpdateFlightTypeRequest request) {
        return this.flightTypeService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.flightTypeService.delete(id);
    }
}
