package rimac.test.definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepPlanVidaContigo;

import static org.junit.Assert.assertTrue;

public class DefPlanVidaContigo {

    @Steps
    StepPlanVidaContigo stepPlanVidaContigo;


    @When("deseo conocer las caracteristicas de mi  seguro Vida Contigo")
    public void deseoConocerLasCaracteristicasDeMiSeguroVidaContigo() {
        stepPlanVidaContigo.ver_detalle_vida_contigo();
        stepPlanVidaContigo.descargar_manual();
    }

    @Then("debe descargar el manual de uso de mi seguro")
    public void debeDescargarElManualDeUsoDeMiSeguro() {
        assertTrue(stepPlanVidaContigo.validar_visualizacion_manual());
    }
}
