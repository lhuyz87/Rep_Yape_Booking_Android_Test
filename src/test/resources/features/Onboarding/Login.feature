#Author: your.email@your.domain.com
@tag
Feature: Login APP Nativa

  @Login @RegresionPoliza
  Scenario Outline: Realizar Login Exitoso en Mundo Rimac
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"
    Then se valida el correcto acceso

    Examples: 
      | tipoID | id       | password  |
      | DNI    | 70434801 | Rimac2020 |

  @OlvidePassword
  Scenario Outline: Validar que se permita cambiar el password respondiendo preguntas
    Given se selecciona la opción ¿Olvidaste tu contraseña?
    And se ingresa el tipo y número de documento: "<tipoID>", "<id>"
    When se selecciona la opción Responder Preguntas
    And se ingresa la fecha de nacimiento "<fechaNacimiento>" y los seguros "<seguros>" que cuenta el cliente
    Then debe permitir el ingreso de una nueva contraseña
    And debe de aparecer el mensaje de "Tu contraseña fue cambiada con éxito"

    Examples: 
      | tipoID | id       | fechaNacimiento | seguros | Password |
      | DNI    | 10667872 | 08/01/1978     | SOAT    | Rimac    |
    ## | DNI    | 10667872 | 08/01/1978      | SOAT    | Rimac    |