package rimac.test.definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepDescargaPoliza;
import static org.junit.Assert.assertTrue;

public class DefDescargaPoliza {

    @Steps
    StepDescargaPoliza stepDescargaPoliza;

    @When("deseo conocer el detalle de mi {string}")
    public void deseoConocerElDetalleDeMi(String seguro) {
        stepDescargaPoliza.ver_Detalle_Seguros(seguro);
        stepDescargaPoliza.ver_Detalle_Poliza();
    }
    @When("deseo conocer el detalle del estado de cuenta de mi {string} del {string} y del {string}")
    public void deseoConocerElDetalleDelEstadoDeCuentaDeMiDelYDel(String seguro, String anio, String mes) {
        stepDescargaPoliza.ver_Detalle_Seguros(seguro);
        stepDescargaPoliza.ir_EstadoCuenta();
        stepDescargaPoliza.ingresarfecha(anio,mes);
        stepDescargaPoliza.descargarPoliza();
    }
    @Then("debe descargar la información de mi poliza vehicular")
    public void debeDescargarLaInformaciónDeMiPolizaVehicular() {
        assertTrue(stepDescargaPoliza.validarPDF());
    }

}
