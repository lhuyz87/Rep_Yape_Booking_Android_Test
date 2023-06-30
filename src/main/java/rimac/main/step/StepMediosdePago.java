package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.*;
import rimac.main.util.ConstantesDummy;
import rimac.main.util.Variables;

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
        scMediosDePago.seleccionarOpcionPerfil();
        scPerfil.irMediosDePago();
    }

    public void volverDesdePerfil() throws Exception {
        scPerfil.volverPerfil();
    }
    public void irMedioPago_desde_tab_pagos(){
        scTusSeguros.irPagos();
        scPagos.irMediosPago();
    }

    public void detalle_seguro_vehicular(){
        scHome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.ver_detalle_Vehicular("Seguro Vehicular");
    }

    public void agregarTarjeta(String numTarjeta, String cvv, String fecha) throws Exception {

        String nombre = ConstantesDummy.nombre;
        String apellido = ConstantesDummy.apellido;
        String correo = ConstantesDummy.correo;
        StringBuilder mmaa = new StringBuilder(fecha.substring(0,2));
        mmaa.append(fecha.substring(3,5));
        scMediosDePago.agregarTarjetaNueva();
        scMediosDePago.ingresarDatosTarjeta(numTarjeta, nombre,apellido,mmaa,cvv,correo);
        scMediosDePago.pagar();
        scMediosDePago.esperarListadoTarjetas();
    }

    public void eliminarTarjeta(String numTarjeta){

        scMediosDePago.eliminarTarjeta(numTarjeta);
    }

    public void afiliarTarjeta(String numTarjeta, String cvv, String fecha) throws Exception{
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
        scTusSeguros.ver_vetalle_Soat("SOAT");
    }

    public void se_mantiene_la_inactividad_asistencia_vehicular() {
        scTuSesionExpiro.inactividad_del_modulo();
    }
    public void se_valida_mensaje_de_inactividad(){
        scTuSesionExpiro.validacion_mensaje_TimeOut();
    }
    public void irCuotasaPagar_desde_tab_pagos(String placa) throws Exception {
        scHome.seleccionarOpcionPrincipal("Seguros");
        scTusSeguros.esperar_Tus_Seguros();
        scTusSeguros.seleccionar_Placa(placa);
        scTusSeguros.irPagos();
        scPagos.iraPagarCuotas();
        scPagos.seleccionarCuota();
    }
    public void se_añade_nueva_tarjeta() {
        scTusSeguros.añadir_nueva_tarjeta();
    }

    public boolean obtiene_mensaje_confirmacion() {
        return scPagos.obtener_mensaje_confirmacion();
    }

    public String obtiene_mensaje_pago() {
        return scPagos.obtener_mensaje_pago();
    }

    public void irMedioPago_desde_regresoPerfil() {
        scMediosDePago.regresarSelecOpcionPerfil();
        scPerfil.irMediosDePago();
    }

    public void anadirTarjeta(String numTarjeta, String cvv, String fecha) throws Exception {
        String nombre = ConstantesDummy.nombre;
        String apellido = ConstantesDummy.apellido;
        String correo = ConstantesDummy.correo;
        StringBuilder mmaa = new StringBuilder(fecha.substring(0,2));
        mmaa.append(fecha.substring(3,5));
        scMediosDePago.ingresarDatosTarjeta(numTarjeta, nombre,apellido,mmaa,cvv,correo);
        scMediosDePago.guardarTarjeta();
        scMediosDePago.pagar();
    }
    public void seleccionaPagos() throws Exception {
        scTusSeguros.irPagos();
        scPagos.iraPagarCuotas();
        scPagos.seleccionarCuota();
        scMediosDePago.agregarTarjetaNueva();
    }
    public void pagarcuotas(String numTarjeta, String cvv, String fecha) throws Exception {
        String nombre = ConstantesDummy.nombre;
        String apellido = ConstantesDummy.apellido;
        String correo = ConstantesDummy.correo;
        StringBuilder mmaa = new StringBuilder(fecha.substring(0,2));
        mmaa.append(fecha.substring(3,5));
        scMediosDePago.ingresarDatosTarjeta(numTarjeta, nombre,apellido,mmaa,cvv,correo);
        scMediosDePago.guardarTarjetaCuotas();
    }

    public void pagarcuotasTarAfil(String numTarjeta, String cvv, String fecha) throws Exception {
        String nombre = ConstantesDummy.nombre;
        String apellido = ConstantesDummy.apellido;
        String correo = ConstantesDummy.correo;
        StringBuilder mmaa = new StringBuilder(fecha.substring(0,2));
        mmaa.append(fecha.substring(3,5));
        scMediosDePago.ingresarDatosTarjeta(numTarjeta, nombre,apellido,mmaa,cvv,correo);
        scMediosDePago.pagarTarjetaAfil();
    }
}
