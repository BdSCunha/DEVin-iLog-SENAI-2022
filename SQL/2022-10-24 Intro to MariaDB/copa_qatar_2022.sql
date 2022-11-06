# [M01S08] Ex 01 - Copa do Mundo (parte 1) - Tabela de Times

CREATE DATABASE IF NOT EXISTS copa_qatar_2022;
USE copa_qatar_2022;

# a) Criar uma tabela chamada TIMES com os campos 'sigla' (varchar e chave primária) e 'nome' (varchar e não-nulo).
CREATE TABLE IF NOT EXISTS times(
	sigla VARCHAR(3),
	nome VARCHAR(100) NOT NULL,
	PRIMARY KEY(sigla)
);

# b) Inserir nesta tabela os times participantes da Copa, conforme listagem mais abaixo
INSERT INTO times(sigla, nome)
VALUES ('QAT', 'Qatar'),
('ECU', 'Equador'),
('SEN', 'Senegal'),
('NED', 'Holanda'),
('ENG', 'Inglaterra'),
('IRN', 'Irã'),
('USA', 'Estados Unidos'),
('WAL', 'País de Gales'),
('ARG', 'Argentina'),
('KSA', 'Arábia Saudita'),
('MEX', 'México'),
('POL', 'Polônia'),
('FRA', 'França'),
('DEN', 'Dinamarca'),
('TUN', 'Tunísia'),
('AUS', 'Austrália'),
('ESP', 'Espanha'),
('GER', 'Alemanha'),
('JPN', 'Japão'),
('CRC', 'Costa Rica'),
('BEL', 'Bélgica'),
('CAN', 'Canadá'),
('MAR', 'Marrocos'),
('CRO', 'Croácia'),
('BRA', 'Brasil'),
('SRB', 'Sérvia'),
('SUI', 'Suíça'),
('CMR', 'Camarões'),
('POR', 'Portugal'),
('GHA', 'Gana'),
('URU', 'Uruguai'),
('KOR', 'Coréia do Sul');

#c) Consultar todos os itens da lista para conferir o registro de todas as linhas.
SELECT * FROM times;

