package rimac.test.definition;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepVentaSOAT;

public class DefVentaNueva {
    @Steps
    StepVentaSOAT stepVentaSOAT;
    @When("ingreso mis datos bancarios {string},{string} y {string} para generar la compra del producto SOAT para el vehiculo {string}")
    public void ingresoMisDatosBancariosYParaGenerarLaCompraDelProductoSOATParaElVehiculo(String numTarjeta, String cvv, String fecha, String placa) throws Exception {
        stepVentaSOAT.ingresarSoatDosMinutos(placa);
        stepVentaSOAT.eligePlanVial();
        stepVentaSOAT.agregarTarjeta(numTarjeta,cvv,fecha);
    }
}
