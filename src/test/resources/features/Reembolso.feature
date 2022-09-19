#Author: Luis Retamozo
@FeatureReembolso
Feature: Reembolso

  @regresionReembolso @reembolsoSinBeneficiario
  Scenario Outline: Realizar solicitud de reembolso sin beneficiarios
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When diligencia los formularios para reembolso de salud sin benefeciarios
      | productoContratante   | lugarAtencion   | fechaAtencion   | tipoCobertura   | email   | celular   | departamento   | provincia   | distrito   | direccion   | tipoDocumento   | descripcion   | serieDocumento   | numeroDocumento   | moneda   | monto   | fechaEmisionDocumento   | entidadBancaria   | tipoCuenta   | numeroCuenta   |
      | <productoContratante> | <lugarAtencion> | <fechaAtencion> | <tipoCobertura> | <email> | <celular> | <departamento> | <provincia> | <distrito> | <direccion> | <tipoDocumento> | <descripcion> | <serieDocumento> | <numeroDocumento> | <moneda> | <monto> | <fechaEmisionDocumento> | <entidadBancaria> | <tipoCuenta> | <numeroCuenta> |
    Then podra validar la notificacion: Solicitud de reembolso recibida

    Examples: 
      | tipoID | id       | password  | productoContratante | lugarAtencion | fechaAtencion | tipoCobertura | email         | celular    | departamento | provincia | distrito | direccion | tipoDocumento | descripcion | serieDocumento | numeroDocumento | moneda  | monto | fechaEmisionDocumento | entidadBancaria | tipoCuenta        | numeroCuenta       |
      | DNI    | 76243722 | Rimac2021 | AMC COLECTIVA FOLA  | Lima          | 11/08/2021    | Medicinas     | abc@gmail.com | 9425631547 | Ancash       | Asuncion  | Chacas   | calle     | Factura       | Otro        | F123           |        56238941 | Dólares |   100 | 11/08/2021            | BBVA            | Cuenta de ahorros | 653214569874512487 |
