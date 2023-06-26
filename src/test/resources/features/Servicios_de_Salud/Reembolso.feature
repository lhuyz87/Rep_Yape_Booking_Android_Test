#Author: Luis Retamozo
@ModuloServiciosDeSalud_4_16
Feature: Servicios de Salud - Reembolso

  @reembolsoSaludSinBeneficiarioDesdeMenuTramites
  Scenario Outline: Realizar solicitud de reembolso con cobertura medicinas sin beneficiarios desde menu Tramites
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
    And se ingresa al Seguimiento de Reembolso de Salud desde Tramites
    And debe aparecer el monto del reembolso solicitado

    Examples:
      | tipoID | id       | password  | productoContratante                         | lugarAtencion | tipoCobertura |
      | DNI    | 76243722 | Rimac2020 | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | Medicinas     |

  @reembolsoSaludConBeneficiariosDesdeMenuTramites
  Scenario Outline: Realizar solicitud de reembolso con cobertura medicinas con beneficiarios desde Tramites
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Reembolso de Salud desde Tramites y se inicia el tramite
    And se registra los datos del reembolso con beneficiario con tipo de cobertura
      | productoContratante   | paciente   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <paciente> | <lugarAtencion> | <tipoCobertura> |
    ## And selecciona tipo de reembol   so "<tipoReembolso>"
    And registra sus datos de contacto
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then debe aparecer el mensaje: "Solicitud de reembolso recibida"
    And se ingresa al Seguimiento de Reembolso de Salud desde Tramites
    And debe aparecer el monto del reembolso solicitado

    Examples:
      | tipoID | id       | password  | productoContratante                | paciente                                 | lugarAtencion | tipoCobertura |
      | DNI    | 10392464 | Rimac2020 | PLANES MEDICOS EPS - Medifarma s a | Madueño Armacanque Herzop Myki - Titular | Lima          | Medicinas     |

  @reembolsoOdontologicoDesdeMenuTramites
  Scenario Outline: Realizar solicitud de reembolso cliente con cobertura odontologica con beneficiarios desde menu Tramites
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
    And se ingresa al Seguimiento de Reembolso de Salud desde Tramites
    And debe aparecer el monto del reembolso solicitado

    Examples:
      | tipoID | id       | password  | productoContratante                  | paciente                                   | lugarAtencion | tipoCobertura | tipoTratamiento |
      | DNI    | 10392464 | Rimac2020 | PLANES MEDICOS EPS - Medifarma s a   | Madueño Armacanque Herzop Myki - Titular   |    Lima       | Odontología   | Ortodoncia      |

  @reembolsoSaludSinBeneficiarioaDesdeMenuInicio
  Scenario Outline: Realizar solicitud de reembolso sin beneficiarios desde menu Inicio
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Reembolso de Salud desde Home y se inicia el tramite
    And se registra los datos del reembolso sin beneficiario con tipo de cobertura
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And registra sus datos de contacto
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then debe aparecer el mensaje: "Solicitud de reembolso recibida"
    And se cierra la sesión del aplicativo
    And realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    And debe aparecer el monto  del reembolso solicitado en Inicio

    Examples:
      | tipoID | id       | password  | productoContratante                         | lugarAtencion | tipoCobertura        |
      | DNI    | 76243722 | Rimac2020 | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | Atención ambulatoria |

  @reembolsoSaludSinBeneficiariosDesdeSeguros
  Scenario Outline: Realizar solicitud de reembolso sin beneficiarios desde detalle de seguro salud
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When se ingresa a Reembolso de Salud desde Seguros y se inicia el tramite "<seguro>"
    And se registra los datos del reembolso sin beneficiario con tipo de cobertura
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And registra sus datos de contacto
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then debe aparecer el mensaje: "Solicitud de reembolso recibida"

    Examples:
      | tipoID | id       | password  | seguro             | productoContratante                         | lugarAtencion | tipoCobertura |
      | DNI    | 76243722 | Rimac2020 | Amc Colectiva Fola | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | Hospitalario  |


  @TiempoInactividadServiciodeSalud
  Scenario Outline: Esperar 15 min de inactividad en el modulo Servicio de salud
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
    When se ingresa al Seguimiento de Reembolso de Salud desde Tramites
    And se mantiene inactivo en la sección servicios de salud
    Then debe validar el mensaje para retornar al Login desde reembolso

    Examples:
      | tipoID | id       | password  | productoContratante                          | lugarAtencion | tipoCobertura |
      | DNI    | 76243722 | Rimac2020 | AMC COLECTIVA FOLA - Citibank del peru s.a.  | Lima          | Medicinas     |




  ##Scenario Outline: Realizar el Seguimiento de Reembolso de Salud desde Tramites
    ##Given realiza el login con credenciales
    ##  | tipoID   | id   | password   |
     ## | <tipoID> | <id> | <password> |
   ## When se ingresa al Seguimiento de Reembolso de Salud desde Tramites
    ##Then debe aparecer el monto "<monto>" del reembolso solicitado en Inicio

    ##Examples:
     ###DATOS###@DataReembolso|1@01-SegReembolso
    ##  | 0 | tipoID | id | password | monto |

 ## Scenario Outline: Realizar el Seguimiento de Reembolso de Salud desde Inicio
   ## Given realiza el login con credenciales
    ##  | tipoID   | id   | password   |
    ##  | <tipoID> | <id> | <password> |
   ## Then debe aparecer el monto "<monto>" del reembolso solicitado en Inicio

   ## Examples:
      ###DATOS###@DataReembolso|U@01-SegReembolso
     ## | 0 | tipoID | id | password | monto |




