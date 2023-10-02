package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.object.ObjPoliza;
import rimac.main.screen.*;
import rimac.main.util.Variables;

public class StepPolizaVehicular {

    @Steps
    ScHome schome;
    @Steps
    ScTusSeguros scTusSeguros;
    @Steps
    ScSeguroPoliza scSeguroVehicular;
    @Steps
    ScTuSesionExpiro scTuSesionExpiro;
    @Steps
    ScPagos scPagos;
    @Steps
    ScCuotasPagar scCuotasPagar;



    public void ver_detalle_SegurosVehicular(){
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_detalle_Vehicular("Seguro Vehicular");
    }

    public void verDetalleSeguroVehicular(String placa, String vigencia){
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_detalle_Vehicular_placa(placa, vigencia);
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

    public void ver_detalle_SegurosSOAT(String placa) {
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.seleccionaSOAT();
        scTusSeguros.ver_detalle_Soat_placa(placa);
        scTusSeguros.irPoliza();
        scTusSeguros.ver_resumen_Poliza();

    }
    public void se_valida_numero_polizaSoat() throws Exception {
        scTusSeguros.se_visualiza_numero_PolizaSoat();

    }

    public void ver_detalle_SegurosVehicularPlaca(String placa,String vigencia) {
        schome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_detalle_Vehicular_placa(placa,vigencia);
    }

    public void se_valida_historial_pago() throws Exception {
        scTusSeguros.se_visualiza_historial_pagos();
    }

    public void obtener_cuota_pagada() throws Exception {
        scTusSeguros.irPagos();
        scPagos.iraPagarCuotas();
        scCuotasPagar.consultaUltimoPago();
        scPagos.irHistorialPagos();
    }

    public void busca_cuota_historial_pago() {
        scTusSeguros.busca_cuota_en_historial(Variables.cuotaPagada);
    }
}
