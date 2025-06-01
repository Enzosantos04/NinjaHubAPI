--V2: Migrations para adicionar a coluna de ranking na tabela ninjaRegister


ALTER TABLE TB_NINJA_REGISTER
    ADD COLUMN rank VARCHAR(255);