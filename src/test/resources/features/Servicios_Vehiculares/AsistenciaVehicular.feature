@AsistenciaVehicular
Feature: Solicitar Asistencia Vehicular


  Scenario Outline: Solicitar Asistencia Vehicular - Auxilio Mecanico
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Auxilio mecánico" y el "<problema>" del vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"

    @AsistenciaVehicularRepuesto
    Examples:
      | tipoID | id       | password  | placa  | problema         |
      | DNI    | 09328751 | Rimac2021 | ASK098 | Cambio de llanta |
    @AsistenciaVehicularProblema
    Examples:
      | tipoID | id       | password  | placa  | problema     |
      | DNI    | 29352104 | Rimac2020 | ALZ225 | Batería baja |

  @SeguimientoAuxilioMecanico
  Scenario Outline: Validar el seguimiento de la Asistencia Vehicular - Auxilio Mecanico
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    Then se debe mostrar el seguimiento de la asistencia vehicular "Auxilio mecánico" de la "<placa>"

    @SeguimientoAsistenciaVehicularRepuesto
    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 09328751 | Rimac2021 | ASK098 |
    @SeguimientoAsistenciaVehicularProblema
    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 29352104 | Rimac2020 | ALZ225 |

  @AsistenciaVehicularGrua
  Scenario Outline: Solicitar Asistencia Vehicular - Grua
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Grúa" y la zona en donde se encuentra el vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"

    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 40861606 | Rimac2021 | FGH456 |

  @SeguimientoAsistenciaVehicularGrua
  Scenario Outline: Validar el seguimiento de la Asistencia Vehicular - Grúa
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    Then se debe mostrar el seguimiento de la asistencia vehicular "Grúa" de la "<placa>"

    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 40861606 | Rimac2021 | FGH456 |
