package com.see1rg.listofcars.entity;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Date birthDate;

    @Column(name = "manager") //parent
    @Digits(integer = 10, fraction = 0, message = "Parent ID must be a numeric value")
    private Long managerId;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @JoinColumn(name = "dept_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Department departmentId;

    @Lob
    @Column(name = "image", columnDefinition = "bytea")
    private byte[] image;

    @Lob
    @Column(name = "data", columnDefinition = "bytea")
    private byte[] data;

    public Employee(Integer id, String fullName, String description, Integer experience, BigDecimal salary, Date birthDate, Long managerId, Timestamp creationDate, Department departmentId, byte[] image, byte[] data) {
        this.id = id;
        this.fullName = fullName;
        this.description = description;
        this.experience = experience;
        this.salary = salary;
        this.birthDate = birthDate;
        this.managerId = managerId;
        this.creationDate = creationDate;
        this.departmentId = departmentId;
        this.image = image;
        this.data = data;
    }

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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
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
}
