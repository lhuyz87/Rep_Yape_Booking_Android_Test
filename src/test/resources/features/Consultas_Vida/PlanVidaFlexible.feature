#Author: Candy Espinoza
@FeaturePlanVidaFlexible
Feature: Plan Vida Flexible

  @DescargaEstadoCuentaPlanVidaFlexible
  Scenario Outline: Descarga estado de cuenta digital - "Vida Flexible"
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer el detalle del estado de cuenta de mi "<seguro>" del "<año>" y del "<mes>"
    Then debe descargar la información de mi poliza vehicular

    Examples:
      | tipoID | id       | password  | seguro             | mes  | año  |
      | DNI    | 44926877 | Rimac2020 | Plan Vida Flexible | Mayo | 2022 |
