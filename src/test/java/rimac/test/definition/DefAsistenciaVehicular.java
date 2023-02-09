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
        stepAsistenciaVehicular.chkTerminosAsistencia();
        stepAsistenciaVehicular.se_ingresa_Datos_de_contacto();
        stepAsistenciaVehicular.seleccionarVehiculo(placa);
        stepAsistenciaVehicular.confirmarUbicacion();
    }
    @And("selecciono el {string} del vehiculo")
    public void seleccionoElDelVehiculo(String problema) {
        stepAsistenciaVehicular.selecciona_asistencia_Auxilio_Mecanico();
        stepAsistenciaVehicular.selecciona_problema_vehiculo(problema);
    }
    @And("confirmo los terminos de la solicitud")
    public void confirmoLosTerminosDeLaSolicitud() {
        stepAsistenciaVehicular.confirmar_solicitud();
    }

    @And("selecciono la asistencia Grua y la zona en donde se encuentra el vehiculo")
    public void seleccionoLaAsistenciaGruaYLaZonaEnDondeSeEncuentraElVehiculo() {
        stepAsistenciaVehicular.selecciona_asistencia_Grua();
        stepAsistenciaVehicular.indico_zona_del_vehiculo();
    }
    @Then("valido el mensaje de la solicitud enviada")
    public void validoElMensajeDeLaSolicitudEnviada() throws Exception {
        stepAsistenciaVehicular.validar_solicitud_enviada();
    }

    @Then("Se valida que sea el seguimiento requerido")
    public void seValidaQueSeaElSeguimientoRequerido() {
        stepAsistenciaVehicular.validar_solicitud_home();
    }

    @When("se muestra el seguimiento de la asistencia vehicular Auxilio Mecanico de la {string}")
    public void seMuestraElSeguimientoDeLaAsistenciaVehicularAuxilioMecanicoDeLa(String placa) {
        stepAsistenciaVehicular.se_indica_asistencia_auxilio_mecanico(placa);
    }

    @When("se muestra el seguimiento de la asistencia vehicular Grua de la {string}")
    public void seMuestraElSeguimientoDeLaAsistenciaVehicularGruaDeLa(String placa) {
        stepAsistenciaVehicular.se_indica_asistencia_Grua(placa);
    }
}
