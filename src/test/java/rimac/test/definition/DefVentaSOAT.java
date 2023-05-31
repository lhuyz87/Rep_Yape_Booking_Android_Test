package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepMediosdePago;
import rimac.main.step.StepVentaSOAT;

import static org.junit.Assert.assertEquals;

public class DefVentaSOAT {

    @Steps
    StepVentaSOAT stepVentaSOAT;
    @Steps
    StepMediosdePago stepAgregarMedioPago;

    @When("ingreso mis datos bancarios {string},{string} y {string} para generar la compra del SOAT para el vehiculo {string}")
    public void ingresoMisDatosBancariosYParaGenerarLaCompraDelSOATParaElVehiculo(String numTarjeta, String cvv, String fecha, String placa) throws Exception {
        stepVentaSOAT.seleccionarTienda();
        stepVentaSOAT.empezarSoatDosMinutos(placa);
        stepVentaSOAT.eligePlanDigital();
        stepVentaSOAT.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @When("ingreso mis datos bancarios {string},{string} y {string} para generar la compra del SOAT Plan Vial para el vehiculo {string}")
    public void ingresoMisDatosBancariosYParaGenerarLaCompraDelSOATPlanVialParaElVehiculo(String numTarjeta, String cvv, String fecha, String placa) throws Exception {
        stepVentaSOAT.seleccionarTienda();
        stepVentaSOAT.empezarSoatDosMinutos(placa);
        stepVentaSOAT.eligePlanVial();
        stepVentaSOAT.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @Then("debe de mostrar el mensaje {string}")
    public void debeDeMostrarElMensaje(String mensaje) throws Exception {
        assertEquals(mensaje,stepVentaSOAT.validaMensaje());
        stepVentaSOAT.finalizarOperacion();
    }

    @And("elimino la tarjeta guardada {string} desde Mi Perfil")
    public void eliminoLaTarjetaGuardadaDesdeMiPerfil(String numTarjeta) throws Exception {
        stepVentaSOAT.irMedioPago_desde_perfil();
        stepVentaSOAT.eliminarTarjeta(numTarjeta);
        stepVentaSOAT.volverDesdePerfil();
    }

    @And("se mantiene inactivo el modulo en la pantalla de confirmación de la compra")
    public void seMantieneInactivoElModuloEnLaPantallaDeConfirmaciónDeLaCompra() {
        stepVentaSOAT.se_mantiene_la_inactividad_asistencia_vehicular();
    }

    @Then("se valida el mensaje para retornar al Login desde la pantalla de confirmación de compra")
    public void seValidaElMensajeParaRetornarAlLoginDesdeLaPantallaDeConfirmaciónDeCompra() {
        stepVentaSOAT.se_valida_mensaje_de_inactividad();
    }
}
