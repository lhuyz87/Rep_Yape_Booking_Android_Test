#Author: Candy Espinoza
  Feature: Descarga de Poliza Digital Vehicular

   @DescargaPolizaTab
    Scenario Outline: Descarga poliza digital desde el tab poliza
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When deseo conocer el detalle de mi "<seguro>"
      Then obtengo la información de mi poliza vehicular

      Examples:
        | tipoID | id       | password  | seguro           |
        | DNI    | 25676942 | Rimac2021 | Seguro Vehicular |
