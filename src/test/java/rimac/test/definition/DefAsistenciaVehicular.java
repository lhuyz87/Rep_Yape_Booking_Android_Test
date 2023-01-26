package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepAsistenciaVehicular;

public class DefAsistenciaVehicular {

    @Steps
    StepAsistenciaVehicular stepAsistenciaVehicular;
    @When("se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la {string} del vehiculo")
    public void seIngresaAAsistenciasVehicularesDesdeTramitesYSeIniciaElTramiteConLaDelVehiculo(String placa) throws Exception {
        stepAsistenciaVehicular.se_ingresa_a_asistencia_vehicular_desde_tramites();
        stepAsistenciaVehicular.se_ingresa_Datos_de_contacto();
        stepAsistenciaVehicular.seleccionarVehiculo(placa);
        stepAsistenciaVehicular.confirmarUbicacion();
        stepAsistenciaVehicular.selecciona_asistencia_Auxilio_Mecanico();
    }
    @And("selecciono el {string} del vehiculo")
    public void seleccionoElDelVehiculo(String problema) {
        stepAsistenciaVehicular.selecciona_problema_vehiculo(problema);
    }
    @And("confirmo los terminos de la solicitud")
    public void confirmoLosTerminosDeLaSolicitud() {
        stepAsistenciaVehicular.confirmar_solicitud();
    }

    @Then("valido el mensaje de la solicitud enviada y su visualizacion en el home")
    public void validoElMensajeDeLaSolicitudEnviadaYSuVisualizacionEnElHome() throws Exception {
        stepAsistenciaVehicular.validar_solicitud_enviada();
        stepAsistenciaVehicular.validar_solicitud_home();
    }
}
