@TiempoInactividad

Feature: Ejecutar los Procesos por Modulo y esperar 15 min de inactividad

  @TiempoInactividadModulo
  Scenario Outline: Esperar 15 min de inactividad - M??dulo Asistencias Vehiculares
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Asistencias vehiculares desde Tramites y se mantiene inactivo el modulo
    Then se valida el mensaje para retornar al Login
    Examples:
      | tipoID | id       | password  |
      | DNI    | 40861606 | Rimac2020 |


