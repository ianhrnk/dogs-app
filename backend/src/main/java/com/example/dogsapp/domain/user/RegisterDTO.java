package com.example.dogsapp.domain.user;

public record RegisterDTO(String email, String password, UserRole role, String cep, String city,
    String state, String street, String streetNumber) {
}
