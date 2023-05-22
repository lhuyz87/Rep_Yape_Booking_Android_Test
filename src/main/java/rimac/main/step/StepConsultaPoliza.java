package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScPoliza;
import rimac.main.screen.ScTuSesionExpiro;
import rimac.main.screen.ScTusSeguros;

public class StepConsultaPoliza {

    @Steps
    ScHome schome;

    @Steps
    ScTusSeguros scTusSeguros;
    @Steps
    ScPoliza scPoliza;

    @Steps
    ScTuSesionExpiro scTuSesionExpiro;

    public void selecciona_detalle_del_seguro_planes_medicos_eps(){
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_vetalle_Salud("Planes Médicos EPS");
    }

    public void se_visuliza_el_numero_de_poliza() throws Exception{
        scPoliza.se_visualiza_numero_Poliza();
    }

    public void se_mantiene_inactivo_en_consulta(){
        scTuSesionExpiro.inactividad_del_modulo();
    }

    public void se_valida_mensaje_de_inactividad_desde_Consulta_Poliza(){
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
}
