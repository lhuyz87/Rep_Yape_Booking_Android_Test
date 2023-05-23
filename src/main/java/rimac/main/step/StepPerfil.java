package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScPerfil;
import rimac.main.screen.ScTuSesionExpiro;

public class StepPerfil {
    @Steps
    ScTuSesionExpiro scTuSesionExpiro;

    @Steps
    ScHome scHome;
    @Steps
    ScPerfil scPerfil;
    public void ingresaraaPerfil() throws Exception {
        scHome.seleccionarOpcionPrincipal("Perfil");
        scPerfil.miInformacion();
    }

    public void inactivadModuloTramites() {
        scTuSesionExpiro.inactividad_del_modulo();
    }

    public void validaMensaje() {
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
}
