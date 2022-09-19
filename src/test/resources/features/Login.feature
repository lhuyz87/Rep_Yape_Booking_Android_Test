#Author: your.email@your.domain.com
@tag
Feature: Login APP Nativa

  @Login @RegresionPoliza
  Scenario Outline: Login
    Given inicio el app Mundo Rimac "<dniUser>", "<passUser>"
    When selecciono el producto "<taller>"

    Examples: 
      | dniUser  | passUser  | taller              |
      | 71796666 | Rimac2022 | Sauce Labs Backpack |
      | 71796666 | Rimac2022 | Sauce Labs Backpack |
