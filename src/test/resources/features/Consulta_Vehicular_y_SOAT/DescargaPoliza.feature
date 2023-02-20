#Author: Candy Espinoza
  Feature: Descarga de Poliza Digital Vehicular

   @DescargaPolizaTab
    Scenario Outline: Descarga poliza digital desde el tab poliza
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When deseo conocer el detalle de mi "<seguro>"
      Then debe descargar la información de mi poliza vehicular

      Examples:
        | tipoID | id       | password  | seguro           |
        | DNI    | 25676942 | Rimac2021 | Seguro Vehicular |

    @DescargaPolizaVidaFlexible
    Scenario Outline: Descarga poliza digital desde el tab poliza del Producto "Vida Flexible"
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When deseo conocer el detalle del estado de cuenta de mi "<seguro>" del "<año>" y del "<mes>"
      Then debe descargar la información de mi poliza vehicular

      Examples:
        | tipoID | id       | password  | seguro             | mes  | año  |
        | DNI    | 44926877 | Rimac2020 | Plan Vida Flexible | Mayo | 2022 |


