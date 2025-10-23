package com.adrian.sv.service;

import com.adrian.sv.dto.request.auth.LoginRequest;
import com.adrian.sv.dto.request.auth.RefreshTokenRequest;
import com.adrian.sv.dto.request.auth.RegisterRequest;
import com.adrian.sv.dto.response.AuthResponse;
import com.adrian.sv.dto.response.MessageResponse;
import com.adrian.sv.model.entity.Passageiro;
import com.adrian.sv.model.entity.Role;
import com.adrian.sv.repository.PassengerRepository;
import com.adrian.sv.repository.RoleRepository;
import com.adrian.sv.security.CustomUserDetails;
import com.adrian.sv.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final PassengerRepository passengerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Transactional
    public AuthResponse register(RegisterRequest registerRequest) {
        // Validate if user already exists
        if (passengerRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }

        if (passengerRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }

        if (passengerRepository.existsByCpf(registerRequest.getCpf())) {
            throw new RuntimeException("CPF is already registered!");
        }

        // Create new user
        Passageiro passageiro = Passageiro.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .cpf(registerRequest.getCpf())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(new HashSet<>())
                .build();

        // Assign default role
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        passageiro.getRoles().add(userRole);

        // Save user
        Passageiro savedPassageiro = passengerRepository.save(passageiro);

        // Authenticate user and generate tokens
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerRequest.getEmail(),
                        registerRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String accessToken = jwtUtils.generateAccessToken(authentication);
        String refreshToken = jwtUtils.generateRefreshToken(authentication);

        Set<String> roles = savedPassageiro.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        return new AuthResponse(
                accessToken,
                refreshToken,
                savedPassageiro.getId(),
                savedPassageiro.getUsername(),
                savedPassageiro.getEmail(),
                roles
        );
    }

    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String accessToken = jwtUtils.generateAccessToken(authentication);
        String refreshToken = jwtUtils.generateRefreshToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Passageiro passageiro = userDetails.getPassageiro();

        Set<String> roles = passageiro.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        return new AuthResponse(
                accessToken,
                refreshToken,
                passageiro.getId(),
                passageiro.getUsername(),
                passageiro.getEmail(),
                roles
        );
    }

    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String refreshToken = refreshTokenRequest.getRefreshToken();

        if (!jwtUtils.validateJwtToken(refreshToken)) {
            throw new RuntimeException("Invalid refresh token!");
        }

        if (jwtUtils.isTokenExpired(refreshToken)) {
            throw new RuntimeException("Refresh token is expired!");
        }

        String email = jwtUtils.getEmailFromJwtToken(refreshToken);
        Passageiro passageiro = passengerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        String newAccessToken = jwtUtils.generateTokenFromEmail(email, 86400000L); // 24 hours
        String newRefreshToken = jwtUtils.generateTokenFromEmail(email, 604800000L); // 7 days

        Set<String> roles = passageiro.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        return new AuthResponse(
                newAccessToken,
                newRefreshToken,
                passageiro.getId(),
                passageiro.getUsername(),
                passageiro.getEmail(),
                roles
        );
    }

    public MessageResponse logout() {
        SecurityContextHolder.clearContext();
        return new MessageResponse("Logout successful!");
    }
}
