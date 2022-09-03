#Author: your.email@your.domain.com
@tag
Feature: Login APP Nativa

  @Login @RegresionPoliza
  Scenario Outline: Login
    Given inicio el app Mundo Rimac
    When selecciono el producto "<taller>"

    Examples: 
      |taller|
      |Sauce Labs Backpack|