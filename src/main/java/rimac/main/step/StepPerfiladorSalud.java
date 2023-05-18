package rimac.main.step;

import net.thucydides.core.annotations.Steps;
import rimac.main.screen.ScHome;
import rimac.main.screen.ScPerfiladorSalud;
import rimac.main.screen.ScTiendaRimac;

public class StepPerfiladorSalud {
    @Steps
    ScHome schome;

    @Steps
    ScTiendaRimac scTiendaRimac;
    @Steps
    ScPerfiladorSalud scPerfiladorSalud;

    public void irTiendaDesdePerfil() throws Exception {
        schome.seleccionarOpcionPrincipal("Tienda");
        scTiendaRimac.opc_SegurosDeSalud();
    }


    public void iraTestSalud() throws Exception {
        scTiendaRimac.opc_Salud();
        scPerfiladorSalud.opc_Test();
    }

    public void iraaOpcionesTest() throws Exception {
        scPerfiladorSalud.opc_Preguntas();
    }

    public void opcionRecomendada() throws Exception {
        scPerfiladorSalud.opc_Recomendada();

    }

}
