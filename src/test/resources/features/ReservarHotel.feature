#Author: Luis Retamozo
@ReservarHotel
Feature: Poder realizar la reserva de un hotel

  @ValidarMonto
  Scenario Outline: Validar la correcta cotización al realizar una reserva
    Given realiza el login con cuenta google
    And ingreso los datos de busqueda de alojamiento destino "<destino>", fecha de ida "<ida>", fecha de regreso "<regreso>"
    And ingreso la cantidad de habitación "<habitaciones>", la cantidad de adultos "<adultos>" y la edad de niños  "<ninos>"
    And realizamos la busqueda
    And seleccionamos el hotel de preferencia "<hotel>"
    And confirmamos la elección de la habitación y la reserva
    And ingresamos los datos del cliente:
      | Nombre | Apellido | e-mail            | Direccion          | codigo Postal | Ciudad | Pais | Telefono  | Motivo Viaje |
      | Luis   | Retamozo | lhuyz87@gmail.com | calle siempre viva |        101901 | Lima   | Perú | 992937222 | Negocios     |
    When confirmar los datos de la reserva
    And ingresar los datos de la tarjeta de crédito:
      | Numero de Tarjeta | Fecha de vencimiento |
      |  4970110000000062 | 02/28                |
    Then validamos el monto total de la reserva sea correcto "<monto esperado>"

    Examples: 
      | destino | ida             | regreso         | habitaciones | adultos | ninos    | hotel            | monto esperado |
      | Cuzco   | 23 octubre 2023 | 28 octubre 2023 |            1 |       2 | 1-5 años | Palacio del Inka |           3874 |

  @ValidarRealizacionReserva
  Scenario Outline: Validar que se genere una reserva correctamente
    Given realiza el login con cuenta google
    And ingreso los datos de busqueda de alojamiento destino "<destino>", fecha de ida "<ida>", fecha de regreso "<regreso>"
    And ingreso la cantidad de habitación "<habitaciones>", la cantidad de adultos "<adultos>" y la edad de niños  "<ninos>"
    And realizamos la busqueda
    And seleccionamos el hotel de preferencia "<hotel>"
    And confirmamos la elección de la habitación y la reserva
    And ingresamos los datos del cliente:
      | Nombre | Apellido | e-mail            | Direccion          | codigo Postal | Ciudad | Pais | Telefono  | Motivo Viaje |
      | Luis   | Retamozo | lhuyz87@gmail.com | calle siempre viva |        101901 | Lima   | Perú | 992937222 | Negocios     |
    When confirmar los datos de la reserva
    And ingresar los datos de la tarjeta de crédito:
      | Numero de Tarjeta | Fecha de vencimiento |
      |  4970110000000062 | 02/28                |
    And confirmamos el pago de la reserva
    Then validamos que se muestre el mensaje "<mensaje esperado>"

    Examples: 
      | destino | ida             | regreso         | habitaciones | adultos | ninos    | hotel            | mensaje esperado           |
      | Cuzco   | 23 octubre 2023 | 28 octubre 2023 |            1 |       2 | 1-5 años | Palacio del Inka | Confirmación de la reserva |
