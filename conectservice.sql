create database conectservice;
use conectservice;


CREATE TABLE setor (
    codsetor INT NOT NULL AUTO_INCREMENT,
    nome_setor VARCHAR(50),
    CONSTRAINT PRIMARY KEY (codsetor)
);

CREATE TABLE formas_Pagamento (
    codpagamento INT NOT NULL AUTO_INCREMENT,
    formas_pagamento VARCHAR(50),
    CONSTRAINT PRIMARY KEY (codpagamento)
);

CREATE TABLE login (
    login VARCHAR(20),
    senha VARCHAR(8),
    prestado_servico ENUM('sim', 'não'),
	CONSTRAINT FOREIGN KEY (login)
        REFERENCES usuario (login),
    CONSTRAINT FOREIGN KEY (senha)
        REFERENCES usuario (senha),
	CONSTRAINT FOREIGN KEY (prestado_servico)
        REFERENCES usuario (prestado_servico),
	CONSTRAINT FOREIGN KEY (login)
        REFERENCES prestador_servico (login),
    CONSTRAINT FOREIGN KEY (senha)
        REFERENCES prestador_servico(senha),
	CONSTRAINT FOREIGN KEY (prestado_servico)
        REFERENCES prestador_servico(prestado_servico)
	
    
);


CREATE TABLE usuario (
    codusuario INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50),
    cpf VARCHAR(50),
    login VARCHAR(20),
    senha VARCHAR(8),
	prestado_servico ENUM('não'),
    CONSTRAINT PRIMARY KEY (codusuario)
    
);


CREATE TABLE prestador_servico (
    codprestador INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50),
    cnpj VARCHAR(50),
    login VARCHAR(20),
    senha VARCHAR(8),
    codsetor INT NOT NULL,
	prestado_servico ENUM('sim'),
    CONSTRAINT PRIMARY KEY (codprestador),
     CONSTRAINT FOREIGN KEY (codsetor)
        REFERENCES setor (codsetor)
);


CREATE TABLE servico (
    codservico INT NOT NULL AUTO_INCREMENT,
    nome_servico VARCHAR(255),
    codprestador INT NOT NULL,
    CONSTRAINT PRIMARY KEY (codservico),
    CONSTRAINT FOREIGN KEY (codprestador)
        REFERENCES prestador_Servico (codprestador)
);


CREATE TABLE servico_pagamento (
    codsetor INT NOT NULL,
    codservico INT NOT NULL,
    codpagamento INT NOT NULL,
	codusuario INT NOT NULL,
    CONSTRAINT FOREIGN KEY (codsetor)
        REFERENCES setor (codsetor),
    CONSTRAINT FOREIGN KEY (codservico)
        REFERENCES servico (codservico),
    CONSTRAINT FOREIGN KEY (codpagamento)
        REFERENCES formas_Pagamento (codpagamento),
        CONSTRAINT FOREIGN KEY (codusuario)
        REFERENCES usuario (codusuario)
);

