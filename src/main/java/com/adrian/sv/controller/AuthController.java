package com.adrian.sv.controller;

import com.adrian.sv.dto.request.auth.LoginRequest;
import com.adrian.sv.dto.request.auth.RefreshTokenRequest;
import com.adrian.sv.dto.request.auth.RegisterRequest;
import com.adrian.sv.dto.response.AuthResponse;
import com.adrian.sv.dto.response.MessageResponse;
import com.adrian.sv.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        try {
            AuthResponse response = authService.register(registerRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            throw new RuntimeException("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse response = authService.login(loginRequest);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        try {
            AuthResponse response = authService.refreshToken(refreshTokenRequest);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            throw new RuntimeException("Token refresh failed: " + e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<MessageResponse> logout() {
        MessageResponse response = authService.logout();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<MessageResponse> health() {
        return ResponseEntity.ok(new MessageResponse("Authentication service is running"));
    }
}
