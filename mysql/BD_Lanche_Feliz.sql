CREATE DATABASE bar;

USE bar;

CREATE TABLE cliente(
	cpf varchar(14) PRIMARY KEY NOT NULL,
    nome varchar(255),
    email varchar(255)
);

CREATE TABLE categoria(
	id_categoria INT(5) PRIMARY KEY NOT NULL,
    info_cate TEXT
);

CREATE TABLE cardapio(
	id_Cardapio int(10) auto_increment not null primary key,
    nome varchar(100),
    tipo varchar(100),
    id_categoria int,
    CONSTRAINT fk_CateCarda FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE estoque(
	id_estoque int(10) auto_increment not null primary key,
    quantidade int(10),
    data_validade date,
    id_cardapio int,
    CONSTRAINT fk_CardaEst FOREIGN KEY (id_cardapio) REFERENCES cardapio(id_cardapio)
);

select * from cliente;


