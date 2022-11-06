/*Instrução para criar o database*/
CREATE DATABASE banking;

/*Instrução para criação das tabelas*/
CREATE TABLE cliente(
	idCliente INT AUTO_INCREMENT NOT NULL,
	nomeCompleto VARCHAR(200) NOT NULL,
	primeiroNome VARCHAR(200) NOT NULL,
	sobrenome VARCHAR(200) NOT NULL,
	dataNascimento DATE NOT NULL,
	PRIMARY KEY (idCliente)
);

CREATE TABLE categoria(
	idCategoria INT AUTO_INCREMENT NOT NULL,
	nomeCategoria VARCHAR(60),
	PRIMARY KEY (idCategoria)
);

CREATE TABLE contaTipo(
	idContaTipo INT AUTO_INCREMENT NOT NULL,
	nome VARCHAR(60) NOT NULL,
	PRIMARY KEY (idContaTipo) 
);

CREATE TABLE movimentoStatus(
	idMovimentoStatus int NOT NULL,
	nomeStatus VARCHAR(60) NOT NULL,
	PRIMARY KEY(idMovimentoStatus)
);

CREATE TABLE movimentoTipo(
	idMovimentoTipo int NOT NULL,
	nomeTipo VARCHAR(60) NOT NULL,
	PRIMARY KEY(idMovimentoTipo)
);

CREATE TABLE conta(
	idConta INT AUTO_INCREMENT,
	cliente_id INT NOT NULL, 
	tipo_id INT NOT NULL,
	categoria_id INT NOT NULL,
	valor INT NOT NULL,
	PRIMARY KEY(idConta)
);

CREATE TABLE contaServicos(
	idContaServico INT AUTO_INCREMENT,
	categoria_id INT NOT NULL, 
	nome VARCHAR(60) NOT NULL,
	quantidade INT NOT NULL,
	taxa INT NOT NULL,
	PRIMARY KEY(idContaServico)
);



CREATE TABLE movimento(
	idMovimento INT AUTO_INCREMENT,
	valor INT NOT NULL,
	cadastradoEm DATETIME,
	atualizadoEm DATETIME,
	tipo_id INT NOT NULL,
	conta_id INT NOT NULL,
	status_id INT NOT NULL,
	PRIMARY KEY(idMovimento)
);



/*ADICIONANDO AS CHAVES ESTRANGEIRAS:*/

ALTER TABLE conta ADD CONSTRAINT fk_conta_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(idCliente);

ALTER TABLE conta
ADD CONSTRAINT fk_conta_contaTipo FOREIGN KEY (tipo_id) REFERENCES contaTipo(idContaTipo);

ALTER TABLE conta
ADD CONSTRAINT fk_conta_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(idCategoria);

/*ADICIONANDO AS CHAVES ESTRANGEIRAS:*/

ALTER TABLE contaServicos
ADD CONSTRAINT fk_contaServicos_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(idCategoria);

/*ADICIONANDO AS CHAVES ESTRANGEIRAS:*/

ALTER TABLE movimento
ADD CONSTRAINT fk_movimento_movimentoTipo FOREIGN KEY (tipo_id) REFERENCES movimentoTipo(idMovimentoTipo);

ALTER TABLE movimento
ADD CONSTRAINT fk_movimento_conta FOREIGN KEY (conta_id) REFERENCES conta(idConta);

ALTER TABLE movimento
ADD CONSTRAINT fk_movimento_movimentoStatus FOREIGN KEY (status_id) REFERENCES movimentoStatus(idMovimentoStatus);





/*Inserts das tabelas*/
INSERT INTO cliente (nomeCompleto, primeiroNome, sobrenome, dataNascimento) VALUES 
('Santiago Rodrigues Gilberto','Santiago','Rodrigues Gilberto','1984-09-15'),
('Andressa Santos Scheifer','Andressa','Santos Scheifer','1998-02-10'),
('Helena Silva','Helena','Silva','1973-05-30'),
('João Borges','João','Borges','1992-07-22'),
('Vanessa Luz','Vanessa','Luz','1995-04-01'),
('Rosa Amorim','Rosa','Amorim','1989-07-11'),
('Cristiano Machado','Cristiano','Machado','2000-01-29'),
('Estefani Silveira','Estefani','Silveira','1994-12-17'),
('Samanta Fagundes','Samanta','Fagundes','1987-10-05'),
('Camila Marques','Camila','Marques','1997-09-30'),
('Orlando Souza','Orlando','Souza','2001-02-20'),
('Renata Correia','Renata','Correia','1996-04-10'),
('Gabriel Borba','Gabriel','Borba','1978-08-30');

INSERT INTO contaTipo (nome) 
VALUES ('conta-salário'), ('conta-corrente'), ('conta-poupança');

INSERT INTO categoria (nomeCategoria)
VALUES ('básica'),('prata'),('ouro'),('premium');

INSERT INTO movimentoTipo (idMovimentoTipo, nomeTipo)
VALUES  (1,'entrada de fundos - transferência'),
(2,'entrada de fundos - depósito'),(3,'entrada de fundos - pix'),
(4,'entrada de fundos - cobrança'),(5,'entrada de fundos - estorno'),
(6,'saída de fundos - transferência'),(7,'saída de fundos - saque'),
(8,'saída de fundos - pix'),(9,'saída de fundos - pagamento de boleto'),
(10,'saída de fundos - taxa de operação bancária');

INSERT INTO movimentoStatus (idMovimentoStatus, nomeStatus)
VALUES (1,'pendente'), (2,'sucesso'), (3,'falha');

INSERT INTO conta (cliente_id, tipo_id,categoria_id, valor)
VALUES (9,1,1,24700),(11,3,4,5000),(3,3,3,50450),(6,3,2,5600),
(8,2,1,4500),(6,3,4,128500),(2,1,1,2999),(5,2,1,103649),
(7,3,3,20000),(10,3,4,1000),(13,3,2,19498),(12,3,3,1500),
(12,3,2,54999),(1,1,1,5499);

INSERT INTO contaServicos (categoria_id, nome, quantidade, taxa) 
VALUES (1,'cadastro de conta',1,0),(1,'saque caixa eletronico',1,0),
(1,'extrato caixa eletronico',99,0),(1,'extrato online',99,0),(1,'atendimento fone',99,0),
(2,'cadastro de conta',1,1999),(2,'saque caixa eletronico',6,50),(2,'extrato caixa eletronico',99,0),
(2,'extrato online',99,0),(2,'atendimento fone',99,0),(2,'atendimento 24/7',99,0),
(2,'cartão de débito',99,499),(2,'pix',99,0),(3,'cadastro de conta',1,499),
(3,'saque caixa eletronico',10,0),(3,'extrato caixa eletronico',99,0),(3,'extrato online',99,0),
(3,'atendimento 24/7',99,0),(3,'cartão de débito',1,499),(3,'pix',99,0),
(3,'internet banking',99,0),(3,'cartão de crédito',1,499),(3,'seguro de automóvel',1,79999),
(3,'limite pré aprovado R$ 5.000,00',1,0),(4,'cadastro de conta',1,2999),(4,'saque caixa eletronico',99,0),
(4,'extrato caixa eletronico',99,0),(4,'extrato online',99,0),(4,'atendimento 24/7',99,0),
(4,'cartão de débito',99,0),(4,'pix',99,0),(4,'internet banking',99,0),
(4,'cartão de crédito',3,0),(4,'previdência privada',12,49999),(4,'limite pré aprovado R$ 50.000,00',1,0),
(4,'seguro de automóvel',3,199999),(4,'seguro de vida',12,4999),(4,'desconto em viagens',12,999),
(4,'título de capitalização',12,9999),(4,'consórcio automotivo',3,399999);

INSERT INTO movimento (valor, cadastradoEm, atualizadoEm, tipo_id,conta_id, status_id)
VALUES  (1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,14,2),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',10,14,2),
(4500,'2021-03-26 12:22:31','2021-03-26 12:22:31',4,5,2),
(5600,'2021-03-26 12:22:31','2021-03-26 12:22:31',5,4,2),
(4999,'2021-03-26 12:22:31','2021-03-26 12:22:31',7,8,2),
(1000,'2021-03-26 12:22:31','2021-03-26 12:22:31',5,10,2),
(60000,'2021-03-26 12:22:31','2021-03-26 12:22:31',9,10,2),
(5000,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,1,2),
(450,'2021-03-26 12:22:31','2021-03-26 12:22:31',5,3,2),
(1500,'2021-03-26 12:22:31','2021-03-26 12:22:31',6,4,1),
(3500,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,6,2),
(2500,'2021-03-26 12:22:31','2021-03-26 12:22:31',8,7,2),
(50000,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,3,2),
(10000,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,1,2),
(5000,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,2,2),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',10,2,2),
(140000,'2021-03-26 12:22:31','2021-03-26 12:22:31',6,12,1),
(5000,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,12,1),
(6300,'2021-03-26 12:22:31','2021-03-26 12:22:31',9,12,1),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',8,8,2),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,8,2),
(5000,'2021-03-26 12:22:31','2021-03-26 12:22:31',8,9,2),
(2999,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,7,2),
(10000,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,6,2),
(199,'2021-03-26 12:22:31','2021-03-26 12:22:31',7,5,1),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,7,1),
(9999,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,11,2),
(5000,'2021-03-26 12:22:31','2021-03-26 12:22:31',7,13,2),
(9999,'2021-03-26 12:22:31','2021-03-26 12:22:31',5,13,2),
(2999,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,11,2),
(1500,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,12,2),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',10,14,2),
(750000,'2021-03-26 12:22:31','2021-03-26 12:22:31',9,5,2),
(75000000,'2021-03-26 12:22:31','2021-03-26 12:22:31',6,4,1),
(250,'2021-03-26 12:22:31','2021-03-26 12:22:31',9,14,2),
(45000,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,13,2),
(8000,'2021-03-26 12:22:31','2021-03-26 12:22:31',8,9,2),
(150000,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,8,1),
(6000,'2021-03-26 12:22:31','2021-03-26 12:22:31',7,13,2),
(5000,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,9,2),
(1400,'2021-03-26 12:22:31','2021-03-26 12:22:31',9,7,2),
(50000,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,4,1),
(45000,'2021-03-26 12:22:31','2021-03-26 12:22:31',8,3,2),
(10000,'2021-03-26 12:22:31','2021-03-26 12:22:31',6,6,2),
(500,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,8,1),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',7,9,2),
(15000,'2021-03-26 12:22:31','2021-03-26 12:22:31',6,2,2),
(2999,'2021-03-26 12:22:31','2021-03-26 12:22:31',9,14,1),
(15000,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,9,2),
(3000,'2021-03-26 12:22:31','2021-03-26 12:22:31',8,6,2),
(3500,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,14,2),
(1200,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,1,2),
(15000,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,6,2),
(150,'2021-03-26 12:22:31','2021-03-26 12:22:31',4,8,2),
(6500,'2021-03-26 12:22:31','2021-03-26 12:22:31',5,11,2),
(4500,'2021-03-26 12:22:31','2021-03-26 12:22:31',6,12,2),
(3500,'2021-03-26 12:22:31','2021-03-26 12:22:31',7,12,2),
(1200,'2021-03-26 12:22:31','2021-03-26 12:22:31',8,12,2),
(1100,'2021-03-26 12:22:31','2021-03-26 12:22:31',9,12,1),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',10,6,2),
(6500,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,8,2),
(10000000,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,6,2),
(95000,'2021-03-26 12:22:31','2021-03-26 12:22:31',4,8,2),
(15000,'2021-03-26 12:22:31','2021-03-26 12:22:31',7,4,3),
(4500,'2021-03-26 12:22:31','2021-03-26 12:22:31',8,3,3),
(3500,'2021-03-26 12:22:31','2021-03-26 12:22:31',9,2,3),
(15000,'2021-03-26 12:22:31','2021-03-26 12:22:31',4,2,3),
(8500,'2021-03-26 12:22:31','2021-03-26 12:22:31',5,1,2),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',6,8,3),
(1500,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,3,3),
(1999,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,6,3),
(5000,'2021-03-26 12:22:31','2021-03-26 12:22:31',1,6,3),
(150000,'2021-03-26 12:22:31','2021-03-26 12:22:31',2,12,3),
(60000,'2021-03-26 12:22:31','2021-03-26 12:22:31',3,13,3),
(15000,'2021-03-26 12:22:31','2021-03-26 12:22:31',6,13,3);

SELECT nomeCompleto AS cliente, dataNascimento AS 'Data Nascimento', YEAR(FROM_DAYS(TO_DAYS(NOW())-TO_DAYS(dataNascimento))) AS Idade FROM cliente ORDER BY Idade DESC