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

import javax.validation.constraints.NotEmpty;
import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/data_list/employee")
    @PreAuthorize("hasAuthority('LIST_VIEW')")
    public ResponseEntity<Page<EmployeeDTO>> getEmployeeList(EmployeePage employeePage,
                                                             EmployeeSearchCriteria employeeSearchCriteria, Principal principal) {
        System.out.println(principal.getName());
        return new ResponseEntity<>(employeeService.findAllWithFilters(employeePage, employeeSearchCriteria),
                HttpStatus.OK);
    }

    @GetMapping("/get_data/employee/{employeeId}")
    @PreAuthorize("hasAuthority('ROLE_ADD')")
    public ResponseEntity<EmployeeDTO> getEmployeeForEdit(@PathVariable Integer employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeForEdit(employeeId));
    }

    @PostMapping("/edit_data/employee")
    @PreAuthorize("hasAuthority('ROLE_EDIT')")
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee) {
        employeeService.editEmployee(employee);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_data/employee/{entityId}")
    @PreAuthorize("hasAuthority('ROLE_DELETE')")
    public ResponseEntity<Void> deleteEmployee(@NotEmpty @PathVariable Integer entityId) {
        Employee employee = employeeService.getEmployee(entityId);
        if (employee != null) {
            employeeService.deleteEmployee(entityId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
