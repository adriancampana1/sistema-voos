-- Create roles table
CREATE TABLE roles (
    id_role BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create user_roles junction table for many-to-many relationship
CREATE TABLE user_roles (
    id_user_role BIGSERIAL PRIMARY KEY,
    id_passageiro BIGINT NOT NULL REFERENCES passageiros(id_passageiro) ON DELETE CASCADE,
    id_role BIGINT NOT NULL REFERENCES roles(id_role) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(id_passageiro, id_role)
);

-- Insert default roles
INSERT INTO roles (name, description) VALUES
('ROLE_USER', 'Regular user with basic permissions'),
('ROLE_ADMIN', 'Administrator with full permissions'),
('ROLE_MODERATOR', 'Moderator with limited administrative permissions');

-- Create index for better query performance
CREATE INDEX idx_user_roles_passageiro ON user_roles(id_passageiro);
CREATE INDEX idx_user_roles_role ON user_roles(id_role);
