package com.see1rg.listofcars.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "manager") //parent
    @Digits(integer = 10, fraction = 0, message = "Parent ID must be a numeric value")
    private Integer managerId;

    @Column(name = "creation_date")
    @JsonIgnore
    private Timestamp dateOfLastModification;

    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({CascadeType.PERSIST})
    private Department departmentId;

    @Lob
    @Column(name = "image", columnDefinition = "bytea")
    @Transient
    private byte[] image; //todo

    @Lob
    @Column(name = "data", columnDefinition = "bytea")
    @Transient
    private byte[] data; //todo

    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Timestamp getDateOfLastModification() {
        return dateOfLastModification;
    }


    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                ", managerId=" + managerId +
                ", dateOfLastModification=" + dateOfLastModification +
                ", departmentId=" + departmentId +
                ", image=" + Arrays.toString(image) +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
