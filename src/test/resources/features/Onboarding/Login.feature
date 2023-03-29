#Author: your.email@your.domain.com
Feature: Onboarding - Login

  @Login @ModuloOnboardingFuncional_2/4
  Scenario Outline: Realizar Login Exitoso en Mundo Rimac
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"

    Examples:
      | tipoID | id       | password  |
      | DNI    | 70434801 | Rimac2020 |

  @OlvidasteTuContrasenia @ModuloOnboardingFuncional_2/4
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

    @ValidaVersionMinimaRequerida @ModuloOnboardingNoFuncional1_1/1
  Scenario: Validar que al usar versiones muy antiguas sea obligatorio actualizar a la ultima Version
    Given Se ingresa a la aplicación con una versión menor a la minima requerida
    Then se debe mostar mensaje informativo "Tu App RIMAC necesita actualizarse"
    And mostrar solo opción actualizar


  @ValidaVersionMinimaRecomendada @ModuloOnboardingNoFuncional2_1/1
  Scenario: Validar que el App muestre el mensaje: Mundo Rimac Necesita Actualizarse
    Given Se ingresa a la aplicación con una versión menor a la minima recomendada
    Then  se debe mostar mensaje informativo "Tu App RIMAC necesita actualizarse"
    And seleccionamos opción "Mas tarde"
    And debe permitir el ingreso a la aplicación
    


    
    
    
    
    
