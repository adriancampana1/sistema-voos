package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.employeecategory.CreateEmployeeCategoryRequest;
import com.adrian.sv.dto.request.employeecategory.UpdateEmployeeCategoryRequest;
import com.adrian.sv.dto.response.EmployeeCategoryResponse;
import com.adrian.sv.model.entity.CategoriaFuncionario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EmployeeCategoryMapper {
    CategoriaFuncionario toEntity(CreateEmployeeCategoryRequest request);
    EmployeeCategoryResponse toResponseDTO(CategoriaFuncionario employeeCategory);
    void updateEntity(UpdateEmployeeCategoryRequest request, @MappingTarget CategoriaFuncionario employeeCategory);
}
