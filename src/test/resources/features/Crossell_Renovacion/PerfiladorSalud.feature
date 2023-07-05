@ModuloCrossellRenovacion_4_13

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
      ###DATOS###@Data|1@PerfiladorSalud
      | 0 | tipoID | id | password |
