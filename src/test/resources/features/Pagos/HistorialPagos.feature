#Author: Candy Espinoza
@ModuloPagos_5_7
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
      ###DATOS###@Data|1@DescargaHistorialPagos
        | 0 | tipoID | id | password |
