package com.adrian.sv.service;

import com.adrian.sv.dto.request.employee.CreateEmployeeRequest;
import com.adrian.sv.dto.request.employee.UpdateEmployeeRequest;
import com.adrian.sv.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse create(CreateEmployeeRequest request);
    List<EmployeeResponse> findAll();
    EmployeeResponse findById(Long id);
    EmployeeResponse update(Long id, UpdateEmployeeRequest request);
    void delete(Long id);
}
