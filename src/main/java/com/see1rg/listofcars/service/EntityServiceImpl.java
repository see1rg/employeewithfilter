package com.see1rg.listofcars.service;

import com.see1rg.listofcars.repository.DepartmentRepository;
import com.see1rg.listofcars.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl implements EntityService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    public EntityServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public void deleteEntity(String entityType, Integer entityId) {

        if ("employee".equalsIgnoreCase(entityType)) {
            employeeRepository.deleteById(entityId);
        } else if ("department".equalsIgnoreCase(entityType)) {
            departmentRepository.deleteById(entityId);
        } else {
            throw new IllegalArgumentException("Invalid entity type");
        }
    }
}
