#Author: Luis Retamozo
@ModuloServiciosDeSalud_4_16
Feature: Servicios de Salud - Buscador de clinicas

  @BuscadordeClinicasdesdeHome
  Scenario Outline: Buscador de clinicas desde Home
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When selecciona la opción Búsqueda de clínicas desde Home y se inicia el tramite
    And al filtrar la clínica "<nomClinica>"
    Then al seleccionarla debe mostrar su monto de copago

    Examples:
    ###DATOS###@ServiciosSalud|1@BuscadordeClinicasdesdeHome
      | 0 | tipoID | id | password | nomClinica |

  @BuscadordeClinicasdesdeTramites
  Scenario Outline: Buscador de clinicas desde menu Tramites
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When selecciona la opción Búsqueda de clínicas desde menu Tramites y se inicia el tramite
    And al filtrar la clínica "<nomClinica>"
    Then al seleccionarla debe mostrar su monto de copago

    Examples:
      ###DATOS###@ServiciosSalud|1@BuscadordeClinicasdesdeTramites
      | 0 | tipoID | id | password | nomClinica |
