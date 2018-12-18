USE bar;

SELECT * FROM cardapio;

SELECT * FROM alimento;

SELECT * FROM alim_card;

SELECT * FROM cliente;

SELECT cardapio.id, cardapio.nome, cardapio.decricao, selecao.quantidade FROM cardapio, (SELECT id, COUNT(id) AS quantidade FROM cliente INNER JOIN cardapio ON cardapio.id = cliente.id_cardapio GROUP BY id ORDER BY COUNT(id) DESC LIMIT  5) AS selecao WHERE cardapio.id = selecao.id;