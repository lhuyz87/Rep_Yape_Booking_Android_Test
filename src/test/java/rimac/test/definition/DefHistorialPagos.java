package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepHistorialPagos;
import rimac.main.step.StepMediosdePago;
import rimac.main.step.StepPolizaVehicular;

import static org.junit.Assert.assertTrue;

public class DefHistorialPagos {

    @Steps
    StepPolizaVehicular stepPolizaVehicular;

    @Steps
    StepMediosdePago stepAgregarMedioPago;

    @Steps
    StepHistorialPagos stepHistorialPagos;

    @When("se ingresa al detalle del Seguro Vehicular desde la opcion Seguros")
    public void seIngresaAlDetalleDelSeguroVehicularDesdeLaOpcionSeguros() {
        stepPolizaVehicular.ver_detalle_SegurosVehicular();
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

    @And("ingreso a las cuotas por pagar")
    public void ingresoALasCuotasPorPagar() throws Exception {
        stepHistorialPagos.iraPagarCuotas();
    }

    @Then("debe mostrar el listado de las cuotas")
    public void debeMostrarElListadoDeLasCuotas() throws Exception {
        assertTrue(stepHistorialPagos.validarCronograma());
    }

    @And("ingreso a historial de pagos")
    public void ingresoAHistorialDePagos() {
        stepAgregarMedioPago.selecciona_TabPagos();
        stepAgregarMedioPago.selecciona_HistorialPago();
    }

    @Then("debe mostrar el listado de pagos desde historial de pagos")
    public void debeMostrarElListadoDePagosDesdeHistorialDePagos() throws Exception {
        assertTrue(stepHistorialPagos.validarHistorial());
    }

    @When("se ingresa al detalle del Seguro Vehicular {string} {string}")
    public void seIngresaAlDetalleDelSeguroVehicular(String placa, String vigencia) {
        stepPolizaVehicular.verDetalleSeguroVehicular(placa,vigencia);
    }

    @When("se ingresa al detalle del Seguro Planes Medicos EPS")
    public void seIngresaAlDetalleDelSeguroPlanesMedicosEPS() {
        stepHistorialPagos.selecciona_detalle_del_seguro_planes_medicos_eps();
    }
}
