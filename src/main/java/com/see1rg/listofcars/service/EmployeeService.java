package com.see1rg.listofcars.service;

import com.see1rg.listofcars.model.EmployeePage;
import com.see1rg.listofcars.model.EmployeeSearchCriteria;
import com.see1rg.listofcars.model.entity.Employee;
import com.see1rg.listofcars.model.entity.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    Page<EmployeeDTO> findAllWithFilters(EmployeePage employeePage,
                                         EmployeeSearchCriteria employeeSearchCriteria);

    EmployeeDTO getEmployeeForEdit(Integer employeeId);

    void deleteEmployee(Integer employeeId);

    Employee editEmployee(Employee employee);

    Employee getEmployee(Integer employeeId);

    Employee getEmployeeByFullName(String fullName);
}
