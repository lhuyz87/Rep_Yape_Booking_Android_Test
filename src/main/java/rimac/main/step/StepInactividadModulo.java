package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.*;

public class StepInactividadModulo {


    @Steps
    ScTuSesionExpiro scTuSesionExpiro;
    @Steps
    ScAlertas scAlertas;
    @Steps
    ScTusTramites scTusTramites;
    @Steps
    ScHome scHome;

    public void se_ingresa_a_Asistencias_Vehiculares_se_mantiene_la_inactividad() throws Exception {
        scAlertas.omitirAlertas(20);
        scHome.seleccionarOpcionPrincipal("Tramites");
        scTusTramites.seleccionaAsistenciaVehicular();
        scTuSesionExpiro.inactividad_del_modulo_AsistenciasVehiculares();
    }

    public void se_valida_mensaje_de_inactividad(){
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
}
