CREATE TABLE passageiros (
    id_passageiro BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE aeroportos (
    id_aeroporto BIGSERIAL PRIMARY KEY,
    code VARCHAR(3) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tipos_voo (
    id_tipo_voo BIGSERIAL PRIMARY KEY,
    type VARCHAR(200) UNIQUE NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tipos_aeronave (
    id_tipo_aeronave BIGSERIAL PRIMARY KEY,
    type VARCHAR(200) UNIQUE NOT NULL,
    description TEXT,
    passenger_capacity SMALLINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE aeronaves (
    id_aeronave BIGSERIAL PRIMARY KEY,
    id_tipo_aeronave BIGSERIAL NOT NULL REFERENCES tipos_aeronave(id_tipo_aeronave),
    registration VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categorias_funcionario (
    id_categoria_funcionario BIGSERIAL PRIMARY KEY,
    type VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE funcionarios (
    id_funcionario BIGSERIAL PRIMARY KEY,
    id_categoria_funcionario BIGSERIAL NOT NULL REFERENCES categorias_funcionario(id_categoria_funcionario),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE voos (
    id_voo BIGSERIAL PRIMARY KEY,
    id_tipo_voo BIGSERIAL NOT NULL REFERENCES tipos_voo(id_tipo_voo),
    id_tipo_aeronave BIGSERIAL NOT NULL REFERENCES tipos_aeronave(id_tipo_aeronave),
    id_aeroporto_origem BIGSERIAL NOT NULL REFERENCES aeroportos(id_aeroporto),
    id_aeroporto_destino BIGSERIAL NOT NULL REFERENCES aeroportos(id_aeroporto),
    departure_date DATE NOT NULL,
    scheduled_departure_time TIME NOT NULL,
    arrival_date DATE NOT NULL,
    scheduled_arrival_time TIME NOT NULL,
    scheduled_duration_min TIME NOT NULL,
    status VARCHAR(100) DEFAULT 'ativo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (status IN ('ativo', 'cancelado'))
);

CREATE TABLE escalas_voo (
    id_escala BIGSERIAL PRIMARY KEY NOT NULL,
    id_voo BIGSERIAL NOT NULL REFERENCES voos(id_voo) ON DELETE CASCADE,
    id_aeroporto BIGSERIAL NOT NULL REFERENCES aeroportos(id_aeroporto),
    ordem_escala INT NOT NULL,
    departure_date DATE NOT NULL,
    scheduled_departure_time TIME NOT NULL,
    arrival_date DATE NOT NULL,
    scheduled_arrival_time TIME NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tripulacao_voo (
    id_tripulacao_voo BIGSERIAL PRIMARY KEY,
    id_voo BIGSERIAL NOT NULL REFERENCES escalas_voo(id_escala) ON DELETE CASCADE,
    id_funcionario BIGSERIAL NOT NULL REFERENCES funcionarios(id_funcionario),
    role VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE reservas (
    id_reserva BIGSERIAL PRIMARY KEY,
    booking_number VARCHAR(50) UNIQUE NOT NULL,
    id_passageiro BIGSERIAL NOT NULL REFERENCES passageiros(id_passageiro),
    id_voo BIGSERIAL NOT NULL REFERENCES voos(id_voo),
    purchase_date DATE NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    payment_status VARCHAR(20) DEFAULT 'pending',
    confirmation_date DATE,
    cancellation_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (payment_method IN ('credit_card', 'bank_slip')),
    CHECK (payment_status IN ('pending', 'confirmed', 'cancelled'))
);

CREATE TABLE passagens (
    id_passagem BIGSERIAL PRIMARY KEY,
    id_reserva BIGSERIAL NOT NULL REFERENCES reservas(id_reserva) ON DELETE CASCADE,
    passenger_name VARCHAR(255) NOT NULL,
    seat_number INT NOT NULL,
    check_in_completed BOOLEAN DEFAULT FALSE,
    check_in_date TIMESTAMP NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (id_reserva, seat_number)
);

CREATE TABLE pagamentos_cartao (
    id_pagamento_cartao BIGSERIAL PRIMARY KEY,
    id_reserva BIGSERIAL NOT NULL REFERENCES reservas(id_reserva) ON DELETE CASCADE,
    card_brand VARCHAR(20) NOT NULL,
    encrypted_card_number VARCHAR(255) NOT NULL,
    expiration_month SMALLINT CHECK (expiration_month BETWEEN 1 AND 12),
    expiration_year SMALLINT CHECK (expiration_year >= 2000),
    authorization_date TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pagamentos_boleto (
    id_pagamento_boleto BIGSERIAL PRIMARY KEY,
    id_reserva BIGSERIAL NOT NULL REFERENCES reservas(id_reserva) ON DELETE CASCADE,
    boleto_code VARCHAR(255) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);