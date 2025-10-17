package com.adrian.sv.controller;

import com.adrian.sv.dto.request.airport.CreateAirportRequest;
import com.adrian.sv.dto.request.airport.UpdateAirportRequest;
import com.adrian.sv.dto.response.AirportResponse;
import com.adrian.sv.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
@AllArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @PostMapping
    public AirportResponse create(@RequestBody() CreateAirportRequest request) {
        return this.airportService.create(request);
    }

    @GetMapping
    public List<AirportResponse> findAll() {
        return this.airportService.findAll();
    }

    @GetMapping("/{id}")
    public AirportResponse findById(@PathVariable("id") Long id) {
        return this.airportService.findById(id);
    }

    @PutMapping("/{id}")
    public AirportResponse update(@PathVariable("id") Long id, @RequestBody() UpdateAirportRequest request) {
        return this.airportService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.airportService.delete(id);
    }
}
