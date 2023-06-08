package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScTusSeguros;
import rimac.main.step.StepPagoCuotas;
import rimac.main.util.Variables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefPagoCuotas {


    @Steps
    StepPagoCuotas stepPagoCuotas;

    @When("se realiza el pago del seguro vehicular de la {string} del vehiculo")
    public void seRealizaElPagoDelSeguroVehicularDeLaDelVehiculo(String placa) throws Exception {
        stepPagoCuotas.verDetalleSeguroVehicular(placa);
        stepPagoCuotas.pagarCuotas();
        stepPagoCuotas.pagarConTarjetaAsociada();
    }

    @And("debe mostrar el mensaje ¡Hemos recibido tu pago!")
    public void debeMostrarElMensajeHemosRecibidoTuPago() {
        assertTrue(stepPagoCuotas.obtiene_mensaje_confirmacion());
    }

    @Then("se valida la cuota pagada en el historial de pago")
    public void seValidaLaCuotaPagadaEnElHistorialDePago() {
        stepPagoCuotas.selecciona_HistorialPago();
        stepPagoCuotas.obtenerMontoHistorial();
        assertEquals(Variables.montoCuotaPagos, Variables.montoCuotaHistorial);
    }

    @When("se ingresa al detalle de pago de la {string} del vehiculo")
    public void seIngresaAlDetalleDePagoDeLaDelVehiculo(String placa) throws Exception {
        stepPagoCuotas.verDetalleSeguroVehicular(placa);
        stepPagoCuotas.pagarCuotas();
    }

    @And("se agrega la tarjeta {string} , {string} y {string} para realizar el pago")
    public void seAgregaLaTarjetaYParaRealizarElPago(String numTarjeta, String cvv, String fecha) throws Exception {
        stepPagoCuotas.pagarSinTarjetaAsociada(numTarjeta,cvv,fecha);
    }
}
