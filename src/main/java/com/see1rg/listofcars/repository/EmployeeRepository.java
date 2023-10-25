package com.see1rg.listofcars.repository;

import com.see1rg.listofcars.model.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findByFullName(String fullName);
}
