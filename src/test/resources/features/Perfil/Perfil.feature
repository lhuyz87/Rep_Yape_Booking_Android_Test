@ModuloPerfil_1_5
Feature: Perfil

  @TiempoInactividadPerfil

  Scenario Outline: Esperar 15 min de inactividad en el modulo Perfil
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When ingreso a mi informacion en opcion perfil
    And  se mantiene inactivo el modulo en la pantalla mi perfil
    Then se valida el mensaje para retornar al login desde pantalla de perfil

    Examples:

      ###DATOS###@Data|1@TiempoInactividadPerfil
      | 0 | tipoID | id | password |
