@ModuloServiciosVehiculares_6_17
Feature: Servicios Vehiculares - Asistencia Vehicular

  @AsistenciaVehicularRepuesto
  Scenario Outline: Solicitar Auxilio Mecanico - Repuesto
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Auxilio mecánico" y el "<problema>" del vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"
    And se debe mostrar el seguimiento de la asistencia vehicular "Auxilio mecánico" de la "<placa>"

    Examples:
      | tipoID | id       | password  | placa  | problema         |
      | DNI    | 22093296 | Rimac2020 | ASQ191 | Cambio de llanta |

  #@SeguimientoAsistenciaVehicularRepuesto
  #Scenario Outline: Realizar el Flujo del Seguimiento de cambio de llanta con Repuesto
  #  Given realiza el login con credenciales
  #    | tipoID   | id   | password   |
  #    | <tipoID> | <id>     | <password> |
  #  Then se debe mostrar el seguimiento de la asistencia vehicular "Auxilio mecánico" de la "<placa>"

  #  Examples:
  #    | tipoID | id       | password  | placa  |
  #    | DNI    | 22093296 | Rimac2020 | ASQ191 |

  @AsistenciaVehicularProblema
  Scenario Outline: Solicitar Auxilio Mecanico - Problema
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Auxilio mecánico" y el "<problema>" del vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"
    And se debe mostrar el seguimiento de la asistencia vehicular "Auxilio mecánico" de la "<placa>"

    Examples:
      | tipoID | id       | password  | placa  | problema     |
      | DNI    | 22093296 | Rimac2020 | ASE310 | Batería baja |

 # @SeguimientoAsistenciaVehicularProblema
 # Scenario Outline: Realizar el Flujo del Seguimiento de auxilio mecanico por Problema
 #   Given realiza el login con credenciales
  #    | tipoID   | id   | password   |
  #    | <tipoID> | <id>     | <password> |
 #   Then se debe mostrar el seguimiento de la asistencia vehicular "Auxilio mecánico" de la "<placa>"

  #  Examples:
  #    | tipoID | id       | password  | placa  |
  #    | DNI    | 22093296 | Rimac2020 | ASE310 |

  @AsistenciaVehicularGrua
  Scenario Outline: Realizar una solicitud de Grua
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Grúa" y la zona en donde se encuentra el vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"
    And se debe mostrar el seguimiento de la asistencia vehicular "Grúa" de la "<placa>"

    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 41430164 | Rimac2020 | AWA099 |

  #@SeguimientodeGrua
  #Scenario Outline: Realizar el Flujo del Seguimiento de Solicitar Grua
  #  Given realiza el login con credenciales
  #    | tipoID   | id   | password   |
  #    | <tipoID> | <id>     | <password> |
  #  Then se debe mostrar el seguimiento de la asistencia vehicular "Grúa" de la "<placa>"

  #  Examples:
  #    | tipoID | id       | password  | placa  |
  #    | DNI    | 41430164 | Rimac2020 | AWA099 |

  @TiempoInactividadServicioVehicular
  Scenario Outline: Esperar 15 min de inactividad en Asistencias Vehiculares
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Auxilio mecánico" y el "<problema>" del vehiculo
    And se mantiene inactivo el modulo en Asistencias Vehiculares
    Then se valida el mensaje para retornar al Login
    Examples:
      | tipoID | id       | password  | placa  |problema     |
      | DNI    | 22093296 | Rimac2020 | ASE310 |Batería baja |
