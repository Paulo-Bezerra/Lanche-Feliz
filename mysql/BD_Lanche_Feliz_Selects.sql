USE bar;

SELECT * FROM cardapio;

SELECT * FROM alimento;

SELECT * FROM alim_card;

SELECT * FROM cliente;

SELECT cardapio.id, cardapio.nome, cardapio.decricao, selecao.quantidade FROM cardapio, (SELECT id, COUNT(id) AS quantidade FROM cliente INNER JOIN cardapio ON cardapio.id = cliente.id_cardapio GROUP BY id ORDER BY COUNT(id) DESC LIMIT  5) AS selecao WHERE cardapio.id = selecao.id;

SELECT cardapio.nome AS cardapios, alimento.nome AS Alimento FROM cardapio, alimento, alim_card WHERE alimento.id = id_alimento AND cardapio.id = id_cardapio;

SELECT * FROM cardapio WHERE id = 28;

SELECT alimento.nome AS alimento FROM cardapio, alimento, alim_card WHERE alimento.id = id_alimento AND cardapio.id = id_cardapio AND id_cardapio = 28;

SELECT alimento.nome FROM alimento, (SELECT id_alimento AS id FROM alim_card  WHERE id_cardapio = 28) AS selecao WHERE alimento.id = selecao.id;