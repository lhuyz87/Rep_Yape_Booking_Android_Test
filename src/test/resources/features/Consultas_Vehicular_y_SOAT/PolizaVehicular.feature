#Author: Candy Espinoza
@regresionBloque3
  Feature: Poliza Vehicular

   @DescargaPolizaVehicularDigital
    Scenario Outline: Validar la descarga de poliza vehicular
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle del Seguro Vehicular desde Seguros
      And  al descargar la poliza Vehicular
      Then debe descargar la información de mi poliza vehicular

      Examples:
        | tipoID | id       | password  |
        | DNI    | 25676942 | Rimac2021 |


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
        | tipoID | id       | password  |
        | DNI    | 25676942 | Rimac2021 |

