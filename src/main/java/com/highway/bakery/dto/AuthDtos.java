
package com.highway.bakery.dto;

public class AuthDtos {
    public record LoginRequest(String email, String password) {}
    public record RegisterRequest(String name, String email, String phone, String password) {}
    public record AuthResponse(String token, String name, String email, String role) {}
}
