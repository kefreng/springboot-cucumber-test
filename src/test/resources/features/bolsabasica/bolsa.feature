Feature: funcionalidades para bolsa

  Scenario: Poner un elemento en la bolsa
    Given la bolsa no esta vacia
    When vacio la bolsa
    Then la bolsa esta vacia
