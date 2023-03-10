package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScSeguroPoliza;
import rimac.main.screen.ScTusSeguros;

public class StepPlanVidaContigo {

    @Steps
    ScSeguroPoliza scSeguroVehicular;
    @Steps
    ScHome schome;
    @Steps
    ScTusSeguros scTusSeguros;
    public void ver_detalle_vida_contigo(){
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_Detalle("Vida Contigo");
    }

    public void descargar_manual(){
        scSeguroVehicular.descargarpdf();
    }

    public boolean validar_visualizacion_manual(){
        return scSeguroVehicular.seVisualizaPdf();
    }
}
