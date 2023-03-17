package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScSeguroPoliza;
import rimac.main.screen.ScTusSeguros;

public class StepPlanVidaFlexible {

    @Steps
    ScSeguroPoliza scSeguroVehicular;
    @Steps
    ScHome schome;
    @Steps
    ScTusSeguros scTusSeguros;


    public void ver_detalle_vida_flexible(){
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.seleccionarVida();
        scTusSeguros.ver_Detalle("Plan Vida Flexible");
    }
    public void ingresarfecha(String anio, String mes) throws InterruptedException {
        mes = new StringBuilder(mes.substring(0,3)).append(".").toString();
        scSeguroVehicular.buscarFecha(anio, mes);
    }

    public void ir_EstadoCuenta(){
        scSeguroVehicular.opcPoliza();
        scSeguroVehicular.ir_EstadoCuenta();
    }
    public void descargar_estado_cuenta(){
        scSeguroVehicular.descargarpdf();
    }

    public boolean validar_estado_cuenta(){
        return scSeguroVehicular.seVisualizaPdf();
    }
}
