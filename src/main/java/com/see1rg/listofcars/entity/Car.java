package com.see1rg.listofcars.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "date")
    private Date date;

    @Column(name = "date_time")
    private Timestamp dateTime;

    @Column(name = "car_description_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cars")
    private CarDescription carDescriptionId;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Lob
    @Column(name = "data")
    private byte[] data;
    @Column(name = "parent_id")
    @Pattern(regexp = "^[0-9]*$", message = "Parent ID must be numeric")
    private Long parentId;
}
