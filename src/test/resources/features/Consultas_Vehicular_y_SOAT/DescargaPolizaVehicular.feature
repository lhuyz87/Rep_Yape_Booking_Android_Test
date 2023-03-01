#Author: Candy Espinoza
  Feature: Consulta Vehicular SOAT

   @DescargaPolizaVehicularDigital
    Scenario Outline: Descarga poliza digital
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When deseo conocer el detalle de mi "<seguro>"
      Then debe descargar la información de mi poliza vehicular

      Examples:
        | tipoID | id       | password  | seguro           |
        | DNI    | 25676942 | Rimac2021 | Seguro Vehicular |




