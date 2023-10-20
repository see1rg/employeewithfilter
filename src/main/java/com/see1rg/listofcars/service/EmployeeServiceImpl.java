package com.see1rg.listofcars.service;

import com.see1rg.listofcars.exception.EmployeeNotFoundException;
import com.see1rg.listofcars.mapper.EmployeeMapper;
import com.see1rg.listofcars.model.EmployeePage;
import com.see1rg.listofcars.model.EmployeeSearchCriteria;
import com.see1rg.listofcars.model.entity.Department;
import com.see1rg.listofcars.model.entity.Employee;
import com.see1rg.listofcars.model.entity.dto.EmployeeDTO;
import com.see1rg.listofcars.repository.DepartmentRepository;
import com.see1rg.listofcars.repository.EmployeeCriteriaRepository;
import com.see1rg.listofcars.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeCriteriaRepository employeeCriteriaRepository;
    private final EmployeeMapper employeeMapper;
    private static final Logger log = getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmployeeCriteriaRepository employeeCriteriaRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeCriteriaRepository = employeeCriteriaRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Page<EmployeeDTO> findAllWithFilters(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria) {
        log.info("findAllWithFilters");
        return employeeCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
    }

    @Override
    @Transactional
    public EmployeeDTO getEmployeeForEdit(Integer employeeId) {
        log.info("getEmployeeForEdit");

        if (!employeeRepository.existsById(employeeId)) {
            throw new EmployeeNotFoundException();
        }

        Employee employee = employeeRepository.findById(employeeId).get();

        return employeeMapper.toEmployeeDTO(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {

        if (!employeeRepository.existsById(employeeId)) {
            throw new EmployeeNotFoundException();
        }

        log.info("Delete entity with id: {}", employeeId);
        employeeRepository.deleteById(employeeId);
    }

    @Override
    @Transactional
    public Employee editEmployee(EmployeeDTO employee) {
        log.info("editEmployee {}", employee);

            Department department = departmentRepository.findById(employee.getDepartmentId())
                    .isPresent() ? departmentRepository.findById(employee.getDepartmentId()).get() : null;

            log.info("department {}", department);

            Employee mapperEmployee = employeeMapper.toEmployee(employee, department);

            log.info("mapperEmployee {}", mapperEmployee);

            return employeeRepository.save(mapperEmployee);
    }


}
