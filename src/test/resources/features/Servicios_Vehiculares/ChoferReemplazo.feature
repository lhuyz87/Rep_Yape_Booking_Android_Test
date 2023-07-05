@ModuloServiciosVehiculares_9_17
Feature: Servicios Vehiculares - Chofer Reemplazo

  @ChoferReemplazo
  Scenario Outline: Solicitar Chofer reemplazo
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Chofer Remplazo desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And se solicita el servicio indicando la ubicación, fecha y la documentación requerida
    Then se realiza la confirmación de la solicitud
    And debe mostrar el seguimiento de chofer de reemplazo de la  "<placa>"


    Examples:
      ###DATOS###@Data|1@ChoferReemplazo
      | 0 | tipoID | id | password | placa  |
