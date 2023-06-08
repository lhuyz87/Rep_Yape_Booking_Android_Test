package rimac.main.screen;

import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

public class ScAlertas extends BaseDriver {

    protected ObjAlertas objAlertas=ObjAlertas.getInstancia();
    protected ObjPaginaPrincipal objPaginaPrincipal =ObjPaginaPrincipal.getInstancia();
    protected UtilApp util = UtilApp.getInstancia();

    public void omitirAlertas(int intentos) {
        int contador=0;
        int i=0;
        while(i<intentos){
            if(element(objAlertas.btnCerrarEmail).isDisplayed()){
                element(objAlertas.btnCerrarEmail).click();
            }
            if(element(objAlertas.btnTalvezMasTarde).isDisplayed()){
                element(objAlertas.btnTalvezMasTarde).click();
            }
            if (element(objAlertas.btnHuellaPorAhoraNo).isDisplayed()) {
                    element(objAlertas.btnHuellaPorAhoraNo).click();
                }
            if (element(objAlertas.btnEnteratePorAhoraNo).isDisplayed()) {
                    element(objAlertas.btnEnteratePorAhoraNo).click();
                }
            if (element(objAlertas.btnCerrarModalInspeccion).isDisplayed()) {
                    element(objAlertas.btnCerrarModalInspeccion).click();
                }
            if (element(objAlertas.btnCerrarModalError).isDisplayed()) {
                    element(objAlertas.btnCerrarModalError).click();
                }
            if (element(objPaginaPrincipal.btnEmergencia).isDisplayed()) {
                    contador++;
                }
            i++;
            if(contador==3){
                break;
            }
            util.esperarSegundos(1);
        }
    }
}
