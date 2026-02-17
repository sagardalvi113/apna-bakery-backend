package com.highway.bakery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

record LoginReq(String email, String password) {}

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Simple, minimal login to satisfy frontend admin flow.
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginReq req) {
        // Credentials match the seeded admin used in frontend by default
        if ("admin@bakery.com".equalsIgnoreCase(req.email()) && "admin123".equals(req.password())) {
            return ResponseEntity.ok(Map.of(
                    "token", "admin-token",
                    "name", "Admin",
                    "email", "admin@bakery.com",
                    "role", "ADMIN"
            ));
        }
        return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
    }
}
