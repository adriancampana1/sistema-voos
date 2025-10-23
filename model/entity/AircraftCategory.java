package com.adrian.sv.model.entity;

public enum AircraftCategory {
    COMERCIAL("Comercial"),
    CARGUEIRO("Cargueiro"),
    MILITAR("Militar"),
    REGIONAL("Regional"),
    EXECUTIVO("Executivo");

    private final String description;

    AircraftCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
