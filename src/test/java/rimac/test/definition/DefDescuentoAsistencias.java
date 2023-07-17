package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepDescuentoAsistencias;
import rimac.main.step.StepMediosdePago;

public class DefDescuentoAsistencias {

    @Steps
    StepDescuentoAsistencias stepDescuentoAsistencias;

    @When("ingreso a la opción Descuento en asistencias desde trámites")
    public void ingresoALaOpciónDescuentoEnAsistenciasDesdeTrámites() {
        stepDescuentoAsistencias.se_ingresa_descuento_asistencias();
    }

    @And("se mantiene inactiva la sesión en el módulo")
    public void seMantieneInactivaLaSesiónEnElMódulo() {
        stepDescuentoAsistencias.se_mantiene_la_inactividad_descuento_asistencia();
    }

    @Then("se valida el mensaje para retornar al Login desde el módulo Servicios de Soat")
    public void seValidaElMensajeParaRetornarAlLoginDesdeElMóduloServiciosDeSoat() {
        stepDescuentoAsistencias.se_valida_mensaje_de_inactividad();
    }
}
