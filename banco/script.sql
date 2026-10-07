CREATE TABLE ativo (
                       id_ativo SERIAL PRIMARY KEY,
                       codigo_ativo VARCHAR(10) NOT NULL,
                       nome_empresa VARCHAR(100) NOT NULL,
                       tipo_investimento VARCHAR(50) NOT NULL,
                       quantidade_cotas INTEGER NOT NULL,
                       preco_unitario NUMERIC(12,2) NOT NULL
);