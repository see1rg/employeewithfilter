package com.see1rg.listofcars.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    @NotEmpty
    private String fullName;

    @Column(name = "description")
    private String description;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "salary", precision = 10, scale = 2)
    @Positive
    private BigDecimal salary;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "manager") //parent
    @Pattern(regexp = "^[0-9]*$", message = "Parent ID must be numeric")
    private Long managerId;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @JoinColumn(name = "dept_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Department departmentId;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Lob
    @Column(name = "data")
    private byte[] data;
}
