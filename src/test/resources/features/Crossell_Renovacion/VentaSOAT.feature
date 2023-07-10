#Author: Candy Espinoza
@ModuloCrossellRenovacion_4_13
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
   ###DATOS###@CrossellRenovacion|1@CompraSOATDigital
      | 0 | tipoID | id | password | placa | numtarjeta | cvv | fecha |
