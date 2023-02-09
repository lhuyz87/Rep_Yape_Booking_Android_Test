package rimac.test.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import rimac.main.step.StepAsistenciaVehicular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefAsistenciaVehicular {

    @Steps
    StepAsistenciaVehicular stepAsistenciaVehicular;
    @When("se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la {string} del vehiculo")
    public void seIngresaAAsistenciasVehicularesDesdeTramitesYSeIniciaElTramiteConLaDelVehiculo(String placa) throws Exception {
        stepAsistenciaVehicular.se_ingresa_a_asistencia_vehicular_desde_tramites();
        stepAsistenciaVehicular.chkTerminosAsistencia();
        stepAsistenciaVehicular.se_ingresa_Datos_de_contacto();
        stepAsistenciaVehicular.seleccionarVehiculo(placa);
        stepAsistenciaVehicular.confirmarUbicacion();
    }

    @And("selecciono la asistencia {string} y el {string} del vehiculo")
    public void seleccionoLaAsistenciaYElDelVehiculo(String asistencia, String problema) {
        stepAsistenciaVehicular.selecciona_asistencia_vehicular(asistencia);
        stepAsistenciaVehicular.selecciona_problema_vehiculo(problema);
    }

    @And("selecciono la asistencia {string} y la zona en donde se encuentra el vehiculo")
    public void seleccionoLaAsistenciaYLaZonaEnDondeSeEncuentraElVehiculo(String asistencia) {
        stepAsistenciaVehicular.selecciona_asistencia_vehicular(asistencia);
        stepAsistenciaVehicular.indico_zona_del_vehiculo();
    }
    @And("confirmo los terminos de la solicitud")
    public void confirmoLosTerminosDeLaSolicitud() {
        stepAsistenciaVehicular.confirmar_solicitud();
    }

    @Then("se debe mostrar el mensaje : {string}")
    public void seDebeMostrarElMensaje(String valorEsperado) {
        String valorObtenido = stepAsistenciaVehicular.obtiene_mensaje_confirmacion();
        assertEquals(valorEsperado, valorObtenido);
    }
    @Then("se debe mostrar el seguimiento de la asistencia vehicular {string} de la {string}")
    public void seDebeMostrarElSeguimientoDeLaAsistenciaVehicularDeLa(String asistencia, String placa) {
        assertTrue(stepAsistenciaVehicular.se_valida_solicitud_home(asistencia, placa));
    }

}
