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
      | tipoID | id       | password  | placa   |
      | DNI    | 45642376 | Rimac2021 | H2W-613 |


  @PagoSinTarjetaAsociada
  Scenario Outline: Realizar Pago Seguro Vehicular Exitoso sin tarjeta asociada en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle de pago de la "<placa>" del vehiculo
    And se agrega la tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>" para realizar el pago
    Then debe mostrar el mensaje ¡Hemos recibido tu pago!

    Examples:
      | tipoID | id       | password  | placa      | numtarjeta       | fecha | cvv |
      | DNI    | 40320677 | Rimac2020 | En trámite | 4919107570913512 | 03/28 | 111 |

