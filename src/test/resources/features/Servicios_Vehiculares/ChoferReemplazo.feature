Feature: Servicios Vehiculares -  chofer de reemplazo
  @ChoferReemplazo @ModuloServiciosVehiculares_9_17
  Scenario Outline: Solicitar Chofer reemplazo
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Chofer Remplazo desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
    And se solicita el servicio indicando la ubicación, fecha y la documentación requerida
    Then se realiza la confirmación de la solicitud
    And debe mostrar el seguimiento de chofer de reemplazo de la  "<placa>"


    Examples:
      | tipoID | id       | password  | placa  |
      | DNI    | 22093296 | Rimac2020 | ASQ191 |