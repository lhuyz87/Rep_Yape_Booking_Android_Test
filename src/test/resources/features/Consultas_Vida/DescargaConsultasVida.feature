#Author: Candy Espinoza
Feature: Descargar la información digital del seguro desde el tab polizas

  @DescargaPolizaVidaFlexible
  Scenario Outline: Descarga estado de cuenta digital desde el tab poliza del Producto "Vida Flexible"
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer el detalle del estado de cuenta de mi "<seguro>" del "<año>" y del "<mes>"
    Then debe descargar la información de mi poliza vehicular

    Examples:
      | tipoID | id       | password  | seguro             | mes  | año  |
      | DNI    | 44926877 | Rimac2020 | Plan Vida Flexible | Mayo | 2022 |

  @DescargaManualVida
  Scenario Outline: Descarga manual de uso de poliza desde el tab poliza del Producto Vida Contigo
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer las caracteristicas de mi "<seguro>"
    Then debe mostrar la previsualización del documento pdf

    Examples:
      | tipoID | id       | password  | seguro       |
      | DNI    | 07525151 | Rimac2020 | Vida Contigo |
