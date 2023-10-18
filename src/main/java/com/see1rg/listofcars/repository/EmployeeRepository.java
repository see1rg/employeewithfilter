package com.see1rg.listofcars.repository;

import com.see1rg.listofcars.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
