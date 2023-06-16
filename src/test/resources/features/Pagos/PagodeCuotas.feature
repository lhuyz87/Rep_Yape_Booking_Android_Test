#Author: Candy Espinoza
Feature: Pagos

  @PagoConValidacionHistorial
  Scenario Outline: Realizar Pago Seguro Vehicular Exitoso validando historial de pago en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se realiza el pago del seguro vehicular de la "<placa>" del vehiculo
    And debe mostrar el mensaje ¡Hemos recibido tu pago!
    Then se valida la cuota pagada en el historial de pago

    Examples:
    ###DATOS###@Data|1@PagaConValidacionHistorial
      | 0 | tipoID | id | password | placa |

  @PagoSinTarjetaAsociada
  Scenario Outline: Realizar Pago Seguro Vehicular Exitoso sin tarjeta asociada en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle de pago de la "<placa>" del vehiculo
    And se agrega la tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>" para realizar el pago
    Then debe mostrar el mensaje ¡Hemos recibido tu pago!

    Examples:
     ###DATOS###@Data|1@PagoSinTarjetaAsociada
      | 0 | tipoID | id | password | placa | numtarjeta | fecha | cvv |

  @PagoConTarjetaAsociada
  Scenario Outline: Realizar Pago Seguro Vehicular Exitoso validando historial de pago en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se realiza el pago del seguro vehicular de la "<placa>" del vehiculo
    Then debe mostrar el mensaje ¡Hemos recibido tu pago!

    Examples:
    ###DATOS###@Data|1@PagaConTarjetaAsociada
      | 0 | tipoID | id | password | placa |
