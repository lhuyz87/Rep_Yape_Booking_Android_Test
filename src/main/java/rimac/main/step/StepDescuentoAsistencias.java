package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScTuSesionExpiro;
import rimac.main.screen.ScTusTramites;

public class StepDescuentoAsistencias {

    @Steps
    ScHome scHome;

    @Steps
    ScTuSesionExpiro scTuSesionExpiro;

    @Steps
    ScTusTramites scTusTramites;
    public void se_ingresa_descuento_asistencias() {
        scHome.seleccionarOpcionPrincipal("Tramites");
        scTusTramites.seleccionaDescuentoAsistencias();
    }

    public void se_mantiene_la_inactividad_descuento_asistencia() {
        scTuSesionExpiro.inactividad_del_modulo();
    }
    public void se_valida_mensaje_de_inactividad(){
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
}
