#Author: Luis Retamozo
@FeatureReembolso
Feature: Reembolso

  @regresionReembolso @reembolsoSinBeneficiario
  Scenario Outline: Realizar solicitud de reembolso sin beneficiarios
    Given realiza el login con credenciales "<tipoID>", "<id>" y "<password>"
    When se ingresa a reembolso y se inicia el tramite
    And se registra los datos del reembolso "<productoContratante>" , "<lugarAtencion>", "<fechaAtencion>" y "<tipoCobertura>"
    And registramos los datos del contacto: "<email>", "<celular>"  y direccion: "<departamento>", "<provincia>", "<distrito>" y "<direccion>"
    And adjuntamos los documentos necesarios de la cobertura

    #Then podra validar la notificacion: Solicitud de reembolso recibida
    Examples: 
      | tipoID | id       | password  | productoContratante                         | lugarAtencion | fechaAtencion | tipoCobertura | email         | celular    | departamento | provincia | distrito | direccion | tipoDocumento | descripcion | serieDocumento | numeroDocumento | moneda  | monto | fechaEmisionDocumento | entidadBancaria | tipoCuenta        | numeroCuenta       |
      | DNI    | 76243722 | Rimac2021 | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | 20/09/2022    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |
  #    | DNI    | 76243722 | Rimac2021 | ACC. ESTUDIANTES COMPLEMENTARIA - Hermes - corporativa | Lima          | 11/08/2021    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |
  #    | DNI    | 76243722 | Rimac2021 |AMI ACCIDENTE ESTUDIANTE - Hermes - corporativa | Lima          | 11/08/2021    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |
