package com.adrian.sv.model.mapper;

import com.adrian.sv.dto.request.employee.CreateEmployeeRequest;
import com.adrian.sv.dto.request.employee.UpdateEmployeeRequest;
import com.adrian.sv.dto.response.EmployeeResponse;
import com.adrian.sv.model.entity.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EmployeeMapper {
    Funcionario toEntity(CreateEmployeeRequest request);
    EmployeeResponse toResponseDTO(Funcionario employee);
    void updateEntity(UpdateEmployeeRequest request, @MappingTarget Funcionario employee);
}
