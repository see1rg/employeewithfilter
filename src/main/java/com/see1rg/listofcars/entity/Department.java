package com.see1rg.listofcars.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {
    @Id
    private Long id;

    @Column(name = "name", length = 55)
    @NotEmpty
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "cars_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cars")
    private List<Employee> employee;

}

