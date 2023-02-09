package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.*;
import rimac.main.util.ConstantesDummy;

public class StepAsistenciaVehicular {

    @Steps
    ScHome scHome;
    @Steps
    ScAlertas scAlertas;
    @Steps
    ScTusTramites scTusTramites;
    @Steps
    ScAsistenciaVehicular scAsistenciaVehicular;
    public void se_ingresa_a_asistencia_vehicular_desde_tramites() {
        scHome.seleccionarOpcionPrincipal("Tramites");
        scTusTramites.seleccionaAsistenciaVehicular();
    }

    public void chkTerminosAsistencia(){
        scAsistenciaVehicular.terminosCondicionesAsistencia();
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

    public void se_indica_asistencia_Grua(String placa){
        scAsistenciaVehicular.se_indica_asistencia_vehicular("Grúa", placa);
    }

    public void se_indica_asistencia_auxilio_mecanico(String placa){
        scAsistenciaVehicular.se_indica_asistencia_vehicular("Auxilio mecánico", placa);
    }
    public void selecciona_asistencia_Auxilio_Mecanico(){
        scAsistenciaVehicular.selecciona_asistencia("Auxilio mecánico");
    }

    public void selecciona_asistencia_Grua(){
        scAsistenciaVehicular.selecciona_asistencia("Grúa");
    }

    public void indico_zona_del_vehiculo(){
        scAsistenciaVehicular.indica_zona_del_vehiculo();
    }

    public void selecciona_problema_vehiculo(String problemaVehiculo){
        scAsistenciaVehicular.selecciona_problema_vehiculo(problemaVehiculo);
    }

    public void confirmar_solicitud(){
        scAsistenciaVehicular.confirmar_solicitud();
    }

    public void validar_solicitud_enviada() {
        scAsistenciaVehicular.validacion_mensaje_confirmacion();
    }
    public void validar_solicitud_home() {
        scAsistenciaVehicular.validacion_solicitud_home();
    }







}
