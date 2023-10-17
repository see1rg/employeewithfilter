-- liquibase formatted sql

-- changeSet see1rg:1

CREATE TABLE users (
                       user_id INT PRIMARY KEY,
                       full_name VARCHAR(255),
                       username VARCHAR(50) UNIQUE,
                       password VARCHAR(255)
);

CREATE TABLE cars (
                      id INT PRIMARY KEY,
                      name VARCHAR(255),
                      body_type VARCHAR(15),
                      year INT,
                      price DECIMAL(10, 2),
                      date DATE,
                      date_time TIMESTAMP,
                      car_description_id INT,
                      image BYTEA,
                      data BYTEA,
                      parent_id INT,
                      FOREIGN KEY (parent_id) REFERENCES cars(id)
);

CREATE TABLE car_description (
                                 id INT PRIMARY KEY,
                                 name VARCHAR(255),
                                 brand VARCHAR(50),
                                 model VARCHAR(50),
                                 year INT,
                                 engine_type VARCHAR(50),
                                 horse_power INT,
                                 cars_id INT,
                                 FOREIGN KEY (cars_id) REFERENCES cars(id)
);
