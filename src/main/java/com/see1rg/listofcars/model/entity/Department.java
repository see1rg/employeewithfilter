package com.see1rg.listofcars.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 55)
    @NotEmpty
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp creationDate;


    @Column(name = "employee_id")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departmentId")
    @JsonIgnore
    private List<Employee> employee;

    public Department(Integer id, String name,
                      String description, Timestamp creationDate,
                      List<Employee> employee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.employee = employee;
    }

    public Department() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

