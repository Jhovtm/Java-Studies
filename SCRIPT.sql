CREATE DATABASE IF NOT EXISTS basejdbc CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE basejdbc;
CREATE TABLE IF NOT EXISTS produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    preco_de_custo DECIMAL(10, 2) NOT NULL,
    data_cadastro DATE NOT NULL DEFAULT (CURRENT_DATE),
    UNIQUE INDEX unq_descricao (descricao)
) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS servico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL
) ENGINE=InnoDB;

INSERT IGNORE INTO produto (id, descricao, preco_de_custo, data_cadastro) VALUES
    (1, 'HEINECKEN', 5.50, '2014-01-29'),
    (2, 'Coca Cola 2 litros', 8.50, '2021-02-02'),
    (3, 'Salgadinho Torcida', 2.50, '2010-05-10');
SELECT * FROM produto;
