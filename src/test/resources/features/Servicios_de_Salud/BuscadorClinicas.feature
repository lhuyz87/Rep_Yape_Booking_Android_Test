#Author: Luis Retamozo
@BuscadordeClinicas
Feature: Buscador de cl??nicas

  @BuscadordeClinicasdesdeHome
  Scenario Outline: Buscador de clinicas desde Home
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When selecciona la opci??n B??squeda de cl??nicas desde Home y se inicia el tramite
    And al filtrar la cl??nica "<nomClinica>"
    Then al seleccionarla debe mostrar su monto de copago "<copago>"

    Examples:
      | tipoID | id       | password  | nomClinica           |copago|
      | DNI    | 40660901 | Rimac2021 | Clinica Javier Prado |S/ 45.00|

  @BuscadordeClinicasdesdeTramites
  Scenario Outline: Buscador de clinicas desde menu Tramites
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When selecciona la opci??n B??squeda de cl??nicas desde menu Tramites y se inicia el tramite
    And al filtrar la cl??nica "<nomClinica>"
    Then al seleccionarla debe mostrar su monto de copago "<copago>"

    Examples:
      | tipoID | id       | password  | nomClinica           |copago|
      | DNI    | 40660901 | Rimac2021 | Clinica Javier Prado |S/ 45.00|
