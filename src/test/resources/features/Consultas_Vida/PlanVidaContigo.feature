#Author: Candy Espinoza
@ModuloConsultasVida_3_7
Feature: Consultas Vida - Plan Vida Contigo

  @DescargaManualdeUsoPlanVidaContigo
  Scenario Outline: Descarga manual de uso de poliza desde el tab poliza del Producto Vida Contigo
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer las caracteristicas de mi  seguro Vida Contigo
    Then debe descargar el manual de uso de mi seguro

    Examples:
    ###DATOS###@ConsultasVida|1@DescargaManualdeUsoPlanVidaCont
    | 0 | tipoID | id | password |
