@AsistenciaVehicular
Feature: Solicitar Asistencia Vehicular

  @AsistenciaVehicularRepuesto
  Scenario Outline: Solicitar Auxilio Mecanico - Repuesto
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Auxilio mecánico" y el "<problema>" del vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"

    Examples:
      | tipoID | id       | password  | placa  | problema         |
      | DNI    | 22093296 | Rimac2020 | ASQ191 | Cambio de llanta |

  @SeguimientoAsistenciaVehicularRepuesto
  Scenario Outline: Validar el seguimiento del Auxilio Mecanico - Repuesto
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    Then se debe mostrar el seguimiento de la asistencia vehicular "Auxilio mecánico" de la "<placa>"

    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 22093296 | Rimac2020 | ASQ191 |

  @AsistenciaVehicularProblema
  Scenario Outline: Solicitar Auxilio Mecanico- Problema
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Auxilio mecánico" y el "<problema>" del vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"

    Examples:
      | tipoID | id       | password  | placa  | problema     |
      | DNI    | 22093296 | Rimac2020 | AYA522 | Batería baja |

  @SeguimientoAsistenciaVehicularProblema
  Scenario Outline: Validar el seguimiento del Auxilio Mecanico - Problema
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    Then se debe mostrar el seguimiento de la asistencia vehicular "Auxilio mecánico" de la "<placa>"

    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 22093296 | Rimac2020 | AYA522 |

  @AsistenciaVehicularGrua
  Scenario Outline: Solicitar Asistencia - Grua
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Grúa" y la zona en donde se encuentra el vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"

    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 41430164| Rimac2020 | AWA099 |

  @SeguimientoAsistenciaVehicularGrua
  Scenario Outline: Validar el seguimiento de la Asistencia - Grua
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    Then se debe mostrar el seguimiento de la asistencia vehicular "Grúa" de la "<placa>"

    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 41430164| Rimac2020 | AWA099 |

  @TiempoInactividadServiciosSOAT
  Scenario Outline: Esperar 15 min de inactividad - Modulo Asistencias Vehiculares
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se mantiene inactivo el modulo
    Then se valida el mensaje para retornar al Login
    Examples:
      | tipoID | id       | password  |
      | DNI    | 40861606 | Rimac2021 |
