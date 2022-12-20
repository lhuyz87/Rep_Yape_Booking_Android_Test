#Author: Luis Retamozo
@BuscadordeClinicas
Feature: Buscador de clínicas

  @BuscadordeClinicasdesdeHome
  Scenario Outline: Buscador de clinicas desde Home
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When selecciona la opción Búsqueda de clínicas desde Home y se inicia el tramite
    And al filtrar la clínica "<nomClinica>"
    Then al seleccionarla debe mostrar su monto de copago "<copago>"

    Examples: 
      | tipoID | id       | password  | nomClinica           |copago|
      | DNI    | 40660901 | Rimac2021 | Clinica Javier Prado |S/ 45.00|

  @BuscadordeClinicasdesdeTramites
  Scenario Outline: Buscador de clinicas desde menu Tramites
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |  
    When selecciona la opción Búsqueda de clínicas desde menu Tramites y se inicia el tramite
    And al filtrar la clínica "<nomClinica>"
    Then al seleccionarla debe mostrar su monto de copago

    Examples: 
      | tipoID | id       | password  | nomClinica           |
      | DNI    | 40660901 | Rimac2021 | Clinica Javier Prado |