#Author: Candy Espinoza
@ModuloPagos_6_7
Feature: Informacion de pagos

  @CronogramaPagos
  Scenario Outline: Ver el Cronograma de Pagos de una poliza Vehicular-Tap Pagos y se ve el listado de cuotas
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del Seguro Vehicular desde la opcion Seguros
    And ingreso a las cuotas por pagar
    Then debe mostrar el listado de las cuotas

    Examples:
      ###DATOS###@Pagos|1@CronogramaPagos
      | 0 | tipoID | id | password |

  @HistorialPagos
  Scenario Outline: Ver el Historial de Pagos de una poliza Vehicular-Tap Pagos y se ve el listado de cuotas
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del Seguro Vehicular desde la opcion Seguros
    And ingreso a historial de pagos
    Then debe mostrar el listado de pagos desde historial de pagos

    Examples:
      ###DATOS###@Pagos|1@HistorialPagos
      | 0 | tipoID | id | password |

  @DescargaHistorialPagos
    Scenario Outline: Descargar el historial de pagos de una poliza vehicular
    Given realiza el login con credenciales
    | tipoID   | id   | password   |
    | <tipoID> | <id> | <password> |
    When se ingresa al detalle del Seguro Vehicular desde la opcion Seguros
    And descargo el historial desde el tab de pagos
    Then debe mostrar el pdf con el historial de pagos

      Examples:
      ###DATOS###@Pagos|1@DescargaHistorialPagos
        | 0 | tipoID | id | password |
