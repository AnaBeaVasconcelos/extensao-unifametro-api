-- Criação da tabela
CREATE TABLE financeiro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codbarras VARCHAR(255) NOT NULL,
    numdoc INT NOT NULL,
    vlrdoc DECIMAL(18,2) NOT NULL,
    dtven DATE NOT NULL,
    dtpros DATE,
    nomeparc VARCHAR(255) NOT NULL,
    status INT NOT NULL,
    dtbaixa DATE
);

-- Tabela interfacedda
CREATE TABLE interfacedda (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codbarras VARCHAR(255) NOT NULL,
    numdoc VARCHAR(255) NOT NULL,
    vlrdoc DECIMAL(18,2) NOT NULL,
    dtven DATE NOT NULL,
    dtpros DATE NOT NULL,
    nomeparc VARCHAR(255) NOT NULL,
    status INTEGER NOT NULL
);

---- Inserção de dados
--INSERT INTO financeiro (codbarras, numdoc, vlrdoc, dtven, dtpros, nomeparc, status, dtbaixa) VALUES
--('1234567890123', 1001, 1500.50, '2025-10-01', '2025-10-05', 'Empresa A', 0, NULL);
--
--INSERT INTO financeiro (codbarras, numdoc, vlrdoc, dtven, dtpros, nomeparc, status, dtbaixa) VALUES
--('9876543210987', 1002, 2500.75, '2025-10-03', '2025-10-07', 'Empresa B', 1, NULL);
--
--INSERT INTO financeiro (codbarras, numdoc, vlrdoc, dtven, dtpros, nomeparc, status, dtbaixa) VALUES
--('4561237894561', 1003, 320.00, '2025-10-02', '2025-10-06', 'Empresa C', 0, NULL);

INSERT INTO financeiro (codbarras, numdoc, vlrdoc, dtven, dtpros, nomeparc, status, dtbaixa) VALUES
('103393123000000921419451781400000005435190101', 316321753, 921.41, '2025-09-10', NULL, 'UP BRASIL ADMINISTRACAO E SERV', 0, NULL );
