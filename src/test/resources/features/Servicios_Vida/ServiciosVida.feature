@ModuloServicioVida_1_7
Feature: Servicios Vida

  @TiempoInactividadConsultasVidaHome
  Scenario Outline: Esperar 15 min de inactividad en el modulo de Consultas Vida desde Home
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer el detalle del estado de cuenta del "<año>" y del "<mes>" ingresando desde Home
    And se mantiene inactivo en la previsualización del pdf
    Then debe validar el mensaje para retornar al Login desde plan Vida Flexible

    Examples:
    ###DATOS###@ServiciosVida|1@TiempoInactConsultasVidaHome
      | 0 | tipoID | id | password |mes  | año  |
