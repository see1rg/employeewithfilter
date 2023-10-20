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

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/data_list/employee")
//    @PreAuthorize("hasRole('ROLE_LIST_VIEW')")
    public ResponseEntity<Page<EmployeeDTO>> getEmployeeList(EmployeePage employeePage,
                                                             EmployeeSearchCriteria employeeSearchCriteria) {

        return new ResponseEntity<>(employeeService.findAllWithFilters(employeePage, employeeSearchCriteria),
                HttpStatus.OK);
    }

    @GetMapping("/get_data/employee/{employeeId}")
//    @PreAuthorize("hasRole('ROLE_ADD')")
    public ResponseEntity<EmployeeDTO> getEmployeeForEdit(@PathVariable Integer employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeForEdit(employeeId));
    }

    @PostMapping("/edit_data/employee")
//    @PreAuthorize("hasRole('ROLE_EDIT')")
    public ResponseEntity<Employee> editEmployee(@RequestBody EmployeeDTO employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.editEmployee(employee));
    }

    @DeleteMapping("/delete_data/employee/{entityId}")
//    @PreAuthorize("hasRole('ROLE_DELETE')")
    public ResponseEntity<String> deleteEmployee(@NotEmpty @PathVariable Integer entityId) {
        employeeService.deleteEmployee(entityId);
        return ResponseEntity.ok("Entity deleted successfully");
    }
}
