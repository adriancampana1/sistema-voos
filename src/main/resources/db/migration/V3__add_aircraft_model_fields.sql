-- Add aircraft model specific fields to tipos_aeronave table
-- These fields define the characteristics of each aircraft model (Boeing 737, Airbus A320, etc.)

ALTER TABLE tipos_aeronave
ADD COLUMN aircraft_category VARCHAR(50) DEFAULT 'COMERCIAL' NOT NULL,
ADD COLUMN max_speed INTEGER DEFAULT 0 NOT NULL,
ADD COLUMN range_km INTEGER DEFAULT 0 NOT NULL,
ADD COLUMN cargo_capacity_kg BIGINT DEFAULT 0 NOT NULL,
ADD COLUMN max_altitude_ft INTEGER DEFAULT 0 NOT NULL;

-- Add constraint for valid aircraft categories
ALTER TABLE tipos_aeronave
ADD CONSTRAINT check_aircraft_category
CHECK (aircraft_category IN ('COMERCIAL', 'CARGUEIRO', 'MILITAR', 'REGIONAL', 'EXECUTIVO'));
