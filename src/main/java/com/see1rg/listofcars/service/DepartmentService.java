package com.see1rg.listofcars.service;

import com.see1rg.listofcars.model.entity.Department;
import com.see1rg.listofcars.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
