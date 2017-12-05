Feature: Pesquisa no Mercado Livre
 
Scenario: Realizar uma pesquisa no site do mercado livre e imprimir SOMENTE título e valor dos CINCO primeiros resultados.

	Given Acessar a pagina do Mercado Livre.
	When No campo pesquisar,digitar o nome do produto.
	Then Exibir o titulo e o valor dos 5 primeiros produtos.

Scenario: Realizar uma pesquisa no site do mercado livre que contenha paginação.

	Given Acessar a pagina do Mercado Livre.
	When No campo pesquisar,digitar o nome do produto.
	Then Tirar um print do penultimo anuncio da segunda pagina.