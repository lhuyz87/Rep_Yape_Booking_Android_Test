Feature: Tramite y siniestros

  @TiempoInactividadTramiteYSiniestro @TiempoInactAndroid
  Scenario Outline: Esperar 15 min de inactividad en el modulo Tramite y Siniestro
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso a menu tramites
    And  se mantiene inactivo el modulo en la pantalla tramites
    Then se valida el mensaje para retornar al login desde pantalla de pagos

    Examples:
     ###DATOS###@TramitesSiniestros|1@TiempoInactividadTramiteYSinies
      | 0 | tipoID | id | password |
