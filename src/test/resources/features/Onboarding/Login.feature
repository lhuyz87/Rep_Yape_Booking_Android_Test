#Author: your.email@your.domain.com
@tag
Feature: Login APP Nativa

  @Login @RegresionPoliza
  Scenario Outline: Realizar Login Exitoso en Mundo Rimac
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"

    Examples:
      | tipoID | id       | password  |
      | DNI    | 70434801 | Rimac2020 |

  @OlvidePassword
  Scenario Outline: Validar que se permita cambiar el password respondiendo preguntas
    Given se selecciona la opci??n ??Olvidaste tu contrase??a?
    And se ingresa el tipo y n??mero de documento: "<tipoID>", "<id>"
    When se selecciona la opci??n Responder Preguntas
    And se ingresa la fecha de nacimiento "<fechaNacimiento>" y los seguros "<seguros>" que cuenta el cliente
    Then debe permitir el ingreso de una nueva contrase??a
    And debe de aparecer el mensaje de "Tu contrase??a fue cambiada con ??xito"

    Examples:
      | tipoID | id       | fechaNacimiento | seguros |
      | DNI    | 10667872 | 08/01/1978      | SOAT    |
    ## | DNI    | 10667872 | 08/01/1978      | SOAT    |
    
    
    
    @ValidaVersionMinimaRequerida
  Scenario: Valida versi??n m??nima requerida
    Given Se ingresa a la aplicaci??n con una versi??n menor a la minima requerida    
    Then se debe mostar mensaje informativo "Tu App RIMAC necesita actualizarse"
    And mostrar solo opci??n actualizar


  @ValidaVersionMinimaRecomendada
  Scenario: Valida versi??n m??nima recomendada
    Given Se ingresa a la aplicaci??n con una versi??n menor a la minima recomendada
    Then  se debe mostar mensaje informativo "Tu App RIMAC necesita actualizarse"
    And seleccionamos opci??n "Mas tarde"
    And debe permitir el ingreso a la aplicaci??n
    
   @ValidaModoDesarrollo
  Scenario: Valida que la aplicaci??n no pueda iniciar al contar con modo desarrollador en el dispositivo m??vil
    Given Se ingresa a la aplicaci??n con un dispositivo con modo desarrollador activado
  	Then  no debe permitir el ingreso al aplicativo y debe mostar mensaje informativo relacionado a "Desactivar modo desarrollador"

    
    
    
    
    
