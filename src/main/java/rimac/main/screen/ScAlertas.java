package rimac.main.screen;

import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

import static net.serenitybdd.core.pages.WebElementExpectations.elementIsPresent;

public class ScAlertas extends BaseDriver {

    protected ObjAlertas objAlertas = ObjAlertas.getInstancia();
    protected ObjPaginaPrincipal objPaginaPrincipal = ObjPaginaPrincipal.getInstancia();
    protected UtilApp util = UtilApp.getInstancia();

    public void omitirAlertas(int intentos) {
        int i = 0;
        int contador = 0;
        while (i < intentos) {
            util.esperarSegundos(1);
            i++;
            try {
                if (element(objAlertas.btnCerrarEmail).isCurrentlyVisible()) {
                    element(objAlertas.btnCerrarEmail).click();
                }

                if (element(objAlertas.btnTalvezMasTarde).isCurrentlyVisible()) {
                    element(objAlertas.btnTalvezMasTarde).click();
                }

                if (element(objAlertas.btnHuellaPorAhoraNo).isCurrentlyVisible()) {
                    element(objAlertas.btnHuellaPorAhoraNo).click();
                }

                if (element(objAlertas.btnEnteratePorAhoraNo).isCurrentlyVisible()) {
                    element(objAlertas.btnEnteratePorAhoraNo).click();
                }

                if (element(objAlertas.btnCerrarModalInspeccion).isCurrentlyVisible()) {
                    element(objAlertas.btnCerrarModalInspeccion).click();
                }

                if (element(objAlertas.btnCerrarModalError).isCurrentlyVisible()) {
                    element(objAlertas.btnCerrarModalError).click();
                }
            } catch (Exception e) {
                System.out.println("Error al omitir la alerta");
            }
        }
    }

}
