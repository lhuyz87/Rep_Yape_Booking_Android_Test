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
            if(element(objAlertas.btnHuellaPorAhoraNo).isCurrentlyVisible()){
                element(objAlertas.btnHuellaPorAhoraNo).click();
            }
            if(element(objAlertas.btnCerrarModal).isCurrentlyVisible()){
                element(objAlertas.btnCerrarModal).click();
            }
            if(element(objAlertas.btnCerrarEmail).isCurrentlyVisible()){
                element(objAlertas.btnCerrarEmail).click();
            }
            if(element(objAlertas.btnEnteratePorAhoraNo).isCurrentlyVisible()){
                element(objAlertas.btnEnteratePorAhoraNo).click();
            }
            if(element(objPaginaPrincipal.btnEmergencia).isCurrentlyVisible()){
                contador++;
            }
            i++;
            util.esperarSegundos(1);
            if(contador==5){
                break;
            }
        }
    }
}
