@ModuloServiciosSoat_1_5
Feature:Servicios de SOAT

  @TiempoInactividadServiciosSOAT
  Scenario Outline: Esperar 15 min de inactividad en el modulo Servicios de SOAT
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso a la opción Descuento en asistencias desde trámites
    And se mantiene inactiva la sesión en el módulo
    Then se valida el mensaje para retornar al Login desde el módulo Servicios de Soat

    Examples:
    ###DATOS###@ServiciosSoat|1@TiempoInactServiciosSOAT
      |0|tipoID| id       | password  |
