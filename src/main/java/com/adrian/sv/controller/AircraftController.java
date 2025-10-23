package com.adrian.sv.controller;

import com.adrian.sv.dto.request.aircraft.CreateAircraftRequest;
import com.adrian.sv.dto.request.aircraft.UpdateAircraftRequest;
import com.adrian.sv.dto.response.AircraftResponse;
import com.adrian.sv.service.AircraftService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
@AllArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AircraftResponse create(@RequestBody() CreateAircraftRequest request) {
        return this.aircraftService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public List<AircraftResponse> findAll() {
        return this.aircraftService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public AircraftResponse findById(@PathVariable("id") Long id) {
        return this.aircraftService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AircraftResponse update(@PathVariable("id") Long id, @RequestBody UpdateAircraftRequest request) {
        return this.aircraftService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.aircraftService.delete(id);
    }
}
