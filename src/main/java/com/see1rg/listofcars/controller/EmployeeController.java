package com.see1rg.listofcars.controller;

import com.see1rg.listofcars.entity.Employee;
import com.see1rg.listofcars.service.EmployeeService;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
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


//    @GetMapping("/data_list")
////    @PreAuthorize("hasRole('ROLE_LIST_VIEW')")
//    public Iterable<Employee> getEmployeeList(
//            @QuerydslPredicate(root = Employee.class) Predicate predicate) {
//
//        return employeeService.getDataWithFilterAndSorting(predicate);
//    }

    @GetMapping("/get_data")
    @PreAuthorize("hasRole('ROLE_EDIT')")
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
