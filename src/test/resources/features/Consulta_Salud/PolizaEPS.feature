#Author: Candy Espinoza
@ModuloConsultaSalud_1_5
Feature: Consulta Salud - Plan Medico EPS

  @ConsultaNumeroDePoliza
  Scenario Outline: Consulta el numero de la poliza
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del seguro de Salud
    Then Se valida el número de póliza

    Examples:
      | tipoID | id       | password  |
      | DNI    | 10318552 | Rimac2020 |

  @TiempoInactividadConsultasSalud
  Scenario Outline: Esperar 15 min de inactividad en el modulo de seguro Consulta Salud
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al detalle del seguro Planes Medicos EPS
    And se visualiza el numero de póliza del seguro
    And se mantiene inactivo en la sección poliza
    Then debe validar el mensaje para retornar al Login desde seguros Consulta de póliza

    Examples:
      | tipoID | id       | password  |
      | DNI    | 40660901 | Rimac2021 |
