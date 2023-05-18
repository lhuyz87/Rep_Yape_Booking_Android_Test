package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepPerfiladorSalud;
import rimac.main.step.StepPerfiladorVehicular;
import rimac.main.step.StepVentaSOAT;

public class DefPerfiladorVehicular {

    @Steps
    StepPerfiladorVehicular stepPerfiladorVehicular;


    @When("se ingresa a tienda, opcion seguros vehiculares")
    public void seIngresaATiendaOpcionSegurosVehiculares() throws Exception {
        stepPerfiladorVehicular.irTiendaDesdePerfil();

    }

    @And("se realiza test ingresamos la {string} para obtener seguro ideal")
    public void seRealizaTestIngresamosLaParaObtenerSeguroIdeal(String placa) throws Exception {
        stepPerfiladorVehicular.iraTestVehicular();
        stepPerfiladorVehicular.ingresarPlacaVeh(placa);
        stepPerfiladorVehicular.datosVeh();

    }

    @Then("muestra plan ideal vehicular")
    public void muestraPlanIdealVehicular() throws Exception {
        stepPerfiladorVehicular.irPlanVehi();
    }
}
