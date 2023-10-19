-- liquibase formatted sql

-- changeSet see1rg:1

-- Таблица "Пользователи"
create table if not exists users (
                       id serial primary key,
                       full_name varchar(255),
                       username varchar(50) UNIQUE,
                       email varchar(50) UNIQUE,
                       password varchar(255),
                       role varchar(12)
);

-- Таблица "Departments"
create table if not exists departments (
                                           id serial primary key,
                                           name varchar(55) not null,
                                           description text,
                                           creation_date timestamp not null default current_timestamp
);

-- Таблица "Сотрудники"
create table if not exists employees (
                                         id serial primary key,
                                         full_name varchar(255),
                                         description text,
                                         experience int,
                                         salary numeric(10, 2),
                                         birth_date timestamp,
                                         manager int, --parent
                                         creation_date timestamp not null default current_timestamp,
                                         dept_id int,
                                         image bytea,
                                         data bytea,
                                         constraint employees_departments_fk foreign key (dept_id) references departments (id) on update cascade on delete cascade
);
