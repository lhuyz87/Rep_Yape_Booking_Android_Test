package rimac.test.definition;

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
}
