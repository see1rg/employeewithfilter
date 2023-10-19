package com.see1rg.listofcars.entity.dto;

import com.see1rg.listofcars.entity.Role;

import java.util.Objects;

public class RegisterReq {
    private String username;
    private String password;
    private String fullName;
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterReq that = (RegisterReq) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(fullName, that.fullName) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, fullName, role);
    }
}
