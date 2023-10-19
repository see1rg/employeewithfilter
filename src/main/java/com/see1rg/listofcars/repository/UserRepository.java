package com.see1rg.listofcars.repository;

import com.see1rg.listofcars.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String userName);
    Optional<User> findByUsernameIgnoreCase(String userName);
}