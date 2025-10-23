package com.adrian.sv.controller;

import com.adrian.sv.dto.request.employeecategory.CreateEmployeeCategoryRequest;
import com.adrian.sv.dto.request.employeecategory.UpdateEmployeeCategoryRequest;
import com.adrian.sv.dto.response.EmployeeCategoryResponse;
import com.adrian.sv.service.EmployeeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-categories")
@RequiredArgsConstructor
public class EmployeeCategoryController {

    private final EmployeeCategoryService employeeCategoryService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public EmployeeCategoryResponse create (@RequestBody() CreateEmployeeCategoryRequest request) {
        return this.employeeCategoryService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public List<EmployeeCategoryResponse> findAll() {
        return this.employeeCategoryService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public EmployeeCategoryResponse findById(@PathVariable("id") Long id) {
        return this.employeeCategoryService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public EmployeeCategoryResponse update(@PathVariable("id") Long id, @RequestBody() UpdateEmployeeCategoryRequest request) {
        return this.employeeCategoryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        this.employeeCategoryService.delete(id);
    }
}