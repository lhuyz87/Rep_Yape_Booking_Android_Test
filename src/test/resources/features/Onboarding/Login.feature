#Author: your.email@your.domain.com
Feature: Onboarding - Login

  @Login @ModuloOnboardingFuncional_1_4
  Scenario Outline: Realizar Login Exitoso en Mundo Rimac
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"

    Examples:
    ###DATOS###@Onboarding|1@Login
      | 0 | tipoID | id | password |

  @OlvidasteTuContrasenia
  Scenario Outline: Recuperar contrasena - Validar que se permita registrar el password respondiendo preguntas
    Given se selecciona la opción ¿Olvidaste tu contraseña?
    And se ingresa el tipo y número de documento: "<tipoID>", "<id>"
    When se selecciona la opción Responder Preguntas
    And se ingresa la fecha de nacimiento "<fechaNacimiento>" y los seguros "<seguros>" que cuenta el cliente
    Then debe permitir el ingreso de una nueva contraseña
    And debe de aparecer el mensaje de "Tu contraseña fue cambiada con éxito"

    Examples:
      | tipoID | id       | fechaNacimiento | seguros |
      | DNI    | 10667872 | 08/01/1978      | SOAT    |

  @ValidaVersionMinimaRequerida @ModuloOnboardingNoFuncional1_1_1
  Scenario: Valida version minima requerida
    Given Se ingresa a la aplicación con una versión menor a la minima requerida
    Then se debe mostar mensaje informativo "Tu App RIMAC necesita actualizarse"
    And mostrar solo opción actualizar


  @ValidaVersionMinimaRecomendada @ModuloOnboardingNoFuncional2_1_1
  Scenario: Valida version minima recomendada
    Given Se ingresa a la aplicación con una versión menor a la minima recomendada
    Then  se debe mostar mensaje informativo "Tu App RIMAC necesita actualizarse"
    And seleccionamos opción "Mas tarde"
    And debe permitir el ingreso a la aplicación


  @TiempoInactividadOnboarding
  Scenario Outline: Ejecutar los Procesos por Modulo y esperar 15 min y validar el regreso al login por inactividad
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    And se mantiene inactiva la sesión en el módulo onboarding
    Then se valida el mensaje para retornar al Login desde el home

    Examples:
    ###DATOS###@Onboarding|1@Login
      | 0 | tipoID | id | password |
