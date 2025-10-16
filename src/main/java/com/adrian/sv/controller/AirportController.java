package com.adrian.sv.controller;

import com.adrian.sv.dto.request.airport.CreateAirportRequest;
import com.adrian.sv.dto.request.airport.UpdateAirportRequest;
import com.adrian.sv.model.entity.Aeroporto;
import com.adrian.sv.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport")
@AllArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @PostMapping
    public Aeroporto create(@RequestBody() CreateAirportRequest request) {
        return this.airportService.create(request);
    }

    @GetMapping
    public List<Aeroporto> findAll() {
        return this.airportService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Aeroporto> findById(@PathVariable("id") Long id) {
        return this.airportService.findById(id);
    }

    @PutMapping("/{id}")
    public Aeroporto update(@PathVariable("id") Long id, @RequestBody() UpdateAirportRequest request) {
        return this.airportService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.airportService.delete(id);
    }
}
