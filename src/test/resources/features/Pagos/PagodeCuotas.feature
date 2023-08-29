#Author: Candy Espinoza
@ModuloPagos_6_7
Feature: Pagos


  @PagoAsociandoTarjeta
  Scenario Outline: Realizar Pago exitoso asociado a tarjeta- Tap de Pagos
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a un seguro Vehicular desde el Menù seleccionando la "<placa>" "<vigencia>" del vehiculo
    And ingreso mis datos bancarios desde la opcion pagar cuotas para suscribir mi tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>" para realizar el pago
    Then debe mostrar el mensaje de confirmación ¡Hemos recibido tu pago!

    Examples:
     ###DATOS###@Pagos|1@PagoAsociandoTarjeta
      | 0 | tipoID | id | password | placa | numtarjeta | fecha | cvv | vigencia |

  @PagoAfiliadoDebitoAuto
  Scenario Outline: Realizar Pago estando afiliado a debito automatico - Tap de Pagos
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a un seguro Vehicular desde el Menù seleccionando la "<placa>" "<vigencia>" del vehiculo
    And ingreso mis datos bancarios desde la opcion pagar cuotas estando afilidado a debito automatico "<numtarjeta>" , "<cvv>" y "<fecha>"
    Then debe mostrar el mensaje de confirmación ¡Hemos recibido tu pago!

    Examples:
    ###DATOS###@Pagos|1@PagoAfiliadoDebitoAuto
      | 0 | tipoID | id | password | placa | numtarjeta | fecha | cvv |vigencia |

  @PagoPolizaSoat
  Scenario Outline: Validar Pago Poliza Soat en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingresamos al seguro SOAT desde el menú
    Then debe mostrar el detalle del pago anual

    Examples:
     ###DATOS###@Pagos|1@PagoPolizaSoat
      | 0 | tipoID | id | password |

  @PagoConValidacionHistorial
  Scenario Outline: Realizar Pago Seguro Vehicular Exitoso validando historial de pago en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se realiza el pago del seguro vehicular de la "<placa>" "<vigencia>" del vehiculo con la tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>"
    And debe mostrar el mensaje ¡Hemos recibido tu pago!
    Then se valida la cuota pagada en el historial de pago

    Examples:
    ###DATOS###@Pagos|1@PagoConValidacionHistorial
      | 0 | tipoID | id | password | placa | numtarjeta | fecha | cvv |vigencia |

  @PagoSinTarjetaAsociada
  Scenario Outline: Realizar Pago Seguro Vehicular Exitoso sin tarjeta asociada en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle de pago de la "<placa>" "<vigencia>" del vehiculo
    And se agrega la tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>" para realizar el pago
    Then debe mostrar el mensaje ¡Hemos recibido tu pago!

    Examples:
     ###DATOS###@Pagos|1@PagoSinTarjetaAsociada
      | 0 | tipoID | id | password | placa | numtarjeta | fecha | cvv |vigencia |

  @PagoConTarjetaAsociada
  Scenario Outline: Realizar Pago Seguro Vehicular Exitoso con tarjeta asociada en Mundo Rimac
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se realiza el pago del seguro vehicular de la "<placa>" "<vigencia>" del vehiculo
    Then debe mostrar el mensaje ¡Hemos recibido tu pago!

    Examples:
    ###DATOS###@Pagos|1@PagoConTarjetaAsociada
      | 0 | tipoID | id       | password  | placa      | vigencia |
