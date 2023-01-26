@AsistenciaVehicular
Feature: Solicitar Asistencia Vehicular

  @AsistenciaVehicularAuxilioMecanico
  Scenario Outline: Solicitar Asistencia Vehicular - Auxilio Mecanico
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono el "<problema>" del vehiculo
    And confirmo los terminos de la solicitud
    Then valido el mensaje de la solicitud enviada y su visualizacion en el home

    Examples:

      | tipoID | id       | password  | placa  | problema         |
      #| DNI    | 40861606 | Rimac2020 | FGH456 | Batería baja |
      #| DNI    | 29352104 | Rimac2020 | ALK286 | Llaves dentro de tu vehículo |
      | DNI    | 29352104 | Rimac2020 | ALZ225 | Batería baja     |
      | DNI    | 29352104 | Rimac2020 | BAN126 | Cambio de llanta |
      #| DNI    | 29352104 | Rimac2020 | ALZ225 | Batería baja     |

