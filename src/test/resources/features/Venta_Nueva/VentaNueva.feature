@ModuloVentaNueva_1_7
  Feature: Venta nueva

@TiempoInactividadVentaNueva
  Scenario Outline: Esperar 15 min de inactividad en el modulo Venta nueva
  Given realiza el login con credenciales
    | tipoID   | id   | password   |
    | <tipoID> | <id> | <password> |
  When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del producto SOAT para el vehiculo "<placa>"
  And se mantiene inactivo el modulo en la pantalla de confirmación de la compra
  Then se valida el mensaje para retornar al Login desde la pantalla de confirmación de compra

  Examples:
    ###DATOS###@VentaNueva|1@TiempoInactividadVentaNueva
    | 0 | tipoID | id | password | placa | numtarjeta | fecha | cvv |

