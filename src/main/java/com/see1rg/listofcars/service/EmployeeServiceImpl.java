package com.see1rg.listofcars.service;

import com.see1rg.listofcars.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @Override
//    public Iterable<Employee> getDataWithFilterAndSorting(Predicate predicate) {
//
//        return employeeRepository.findAll(predicate);
//    }
}
