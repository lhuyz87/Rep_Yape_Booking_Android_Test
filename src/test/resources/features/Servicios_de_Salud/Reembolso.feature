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

  @regresionReembolso @reembolsoOdontologicoConBeneficiario2
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

  @regresionReembolso @reembolsoSinBeneficiarioMedicinaHome
  Scenario Outline: Realizar solicitud de reembolso de salud para tipo de coberturas con medicinas sin beneficiarios desde la pagina principal
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"
    When desde el HOME seleccionar reembolso
    And se registra los datos del reembolso "<productoContratante>" , "<lugarAtencion>", "<fechaAtencion>" y "<tipoCobertura>"
    And registramos los datos del contacto: "<email>", "<celular>"  y direccion: "<departamento>", "<provincia>", "<distrito>" y "<direccion>"
    And adjuntamos los documentos necesarios de la cobertura
    Then podra validar la notificacion: Solicitud de reembolso recibida

    Examples: 
      | tipoID | id       | password  | productoContratante                         | lugarAtencion | fechaAtencion | tipoCobertura | email         | celular    | departamento | provincia | distrito | direccion | tipoDocumento | descripcion | serieDocumento | numeroDocumento | moneda  | monto | fechaEmisionDocumento | entidadBancaria | tipoCuenta        | numeroCuenta       |
      | DNI    | 76243722 | Rimac2021 | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | 20/09/2022    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |

  @regresionReembolso @reembolsoSinBeneficiarioDetalleSeguro
  Scenario Outline: Realizar solicitud de reembolso sin beneficiarios desde detalle de seguro salud
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"
    When desde el detalle del seguro seleccionar la opcion reembolso
    And se registra los datos del reembolso "<productoContratante>" , "<lugarAtencion>", "<fechaAtencion>" y "<tipoCobertura>"
    And registramos los datos del contacto: "<email>", "<celular>"  y direccion: "<departamento>", "<provincia>", "<distrito>" y "<direccion>"
    And adjuntamos los documentos necesarios de la cobertura
    Then podra validar la notificacion: Solicitud de reembolso recibida

    Examples: 
      | tipoID | id       | password  | productoContratante                         | lugarAtencion | fechaAtencion | tipoCobertura | email         | celular    | departamento | provincia | distrito | direccion | tipoDocumento | descripcion | serieDocumento | numeroDocumento | moneda  | monto | fechaEmisionDocumento | entidadBancaria | tipoCuenta        | numeroCuenta       |
      | DNI    | 76243722 | Rimac2021 | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | 20/09/2022    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |

  #########################################
  @regresionReembolsoSalud @reembolsoSaludSinBeneficiarioconCoberturadeMedicinas @reembolso
  Scenario Outline: Realizar solicitud de reembolso sin beneficiarios desde menú Tramites
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Reembolso de Salud desde Tramites y se inicia el tramite
    And se registra los datos del reembolso sin beneficiario con tipo de cobertura
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And registra sus datos de contacto
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then debe aparecer el mensaje: "Solicitud de reembolso recibida"

    Examples: 
      | tipoID | id       | password  | productoContratante                         | lugarAtencion | tipoCobertura |
      | DNI    | 76243722 | Rimac2021 | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | Medicinas     |

  @regresionReembolsoSalud @reembolsoSaludConBeneficiarioconCoberturadeMedicinas @reembolso
  Scenario Outline: Realizar solicitud de reembolso cliente con beneficiarios desde Tramites
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Reembolso de Salud desde Tramites y se inicia el tramite
    And se registra los datos del reembolso con beneficiario con tipo de cobertura
      | productoContratante   | paciente   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <paciente> | <lugarAtencion> | <tipoCobertura> |
    ## And selecciona tipo de reembolso "<tipoReembolso>"
    And registra sus datos de contacto
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then debe aparecer el mensaje: "Solicitud de reembolso recibida"

    Examples: 
      | tipoID | id       | password  | productoContratante                | paciente                                 | lugarAtencion | tipoCobertura |
      | DNI    | 10392464 | Rimac2020 | PLANES MEDICOS EPS - Medifarma s a | Madueño Armacanque Herzop Myki - Titular | Lima          | Medicinas     |

  @regresionReembolsoSalud @reembolsoOdontologicoConBeneficiario @reembolso
  Scenario Outline: Realizar solicitud de reembolso cliente con cobertura odontologica con beneficiarios desde menú Tramites
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Reembolso de Salud desde Tramites y se inicia el tramite
    And se registra los datos del reembolso con beneficiario con tipo de cobertura y tratamiento
      | productoContratante   | paciente   | lugarAtencion   | tipoCobertura   | tipoTratamiento   |
      | <productoContratante> | <paciente> | <lugarAtencion> | <tipoCobertura> | <tipoTratamiento> |
    And registra sus datos de contacto
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then debe aparecer el mensaje: "Solicitud de reembolso recibida"

    Examples: 
      | tipoID | id       | password  | productoContratante                             | paciente                                   | lugarAtencion | tipoCobertura | tipoTratamiento |
      | DNI    | 70434801 | Rimac2020 | PLANES MEDICOS EPS - Rimac seguros y reaseguros | Armacanque Delvoy Yoshlin Heuver - Titular | Lima          | Odontología   | Ortodoncia      |
