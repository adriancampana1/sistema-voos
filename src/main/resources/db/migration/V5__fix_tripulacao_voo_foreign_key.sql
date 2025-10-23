-- Fix the foreign key constraint in tripulacao_voo table
-- The constraint should reference voos(id_voo) instead of escalas_voo(id_escala)

-- Drop the incorrect foreign key constraint
ALTER TABLE tripulacao_voo
DROP CONSTRAINT IF EXISTS tripulacao_voo_id_voo_fkey;

-- Add the correct foreign key constraint
ALTER TABLE tripulacao_voo
ADD CONSTRAINT tripulacao_voo_id_voo_fkey
FOREIGN KEY (id_voo) REFERENCES voos(id_voo) ON DELETE CASCADE;
