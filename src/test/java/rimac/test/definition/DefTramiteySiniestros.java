package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepTramiteySiniestros;

public class DefTramiteySiniestros {
    @Steps
    StepTramiteySiniestros stepTramiteySiniestros;
    @When("ingreso a menu tramites")
    public void ingresoAMenuTramites() {
        stepTramiteySiniestros.iraTramites();
    }

    @And("se mantiene inactivo el modulo en la pantalla tramites")
    public void seMantieneInactivoElModuloEnLaPantallaTramites() {
        stepTramiteySiniestros.inactivadModuloTramites();
        
    }

    @Then("se valida el mensaje para retornar al login desde pantalla de pagos")
    public void seValidaElMensajeParaRetornarAlLoginDesdePantallaDePagos() {
        stepTramiteySiniestros.validaMensaje();

    }
}
