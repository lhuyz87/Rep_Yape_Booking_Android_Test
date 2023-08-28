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

    @When("se realiza el pago del seguro vehicular de la {string} {string} del vehiculo")
    public void seRealizaElPagoDelSeguroVehicularDeLaDelVehiculo(String placa, String vigencia) throws Exception {
        stepPagoCuotas.verDetalleSeguroVehicular(placa, vigencia);
        stepPagoCuotas.pagarCuotas();
        stepPagoCuotas.pagarConTarjetaAsociada();
    }

    @When("se realiza el pago del seguro vehicular de la {string} {string} del vehiculo con la tarjeta {string} , {string} y {string}")
    public void seRealizaElPagoDelSeguroVehicularDeLaDelVehiculoConLaTarjetaY(String placa,String vigencia, String numTarjeta, String cvv, String fecha) throws Exception {
        stepPagoCuotas.verDetalleSeguroVehicular(placa,vigencia);
        stepPagoCuotas.pagarCuotas();
        stepPagoCuotas.pagarSinTarjetaAsociada(numTarjeta,cvv,fecha);
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

    @When("se ingresa al detalle de pago de la {string} {string} del vehiculo")
    public void seIngresaAlDetalleDePagoDeLaDelVehiculo(String placa,String vigencia) throws Exception {
        stepPagoCuotas.verDetalleSeguroVehicular(placa,vigencia);
        stepPagoCuotas.pagarCuotas();
    }

    @And("se agrega la tarjeta {string} , {string} y {string} para realizar el pago")
    public void seAgregaLaTarjetaYParaRealizarElPago(String numTarjeta, String cvv, String fecha) throws Exception {
        stepPagoCuotas.pagarSinTarjetaAsociada(numTarjeta,cvv,fecha);
    }

    @When("ingresamos al seguro SOAT desde el menú")
    public void ingresamosAlSeguroSOATDesdeElMenú() {
        stepPagoCuotas.iraSegurosDesdePerfil();
        stepPagoCuotas.iraSoatDesdeSeguros();
        stepPagoCuotas.verDetalleSoat();
        stepPagoCuotas.mostrarDetallePago();
        
    }

    @Then("debe mostrar el detalle del pago anual")
    public void debeMostrarElDetalleDelPagoAnual() {
        assertTrue(stepPagoCuotas.obtiene_mensaje_detallePago());
    }

    @When("se ingresa a un seguro Vehicular desde el Menù seleccionando la {string} {string} del vehiculo")
    public void seIngresaAUnSeguroVehicularDesdeElMenùSeleccionandoLaDelVehiculo(String placa,String vigencia) {
        stepPagoCuotas.verDetalleSeguroVehicular(placa,vigencia);
    }


    @And("elimino la tarjeta del listado {string} desde Mi Perfil")
    public void eliminoLaTarjetaDelListadoDesdeMiPerfil(String numTarjeta) {
        stepPagoCuotas.irMedioPago_desde_regresoPerfil();
        stepPagoCuotas.eliminarTarjeta(numTarjeta);
    }
}
