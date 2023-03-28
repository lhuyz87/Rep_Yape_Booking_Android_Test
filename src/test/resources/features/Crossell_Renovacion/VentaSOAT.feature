#Author: Candy Espinoza
Feature: Venta SOAT

  @CompraSOATDigital
  Scenario Outline: Plan SOAT(DIGITAL)
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del SOAT para el vehiculo "<placa>"
    Then debe de mostrar el mensaje "¡Listo! Estamos por enviar tu SOAT"

    Examples:
      | tipoID | id       | password  | placa  | numtarjeta       | cvv | fecha |
      | DNI    | 23977057 | Rimac2020 | AXT154 | 4474118355632240 | 111 | 03/28 |
