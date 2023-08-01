#Author: Candy Espinoza
@ModuloCrossellRenovacion_4_13
Feature: Venta SOAT

  @CompraSOATDigital
  Scenario Outline: Plan SOAT Digital
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del SOAT para el vehiculo "<placa>"
    Then debe de mostrar el mensaje "¡Listo! Estamos por enviar tu SOAT"
    And elimino la tarjeta guardada "<numtarjeta>" desde Mi Perfil

    Examples:
   ###DATOS###@CrossellRenovacion|1@CompraSOATDigital
      | 0 | tipoID | id | password | placa | numtarjeta | cvv | fecha |


  @CompraSOATVial
  Scenario Outline: Plan SOAT Vial
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del plan vial para el vehiculo "<placa>"
    Then debe de mostrar el mensaje "¡Listo! Estamos por enviar tu SOAT"
    And elimino la tarjeta guardada "<numtarjeta>" desde Mi Perfil

    Examples:
   ###DATOS###@CrossellRenovacion|1@CompraSOATVial
      | 0 | tipoID | id | password | placa | numtarjeta | cvv | fecha |

  @CompraSOATPlus
  Scenario Outline: Plan SOAT Plus
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del plan plus para el vehiculo "<placa>"
    Then debe de mostrar el mensaje "¡Listo! Estamos por enviar tu SOAT"
    And elimino la tarjeta guardada "<numtarjeta>" desde Mi Perfil

    Examples:
   ###DATOS###@CrossellRenovacion|1@CompraSOATPlus
      | 0 | tipoID | id       | password  | placa  | numtarjeta       | cvv | fecha |

  @TiempoInactividadCrossellyRenovacion
  Scenario Outline: Esperar 15 min de inactividad en el modulo Crossell y Renovacion
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
   # And elimino la tarjeta guardada "<numtarjeta>" desde Mi Perfil
    When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del SOAT Plan Vial para el vehiculo "<placa>"
    And se mantiene inactivo el modulo en la pantalla de confirmación de la compra
    Then se valida el mensaje para retornar al Login desde la pantalla de confirmación de compra

    Examples:
   ###DATOS###@CrossellRenovacion|1@TiempoInactividadCrossellyRenov
      | 0 | tipoID | id | password | placa | numtarjeta | cvv | fecha |
