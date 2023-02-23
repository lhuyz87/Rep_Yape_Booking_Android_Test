package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepDescargaPdf;

import static org.junit.Assert.assertTrue;

public class DefDescargaConsultaVida {

    @Steps
    StepDescargaPdf stepDescargaPdf;
    @When("deseo conocer las caracteristicas de mi {string}")
    public void deseoConocerLasCaracteristicasDeMi(String seguro) {
        stepDescargaPdf.ver_Detalle_Seguros(seguro);
        stepDescargaPdf.descargarPdf();
    }

    @Then("debe mostrar la previsualización del documento pdf")
    public void debeMostrarLaPrevisualizaciónDelDocumentoPdf() {
        assertTrue(stepDescargaPdf.validarPDF());
    }
}
