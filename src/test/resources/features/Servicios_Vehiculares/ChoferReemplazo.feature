@ModuloServiciosVehiculares_9_17
Feature: Servicios Vehiculares - Chofer Reemplazo

  @ChoferReemplazo @SeguimientoChoferReemplazo
  Scenario Outline: Solicitar Chofer reemplazo
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Chofer Remplazo desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And se solicita el servicio indicando la ubicación, fecha y la documentación requerida
    Then se realiza la confirmación de la solicitud
    And debe mostrar el seguimiento de chofer de reemplazo de la  "<placa>"

    Examples:
      ###DATOS###@ServiciosVehiculares|1@ChoferReemplazo
      | 0 | tipoID | id | password | placa  |

  @CancelarChoferReemplazo
  Scenario Outline: Solicitar Chofer reemplazo
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se cancela la solicitud de chofer de reemplazo de la "<placa>"
    Then se debe mostrar un mensaje "Solicitud Chofer de reemplazo cancelada"
    And se valida que no se muestre en el home la solicitud de la "<placa>"

    Examples:
      ###DATOS###@ServiciosVehiculares|1@ChoferReemplazo
      | 0 | tipoID | id | password | placa  |
