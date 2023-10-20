package com.see1rg.listofcars.mapper;

import com.see1rg.listofcars.model.entity.Department;
import com.see1rg.listofcars.model.entity.Employee;
import com.see1rg.listofcars.model.entity.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EmployeeMapper {

    @Mapping(target = "departmentId", source = "departmentId.id")
    EmployeeDTO toEmployeeDTO(Employee employee);

    @Mapping(target = "image", ignore = true)
    @Mapping(target = "data", ignore = true)
    @Mapping(target = "dateOfLastModification", ignore = true)
    @Mapping(target = "departmentId", source = "departmentId.id")
    @Mapping(target = "id", source = "employeeDTO.id")
    @Mapping(target = "description", source = "employeeDTO.description")
    Employee toEmployee(EmployeeDTO employeeDTO, Department departmentId);

    default Department map(Integer id) {
        if (id == null) {
            return null;
        }
        Department department = new Department();
        department.setId(id);
        return department;
    }

}
