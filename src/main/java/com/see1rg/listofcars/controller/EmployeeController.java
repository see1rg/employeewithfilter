package com.see1rg.listofcars.controller;

import com.see1rg.listofcars.model.EmployeePage;
import com.see1rg.listofcars.model.EmployeeSearchCriteria;
import com.see1rg.listofcars.model.entity.Employee;
import com.see1rg.listofcars.model.entity.dto.EmployeeDTO;
import com.see1rg.listofcars.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/data_list")
    @PreAuthorize("hasRole('ROLE_LIST_VIEW')")
    public ResponseEntity<Page<EmployeeDTO>> getEmployeeList(EmployeePage employeePage,
                                                             EmployeeSearchCriteria employeeSearchCriteria) {

        return new ResponseEntity<>(employeeService.findAllWithFilters(employeePage, employeeSearchCriteria),
                HttpStatus.OK);
    }

    @GetMapping("/get_data")
    @PreAuthorize("hasRole('ROLE_ADD')")
    public ResponseEntity<Employee> getEmployeeForEdit(@RequestParam Long id) {

        return null;
    }

    @PostMapping("/edit_data")
    @PreAuthorize("hasRole('ROLE_EDIT')")
    public ResponseEntity<String> editEmployee(@RequestBody Employee data) {

        return null;
    }

    @DeleteMapping("/delete_data")
    @PreAuthorize("hasRole('ROLE_DELETE')")
    public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {

        return null;
    }
}
