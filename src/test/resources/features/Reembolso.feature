#Author: Luis Retamozo
@FeatureReembolso
Feature: Reembolso

  @regresionReembolso @reembolsoSinBeneficiario
  Scenario Outline: Realizar solicitud de reembolso de salud para tipo de coberturas con medicinas sin beneficiarios
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"
    When se ingresa a reembolso y se inicia el tramite
    And se registra los datos del reembolso "<productoContratante>" , "<lugarAtencion>", "<fechaAtencion>" y "<tipoCobertura>"
    And registramos los datos del contacto: "<email>", "<celular>"  y direccion: "<departamento>", "<provincia>", "<distrito>" y "<direccion>"
    And adjuntamos los documentos necesarios de la cobertura
    Then podra validar la notificacion: Solicitud de reembolso recibida

    Examples: 
      | tipoID | id       | password  | productoContratante                         | lugarAtencion | fechaAtencion | tipoCobertura | email         | celular    | departamento | provincia | distrito | direccion | tipoDocumento | descripcion | serieDocumento | numeroDocumento | moneda  | monto | fechaEmisionDocumento | entidadBancaria | tipoCuenta        | numeroCuenta       |
      | DNI    | 76243722 | Rimac2021 | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | 20/09/2022    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |

  #    | DNI    | 76243722 | Rimac2021 | ACC. ESTUDIANTES COMPLEMENTARIA - Hermes - corporativa | Lima          | 11/08/2021    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |
  #    | DNI    | 76243722 | Rimac2021 |AMI ACCIDENTE ESTUDIANTE - Hermes - corporativa | Lima          | 11/08/2021    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |
  @regresionReembolso @reembolsoConBeneficiario
  Scenario Outline: Realizar solicitud de reembolso de salud para tipo de coberturas con medicinas con beneficiarios
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"
    When se ingresa a reembolso y se inicia el tramite
    And se registra los datos del reembolso "<productoContratante>" ,"<paciente>", "<lugarAtencion>", "<fechaAtencion>" y "<tipoCobertura>"
    And registramos los datos del contacto: "<email>", "<celular>"  y direccion: "<departamento>", "<provincia>", "<distrito>" y "<direccion>"
    And adjuntamos los documentos necesarios de la cobertura
    Then podra validar la notificacion: Solicitud de reembolso recibida

    Examples: 
      | tipoID | id       | password  | productoContratante                | paciente                                 | lugarAtencion | fechaAtencion | tipoCobertura | email         | celular    | departamento | provincia | distrito | direccion | tipoDocumento | descripcion | serieDocumento | numeroDocumento | moneda  | monto | fechaEmisionDocumento | entidadBancaria | tipoCuenta        | numeroCuenta       |
      | DNI    | 10392464 | Rimac2020 | PLANES MEDICOS EPS - Medifarma s a | Madueño Armacanque Herzop Myki - Titular | Lima          | 11/08/2021    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Receta médica | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |

  @regresionReembolso @reembolsoOdontologicoConBeneficiario
  Scenario Outline: Realizar solicitud de reembolso cliente con cobertura odontologica con beneficiarios
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"
    When se ingresa a reembolso y se inicia el tramite
    And se registra los datos del reembolso odontologico "<productoContratante>" ,"<paciente>", "<lugarAtencion>", "<fechaAtencion>", "<tipoCobertura>" y "<tipoTratamientoOdontologia>"
    And registramos los datos del contacto: "<email>", "<celular>"  y direccion: "<departamento>", "<provincia>", "<distrito>" y "<direccion>"
    And adjuntamos los documentos y comprobantes necesarios de la cobertura
    Then podra validar la notificacion: Solicitud de reembolso recibida

    Examples: 
      | tipoID | id       | password  | productoContratante                             | paciente                                   | lugarAtencion | fechaAtencion | tipoCobertura | tipoTratamientoOdontologia | email         | celular    | departamento | provincia | distrito | direccion | tipoDocumento | descripcion | serieDocumento | numeroDocumento | moneda  | monto | fechaEmisionDocumento | entidadBancaria | tipoCuenta        | numeroCuenta       |
      | DNI    | 70434801 | Rimac2020 | PLANES MEDICOS EPS - Rimac seguros y reaseguros | Armacanque Delvoy Yoshlin Heuver - Titular | Lima          | 17/08/2021    | Odontología   | Ortodoncia                 | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |
      
      
      
@regresionReembolso @reembolsoSinBeneficiarioHome
  Scenario Outline: Realizar solicitud de reembolso de salud para tipo de coberturas con medicinas sin beneficiarios
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"
    When desde el HOME seleccionar reembolso
    And se registra los datos del reembolso "<productoContratante>" , "<lugarAtencion>", "<fechaAtencion>" y "<tipoCobertura>"
    And registramos los datos del contacto: "<email>", "<celular>"  y direccion: "<departamento>", "<provincia>", "<distrito>" y "<direccion>"
    And adjuntamos los documentos necesarios de la cobertura
    Then podra validar la notificacion: Solicitud de reembolso recibida

    Examples: 
      | tipoID | id       | password  | productoContratante                         | lugarAtencion | fechaAtencion | tipoCobertura | email         | celular    | departamento | provincia | distrito | direccion | tipoDocumento | descripcion | serieDocumento | numeroDocumento | moneda  | monto | fechaEmisionDocumento | entidadBancaria | tipoCuenta        | numeroCuenta       |
      | DNI    | 76243722 | Rimac2021 | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | 20/09/2022    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |
      
