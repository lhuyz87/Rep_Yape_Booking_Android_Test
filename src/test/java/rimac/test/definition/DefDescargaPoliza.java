package rimac.test.definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepDescargaPdf;
import static org.junit.Assert.assertTrue;

public class DefDescargaPoliza {

    @Steps
    StepDescargaPdf stepDescargaPdf;

    @When("deseo conocer el detalle de mi {string}")
    public void deseoConocerElDetalleDeMi(String seguro) {
        stepDescargaPdf.ver_Detalle_Seguros(seguro);
        stepDescargaPdf.ver_Detalle_Poliza();
    }
    @When("deseo conocer el detalle del estado de cuenta de mi {string} del {string} y del {string}")
    public void deseoConocerElDetalleDelEstadoDeCuentaDeMiDelYDel(String seguro, String anio, String mes) {
        stepDescargaPdf.ver_Detalle_Seguros(seguro);
        stepDescargaPdf.ir_EstadoCuenta();
        stepDescargaPdf.ingresarfecha(anio,mes);
        stepDescargaPdf.descargarPdf();
    }
    @Then("debe descargar la información de mi poliza vehicular")
    public void debeDescargarLaInformaciónDeMiPolizaVehicular() {
        assertTrue(stepDescargaPdf.validarPDF());
    }

}
