CREATE DATABASE IF NOT EXISTS faculdade;

USE DATABASE faculdade;

CREATE TABLE alunos(
	cpf CHAR(11) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	datanasc DATE NOT NULL,
	telefone VARCHAR(11),
	sexo CHAR(1),
	PRIMARY KEY (cpf)
);

SELECT alunos FROM faculdade;

CREATE TABLE cursos(
	codcurso INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	datacriacao DATE NOT NULL,
	duracao INT DEFAULT 4,
	valor FLOAT,
	PRIMARY KEY(codcurso)
);

CREATE TABLE IF NOT EXISTS disciplinas(
	coddisciplina INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	horas INT(3) DEFAULT 80,
	codcurso INT NOT NULL,
	PRIMARY KEY(coddisciplina),
	CONSTRAINT fk_disciplinas_cursos FOREIGN KEY (codcurso) REFERENCES cursos(codcurso) ON DELETE CASCADE
);

CREATE DATABASE IF NOT EXISTS aula1;
USE aula1;
DROP TABLE pessoa;
CREATE TABLE pessoa (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	doc_receita_federal VARCHAR(20)
);