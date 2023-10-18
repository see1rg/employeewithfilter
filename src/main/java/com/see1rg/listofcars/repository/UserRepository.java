package com.see1rg.listofcars.repository;

import com.see1rg.listofcars.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
