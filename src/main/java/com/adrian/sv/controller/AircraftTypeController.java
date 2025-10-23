package com.adrian.sv.controller;

import com.adrian.sv.dto.request.aircrafttype.CreateAircraftTypeRequest;
import com.adrian.sv.dto.request.aircrafttype.UpdateAircraftTypeRequest;
import com.adrian.sv.dto.response.AircraftTypeResponse;
import com.adrian.sv.service.AircraftTypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft-types")
@AllArgsConstructor
public class AircraftTypeController {

    private final AircraftTypeService aircraftTypeService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AircraftTypeResponse create(@RequestBody() CreateAircraftTypeRequest request) {
        return this.aircraftTypeService.create(request);
    }

    @GetMapping
    public List<AircraftTypeResponse> findAll() {
        return this.aircraftTypeService.findAll();
    }

    @GetMapping("/{id}")
    public AircraftTypeResponse findById(@PathVariable("id") Long id) {
        return this.aircraftTypeService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AircraftTypeResponse update(@PathVariable("id") Long id, @RequestBody UpdateAircraftTypeRequest request) {
        return this.aircraftTypeService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.aircraftTypeService.delete(id);
    }
}
