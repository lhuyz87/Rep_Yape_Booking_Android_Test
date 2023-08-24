#Author: Candy Espinoza
@ModuloPagos_6_7
Feature: Pagos

  @CronogramaPagos
  Scenario Outline: Ver el Cronograma de Pagos de una poliza Vehicular-Tap Pagos y se ve el listado de cuotas
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del Seguro Vehicular "<placa>" "<vigencia>"
    And ingreso a las cuotas por pagar
    Then debe mostrar el listado de las cuotas

    Examples:
     ###DATOS###@Pagos|1@PagoConTarjetaAsociada
      | 0 | tipoID | id | password | placa | vigencia |

  @HistorialPagos
  Scenario Outline: Ver el Historial de Pagos de una poliza Vehicular-Tap Pagos y se ve el listado de cuotas
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del Seguro Vehicular "<placa>" "<vigencia>"
    And ingreso a historial de pagos
    Then debe mostrar el listado de pagos desde historial de pagos

    Examples:
    ###DATOS###@Pagos|1@PagoConTarjetaAsociada
      | 0 | tipoID | id | password | placa | vigencia |

  @DescargaHistorialPagos
  Scenario Outline: Descargar el historial de pagos de una poliza vehicular
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del Seguro Vehicular "<placa>" "<vigencia>"
    And descargo el historial desde el tab de pagos
    Then debe mostrar el pdf con el historial de pagos

      Examples:
       ###DATOS###@Pagos|1@PagoConTarjetaAsociada
        | 0 | tipoID | id | password | placa | vigencia |
