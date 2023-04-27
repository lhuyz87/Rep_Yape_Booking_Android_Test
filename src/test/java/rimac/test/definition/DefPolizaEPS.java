package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepConsultaPoliza;

public class DefPolizaEPS {

    @Steps
    StepConsultaPoliza stepConsultaPoliza;

    @When("se ingresa al detalle del seguro Planes Medicos EPS")
    public void seIngresaAlDetalleDelSeguroPlanesMedicosEPS() {
        stepConsultaPoliza.selecciona_detalle_del_seguro_planes_medicos_eps();
    }

    @And("se visualiza el numero de póliza del seguro")
    public void seVisualizaElNumeroDePólizaDelSeguro() throws Exception {
        stepConsultaPoliza.se_visuliza_el_numero_de_poliza();
    }

    @And("se mantiene inactivo en la sección poliza")
    public void seMantieneInactivoEnLaSecciónPoliza() {
        stepConsultaPoliza.se_mantiene_inactivo_en_consulta();
    }
    @Then("debe validar el mensaje para retornar al Login desde seguros Consulta de póliza")
    public void debeValidarElMensajeParaRetornarAlLoginDesdeSegurosConsultaDePóliza() {
        stepConsultaPoliza.se_valida_mensaje_de_inactividad_desde_Consulta_Poliza();
    }


}
