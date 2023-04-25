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
    @Steps
    ScTuSesionExpiro scTuSesionExpiro;

    @Steps
    ScNecesitoAyuda scNecesitoAyuda;
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

    public void selecciona_asistencia_vehicular(String asistencia){
        switch(asistencia){
            case "Auxilio mecánico":scAsistenciaVehicular.selecciona_asistencia_auxilio_mecanico();
                break;

            case "Grúa":scAsistenciaVehicular.selecciona_asistencia_grua();
                break;

            case "Ayúdame a elegir una":scAsistenciaVehicular.selecciona_asistencia_ayudame_elegir();
                break;
            default:
                break;
        }
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


    public String obtiene_mensaje_confirmacion(){
        return scAsistenciaVehicular.obtener_mensaje_confirmacion();
    }
    public boolean se_valida_solicitud_home(String asistencia ,String placa){
        return scAsistenciaVehicular.validacion_AsistenciaVehicular_home(asistencia,placa);
    }
    public void se_mantiene_la_inactividad_asistencia_vehicular() {
        scTuSesionExpiro.inactividad_del_modulo();
    }
    public void se_valida_mensaje_de_inactividad(){
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
    public void retornarInicio() throws Exception {
        scAsistenciaVehicular.irAlInicio();
        scAlertas.omitirAlertas(10);
    }

    public void seleccionar_ayuda_auxilio_mecanico(String opcion) throws Exception {
        scNecesitoAyuda.seleccionarOpcion(opcion);
        scNecesitoAyuda.seleccionarSi();
        scNecesitoAyuda.seleccionarNo();
        scNecesitoAyuda.solicitarAsistenciaSugerida();
    }

    public void seleccionar_ayuda_grua(String opcion) throws Exception {
        scNecesitoAyuda.seleccionarOpcion(opcion);
        scAsistenciaVehicular.indica_zona_del_vehiculo();
        scNecesitoAyuda.solicitarAsistenciaSugerida();
    }
}
