CREATE DATABASE IF NOT EXISTS empresa;

USE empresa;

CREATE TABLE IF NOT EXISTS empregados(
	id_empregado INT NOT NULL AUTO_INCREMENT,
	nome_empregado VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NOT NULL,
	idade TINYINT UNSIGNED NOT NULL,
	PRIMARY KEY(id_empregado)
);

CREATE TABLE IF NOT EXISTS cargos(
	id_cargo INT NOT NULL AUTO_INCREMENT,
	nome_cargo VARCHAR(50) NOT NULL,
	PRIMARY KEY(id_cargo)
);

CREATE TABLE IF NOT EXISTS gestores(
	id_gestor INT NOT NULL AUTO_INCREMENT,
	nome_gestor VARCHAR(100),
	PRIMARY KEY(id_gestor)
);

####################################################################################################

INSERT INTO empregados(nome_empregado, endereco, idade)
VALUES ('Ronald Lana Diovani', '45602-698 Travessa Santa Terezinha 215, Sao Lourenco, Itabuna - BA', 19),
('Hevelyn Lima Moura', '65633-683 Rua Trinta e Um 169, Cidade Nova, Timon - MA', 51),
('Maria Batista Muniz', '88161-536 Rua Hilda Ana Machado 67, Fundos, Biguacu - SC', 57),
('Joel Avilla Teodoro', '91790-260 Acesso Círio Amaral de Oliveira 445, Restinga, Porto Alegre - RS', 30),
('Estefani Bastida Nigro', '64012-852 Rua Monte Novo, Santa Maria da Codipe 357, Teresina - PI', 37),
('Arthur dos Anjos Mendonça', '68908-435 Rua Caubi Melo 458, Sao Lazaro, Macapa - AP', 61),
('Valeria Peres Mayerhofer', '43810-250 Rua Joana D Arc 437, Nova Brasília, Candeias - BA', 44),
('Adriana Carvalheiro Mesquita', '04889-000 Rua do Jusa 534, Parelheiros, Sao Paulo - SP', 22),
('Francisco Barher dos Anjos', '69312-172, Rua Alcides Lima 331, Caimbe, Boa Vista - RR', 66),
('Lucinea Bravo Diovani', '29201-039 Rua Monte Castelo 148, Ipiranga, Guarapari - ES', 47);

INSERT INTO cargos(nome_cargo)
VALUES ('Vendedor'),
('Analista'),
('Auxiliar administrativo'),
('Recepcionista'),
('Motorista'),
('Repositor de mercadorias'),
('Gerente de processos'),
('Engenheiro'),
('Técnico(a) Enfermagem'),
('Seguranca');

INSERT INTO gestores(nome_gestor)
VALUES ('Daiane Francisca Assuncao'),
('Ruan Murilo Lorenzo Monteiro'),
('Bruno Ricardo Gabriel Alves'),
('Danilo Paulo Alves'),
('Henrique Matheus Gabriel Silva'),
('Alexandre Martin Caleb Rezende'),
('Clarice Fernanda Campos'),
('Adriana Ana Eloa Mendes'),
('Mariah Debora Viana'),
('Daniel Renato Marcio de Paula');