@ModuloCrossellRenovacion_4_13
Feature: Perfilador vehicular

  @PerfiladorVehicular
  Scenario Outline: Realizar el Flujo para el Perfilador Vehicular
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a tienda, opcion seguros vehiculares
    And se realiza test ingresamos la "<placa>" para obtener seguro ideal
    Then muestra plan ideal vehicular

    Examples:
    ###DATOS###@Data|1@PerfiladorVehicular
      | 0 | tipoID | id | password |placa  |
