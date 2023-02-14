package rimac.test.definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepAsistenciaVehicular;
import rimac.main.step.StepInactividadModulo;

public class DefTiempoInactividadModulo {

    @Steps
    StepInactividadModulo stepInactividadModulo;

    @When("se ingresa a Asistencias vehiculares desde Tramites y se mantiene inactivo el modulo")
    public void seIngresaAAsistenciasVehicularesDesdeTramitesYSeMantieneInactivoElModulo() throws Exception {
        stepInactividadModulo.se_ingresa_a_Asistencias_Vehiculares_se_mantiene_la_inactividad();
    }

    @Then("se valida el mensaje para retornar al Login")
    public void seValidaElMensajeParaRetornarAlLogin() {
        stepInactividadModulo.se_valida_mensaje_de_inactividad();
    }

}
