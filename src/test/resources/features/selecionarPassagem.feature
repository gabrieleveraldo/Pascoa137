##language: pt
#
#  Funcionalidade: Selecionar Passagem
#    Cenário: Selecionar Passagem com Sucesso
#      Dado que acesso o site Blazedemo
#      Quando seleciono a origem como "São Paolo" e destino "Berlin"
#      E clico em Procurar Voo
#      Então é exibida a frase indicando voo entre "São Paolo" e "Berlin"

  Feature: Selecionar Passagem
    Scenario: Selecionar Passagem com Sucesso

    Given que acesso o site Blazedemo
    When seleciono a origem como "São Paolo" e destino "Berlin"
    And clico em Procurar Voo
    Then é exibida a frase indicando voo entre "São Paolo" e "Berlin"

