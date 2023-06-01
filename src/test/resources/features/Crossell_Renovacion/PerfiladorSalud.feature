@ModuloCrossellRenovacion_2_13

Feature: Perfilador de salud

  @PerfiladorSalud
  Scenario Outline: Realizar el Flujo para el Perfilador Salud
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a tienda, opcion seguros de salud
    And se realiza test para obtener seguro ideal
    Then muestra la opcion recomendada

    Examples:
      | tipoID | id       | password  |
      | DNI    | 09328751 | Rimac2021 |
