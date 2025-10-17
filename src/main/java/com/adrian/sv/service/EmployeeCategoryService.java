package com.adrian.sv.service;

import com.adrian.sv.dto.request.employeecategory.CreateEmployeeCategoryRequest;
import com.adrian.sv.dto.request.employeecategory.UpdateEmployeeCategoryRequest;
import com.adrian.sv.dto.response.EmployeeCategoryResponse;

import java.util.List;

public interface EmployeeCategoryService {
    EmployeeCategoryResponse create(CreateEmployeeCategoryRequest request);
    List<EmployeeCategoryResponse> findAll();
    EmployeeCategoryResponse findById(Long id);
    EmployeeCategoryResponse update(Long id, UpdateEmployeeCategoryRequest request);
    void delete(Long id);
}
