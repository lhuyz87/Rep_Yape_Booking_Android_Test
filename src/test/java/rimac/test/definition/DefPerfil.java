package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepPerfil;
import rimac.main.step.StepPerfiladorSalud;

public class DefPerfil {

    @Steps
    StepPerfil stepPerfil;

    @When("ingreso a mi informacion en opcion perfil")
    public void ingresoAMiInformacionEnOpcionPerfil() throws Exception {
        stepPerfil.ingresaraaPerfil();
    }

    @And("se mantiene inactivo el modulo en la pantalla mi perfil")
    public void seMantieneInactivoElModuloEnLaPantallaMiPerfil() {
        stepPerfil.inactivadModuloTramites();
    }

    @Then("se valida el mensaje para retornar al login desde pantalla de perfil")
    public void seValidaElMensajeParaRetornarAlLoginDesdePantallaDePerfil() {
        stepPerfil.validaMensaje();
    }
}
