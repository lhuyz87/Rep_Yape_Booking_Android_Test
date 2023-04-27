package rimac.test.definition;

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
        stepAgregarMedioPago.irMedioPago_desde_perfil();
        stepAgregarMedioPago.eliminarTarjeta(numTarjeta);
        stepVentaSOAT.irTiendaDesdePerfil();
        stepVentaSOAT.empezarSoatDosMinutos(placa);
        stepVentaSOAT.eligePlan();
        stepVentaSOAT.agregarTarjeta(numTarjeta,cvv,fecha);
    }

    @Then("debe de mostrar el mensaje {string}")
    public void debeDeMostrarElMensaje(String mensaje) throws Exception {
        assertEquals(mensaje,stepVentaSOAT.validaMensaje());
        stepVentaSOAT.finalizarOperacion();
    }
}
