package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScPagos;
import rimac.main.screen.ScTusSeguros;

public class StepHistorialPagos {

    @Steps
    ScTusSeguros scTusSeguros;

    @Steps
    ScPagos scPagos;

    @Steps
    ScHome schome;

    public void iraPagarCuotas() throws Exception {
        scTusSeguros.irPagos();
        scPagos.iraPagarCuotas();
    }

    public boolean validarCronograma() throws Exception {
       return scPagos.validarCronograma();
    }
    public boolean validarHistorial() throws Exception {
        return scPagos.validarHistorial();
    }

    public void selecciona_detalle_del_seguro_planes_medicos_eps(){
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_vetalle_Salud("Planes Médicos EPS");
    }
}
