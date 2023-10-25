package com.see1rg.listofcars.controller;

import com.see1rg.listofcars.model.entity.Department;
import com.see1rg.listofcars.service.DepartmentService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DepartmentController {
    private final DepartmentService departmentService;
    private static final Logger log = getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
//    @PreAuthorize("hasRole('ROLE_LIST_VIEW')")
    public List<Department> getDepartmentList() {

        log.info("getDepartmentList");

        return departmentService.findAll();
    }
}
