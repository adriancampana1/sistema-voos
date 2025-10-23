package com.adrian.sv.security;

import com.adrian.sv.model.entity.Passageiro;
import com.adrian.sv.model.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final Passageiro passageiro;

    public CustomUserDetails(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return passageiro.getRoles().stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return passageiro.getPassword();
    }

    @Override
    public String getUsername() {
        return passageiro.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Long getId() {
        return passageiro.getId();
    }
}
