#Author: Candy Espinoza
@FeaturePlanVidaFlexible
Feature: Plan Vida Flexible

  @DescargaEstadoCuentaPlanVidaFlexible
  Scenario Outline: Descarga estado de cuenta digital - "Vida Flexible"
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer el detalle del estado de cuenta del "<año>" y del "<mes>"
    Then debe visualizarse el estado de cuenta de mi seguro Vida Flexible

    Examples:
      | tipoID | id       | password  | mes  | año  |
      | DNI    | 44926877 | Rimac2020 | Mayo | 2022 |
