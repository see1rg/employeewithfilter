package com.see1rg.listofcars.service;

import com.see1rg.listofcars.exception.EmployeeNotFoundException;
import com.see1rg.listofcars.mapper.EmployeeMapper;
import com.see1rg.listofcars.model.EmployeePage;
import com.see1rg.listofcars.model.EmployeeSearchCriteria;
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
    private final EmployeeCriteriaRepository employeeCriteriaRepository;
    private final EmployeeMapper employeeMapper;
    private static final Logger log = getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeCriteriaRepository employeeCriteriaRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
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
        log.info("Delete entity with id: {}", employeeId);
        employeeRepository.deleteById(employeeId);
    }

    @Override
    @Transactional
    public Employee editEmployee(Employee employee) {

        log.info("editEmployee with department id {}", employee.getDepartmentId());

//        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
//                .isPresent() ? departmentRepository.findById(employeeDTO.getDepartmentId()).get() : null;

//        Employee employee = employeeMapper.toEmployee(employeeDTO, department);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        log.info("getEmployee {}", employeeId);
        return employeeRepository.findById(employeeId).isPresent()
                ? employeeRepository.findById(employeeId).get() : null;
    }

    @Override
    public Employee getEmployeeByFullName(String fullName) {
        return employeeRepository.findByFullName(fullName);
    }


}
