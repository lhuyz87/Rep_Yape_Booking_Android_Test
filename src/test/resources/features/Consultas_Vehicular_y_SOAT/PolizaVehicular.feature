#Author: Candy Espinoza
@ModuloConsultasVehicularySoat_2_6
  Feature: Consulta Vehicular y Soat - Poliza Vehicular

   @DescargaPolizaVehicularDigital
    Scenario Outline: Descarga poliza digital desde el tab poliza
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle del Seguro Vehicular desde Seguros
      And  al descargar la poliza Vehicular
      Then debe descargar la información de mi poliza vehicular

      Examples:
      ###DATOS###@Data|1@DescargaPolizaVehicularDigital
      | 0 | tipoID | id | password |

    @TiempoInactividadConsultaVehicularySoat
    Scenario Outline: Esperar 15 min de inactividad en el modulo de Consulta Vehicular SOAT
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle del Seguro Vehicular desde Seguros
      And se visualiza la cobertura del seguro
      And se mantiene inactivo en la sección Cobertura
      Then debe validar el mensaje para retornar al Login desde seguros

      Examples:
      ###DATOS###@Data|1@TiempoInactividadConsultaVehicu
      | 0 | tipoID | id | password |
