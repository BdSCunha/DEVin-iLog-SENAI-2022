CREATE DATABASE IF NOT EXISTS cadastro;

USE DATABASE cadastro;

CREATE TABLE IF NOT EXISTS pessoas(
	idPessoa INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	PRIMARY KEY (idPessoa)
);

DESCRIBE pessoas;

ALTER TABLE IF EXISTS pessoas ADD IF NOT EXISTS estadoCivil VARCHAR(20);

ALTER TABLE IF EXISTS pessoas CHANGE IF EXISTS estadoCivil estadoCivil VARCHAR(20) NOT NULL;

ALTER TABLE IF EXISTS pessoas DROP IF EXISTS estadoCivil;

DROP TABLE IF EXISTS pessoas;

###############

DROP TABLE IF EXISTS cliente;

CREATE TABLE IF NOT EXISTS cliente(
	idCliente INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	estado VARCHAR(25) NOT NULL,
	PRIMARY KEY (idCliente)
);

CREATE TABLE IF NOT EXISTS fabricante(
	idFabricante INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	estado VARCHAR(100) NOT NULL,
	PRIMARY KEY (idFabricante)
);

CREATE TABLE IF NOT EXISTS produto(
	idProduto INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	preco FLOAT NOT NULL,
	idFabricante INT NOT NULL,
	PRIMARY KEY (idProduto),
	CONSTRAINT fk_produto_fabricante FOREIGN KEY (idFabricante) REFERENCES fabricante(idFabricante) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pedido(
	idPedido INT NOT NULL AUTO_INCREMENT,
	quantidade TINYINT NOT NULL,
	idCliente INT NOT NULL,
	idProduto INT NOT NULL,
	PRIMARY KEY(idPedido),
	CONSTRAINT fk_pedido_cliente FOREIGN KEY (idCliente) REFERENCES cliente(idCliente) ON DELETE CASCADE,
	CONSTRAINT fk_pedido_produto FOREIGN KEY (idProduto) REFERENCES produto(idProduto) ON DELETE CASCADE
);

INSERT INTO fabricante(nome, endereco, cidade, estado) 
VALUES('LG do Brasil', 'Alameda Rio Grande, 20', 'São Paulo', 'SP'),
('Dell', 'Avenidas das Nações, 359', 'Guaíba', 'RS'),
('Multilaser', 'Avenida Principal, 258', 'Rio de Janeiro', 'RJ'),
('Lenovo', 'Governador Tavares, 15', 'São Paulo', 'SP'),
('Intelbras', 'Marginal da BR', 'São José', 'SC'),
('AOC', 'Rua Grande, S/N', 'Belo Horizonte', 'MG');

SELECT idFabricante, nome FROM fabricante;

SELECT * FROM fabricante;

SELECT idFabricante AS 'Id', nome AS 'Nome do Fabricante' FROM fabricante;

INSERT INTO produto(nome, preco, idFabricante) 
VALUES('Monitor Gamer', '1.099', '1'),
('Notebook Dell Inspiron', '4.099', '2'),
('Kit Mouse e Teclado USB', '99', '3'),
('Notebook Gamer Tela IPS', '6.099', '4'),
('Roteador Wireless', '199', '5'),
('Monitor 21,5 XBrite', '799', '1');

SELECT * FROM produto;

INSERT INTO cliente(nome, endereco, cidade, estado) 
VALUES('Anderson Rodrigues', 'Alameda Rio Grande, 20', 'São Paulo', 'SP'),
('Rogerio Andrade', 'Avenidas das Nações, 359', 'Guaíba', 'RS'),
('Camila Duarte', 'Avenida Principal, 258', 'Rio de Janeiro', 'RJ'),
('Rosane Dutra', 'Governador Tavares, 15', 'São Paulo', 'SP'),
('Estevão Rosa', 'Marginal da BR', 'São José', 'SC'),
('Guilherme Silva', 'Rua Grande, S/N', 'Belo Horizonte', 'MG');

SELECT * FROM cliente;

INSERT INTO pedido(quantidade, idCliente, idProduto)
VALUES('1', '2', '3'),
('1', '2', '2'),
('10', '5', '5'),
('5', '6', '1'),
('2', '6', '1'),
('50', '3', '3');

SELECT * FROM pedido;

###################

UPDATE pedido SET quantidade = '100' WHERE idPedido = '5';

DELETE FROM pedido WHERE idPedido = '5';

SELECT * FROM pedido
INNER JOIN produto ON produto.idProduto = pedido.idProduto
INNER JOIN cliente ON cliente.idCliente = pedido.idCliente;
