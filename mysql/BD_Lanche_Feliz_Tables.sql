USE bar;

CREATE TABLE alimento (  
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	descricao TEXT
);

CREATE TABLE cardapio (  
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nome VARCHAR (30),
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
	cpf VARCHAR (14) NOT NULL,
    nome VARCHAR (50) NOT NULL,
    email VARCHAR (50) NOT NULL,
    id_cardapio INT,
	PRIMARY KEY (cpf),
    FOREIGN KEY (id_cardapio) REFERENCES cardapio (id)
);