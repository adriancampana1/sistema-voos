package com.adrian.sv.controller;

import com.adrian.sv.dto.request.employee.CreateEmployeeRequest;
import com.adrian.sv.dto.request.employee.UpdateEmployeeRequest;
import com.adrian.sv.dto.response.EmployeeResponse;
import com.adrian.sv.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public EmployeeResponse create(@RequestBody() CreateEmployeeRequest request) {
        return this.employeeService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public List<EmployeeResponse> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public EmployeeResponse findById(@PathVariable("id") Long id) {
        return this.employeeService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public EmployeeResponse update(@PathVariable("id") Long id, @RequestBody() UpdateEmployeeRequest request) {
        return this.employeeService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.employeeService.delete(id);
    }
}
