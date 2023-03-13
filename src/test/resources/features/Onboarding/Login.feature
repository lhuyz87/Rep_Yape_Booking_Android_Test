#Author: your.email@your.domain.com
@tag @regresionBloque1
Feature: Login

  @Login @RegresionPoliza
  Scenario Outline: Realizar Login Exitoso en Mundo Rimac
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"

    Examples:
      | tipoID | id       | password  |
      | DNI    | 70434801 | Rimac2020 |

  @OlvidasteTuContrasenia
  Scenario Outline: Validar que se permita cambiar el password respondiendo preguntas
    Given se selecciona la opción ¿Olvidaste tu contraseña?
    And se ingresa el tipo y número de documento: "<tipoID>", "<id>"
    When se selecciona la opción Responder Preguntas
    And se ingresa la fecha de nacimiento "<fechaNacimiento>" y los seguros "<seguros>" que cuenta el cliente
    Then debe permitir el ingreso de una nueva contraseña
    And debe de aparecer el mensaje de "Tu contraseña fue cambiada con éxito"

    Examples:
      | tipoID | id       | fechaNacimiento | seguros |
      | DNI    | 10667872 | 08/01/1978      | SOAT    |

    @ValidaVersionMinimaRequerida
  Scenario: Valida version minima requerida
    Given Se ingresa a la aplicación con una versión menor a la minima requerida
    Then se debe mostar mensaje informativo "Tu App RIMAC necesita actualizarse"
    And mostrar solo opción actualizar


  @ValidaVersionMinimaRecomendada
  Scenario: Valida version minima recomendada
    Given Se ingresa a la aplicación con una versión menor a la minima recomendada
    Then  se debe mostar mensaje informativo "Tu App RIMAC necesita actualizarse"
    And seleccionamos opción "Mas tarde"
    And debe permitir el ingreso a la aplicación
    


    
    
    
    
    
