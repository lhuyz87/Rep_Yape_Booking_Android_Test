Feature: Servicios Vehiculares - Asistencia Vehicular

  @AsistenciaVehicularRepuesto @ModuloServiciosVehiculares_9_17 @regresion
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
       ###DATOS###@ServiciosVehiculares|1@AsistenciaVehicularRepuesto
      | 0 | tipoID | id | password | placa  | problema         |

  @AsistenciaVehicularProblema @ModuloServiciosVehiculares_9_17 @regresion
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
     ###DATOS###@ServiciosVehiculares|1@AsistenciaVehicularProblema
      | 0 | tipoID | id | password | placa  | problema         |

  @AsistenciaVehicularGrua @ModuloServiciosVehiculares_9_17
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
     ###DATOS###@ServiciosVehiculares|1@AsistenciaVehicularGrua
      | 0 | tipoID | id | password | placa  |

  @NecesitoAyudaAuxilioMecanico @ModuloServiciosVehiculares_9_17 @regresion
  Scenario Outline: Necesito ayuda para seleccionar la asistencia Vehicular - Auxilio Mecanico
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono "Ayúdame a elegir una" con la "<opción>"
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"

    Examples:
    ###DATOS###@ServiciosVehiculares|1@NecesitoAyudaAuxilioMecanico
      | 0 | tipoID | id | password | placa  |opción             |

  @NecesitoAyudaGrua @ModuloServiciosVehiculares_9_17
  Scenario Outline: Necesito ayuda  Para seleccionar la asistencia Vehicular - Grua
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono "Ayúdame a elegir una" con la "<opción>" y la indicación de la zona del vehiculo
    And confirmo los terminos de la solicitud
    Then se debe mostrar el mensaje : "¡Solicitud enviada!"

    Examples:
    ###DATOS###@ServiciosVehiculares|1@NecesitoAyudaGrua
      | 0 | tipoID | id | password | placa  |opción             |

  @TiempoInactividadServicioVehicular @TiempoInactAndroid
  Scenario Outline: Esperar 15 min de inactividad en Asistencias Vehiculares
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And selecciono la asistencia "Auxilio mecánico" y el "<problema>" del vehiculo
    And se mantiene inactivo el modulo en Asistencias Vehiculares
    Then se valida el mensaje para retornar al Login
    Examples:
    ###DATOS###@ServiciosVehiculares|1@TiempoInactividadServicioVehicu
      | 0 | tipoID | id | password | placa  |problema             |
