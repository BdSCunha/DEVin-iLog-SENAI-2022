DROP DATABASE IF EXISTS pizzaria_do_joao;

CREATE DATABASE IF NOT EXISTS pizzaria_do_joao;

USE pizzaria_do_joao;

CREATE TABLE IF NOT EXISTS bordas(
	id_bordas INT NOT NULL AUTO_INCREMENT,
	tipo VARCHAR(100) NOT NULL,
	PRIMARY KEY(id_bordas)
);

CREATE TABLE IF NOT EXISTS massas(
	id_massas INT NOT NULL AUTO_INCREMENT,
	tipo VARCHAR(100) NOT NULL,
	PRIMARY KEY(id_massas)
);

CREATE TABLE IF NOT EXISTS sabores(
	id_sabores INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	PRIMARY KEY(id_sabores)
);

CREATE TABLE IF NOT EXISTS pizzas(
	id_pizzas INT NOT NULL AUTO_INCREMENT,
	id_bordas INT NOT NULL,
	id_massas INT NOT NULL,
	PRIMARY KEY(id_pizzas),
	CONSTRAINT fk_pizzas_bordas FOREIGN KEY (id_bordas) REFERENCES bordas(id_bordas) ON DELETE CASCADE,
	CONSTRAINT fk_pizzas_massas FOREIGN KEY (id_massas) REFERENCES massas(id_massas) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pizza_sabores(
	id_pizza_sabores INT NOT NULL AUTO_INCREMENT,
	id_pizzas INT NOT NULL,
	id_sabores INT NOT NULL,
	PRIMARY KEY(id_pizza_sabores),
	CONSTRAINT fk_pizza_sabores_pizzas FOREIGN KEY (id_pizzas) REFERENCES pizzas(id_pizzas) ON DELETE CASCADE,
	CONSTRAINT fk_pizza_sabores_sabores FOREIGN KEY (id_sabores) REFERENCES sabores(id_sabores) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS status_pedido(
	id_status_pedido INT NOT NULL AUTO_INCREMENT,
	tipo VARCHAR(100) NOT NULL,
	PRIMARY KEY(id_status_pedido)
);

CREATE TABLE IF NOT EXISTS pedidos(
		id_pedidos INT NOT NULL AUTO_INCREMENT,
		id_pizzas INT NOT NULL,
		id_status_pedido INT NOT NULL,
		PRIMARY KEY(id_pedidos),
		CONSTRAINT fk_pedidos_pizzas FOREIGN KEY (id_pizzas) REFERENCES pizzas(id_pizzas) ON DELETE CASCADE,
		CONSTRAINT fk_pedidos_status_pedido FOREIGN KEY (id_status_pedido) REFERENCES status_pedido(id_status_pedido) ON DELETE CASCADE
);

####################################################################################################

USE pizzaria_do_joao;

INSERT INTO bordas(tipo) 
VALUES('Borda Simples - Sem Recheio'),
('Borda Recheada - Catupiry'),
('Borda Recheada - Cheddar'),
('Borda Recheada - Cream Cheese'),
('Borda Recheada - Mucarela'),
('Borda Vulcao - Catupiry'),
('Borda Vulcao - Cheddar'),
('Borda Vulcao - Cream Cheese'),
('Borda Vulcao - Mucarela');

INSERT INTO massas(tipo)
VALUES('Massa Comum - Fina'),
('Massa Comum - Grossa'),
('Massa Integral - Fina'),
('Massa Integral - Grossa'),
('Massa Temperada - Fina'),
('Massa Temperada - Grossa');

INSERT INTO sabores(nome)
VALUES('Calabresa'),
('Portuguesa'),
('Marguerita'),
('Frango com Catupiry'),
('Mucarela'),
('Napolitana'),
('Brigadeiro'),
('Romeu e Julieta'),
('Creme de Avela com Frutas'),
('California');

INSERT INTO pizzas(id_bordas, id_massas)
VALUES(5, 4),
(2, 5),
(3, 6),
(8, 4),
(5, 1),
(4, 5),
(8, 2),
(3, 6),
(9, 3),
(9, 4),
(7, 5);

INSERT INTO pizza_sabores(id_pizzas, id_sabores)
VALUES(),
();