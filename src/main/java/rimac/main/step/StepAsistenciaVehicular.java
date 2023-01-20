package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScActivaTuSeguro;
import rimac.main.screen.ScAsistenciaVehicular;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScTusTramites;
import rimac.main.util.ConstantesDummy;

public class StepAsistenciaVehicular {

    @Steps
    ScHome scHome;
    @Steps
    ScActivaTuSeguro scActivaTuSeguro;
    @Steps
    ScTusTramites scTusTramites;
    @Steps
    ScAsistenciaVehicular scAsistenciaVehicular;
    public void se_ingresa_a_asistencia_vehicular_desde_tramites() {
        scHome.cerrarAlertas(15);
        scHome.seleccionarOpcionPrincipal("Tramites");
        scTusTramites.seleccionaAsistenciaVehicular();
    }

    public void se_ingresa_Datos_de_contacto(){
        String nombre = ConstantesDummy.nombre;
        String celular = ConstantesDummy.celular;
        scAsistenciaVehicular.ingresar_Datos_de_Contacto(nombre,celular);
    }

    public void seleccionarVehiculo(String placa){
        scAsistenciaVehicular.seleccionar_Vehiculo(placa);
    }

    public void confirmarUbicacion(){
        scAsistenciaVehicular.confirmar_Ubicacion();
    }

    public void selecciona_asistencia_Auxilio_Mecanico(){
        scAsistenciaVehicular.selecciona_asistencia_Auxilio_Mecanico();
    }

    public void selecciona_problema_vehiculo(String problemaVehiculo){
        scAsistenciaVehicular.selecciona_problema_vehiculo(problemaVehiculo);
    }

    public void confirmar_solicitud(){
        scAsistenciaVehicular.confirmar_solicitud();
    }

    public void validar_solicitud_enviada() throws InterruptedException {
        scAsistenciaVehicular.validacion_mensaje_confirmacion();
    }
    public void validar_solicitud_home() throws InterruptedException {
        scActivaTuSeguro.omitirModalActivatuSeguro();
        scAsistenciaVehicular.validacion_solicitud_home();
    }
}
