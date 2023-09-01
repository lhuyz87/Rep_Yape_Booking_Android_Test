#Author: Candy Espinoza
Feature: Consultas Vida - Plan Vida Flexible

  @DescargaEstadoCuentaPlanVidaFlexible @ModuloConsultasVida_3_7 @Salud_Vida_Vehicular
  Scenario Outline: Descarga Estado de Cuenta desde el tab poliza del Producto Flexivida "Vida Flexible"
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer el detalle del estado de cuenta del "<año>" y del "<mes>"
    Then debe visualizarse el estado de cuenta de mi seguro Vida Flexible

    Examples:
    ###DATOS###@ConsultasVida|1@DescargaEstadoCuentaPlanVidaFle
      | 0 | tipoID | id | password |mes  | año  |

  @TiempoInactividadConsultasVida @TiempoInactAndroid
  Scenario Outline: Esperar 15 min de inactividad en el modulo de Consultas Vida
    Given realiza el login con credenciales
      | tipoID   | id   | password   |
      | <tipoID> | <id> | <password> |
    When deseo conocer el detalle del estado de cuenta del "<año>" y del "<mes>"
    And se mantiene inactivo en la previsualización del pdf
    Then debe validar el mensaje para retornar al Login desde plan Vida Flexible

    Examples:
     ###DATOS###@ConsultasVida|1@TiempoInactividadConsultasVida
     | 0 | tipoID | id | password |mes  | año  |
