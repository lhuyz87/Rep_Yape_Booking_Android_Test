package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepPlanVidaFlexible;

import static org.junit.Assert.assertTrue;

public class DefPlanVidaFlexible {

    @Steps
    StepPlanVidaFlexible stepPlanVidaFlexible;

    @When("deseo conocer el detalle del estado de cuenta del {string} y del {string}")
    public void deseoConocerElDetalleDelEstadoDeCuentaDelYDel(String anio, String mes) throws InterruptedException {
        stepPlanVidaFlexible.ver_detalle_vida_flexible();
        stepPlanVidaFlexible.ir_EstadoCuenta();
        stepPlanVidaFlexible.ingresarfecha(anio,mes);
        stepPlanVidaFlexible.descargar_estado_cuenta();
    }

    @Then("debe visualizarse el estado de cuenta de mi seguro Vida Flexible")
    public void debeVisualizarseElEstadoDeCuentaDeMiSeguroVidaFlexible() {
        assertTrue(stepPlanVidaFlexible.validar_estado_cuenta());
    }

    @And("se mantiene inactivo en la previsualización del pdf")
    public void seMantieneInactivoEnLaPrevisualizaciónDelPdf() {
        stepPlanVidaFlexible.se_mantiene_inactivo_en_consulta();
    }

    @Then("debe validar el mensaje para retornar al Login desde plan Vida Flexible")
    public void debeValidarElMensajeParaRetornarAlLoginDesdePlanVidaFlexible() {
        stepPlanVidaFlexible.se_valida_mensaje_de_inactividad_desde_Consulta_Poliza();
    }
}
