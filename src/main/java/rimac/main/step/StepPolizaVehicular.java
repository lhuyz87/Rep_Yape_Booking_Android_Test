package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.*;

public class StepPolizaVehicular {

    @Steps
    ScHome schome;
    @Steps
    ScTusSeguros scTusSeguros;
    @Steps
    ScSeguroPoliza scSeguroVehicular;
    @Steps
    ScTuSesionExpiro scTuSesionExpiro;

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

    public void seleccionar_tab_coberturas(){
        scSeguroVehicular.seleccionaTabCobertura();
    }

    public void se_mantiene_inactivo_en_cobertura(){
        scTuSesionExpiro.inactividad_del_modulo();
    }

    public void se_valida_mensaje_de_inactividad_desde_cobertura(){
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
}
