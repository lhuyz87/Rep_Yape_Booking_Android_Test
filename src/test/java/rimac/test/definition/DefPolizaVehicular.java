package rimac.test.definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepPolizaVehicular;
import static org.junit.Assert.assertTrue;

public class DefPolizaVehicular {

    @Steps
    StepPolizaVehicular stepDescargaPdf;

    @When("se ingresa al detalle del Seguro Vehicular desde Seguros")
    public void seIngresaAlDetalleDelSeguroVehicularDesdeSeguros() {
        stepDescargaPdf.ver_Detalle_Seguros();
        stepDescargaPdf.ver_Detalle_Poliza();
    }

    @Then("debe descargar la información de mi poliza vehicular")
    public void debeDescargarLaInformaciónDeMiPolizaVehicular() {
        assertTrue(stepDescargaPdf.validarPDF());
    }


}
