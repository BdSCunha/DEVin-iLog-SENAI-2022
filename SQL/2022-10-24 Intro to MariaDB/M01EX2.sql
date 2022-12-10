CREATE DATABASE IF NOT EXISTS labschoolbd;

USE labschoolbd;

CREATE TABLE IF NOT EXISTS pessoa (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(200) NOT NULL,
	telefone VARCHAR(13) NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf BIGINT UNSIGNED NOT NULL UNIQUE,
	
	estado_aluno VARCHAR(50),
	nota FLOAT,
	
	atendimentos_pedagogicos INT UNSIGNED,
	
	estado_professor VARCHAR(50),
	experiencia_professor VARCHAR(50),
	formacao_professor VARCHAR(50)
);