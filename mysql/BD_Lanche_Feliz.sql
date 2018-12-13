CREATE DATABASE bar;

USE bar;

CREATE TABLE alimento (  
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	decricao TEXT
);

CREATE TABLE cardapio (  
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	decricao TEXT
);

CREATE TABLE alim_card (  
	id_alimento  INT,  
	id_cardapio  INT,  
	PRIMARY KEY (id_alimento, id_cardapio),  
	FOREIGN KEY (id_alimento) REFERENCES alimento (id),  
	FOREIGN KEY (id_cardapio) REFERENCES cardapio (id) 
);

CREATE TABLE cliente(
	cpf VARCHAR (14) NOT NULL PRIMARY KEY,
    nome VARCHAR (255) NOT NULL,
    email VARCHAR (255),
    id_cardapio INT,
    FOREIGN KEY (id_cardapio) REFERENCES cardapio (id)
);

SELECT * FROM cardapio;

SELECT * FROM alimento;

SELECT * FROM alim_card;

SELECT * FROM cliente;