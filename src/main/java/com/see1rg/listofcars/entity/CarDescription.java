package com.see1rg.listofcars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_description")
public class CarDescription {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "engine_type", length = 50)
    private String engineType;

    @Column(name = "horse_power")
    private Integer horsePower;

    @Column(name = "cars_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cars")
    private Car car;

}

