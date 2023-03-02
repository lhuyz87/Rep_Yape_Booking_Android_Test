#Author: Candy Espinoza
@FeaturePlanVidaContigo
Feature: Plan Vida Contigo

  @DescargaManualdeUsoPlanVidaContigo
  Scenario Outline: Descarga Manual de uso desde el tab poliza del Producto Vida Contigo
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer las caracteristicas de mi "<seguro>"
    Then debe mostrar la previsualización del documento pdf

    Examples:
      | tipoID | id       | password  | seguro       |
      | DNI    | 07525151 | Rimac2020 | Vida Contigo |
