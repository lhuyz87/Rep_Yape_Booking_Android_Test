#Author: Candy Espinoza
Feature: Pagos

  @PagoExitosoAsociadoTarjeta
  Scenario Outline: Realizar Pago exitoso asociado a tarjeta- Tap de Pagos
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a un seguro Vehicular desde el Menù seleccionando la "<placa>" del vehiculo
    And ingreso mis datos bancarios desde la opcion pagar cuotas para suscribir mi tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>" para realizar el pago
    Then debe mostrar el mensaje de confirmación ¡Hemos recibido tu pago!
    And elimino la tarjeta afiliada "<numtarjeta>" desde Mi Perfil

    Examples:
     ###DATOS###@Data|1@PagoExitosoAsociadoTarjeta
      | 0 | tipoID | id | password | placa | numtarjeta | fecha | cvv |
      |10|DNI|44926877|Rimac2020|En trámite|4919107570913512|03/28|111|

  @PagoPolizaSoat
  Scenario Outline: Validar Pago Poliza Soat en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingresamos al seguro SOAT desde el menú
    Then debe mostrar el detalle del pago anual

    Examples:
      | tipoID | id       | password  |
      | DNI    | 44926877 |  Rimac2020 |

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
      |1|DNI|45642376|Rimac2021|H2W-613|

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
      |1|DNI|40010131|Rimac2021|En trámite|4919107570913512|03/28|111|

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
      |1|DNI|45642376|Rimac2021|BAD-098|
