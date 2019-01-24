CREATE DATABASE bar
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

USE bar;

CREATE TABLE alimento (  
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	descricao TEXT
)DEFAULT CHARSET = utf8;

CREATE TABLE cardapio (  
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nome VARCHAR (30),
	decricao TEXT
)DEFAULT CHARSET = utf8;

CREATE TABLE alim_card (  
	id_alimento  INT,  
	id_cardapio  INT,  
	PRIMARY KEY (id_alimento, id_cardapio),  
	FOREIGN KEY (id_alimento) REFERENCES alimento (id),  
	FOREIGN KEY (id_cardapio) REFERENCES cardapio (id) 
)DEFAULT CHARSET = utf8;

CREATE TABLE cliente(
	cpf VARCHAR (14) NOT NULL,
    nome VARCHAR (50) NOT NULL,
    email VARCHAR (50) NOT NULL,
    id_cardapio INT,
	PRIMARY KEY (cpf),
    FOREIGN KEY (id_cardapio) REFERENCES cardapio (id)
)DEFAULT CHARSET = utf8;