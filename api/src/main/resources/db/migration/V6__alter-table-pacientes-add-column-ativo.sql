ALTER TABLE pacientes ADD ativo TINYINT;
UPDATE pacientes SET ativo = 1;
