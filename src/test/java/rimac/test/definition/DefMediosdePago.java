package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepMediosdePago;

import static org.junit.Assert.*;

public class DefMediosdePago {

    @Steps
    StepMediosdePago stepAgregarMedioPago;

    @When("ingreso mis datos bancarios desde Perfil para suscribir mi tarjeta {string} , {string} y {string}")
    public void ingresoMisDatosBancariosDesdePerfilParaSuscribirMiTarjetaY(String numTarjeta, String cvv, String fecha) throws Exception {
        stepAgregarMedioPago.irMedioPago_desde_perfil();
        stepAgregarMedioPago.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @When("ingreso mis datos bancarios desde el tab de Pagos para suscribir mi tarjeta {string} , {string} y {string}")
    public void ingresoMisDatosBancariosDesdeElTabDePagosParaSuscribirMiTarjetaY(String numTarjeta, String cvv, String fecha) throws Exception {
        stepAgregarMedioPago.detalle_seguro_vehicular();
        stepAgregarMedioPago.irMedioPago_desde_tab_pagos();
        stepAgregarMedioPago.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @Then("se debe agregar la tarjeta {string} a Mis Tarjetas")
    public void seDebeAgregarLaTarjetaAMisTarjetas(String numTarjeta) {
        assertTrue(stepAgregarMedioPago.validarExisteTarjeta(numTarjeta));
    }


    @When("ingreso mis datos bancarios desde afiliacion de tarjetas {string} , {string} y {string}")
    public void ingresoMisDatosBancariosDesdeAfiliacionDeTarjetasY(String numTarjeta, String cvv, String fecha) throws Exception {
        stepAgregarMedioPago.detalle_seguro_vehicular();
        stepAgregarMedioPago.selecciona_TabPagos();
        stepAgregarMedioPago.afiliarTarjeta(numTarjeta,cvv,fecha);
    }

    @Then("debe mostrar el mensaje {string}")
    public void debeMostrarElMensaje(String mensaje) {
        assertEquals(mensaje,stepAgregarMedioPago.validarMensajeAfiliacion());
        stepAgregarMedioPago.iraPagos();
    }

    @And("descargo el historial desde el tab de pagos")
    public void descargoElHistorialDesdeElTabDePagos() {
        stepAgregarMedioPago.selecciona_TabPagos();
        stepAgregarMedioPago.selecciona_HistorialPago();
        stepAgregarMedioPago.descargar_historial();
    }

    @Then("debe mostrar el pdf con el historial de pagos")
    public void debeMostrarElPdfConElHistorialDePagos() {
        assertTrue(stepAgregarMedioPago.validar_historial());
    }

    @When("se ingresa al detalle del Seguro SOAT desde Seguros")
    public void seIngresaAlDetalleDelSeguroSOATDesdeSeguros() {
        stepAgregarMedioPago.ver_detalle_SOAT();
        
    }

    @And("se mantiene inactivo el módulo en el tab de pagos")
    public void seMantieneInactivoElMóduloEnElTabDePagos() {
        stepAgregarMedioPago.selecciona_TabPagos();
        stepAgregarMedioPago.se_mantiene_la_inactividad_asistencia_vehicular();
    }

    @Then("se valida el mensaje para retornar al Login desde el módulo de pagos")
    public void seValidaElMensajeParaRetornarAlLoginDesdeElMóduloDePagos() {
        stepAgregarMedioPago.se_valida_mensaje_de_inactividad();
    }
    @When("se ingresa a Seguro Vehicular desde Seguros y se inicia el tramite {string} del vehiculo")
    public void seIngresaASeguroVehicularDesdeSegurosYSeIniciaElTramiteDelVehiculo(String placa) throws Exception {
        stepAgregarMedioPago.irCuotasaPagar_desde_tab_pagos(placa);
    }


    @And("se realiza el pago añadiendo mi tarjeta {string} , {string} y {string}")
    public void seRealizaElPagoAñadiendoMiTarjetaY(String numTarjeta, String cvv, String fecha) throws Exception {
        stepAgregarMedioPago.se_añade_nueva_tarjeta();
        stepAgregarMedioPago.anadirTarjetaFuturosPagos(numTarjeta,cvv,fecha);
    }

    @Then("debe mostrar el mensaje de confirmación ¡Hemos recibido tu pago!")
    public void debeMostrarElMensajeDeConfirmaciónHemosRecibidoTuPago() {
        assertTrue(stepAgregarMedioPago.obtiene_mensaje_confirmacion());
    }

    @And("elimino la tarjeta afiliada {string} desde Mi Perfil")
    public void eliminoLaTarjetaAfiliadaDesdeMiPerfil(String numTarjeta) {
        stepAgregarMedioPago.irMedioPago_desde_regresoPerfil();
        assertTrue(stepAgregarMedioPago.validarExisteTarjeta(numTarjeta));
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta);
    }

    @Then("debe mostrar el mensaje de confirmación {string}")
    public void debeMostrarElMensajeDeConfirmación(String valorEsperado) {
        String valorObtenido = stepAgregarMedioPago.obtiene_mensaje_pago();
        assertEquals(valorEsperado, valorObtenido);
    }

    @And("elimino la tarjeta agregada {string} desde Mis Tarjetas")
    public void eliminoLaTarjetaAgregadaDesdeMisTarjetas(String numTarjeta) {
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta);
    }
    @And("ingreso mis datos bancarios desde la opcion pagar cuotas para suscribir mi tarjeta {string} , {string} y {string} para realizar el pago")
    public void ingresoMisDatosBancariosDesdeLaOpcionPagarCuotasParaSuscribirMiTarjetaYParaRealizarElPago(String numTarjeta, String cvv, String fecha) throws Exception {
        stepAgregarMedioPago.seleccionaPagos();
        stepAgregarMedioPago.pagarcuotas(numTarjeta,cvv,fecha);
    }

    @And("ingreso mis datos bancarios desde la opcion pagar cuotas estando afilidado a debito automatico {string} , {string} y {string}")
    public void ingresoMisDatosBancariosDesdeLaOpcionPagarCuotasEstandoAfilidadoADebitoAutomaticoY(String numTarjeta, String cvv, String fecha) throws Exception {
        stepAgregarMedioPago.seleccionaPagos();
        stepAgregarMedioPago.pagarcuotasTarAfil(numTarjeta,cvv,fecha);
    }

    @And("elimino la tarjeta suscrita {string} desde Mi Perfil")
    public void eliminoLaTarjetaSuscritaDesdeMiPerfil(String numTarjeta) {
        stepAgregarMedioPago.irMedioPago_desde_regresoPerfil();
        assertTrue(stepAgregarMedioPago.validarExisteTarjeta(numTarjeta));
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta);
    }
}
