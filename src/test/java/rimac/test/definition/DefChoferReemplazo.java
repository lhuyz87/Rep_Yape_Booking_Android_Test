package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepChoferDeReemplazo;

import static org.junit.Assert.assertTrue;

public class DefChoferReemplazo {

    @Steps
    StepChoferDeReemplazo stepChoferDeReemplazo;


    @When("se ingresa a Chofer Remplazo desde Tramites y se inicia el tramite con la {string} del vehiculo")
    public void seIngresaAChoferRemplazoDesdeTramitesYSeIniciaElTramiteConLaDelVehiculo(String placa) throws Exception {
        stepChoferDeReemplazo.se_ingresa_a_chofer_reemplazo_desde_tramites();
        stepChoferDeReemplazo.chkTerminosAsistencia();
        stepChoferDeReemplazo.se_ingresa_Datos_de_contacto();
        stepChoferDeReemplazo.seleccionarVehiculo(placa);
    }

    @And("se solicita el servicio indicando la ubicación, fecha y la documentación requerida")
    public void seSolicitaElServicioIndicandoLaUbicaciónFechaYLaDocumentaciónRequerida() throws InterruptedException {
        stepChoferDeReemplazo.buscar_destino();
        stepChoferDeReemplazo.ingresar_fecha();
        stepChoferDeReemplazo.ingresar_hora();
        stepChoferDeReemplazo.ingresar_requisitos();

    }

    @Then("se realiza la confirmación de la solicitud")
    public void seRealizaLaConfirmaciónDeLaSolicitud() throws Exception {
        stepChoferDeReemplazo.confirmar_chofer();
        stepChoferDeReemplazo.retornarInicio();
    }

    @And("debe mostrar el seguimiento de chofer de reemplazo de la  {string}")
    public void debeMostrarElSeguimientoDeChoferDeReemplazoDeLa(String placa) {
        assertTrue(stepChoferDeReemplazo.se_valida_solicitud_chofer(placa));
    }

    @And("debe mostrar la solicitud de chofer reemplazo de la")
    public void debeMostrarLaSolicitudDeChoferReemplazoDeLa() {
    }
}
