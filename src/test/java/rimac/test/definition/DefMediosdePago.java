package rimac.test.definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepAgregarMedioPago;

import static org.junit.Assert.assertTrue;

public class DefMediosdePago {

    @Steps
    StepAgregarMedioPago stepAgregarMedioPago;

    @When("ingreso mis datos bancarios desde Perfil para suscribir mi tarjeta {string} , {string} y {string}")
    public void ingresoMisDatosBancariosDesdePerfilParaSuscribirMiTarjetaY(String numTarjeta, String cvv, String fecha) {
        stepAgregarMedioPago.irMedioPago_desde_perfil();
        stepAgregarMedioPago.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @When("ingreso mis datos bancarios desde el tab de Pagos para suscribir mi tarjeta {string} , {string} y {string}")
    public void ingresoMisDatosBancariosDesdeElTabDePagosParaSuscribirMiTarjetaY(String numTarjeta, String cvv, String fecha) {
        stepAgregarMedioPago.irMedioPago_desde_tab_pagos();
        stepAgregarMedioPago.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @Then("se debe agregar la tarjeta {string} a Mis Tarjetas")
    public void seDebeAgregarLaTarjetaAMisTarjetas(String numTarjeta) {
        assertTrue(stepAgregarMedioPago.validarTarjeta(numTarjeta));
    }

    @When("realizo la eliminacion de la tarjeta {string} , {string} y {string}")
    public void realizoLaEliminacionDeLaTarjeta(String numTarjeta, String cvv, String fecha) {
        stepAgregarMedioPago.irMedioPago_desde_tab_pagos();
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta,cvv,fecha);
    }

    @Then("debe mostrar el mensaje {string}")
    public void debeMostrarElMensaje(String mensaje) {
        assertTrue(mensaje.equals(stepAgregarMedioPago.validarMensajeEliminacion()));
    }
}
