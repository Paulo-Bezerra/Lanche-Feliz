CREATE DATABASE bar;

USE bar;

CREATE TABLE alimento (  
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR (30),
	descricao TEXT
);

CREATE TABLE cardapio (  
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nome VARCHAR (30),
	descricao TEXT
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

INSERT INTO cardapio (id,nome) VALUES 
(DEFAULT, 'Macarronada'),
(DEFAULT, 'Feijoada'),
(DEFAULT, 'Sopa'),
(DEFAULT, 'Escondidinho'),
(DEFAULT, 'Lasanha'),
(DEFAULT, 'Salada'),
(DEFAULT, 'Comida'),
(DEFAULT, 'Rapadura com farinha'),
(DEFAULT, 'Galinhada'),
(DEFAULT, 'Feijão tropero'),
(DEFAULT, 'Feijão verde com carne');

INSERT INTO alimento (id,nome, descricao) VALUES 
(DEFAULT, 'Macarrão', 'comida'),
(DEFAULT, 'Arroz', 'comida'),
(DEFAULT, 'Feijão', 'comida'),
(DEFAULT, 'Carne de Gado', 'comida'),
(DEFAULT, 'Galinha', 'comida'),
(DEFAULT, 'Frango', 'comida'),
(DEFAULT, 'Cuzcus', 'comida'),
(DEFAULT, 'Farinha', 'comida'),
(DEFAULT, 'isso', 'comida'),
(DEFAULT, 'Agua', 'comida'),
(DEFAULT, 'Fruta', 'comida');


INSERT INTO cliente (cpf, nome, email, id_cardapio) VALUES
('168.852.653-07', 'robeval', 'robsonhhhhh', 1),
('458.456.653-55', 'mirian', 'lokjjjaaa', 2),
('966.456.653-48', 'robeva', 'robsonhhhhh', 2),
('168.111.653-07', 'robivall', 'robsonhhhhh', 3),
('986.456.653-07', 'mara', 'robsonhhhhh', 3),
('168.456.653-66', 'luqinha', 'robsonhhhhh', 3),
('168.456.653-75', 'dick', 'robsonhhhhh', 4),
('168.456.653-78', 'joca', 'robsonhhhhh', 4),
('168.456.653-01', 'pedo', 'robsonhhhhh', 4),
('168.456.653-09', 'josafa', 'robsonhhhhh', 4),
('168.456.785-78', 'and', 'robsonhhhhh', 5),
('168.456.653-85', 'lucinha', 'robsonhhhhh', 5),
('168.456.653-96', 'romario', 'robsonhhhhh', 5),
('168.456.584-55', 'ronaldinho', 'robsonhhhhh', 9),
('168.986.963-99', 'garrinha', 'robsonhhhhh', 9),
('168.786.653-77', 'pele', 'robsonhhhhh', 7),
('168.123.653-17', 'cleyton', 'robsonhhhhh', 7),
('152.456.653-87', 'whinderson', 'robsonhhhhh', 7),
('168.456.653-38', 'mane', 'robsonhhhhh', 7),
('168.456.653-97', 'jose', 'robsonhhhhh', 8),
('168.456.653-87', 'gerold', 'robsonhhhhh', 6),
('168.456.653-37', 'teobaldo', 'robsonhhhhh', 10),
('455.456.653-07', 'vadalco', 'robsonhhhhh', 8),
('999.456.653-07', 'thomas', 'robsonhhhhh', 9),
('102.456.653-07', 'juliclei', 'robsonhhhhh', 4),
('486.456.653-07', 'jubileu', 'robsonhhhhh', 5),
('111.111.111-11', 'irineu', 'irineu@doce', 11);

SELECT * FROM cardapio;

SELECT * FROM alimento;

SELECT * FROM alim_card;

SELECT * FROM cliente;

SELECT cardapio.id, cardapio.nome, cardapio.descricao, selecao.quantidade FROM cardapio, (SELECT id, COUNT(id) AS quantidade FROM cliente INNER JOIN cardapio ON cardapio.id = cliente.id_cardapio GROUP BY id ORDER BY COUNT(id) DESC LIMIT  5) AS selecao WHERE cardapio.id = selecao.id;


delete from cardapio where id = 9;


SELECT id FROM cardapio;