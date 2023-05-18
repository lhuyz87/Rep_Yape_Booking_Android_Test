package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepPerfiladorSalud;

public class DefPerfiladorSalud {
    @Steps
    StepPerfiladorSalud stepPerfiladorSalud;

    @When("se ingresa a tienda, opcion seguros de salud")
    public void seIngresaATiendaOpcionSegurosDeSalud() throws Exception {
        stepPerfiladorSalud.irTiendaDesdePerfil();
    }

    @And("se realiza test para obtener seguro ideal")
    public void seRealizaTestParaObtenerSeguroIdeal() throws Exception {
        stepPerfiladorSalud.iraTestSalud();
        stepPerfiladorSalud.iraaOpcionesTest();
    }

    @Then("muestra la opcion recomendada")
    public void muestraLaOpcionRecomendada() throws Exception {
        stepPerfiladorSalud.opcionRecomendada();
    }


}
