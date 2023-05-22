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
    public void ingresoMisDatosBancariosDesdePerfilParaSuscribirMiTarjetaY(String numTarjeta, String cvv, String fecha) {
        stepAgregarMedioPago.irMedioPago_desde_perfil();
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta);
        stepAgregarMedioPago.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @When("ingreso mis datos bancarios desde el tab de Pagos para suscribir mi tarjeta {string} , {string} y {string}")
    public void ingresoMisDatosBancariosDesdeElTabDePagosParaSuscribirMiTarjetaY(String numTarjeta, String cvv, String fecha) throws Exception {
        stepAgregarMedioPago.irMedioPago_desde_perfil();
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta);
        stepAgregarMedioPago.volverDesdePerfil();
        stepAgregarMedioPago.irMedioPago_desde_tab_pagos();
        stepAgregarMedioPago.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @Then("se debe agregar la tarjeta {string} a Mis Tarjetas")
    public void seDebeAgregarLaTarjetaAMisTarjetas(String numTarjeta) {
        assertTrue(stepAgregarMedioPago.validarExisteTarjeta(numTarjeta));
    }

    @When("realizo la eliminacion de la tarjeta {string} , {string} y {string}")
    public void realizoLaEliminacionDeLaTarjeta(String numTarjeta, String cvv, String fecha) {
        stepAgregarMedioPago.irMedioPago_desde_tab_pagos();
        stepAgregarMedioPago.agregarTarjeta(numTarjeta,cvv,fecha);
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta);
    }

    @Then("se debe eliminar la tarjeta {string} de Mis Tarjetas")
    public void seDebeEliminarLaTarjetaDeMisTarjetas(String numTarjeta) {
        assertFalse(stepAgregarMedioPago.validarEliminarTarjeta(numTarjeta));
    }

    @When("ingreso mis datos bancarios desde afiliacion de tarjetas {string} , {string} y {string}")
    public void ingresoMisDatosBancariosDesdeAfiliacionDeTarjetasY(String numTarjeta, String cvv, String fecha) throws Exception {
        stepAgregarMedioPago.irMedioPago_desde_perfil();
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta);
        stepAgregarMedioPago.volverDesdePerfil();
        stepAgregarMedioPago.irMedioPago_desde_tab_pagos();
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
}
