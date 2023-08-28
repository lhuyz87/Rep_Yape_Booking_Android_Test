#Author: Candy Espinoza
  Feature: Consulta Vehicular y Soat - Poliza Vehicular

    @ConsultaNumeroDePolizaVehiSoat @ModuloConsultasVehicularySoat_4_6
    Scenario Outline: Consulta el numero de la poliza -Soat
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle de la "<placa>" del seguro SOAT
      Then Se valida el número de póliza Soat

      Examples:
    ###DATOS###@ConsultaVehicularSoat|1@ConsultaNumeroDePolizaVehiSoat
        | 0 | tipoID | id | password |placa|

    @ConsultarDeudasSaldosdePoliza @ModuloConsultasVehicularySoat_4_6
    Scenario Outline: Consultar Deudas y Saldos de la Poliza - Vehicular
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle de la "<placa>" "<vigencia>" del seguro vehicular
      Then se valida que muestre el historial de pago

      Examples:
      ###DATOS###@Pagos|1@PagoConTarjetaAsociada
        | 0 | tipoID | id | password | placa | vigencia |

    @DescargaPolizaVehicularDigital @ModuloConsultasVehicularySoat_4_6
    Scenario Outline: Descarga poliza digital desde el tab poliza
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle del Seguro Vehicular desde Seguros
      And  al descargar la poliza Vehicular
      Then debe descargar la información de mi poliza vehicular

      Examples:
      ###DATOS###@ConsultaVehicularSoat|1@DescargaPolizaVehicularDigital
      | 0 | tipoID | id | password |

    @TiempoInactividadConsultaVehicularySoat @TiempoInactAndroid
    Scenario Outline: Esperar 15 min de inactividad en el modulo de Consulta Vehicular SOAT
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle del Seguro Vehicular desde Seguros
      And se visualiza la cobertura del seguro
      And se mantiene inactivo en la sección Cobertura
      Then debe validar el mensaje para retornar al Login desde seguros

      Examples:
      ###DATOS###@ConsultaVehicularSoat|1@TiempoInactividadConsultaVehicu
      | 0 | tipoID | id | password |
