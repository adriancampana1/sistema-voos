INSERT INTO categorias_funcionario (type) VALUES
('piloto'),
('co-piloto'),
('comissario'),
('atendente');

INSERT INTO tipos_voo (type, description) VALUES
('DOM', 'Voo Doméstico'),
('INT', 'Voo Internacional'),
('FRET', 'Voo Fretado');

INSERT INTO aeroportos (code, name, city, state, country) VALUES
('GRU', 'Aeroporto Internacional de São Paulo/Guarulhos', 'São Paulo', 'SP', 'Brasil'),
('CGH', 'Aeroporto de Congonhas', 'São Paulo', 'SP', 'Brasil'),
('GIG', 'Aeroporto Internacional do Rio de Janeiro/Galeão', 'Rio de Janeiro', 'RJ', 'Brasil'),
('SDU', 'Aeroporto Santos Dumont', 'Rio de Janeiro', 'RJ', 'Brasil'),
('BSB', 'Aeroporto Internacional de Brasília', 'Brasília', 'DF', 'Brasil'),
('CNF', 'Aeroporto Internacional de Confins', 'Belo Horizonte', 'MG', 'Brasil'),
('SSA', 'Aeroporto Internacional de Salvador', 'Salvador', 'BA', 'Brasil'),
('POA', 'Aeroporto Internacional Salgado Filho', 'Porto Alegre', 'RS', 'Brasil'),
('REC', 'Aeroporto Internacional do Recife', 'Recife', 'PE', 'Brasil'),
('FOR', 'Aeroporto Internacional de Fortaleza', 'Fortaleza', 'CE', 'Brasil');