package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScTuSesionExpiro;

public class StepTramiteySiniestros {
    @Steps
    ScHome scHome;
    @Steps
    ScTuSesionExpiro scTuSesionExpiro;

    public void iraTramites() {
        scHome.seleccionarOpcionPrincipal("Tramites");
    }

    public void inactivadModuloTramites() {
        scTuSesionExpiro.inactividad_del_modulo();
    }

    public void validaMensaje() {
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
}
