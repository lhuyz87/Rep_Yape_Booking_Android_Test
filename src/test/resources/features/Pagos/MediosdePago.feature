#Author: Candy Espinoza
@ModuloPagos_5_7
Feature: Suscripcion de medios de pago

   @SucripcionDesdePerfil
    Scenario Outline: Suscripcion de Tarjeta desde Mi perfil opcion medios de pagos
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When ingreso mis datos bancarios desde Perfil para suscribir mi tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>"
      Then se debe agregar la tarjeta "<numtarjeta>" a Mis Tarjetas
      And elimino la tarjeta agregada "<numtarjeta>" desde Mis Tarjetas

       Examples:
       ###DATOS###@Pagos|1@SucripcionDesdePerfil
         | 0 | tipoID | id | password |numtarjeta       | cvv | fecha |

    @SucripcionDesdePagos
    Scenario Outline: Suscripcion de Tarjeta desde Tap de Pagos opcion medios de pagos
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When ingreso mis datos bancarios desde el tab de Pagos para suscribir mi tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>"
      Then se debe agregar la tarjeta "<numtarjeta>" a Mis Tarjetas
      And elimino la tarjeta agregada "<numtarjeta>" desde Mis Tarjetas

      Examples:
       ###DATOS###@Pagos|1@SucripcionDesdePagos
        | 0 | tipoID | id | password |numtarjeta       | cvv | fecha |

    @SucripcionDesdeAfiliacion
    Scenario Outline: Suscripcion de Tarjetas desde la Afiliacion
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When ingreso mis datos bancarios desde afiliacion de tarjetas "<numtarjeta>" , "<cvv>" y "<fecha>"
      Then debe mostrar el mensaje "Tarjeta afiliada con éxito"
      And elimino la tarjeta afiliada "<numtarjeta>" desde Mi Perfil

      Examples:
      ###DATOS###@Pagos|1@SucripcionDesdeAfiliacion
        | 0 | tipoID | id | password |numtarjeta       | cvv | fecha |

  @SucripcionDesdeOpcionPagar
    Scenario Outline: Suscripcion de Tarjetas desde la Opcion Pagar, agregar nueva Tarjeta
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa a Seguro Vehicular desde Seguros y se inicia el tramite "<placa>" del vehiculo
      And se realiza el pago añadiendo mi tarjeta "<numtarjeta>" , "<cvv>" y "<fecha>"
      #Then debe mostrar el mensaje de confirmación "Cuota pagada"
      Then debe mostrar el mensaje de confirmación ¡Hemos recibido tu pago!
      And elimino la tarjeta afiliada "<numtarjeta>" desde Mi Perfil

    Examples:
      ###DATOS###@Pagos|1@SuscripcionOpcionPagar
      | 0 | tipoID | id | password | placa | numtarjeta | fecha | cvv |

  @TiempoInactividadPagos
  Scenario Outline: Esperar 15 min de inactividad en el modulo de pagos
      Given realiza el login con credenciales
        | tipoID   | id   | password   |
        | <tipoID> | <id> | <password> |
      When se ingresa al detalle del Seguro SOAT desde Seguros
      And se mantiene inactivo el módulo en el tab de pagos
      Then se valida el mensaje para retornar al Login desde el módulo de pagos

      Examples:
       ###DATOS###@Pagos|1@TiempoInactividadPagos
        | 0 | tipoID | id | password |
