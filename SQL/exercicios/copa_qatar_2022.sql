#############################################################################################################
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


#############################################################################################################
# [M01S08] Ex 02 - Copa do Mundo (parte 2) - Consulta de Times

# a) Consultar o nome da seleção cuja sigla é 'KSA'.
SELECT nome FROM times WHERE sigla = 'KSA';

# b) Consultar a sigla da seleção de Gana.
SELECT sigla FROM times WHERE nome = 'Gana';


#############################################################################################################
# [M01S08] Ex 03 - Copa do Mundo (parte 3) - Novas Consulta de times6

# a) Consultar todos os campos dos times cujo nome começa com 'E'.
SELECT sigla, nome FROM times WHERE nome LIKE 'E%';

# b) Consultar os campos dos times que começam com 'E' e cuja sigla começa com 'U'.
SELECT sigla, nome FROM times WHERE nome LIKE 'E%' AND sigla LIKE 'U%';


#############################################################################################################
# [M01S08] Ex 04 - Copa do Mundo (parte 4) - Novo campo de Grupos

# a) Alterar a tabela de TIMES, adicionando a coluna de 'grupo' (varchar).
ALTER TABLE IF EXISTS times ADD COLUMN IF NOT EXISTS grupo VARCHAR(1) NOT NULL;

# b) Atualizar cada registro com o respectivo grupo em que faz parte, conforme listagem abaixo.
/*
GRUPO - TIMES
-------------
A - Qatar, Equador, Senegal, Holanda
B - Inglaterra, Irã, Estados Unidos, País de Gales
C - Argentina, Arábia Saudita, México, Polônia
D - França, Dinamarca, Tunísia, Austrália
E - Espanha, Alemanha, Japão, Costa Rica
F - Bélgica, Canadá, Marrocos, Croácia
G - Brasil, Sérvia, Suiça, Camarões
H - Portugal, Gana, Uruguai, Coréia do Sul
*/
UPDATE times SET grupo = 'A' WHERE nome IN ('Qatar', 'Equador', 'Senegal', 'Holanda');
UPDATE times SET grupo = 'B' WHERE nome IN ('Inglaterra', 'Irã', 'Estados Unidos', 'País de Gales');
UPDATE times SET grupo = 'C' WHERE nome IN ('Argentina', 'Arábia Saudita', 'México', 'Polônia');
UPDATE times SET grupo = 'D' WHERE nome IN ('França', 'Dinamarca', 'Tunísia', 'Austrália');
UPDATE times SET grupo = 'E' WHERE nome IN ('Espanha', 'Alemanha', 'Japão', 'Costa Rica');
UPDATE times SET grupo = 'F' WHERE nome IN ('Bélgica', 'Canadá', 'Marrocos', 'Croácia');
UPDATE times SET grupo = 'G' WHERE nome IN ('Brasil', 'Sérvia', 'Suiça', 'Camarões');
UPDATE times SET grupo = 'H' WHERE nome IN ('Portugal', 'Gana', 'Uruguai', 'Coréia do Sul');

# c) Consultar todos os times para conferir.
SELECT * FROM times;


#############################################################################################################
# [M01S08] Ex 05 - Copa do Mundo (parte 5) - Consultas de Times e Grupos

# a) Consultar o nome dos times do grupo G.
SELECT nome FROM times WHERE grupo = 'G';

# b) Consultar as siglas dos times do grupo C.
SELECT sigla FROM times WHERE grupo = 'C';


#############################################################################################################
# [M01S08] Ex 06 - Copa do Mundo (parte 6) - Novas Consultas de Times e Grupos

# a) Consultar todos os campos dos times do grupo 'E' e do grupo 'H', em ordem alfabética de grupo.
SELECT * FROM times WHERE grupo IN ('E', 'H') ORDER BY grupo;

# b) Consultar todos os campos dos times do grupo 'E' e do grupo 'H', em ordem alfabética de nome do time.
SELECT * FROM times WHERE grupo IN ('E', 'H') ORDER BY nome;


#############################################################################################################
# [M01S08] Ex 07 - Copa do Mundo (parte 7) - Tabela de Títulos da Copa

# a) Criar a tabela _CAMPEOES_ com os campos ano (int e primary key) e sigla_time (foreign key da tab de times).
CREATE TABLE IF NOT EXISTS campeoes (
	ano INT(4) UNSIGNED PRIMARY KEY,
	sigla_time VARCHAR(3),
	CONSTRAINT fk_sigla_time FOREIGN KEY (sigla_time) REFERENCES times(sigla)
);

# b) Popular esta tabela com os dados listados abaixo.
INSERT INTO campeoes(ano, sigla_time)
VALUES (1930, 'URU'),
(1950, 'URU'),
(1954, 'GER'),
(1958, 'BRA'),
(1962, 'BRA'),
(1966, 'ENG'),
(1970, 'BRA'),
(1974, 'GER'),
(1978, 'ARG'),
(1986, 'ARG'),
(1990, 'GER'),
(1994, 'BRA'),
(1998, 'FRA'),
(2002, 'BRA'),
(2010, 'ESP'),
(2014, 'GER'),
(2018, 'FRA');

# c) Consultar os dados desta tabela para conferência.
SELECT * FROM campeoes;


#############################################################################################################
# [M01S08] Ex 08 - Copa do Mundo (parte 8) - Consultas de Campeões

# a) Consultar os campos da tabela de campeões ordenados pelo ano.
SELECT * FROM campeoes ORDER BY ano;

# b) Consultar sigla do time campeão no último ano em que a copa foi disputada (dica: usar MAX).
SELECT sigla_time FROM campeoes WHERE ano = (SELECT MAX(ano) FROM campeoes);

# c) Consultar a quantidade de títulos por sigla de time, ordenando da maior pra menor quantidade (dica: usar group by, count e order by).
SELECT sigla_time, COUNT(*) AS 'Títulos' FROM campeoes GROUP BY sigla_time ORDER BY COUNT(*) DESC;


#############################################################################################################
# [M01S08] Ex 09 - Copa do Mundo (parte 9) - Novas Consultas de Times e Grupos

# a) Consultar os grupos cadastrados/existentes, sem repetir os grupos e em ordem alfabética (dica: usar distinct).
SELECT DISTINCT(grupo) FROM times ORDER BY grupo;

# b) Consultar a quantidade de times em cada grupo (dica: usar group by).
SELECT grupo, COUNT(*) AS 'Qtd. de times' FROM times GROUP BY grupo ORDER BY grupo;


#############################################################################################################
# [M01S08] Ex 10 - Copa do Mundo (parte 10) - Novas Consultas de Times e Campeões

# a) Consultar os nomes em maiúsculo dos times que estão dispuntando a copa atual é que já ganharam algum título de campeão da Copa do Mundo, sem repetir o nome do time (dica: usar JOIN e DISTINCT)
SELECT UPPER(nome) AS 'Nome' FROM times;

# b) Consultar os nomes em minúsculo dos times que estão dispuntando a copa atual é que nunca ganharam um título de campeão da Copa do Mundo, sem repetir o nome do time (dica: usar JOIN e DISTINCT)

