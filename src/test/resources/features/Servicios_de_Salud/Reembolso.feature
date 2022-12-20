#Author: Luis Retamozo
@FeatureReembolso
Feature: Reembolso

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

  @regresionReembolsoSalud @seguimientoReembolso
  Scenario Outline: Realizar el Seguimiento de Reembolso de Salud desde Tramites
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa al Seguimiento de Reembolso de Salud desde Tramites
    Then debe aparecer el monto "<monto>" del reembolso solicitado

    Examples: 
      ###DATOS###@DataPrueba|1@1-SegReembolsoDesdeHome
      | 0 | tipoID | id       | password  | monto     |
      | 1 | DNI    | 76243722 | Rimac2021 | S/ 25.00  |
      | 2 | DNI    | 76243722 | Rimac2021 | S/ 150.00 |
