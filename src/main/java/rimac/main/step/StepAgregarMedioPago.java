package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.*;
import rimac.main.util.ConstantesDummy;

public class StepAgregarMedioPago {

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

    public void irMedioPago_desde_perfil(){
        scHome.seleccionarOpcionPrincipal("Perfil");
        scPerfil.irMediosDePago();
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

    public void afiliarTarjeta(String numTarjeta, String cvv, String fecha){
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
}
