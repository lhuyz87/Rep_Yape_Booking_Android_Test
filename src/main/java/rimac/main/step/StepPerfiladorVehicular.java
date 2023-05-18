package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScEligePlan;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScTiendaRimac;
import rimac.main.screen.ScPerfiladorVehicular;

public class StepPerfiladorVehicular {
    @Steps
    ScHome schome;

    @Steps
    ScTiendaRimac scTiendaRimac;
    @Steps
    ScPerfiladorVehicular scPerfiladorVehicular;
    @Steps
    ScEligePlan scEligePlan;

    public void irTiendaDesdePerfil() throws Exception {
        schome.seleccionarOpcionPrincipal("Tienda");
        scTiendaRimac.opc_SegurosVehicular();
    }

    public void iraTestVehicular() throws Exception {
        scTiendaRimac.opc_Vehi();
    }

    public void ingresarPlacaVeh(String placa) throws Exception{
        char[] digitosPLaca = placa.toCharArray();
        String placa1 = new String(String.valueOf(digitosPLaca[0]));
        String placa2 = new String(String.valueOf(digitosPLaca[1]));
        String placa3 = new String(String.valueOf(digitosPLaca[2]));
        String placa4 = new String(String.valueOf(digitosPLaca[3]));
        String placa5 = new String(String.valueOf(digitosPLaca[4]));
        String placa6 = new String(String.valueOf(digitosPLaca[5]));
        scPerfiladorVehicular.ingresarPlacaVeh(placa1,placa2,placa3,placa4,placa5,placa6);
    }
    public void datosVeh() throws Exception {
        scPerfiladorVehicular.datosVeh();
    }

    public void irPlanVehi() throws Exception {
        scPerfiladorVehicular.verPlanVehi();
    }
}
