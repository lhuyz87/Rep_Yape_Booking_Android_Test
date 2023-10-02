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

    @When("se ingresa al detalle de la {string} del seguro SOAT")
    public void seIngresaAlDetalleDeLaDelSeguroSOAT(String placa){
        stepPolizaVehicular.ver_detalle_SegurosSOAT(placa);
    }

    @Then("Se valida el número de póliza Soat")
    public void seValidaElNúmeroDePólizaSoat() throws Exception {
        stepPolizaVehicular.se_valida_numero_polizaSoat();
    }

    @When("se ingresa al detalle de la {string} {string} del seguro vehicular")
    public void seIngresaAlDetalleDeLaDelSeguroVehicular(String placa, String vigencia) {
        stepPolizaVehicular.ver_detalle_SegurosVehicularPlaca(placa,vigencia);
    }

    @Then("se valida que muestre el historial de pago")
    public void seValidaQueMuestreElHistorialDePago() throws Exception {
        stepPolizaVehicular.se_valida_historial_pago();
    }

    @And("se consulta la última cuota cancelada")
    public void seConsultaLaÚltimaCuotaCancelada() throws Exception {
        stepPolizaVehicular.obtener_cuota_pagada();
    }

    @Then("se debe visualizar la cuota pagada en el historial")
    public void seDebeVisualizarLaCuotaPagadaEnElHistorial() {
        stepPolizaVehicular.busca_cuota_historial_pago();
    }
}
