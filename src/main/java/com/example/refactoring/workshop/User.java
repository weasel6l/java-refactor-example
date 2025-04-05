package com.example.refactoring.workshop;

public class User {
    private String name;
    private String email;
    private String address;
    private String phone;
    private String role;

    public User(String name, String email, String address, String phone, String role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }
}
