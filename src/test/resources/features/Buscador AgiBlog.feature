Feature: Buscador AgiBlog
  Scenario: Realizar Busca no AgiBlog com Sucesso
    Given que acesse ao AgiBlog
    When eu realizo a busca por "Pix" na barra de pesquisa
    Then o sistema deve exibir os resultados relacionados ao termo pesquisado


  Scenario: Realizar Busca inexistente no AgiBlog
    Given que acesse ao AgiBlog
    When eu realizo a busca por "PinheiroDeGoiabada" na barra de pesquisa
    Then a pesquisa deve me retornar "Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras."