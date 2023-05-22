package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepPolizaVehicular;
import static org.junit.Assert.assertTrue;

public class DefPolizaVehicular {

    @Steps
    StepPolizaVehicular stepPolizaVehicular;

    @When("se ingresa al detalle del Seguro Vehicular desde Seguros")
    public void seIngresaAlDetalleDelSeguroVehicularDesdeSeguros() {
        stepPolizaVehicular.ver_detalle_SegurosVehicular();
    }

    @And("al descargar la poliza Vehicular")
    public void alDescargarLaPolizaVehicular() {
        stepPolizaVehicular.ver_Detalle_Poliza();
    }

    @Then("debe descargar la información de mi poliza vehicular")
    public void debeDescargarLaInformaciónDeMiPolizaVehicular() {
        assertTrue(stepPolizaVehicular.validarPDF());
    }


    @And("se visualiza la cobertura del seguro")
    public void seVisualizaLaCoberturaDelSeguro() {
        stepPolizaVehicular.seleccionar_tab_coberturas();
    }

    @And("se mantiene inactivo en la sección Cobertura")
    public void seMantieneInactivoEnLaSecciónCobertura() {
        stepPolizaVehicular.se_mantiene_inactivo_en_cobertura();
    }

    @Then("debe validar el mensaje para retornar al Login desde seguros")
    public void debeValidarElMensajeParaRetornarAlLoginDesdeSeguros() {
        stepPolizaVehicular.se_valida_mensaje_de_inactividad_desde_cobertura();
    }

}
