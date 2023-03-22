#Author: Candy Espinoza
@FeatureMediosdePago
Feature: Medios de Pago

 @SucripcionDesdePerfil
  Scenario Outline: Realizar la suscripcion de la tarjeta desde el perfil
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso mis datos bancarios desde Perfil para suscribir mi tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>"
    Then se debe agregar la tarjeta "<numtarjeta>" a Mis Tarjetas
     Examples:
       | tipoID | id       | password  | numtarjeta       | cvv | fecha |
       | DNI    | 29724303 | Rimac2021 | 4474104525811674 | 111 | 03/28 |


  @SucripcionDesdePagos
  Scenario Outline: Realizar la suscripcion de la tarjeta desde el tal de Pagos
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso mis datos bancarios desde el tab de Pagos para suscribir mi tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>"
    Then se debe agregar la tarjeta "<numtarjeta>" a Mis Tarjetas
    Examples:
      | tipoID | id       | password  | numtarjeta       | cvv | fecha |
      | DNI    | 29724303 | Rimac2021 | 4474104525811674 | 111 | 03/28 |


  @EliminarMedioPago
  Scenario Outline: Eliminar un Medio de Pago a una poliza Vehicular
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When realizo la eliminacion de la tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>"
    Then se debe eliminar la tarjeta "<numtarjeta>" de Mis Tarjetas
    Examples:
      | tipoID | id       | password  | numtarjeta       | cvv | fecha |
      | DNI    | 23977057 | Rimac2020 | 4474118355632240 | 111 | 03/28 |
