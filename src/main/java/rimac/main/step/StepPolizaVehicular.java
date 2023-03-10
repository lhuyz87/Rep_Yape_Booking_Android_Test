package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScSeguroPoliza;
import rimac.main.screen.ScTusSeguros;

public class StepPolizaVehicular {

    @Steps
    ScHome schome;
    @Steps
    ScTusSeguros scTusSeguros;
    @Steps
    ScSeguroPoliza scSeguroVehicular;

    public void ver_Detalle_Seguros(){
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_Detalle("Seguro Vehicular");
    }

    public void ver_Detalle_Poliza(){
        scSeguroVehicular.opcPoliza();
        scSeguroVehicular.descargarPdf();
    }

    public boolean validarPDF(){
        return scSeguroVehicular.seVisualizaPdf();
    }

}
