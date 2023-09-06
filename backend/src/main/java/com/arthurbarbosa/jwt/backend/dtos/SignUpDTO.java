package com.arthurbarbosa.jwt.backend.dtos;

public record SignUpDTO(String firstName, String lastName, String login, char[] password) {
}
