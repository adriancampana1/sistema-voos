package com.adrian.sv.controller;

import com.adrian.sv.dto.request.connection.CreateConnectionRequest;
import com.adrian.sv.dto.request.connection.UpdateConnectionRequest;
import com.adrian.sv.dto.response.ConnectionResponse;
import com.adrian.sv.service.ConnectionService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
@AllArgsConstructor
public class ConnectionController {

    private final ConnectionService connectionService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ConnectionResponse create(@RequestBody() CreateConnectionRequest request) {
        return this.connectionService.create(request);
    }

    @GetMapping
    public List<ConnectionResponse> findAll() {
        return this.connectionService.findAll();
    }

    @GetMapping("/{id}")
    public ConnectionResponse findById(@PathVariable("id") Long id) {
        return this.connectionService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ConnectionResponse update(@PathVariable("id") Long id, @RequestBody() UpdateConnectionRequest request) {
        return this.connectionService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.connectionService.delete(id);
    }
}
