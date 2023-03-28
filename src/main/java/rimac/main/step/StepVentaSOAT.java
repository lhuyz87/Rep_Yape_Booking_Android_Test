package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.*;
import rimac.main.util.ConstantesDummy;

public class StepVentaSOAT {

    @Steps
    ScHome schome;
    @Steps
    ScTiendaRimac scTiendaRimac;
    @Steps
    ScEligePlan scEligePlan;
    @Steps
    ScPagoConTarjeta scPagaConTarjeta;
    @Steps
    ScPerfil scPerfil;

    public void irTiendaDesdePerfil() {
        scPerfil.volverPerfil();
        schome.seleccionarOpcionPrincipal("Tienda");
    }

    public void empezarSoatDosMinutos(String placa){
        scTiendaRimac.opc_SoatDosMinutos();
        char[] digitosPLaca = placa.toCharArray();
        String placa1 = new String(String.valueOf(digitosPLaca[0]));
        String placa2 = new String(String.valueOf(digitosPLaca[1]));
        String placa3 = new String(String.valueOf(digitosPLaca[2]));
        String placa4 = new String(String.valueOf(digitosPLaca[3]));
        String placa5 = new String(String.valueOf(digitosPLaca[4]));
        String placa6 = new String(String.valueOf(digitosPLaca[5]));
        scEligePlan.ingresarPlaca(placa1,placa2,placa3,placa4,placa5,placa6);
    }

    public void eligePlan(){
        scEligePlan.planDigital();
        scEligePlan.validaPlan();
    }

    public void agregarTarjeta(String numtarjeta, String cvv, String fecha){
        String dni = ConstantesDummy.dniTarjeta;
        String nombre=ConstantesDummy.nombre;
        String apellido=ConstantesDummy.apellido;
        String correo=ConstantesDummy.correo;
        String celular=ConstantesDummy.celular;
        StringBuilder fechaObtenida = new StringBuilder(fecha.substring(0,2));
        fechaObtenida.append(fecha.substring(3,5));
        scPagaConTarjeta.agregarTarjeta(dni,correo,celular,numtarjeta, cvv,fechaObtenida,nombre,apellido);
    }

    public String validaMensaje(){
        String mensaje = scPagaConTarjeta.validaMensaje();
        return mensaje;
    }

    public void finalizarOperacion(){
        scPagaConTarjeta.finalizarOperacion();
    }
}
