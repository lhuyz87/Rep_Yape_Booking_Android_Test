package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.*;
import rimac.main.util.ConstantesDummy;

public class StepMediosdePago {

    @Steps
    ScHome scHome;
    @Steps
    ScPerfil scPerfil;
    @Steps
    ScTusSeguros scTusSeguros;
    @Steps
    ScMediosDePago scMediosDePago;
    @Steps
    ScPagos scPagos;
    @Steps
    ScConsultaTusPagos scConsultaTusPagos;
    @Steps
    ScTuSesionExpiro scTuSesionExpiro;

    public void selecciona_TabPagos() {
        scTusSeguros.irPagos();
    }
    public void irMedioPago_desde_perfil(){
        scHome.seleccionarOpcionPrincipal("Perfil");
        scPerfil.irMediosDePago();
    }

    public void volverDesdePerfil() throws Exception {
        scPerfil.volverPerfil();
    }
    public void irMedioPago_desde_tab_pagos(){
        scHome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_Detalle("Seguro Vehicular");
        scTusSeguros.irPagos();
        scPagos.irMediosPago();
    }

    public void agregarTarjeta(String numTarjeta, String cvv, String fecha){
        String nombre = ConstantesDummy.nombre;
        String apellido = ConstantesDummy.apellido;
        String correo = ConstantesDummy.correo;
        StringBuilder mmaa = new StringBuilder(fecha.substring(0,2));
        mmaa.append(fecha.substring(3,5));
        scMediosDePago.agregarTarjeta(numTarjeta, nombre,apellido,mmaa,cvv,correo);
    }

    public void eliminarTarjeta(String numTarjeta){
        scMediosDePago.eliminarTarjeta(numTarjeta);
    }

    public void afiliarTarjeta(String numTarjeta, String cvv, String fecha) throws Exception{
        scMediosDePago.volverTabPagos();
        scPagos.irAfiliarTarjeta();
        String nombre = ConstantesDummy.nombre;
        String apellido = ConstantesDummy.apellido;
        String correo = ConstantesDummy.correo;
        StringBuilder mmaa = new StringBuilder(fecha.substring(0,2));
        mmaa.append(fecha.substring(3,5));
        scMediosDePago.afiliarTarjeta(numTarjeta, nombre,apellido,mmaa,cvv,correo);
    }

    public boolean validarExisteTarjeta(String numTarjeta){
        return scMediosDePago.existeTarjeta(numTarjeta);
    }

    public boolean validarEliminarTarjeta(String numTarjeta){
        return scMediosDePago.validarEliminarTarjeta(numTarjeta);
    }

    public String validarMensajeAfiliacion(){
        return scMediosDePago.validarAfiliacion();
    }
    public void iraPagos(){
        scMediosDePago.irPagos();
    }

    public void selecciona_HistorialPago() {
        scPagos.irHistorialPagos();
    }
    public void descargar_historial(){
        scConsultaTusPagos.descargar_historial();
    }
    public boolean validar_historial(){
        return scConsultaTusPagos.validacion_pdf();
    }

    public void ver_detalle_SOAT(){
        scHome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_Detalle("SOAT");
    }

    public void se_mantiene_la_inactividad_asistencia_vehicular() {
        scTuSesionExpiro.inactividad_del_modulo();
    }
    public void se_valida_mensaje_de_inactividad(){
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
}
