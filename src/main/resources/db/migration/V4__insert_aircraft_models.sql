-- Insert aircraft models with their specifications
INSERT INTO tipos_aeronave (type, description, passenger_capacity, aircraft_category, max_speed, range_km, cargo_capacity_kg, max_altitude_ft) VALUES
('Boeing 737', 'Aeronave comercial de médio porte', 189, 'COMERCIAL', 910, 5437, 12000, 41000),
('Airbus A320', 'Aeronave comercial de médio porte', 194, 'COMERCIAL', 903, 6300, 9000, 43000),
('Boeing 777', 'Aeronave comercial de longo alcance', 396, 'COMERCIAL', 956, 14685, 32000, 43000),
('Airbus A380', 'Aeronave comercial de grande capacidade', 853, 'COMERCIAL', 908, 14800, 84600, 43000),
('Boeing 747', 'Aeronave comercial de carga', 416, 'CARGUEIRO', 908, 14685, 124432, 45000),
('Airbus A400M', 'Aeronave de transporte militar/carga', 116, 'MILITAR', 780, 4000, 32000, 42000),
('Bombardier CRJ-900', 'Aeronave regional', 90, 'REGIONAL', 870, 3331, 3200, 41000),
('Embraer E195', 'Aeronave regional', 146, 'REGIONAL', 870, 4815, 2650, 43000),
('Cessna Citation X', 'Aeronave executiva', 12, 'EXECUTIVO', 960, 5926, 1000, 51000),
('Gulfstream G650', 'Aeronave executiva de longo alcance', 13, 'EXECUTIVO', 956, 13890, 2000, 51000);
