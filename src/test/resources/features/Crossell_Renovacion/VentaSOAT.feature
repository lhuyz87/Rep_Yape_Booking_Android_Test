#Author: Candy Espinoza
Feature: Venta SOAT

  @CompraSOATDigital
  Scenario Outline: Plan SOAT(DIGITAL)
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del SOAT para el vehiculo "<placa>"
    Then debe de mostrar el mensaje "¡Listo! Estamos por enviar tu SOAT"
    And elimino la tarjeta guardada "<numtarjeta>" desde Mi Perfil

    Examples:
      | tipoID | id       | password  | placa  | numtarjeta       | cvv | fecha |
      | DNI    | 23977057 | Rimac2020 | AXT435 | 4919107570913512 | 111 | 03/28 |


  @TiempoInactividadCrossellyRenovacion
  Scenario Outline: Esperar 15 min de inactividad en el modulo Crossell y Renovacion
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    And elimino la tarjeta guardada "<numtarjeta>" desde Mi Perfil
    When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del SOAT Plan Vial para el vehiculo "<placa>"
    And se mantiene inactivo el modulo en la pantalla de confirmación de la compra
    Then se valida el mensaje para retornar al Login desde la pantalla de confirmación de compra

    Examples:
      | tipoID | id       | password  | placa  | numtarjeta       | cvv | fecha |
      | DNI    | 23977057 | Rimac2020 | ACE187 | 4919107570913512 | 111 | 03/28 |