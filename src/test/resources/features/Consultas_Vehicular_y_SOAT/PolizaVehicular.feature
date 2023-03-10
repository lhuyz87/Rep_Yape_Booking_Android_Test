#Author: Candy Espinoza
  Feature: Poliza Vehicular

   @DescargaPolizaVehicularDigital
    Scenario Outline: Validar la descarga de poliza vehicular
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle del Seguro Vehicular desde Seguros
      Then debe descargar la información de mi poliza vehicular

      Examples:
        | tipoID | id       | password  |
        | DNI    | 25676942 | Rimac2021 |




