#Author: Candy Espinoza
Feature: Consulta Salud - Plan Medico EPS

  @ConsultaNumeroDePoliza @ModuloConsultaSalud_2_5 @Salud_Vida_Vehicular
  Scenario Outline: Consulta el numero de la poliza
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del seguro de Salud
    Then Se valida el número de póliza

    Examples:
    ###DATOS###@ConsultaSalud|1@ConsultaNumeroDePoliza
      | 0 | tipoID | id | password |

  @TiempoInactividadConsultasSalud @TiempoInactAndroid
  Scenario Outline: Esperar 15 min de inactividad en el modulo de seguro Consulta Salud
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del seguro Planes Medicos EPS
    And se visualiza el numero de póliza del seguro
    And se mantiene inactivo en la sección poliza
    Then debe validar el mensaje para retornar al Login desde seguros Consulta de póliza

    Examples:
      ###DATOS###@ConsultaSalud|1@TiempoInactividadConsultasSalud
      | 0 | tipoID | id | password |
