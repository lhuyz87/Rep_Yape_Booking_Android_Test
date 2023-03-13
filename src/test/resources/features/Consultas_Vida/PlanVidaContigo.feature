#Author: Candy Espinoza
@FeaturePlanVidaContigo @regresionBloque3
Feature: Plan Vida Contigo

  @DescargaManualdeUsoPlanVidaContigo
  Scenario Outline: Descarga Manual de uso desde el tab poliza del Producto Vida Contigo
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer las caracteristicas de mi  seguro Vida Contigo
    Then debe descargar el manual de uso de mi seguro

    Examples:
      | tipoID | id       | password  |
      | DNI    | 07525151 | Rimac2020 |
