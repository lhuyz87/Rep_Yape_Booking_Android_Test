package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScSeguroPoliza;
import rimac.main.screen.ScTusSeguros;

public class StepDescargaPdf {

    @Steps
    ScHome schome;
    @Steps
    ScTusSeguros scTusSeguros;
    @Steps
    ScSeguroPoliza scSeguroVehicular;

    public void ver_Detalle_Seguros(String seguro){
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_Detalle(seguro);
    }

    public void ver_Detalle_Poliza(){
        scSeguroVehicular.opcPoliza();
        scSeguroVehicular.descargarPdf();
    }

    public void descargar_Manual(){

    }
    public void ir_EstadoCuenta(){
        scSeguroVehicular.opcPoliza();
        scSeguroVehicular.ir_EstadoCuenta();
    }

    public void ingresarfecha(String anio, String mes){
        mes = new StringBuilder(mes.substring(0,3)).append(".").toString();
        System.out.println(mes);
        scSeguroVehicular.buscarFecha(anio, mes);
    }
    public void descargarPdf(){
        scSeguroVehicular.descargarpdf();
    }
    public boolean validarPDF(){
        return scSeguroVehicular.seVisualizaPdf();
    }

}
