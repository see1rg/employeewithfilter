-- Вставляем данные в таблицу "cars"
INSERT INTO cars (car_id, name, description, brand, model, year, engine_type, integer_field, decimal_field, date_field, date_time_field, simple_reference_id, tree_reference_id, image, bytea_data)
VALUES
    (1, 'Car 1', 'Description 1', 'Toyota', 'Camry', 2022, 'Бензин', 100, 25000.00, '2023-10-17', '2023-10-17 12:00:00', 1, 3, E'\\x', E'\\x'),
    (2, 'Car 2', 'Description 2', 'Honda', 'Civic', 2023, 'Дизель', 200, 32000.50, '2023-10-18', '2023-10-18 14:30:00', 2, 4, E'\\x', E'\\x'),
    (3, 'Car 3', 'Description 3', 'Ford', 'Mustang', 2021, 'Бензин', 150, 35000.75, '2023-10-19', '2023-10-19 10:45:00', 3, 5, E'\\x', E'\\x'),
    (4, 'Car 4', 'Description 4', 'Chevrolet', 'Cruze', 2022, 'Дизель', 180, 28000.25, '2023-10-20', '2023-10-20 16:15:00', 4, 6, E'\\x', E'\\x'),
    (5, 'Car 5', 'Description 5', 'Volkswagen', 'Golf', 2023, 'Бензин', 110, 29000.00, '2023-10-21', '2023-10-21 09:30:00', 5, 7, E'\\x', E'\\x'),
    (6, 'Car 6', 'Description 6', 'Nissan', 'Altima', 2022, 'Дизель', 160, 33000.50, '2023-10-22', '2023-10-22 11:20:00', 6, 8, E'\\x', E'\\x'),
    (7, 'Car 7', 'Description 7', 'Hyundai', 'Elantra', 2023, 'Бензин', 120, 27000.75, '2023-10-23', '2023-10-23 13:40:00', 7, 9, E'\\x', E'\\x'),
    (8, 'Car 8', 'Description 8', 'Kia', 'Optima', 2021, 'Дизель', 170, 31000.25, '2023-10-24', '2023-10-24 15:10:00', 8, 10, E'\\x', E'\\x'),
    (9, 'Car 9', 'Description 9', 'Mazda', 'Mazda3', 2022, 'Бензин', 130, 26000.00, '2023-10-25', '2023-10-25 08:50:00', 9, 1, E'\\x', E'\\x'),
    (10, 'Car 10', 'Description 10', 'Subaru', 'Impreza', 2023, 'Дизель', 190, 30000.50, '2023-10-26', '2023-10-26 10:30:00', 10, 2, E'\\x', E'\\x'),
    (11, 'Car 11', 'Description 11', 'Audi', 'A4', 2021, 'Бензин', 140, 34000.25, '2023-10-27', '2023-10-27 17:20:00', 1, 3, E'\\x', E'\\x'),
    (12, 'Car 12', 'Description 12', 'BMW', '3 Series', 2022, 'Дизель', 150, 29000.00, '2023-10-28', '2023-10-28 08:30:00', 2, 4, E'\\x', E'\\x'),
    (13, 'Car 13', 'Description 13', 'Mercedes-Benz', 'E-Class', 2023, 'Бензин', 110, 32000.50, '2023-10-29', '2023-10-29 12:15:00', 3, 5, E'\\x', E'\\x'),
    (14, 'Car 14', 'Description 14', 'Lexus', 'RX', 2021, 'Дизель', 120, 31000.75, '2023-10-30', '2023-10-30 14:45:00', 4, 6, E'\\x', E'\\x'),
    (15, 'Car 15', 'Description 15', 'Acura', 'MDX', 2022, 'Бензин', 130, 27000.25, '2023-10-31', '2023-10-31 11:30:00', 5, 7, E'\\x', E'\\x'),
    (16, 'Car 16', 'Description 16', 'Infiniti', 'Q50', 2023, 'Дизель', 160, 35000.00, '2023-11-01', '2023-11-01 09:00:00', 6, 8, E'\\x', E'\\x'),
    (17, 'Car 17', 'Description 17', 'Volvo', 'S60', 2021, 'Бензин', 170, 26000.50, '2023-11-02', '2023-11-02 13:20:00', 7, 9, E'\\x', E'\\x'),
    (18, 'Car 18', 'Description 18', 'Jaguar', 'XF', 2022, 'Дизель', 180, 29000.25, '2023-11-03', '2023-11-03 15:40:00', 8, 10, E'\\x', E'\\x'),
    (19, 'Car 19', 'Description 19', 'Porsche', 'Panamera', 2023, 'Бензин', 190, 33000.50, '2023-11-04', '2023-11-04 10:10:00', 9, 1, E'\\x', E'\\x'),
    (20, 'Car 20', 'Description 20', 'Land Rover', 'Range Rover', 2021, 'Дизель', 140, 30000.75, '2023-11-05', '2023-11-05 11:50:00', 10, 2, E'\\x', E'\\x'),
    (21, 'Car 21', 'Description 21', 'Tesla', 'Model 3', 2022, 'Бензин', 150, 28000.25, '2023-11-06', '2023-11-06 14:30:00', 1, 3, E'\\x', E'\\x'),
    (22, 'Car 22', 'Description 22', 'Mitsubishi', 'Outlander', 2023, 'Дизель', 110, 29000.00, '2023-11-07', '2023-11-07 16:20:00', 2, 4, E'\\x', E'\\x'),
    (23, 'Car 23', 'Description 23', 'Jeep', 'Cherokee', 2021, 'Бензин', 160, 31000.50, '2023-11-08', '2023-11-08 09:40:00', 3, 5, E'\\x', E'\\x'),
    (24, 'Car 24', 'Description 24', 'Subaru', 'Forester', 2022, 'Дизель', 120, 33000.25, '2023-11-09', '2023-11-09 12:10:00', 4, 6, E'\\x', E'\\x'),
    (25, 'Car 25', 'Description 25', 'Audi', 'Q5', 2023, 'Бензин', 190, 35000.00, '2023-11-10', '2023-11-10 13:45:00', 5, 7, E'\\x', E'\\x'),
    (26, 'Car 26', 'Description 26', 'Volkswagen', 'Tiguan', 2021, 'Дизель', 170, 26000.50, '2023-11-11', '2023-11-11 15:30:00', 6, 8, E'\\x', E'\\x'),
    (27, 'Car 27', 'Description 27', 'Toyota', 'Rav4', 2022, 'Бензин', 130, 28000.25, '2023-11-12', '2023-11-12 10:20:00', 7, 9, E'\\x', E'\\x'),
    (28, 'Car 28', 'Description 28', 'Honda', 'HR-V', 2023, 'Дизель', 140, 30000.75, '2023-11-13', '2023-11-13 14:50:00', 8, 10, E'\\x', E'\\x'),
    (29, 'Car 29', 'Description 29', 'Ford', 'Escape', 2021, 'Бензин', 180, 33000.50, '2023-11-14', '2023-11-14 09:10:00', 9, 1, E'\\x', E'\\x'),
    (30, 'Car 30', 'Description 30', 'Chevrolet', 'Traverse', 2022, 'Дизель', 110, 29000.00, '2023-11-15', '2023-11-15 11:40:00', 10, 2, E'\\x', E'\\x'),
    (31, 'Car 31', 'Description 31', 'Nissan', 'Rogue', 2023, 'Бензин', 160, 31000.25, '2023-11-16', '2023-11-16 15:30:00', 1, 3, E'\\x', E'\\x'),
    (32, 'Car 32', 'Description 32', 'Hyundai', 'Tucson', 2021, 'Дизель', 120, 27000.75, '2023-11-17', '2023-11-17 13:20:00', 2, 4, E'\\x', E'\\x'),
    (33, 'Car 33', 'Description 33', 'Kia', 'Sportage', 2022, 'Бензин', 140, 32000.50, '2023-11-18', '2023-11-18 14:50:00', 3, 5, E'\\x', E'\\x'),
    (34, 'Car 34', 'Description 34', 'Mazda', 'CX-5', 2023, 'Дизель', 170, 34000.25, '2023-11-19', '2023-11-19 10:40:00', 4, 6, E'\\x', E'\\x'),
    (35, 'Car 35', 'Description 35', 'Subaru', 'Outback', 2021, 'Бензин', 130, 30000.00, '2023-11-20', '2023-11-20 12:00:00', 5, 7, E'\\x', E'\\x'),
    (36, 'Car 36', 'Description 36', 'Audi', 'Q7', 2022, 'Дизель', 180, 33000.50, '2023-11-21', '2023-11-21 16:30:00', 6, 8, E'\\x', E'\\x'),
    (37, 'Car 37', 'Description 37', 'BMW', 'X5', 2023, 'Бензин', 190, 27000.75, '2023-11-22', '2023-11-22 09:50:00', 7, 9, E'\\x', E'\\x'),
    (38, 'Car 38', 'Description 38', 'Mercedes-Benz', 'GLC', 2021, 'Дизель', 110, 31000.25, '2023-11-23', '2023-11-23 15:20:00', 8, 10, E'\\x', E'\\x'),
    (39, 'Car 39', 'Description 39', 'Lexus', 'NX', 2022, 'Бензин', 150, 32000.50, '2023-11-24', '2023-11-24 11:10:00', 9, 1, E'\\x', E'\\x'),
    (40, 'Car 40', 'Description 40', 'Acura', 'RDX', 2023, 'Дизель', 160, 29000.00, '2023-11-25', '2023-11-25 13:40:00', 10, 2, E'\\x', E'\\x'),
    (41, 'Car 41', 'Description 41', 'Infiniti', 'QX60', 2021, 'Бензин', 120, 33000.25, '2023-11-26', '2023-11-26 10:20:00', 1, 3, E'\\x', E'\\x'),
    (42, 'Car 42', 'Description 42', 'Volvo', 'XC90', 2022, 'Дизель', 170, 31000.50, '2023-11-27', '2023-11-27 14:00:00', 2, 4, E'\\x', E'\\x'),
    (43, 'Car 43', 'Description 43', 'Jaguar', 'F-PACE', 2023, 'Бензин', 140, 29000.25, '2023-11-28', '2023-11-28 11:30:00', 3, 5, E'\\x', E'\\x'),
    (44, 'Car 44', 'Description 44', 'Porsche', 'Cayenne', 2021, 'Дизель', 150, 35000.00, '2023-11-29', '2023-11-29 09:50:00', 4, 6, E'\\x', E'\\x'),
    (45, 'Car 45', 'Description 45', 'Land Rover', 'Discovery', 2022, 'Бензин', 130, 32000.50, '2023-11-30', '2023-11-30 15:10:00', 5, 7, E'\\x', E'\\x'),
    (46, 'Car 46', 'Description 46', 'Tesla', 'Model S', 2023, 'Дизель', 120, 28000.25, '2023-12-01', '2023-12-01 10:40:00', 6, 8, E'\\x', E'\\x'),
    (47, 'Car 47', 'Description 47', 'Mitsubishi', 'Eclipse Cross', 2021, 'Бензин', 140, 29000.00, '2023-12-02', '2023-12-02 12:20:00', 7, 9, E'\\x', E'\\x'),
    (48, 'Car 48', 'Description 48', 'Jeep', 'Renegade', 2022, 'Дизель', 160, 31000.75, '2023-12-03', '2023-12-03 14:30:00', 8, 10, E'\\x', E'\\x'),
    (49, 'Car 49', 'Description 49', 'Subaru', 'Crosstrek', 2023, 'Бензин', 180, 33000.50, '2023-12-04', '2023-12-04 11:10:00', 9, 1, E'\\x', E'\\x'),
    (50, 'Car 50', 'Description 50', 'Audi', 'Q8', 2021, 'Дизель', 170, 30000.25, '2023-12-05', '2023-12-05 13:50:00', 10, 2, E'\\x', E'\\x');