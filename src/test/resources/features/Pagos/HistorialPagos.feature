#Author: Candy Espinoza
Feature: Pagos

  @DescargaHistorialPagos
    Scenario Outline: Descargar el historial de pagos de una poliza vehicular
    Given realiza el login con credenciales
    | tipoID   | id   | password   |
    | <tipoID> | <id> | <password> |
    When se ingresa al detalle del Seguro Vehicular desde Seguros
    And descargo el historial desde el tab de pagos
    Then debe mostrar el pdf con el historial de pagos

      Examples:
      | tipoID | id       | password  |
      | DNI    | 29724303 | Rimac2021 |