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

    public static Logger looger = Logger.getLogger(ScTusTramites.class.getName());

    public void omitirAlertas(int intentos) throws Exception {
            int contador=0;
            int i=0;
            while(i<intentos){
                if(element(objAlertas.btnHuellaPorAhoraNo).isEnabled()){
                    element(objAlertas.btnHuellaPorAhoraNo).click();
                }
                if(element(objAlertas.btnCerrarModal).isEnabled()){
                    element(objAlertas.btnCerrarModal).click();
                }
                if(element(objAlertas.btnEnteratePorAhoraNo).isEnabled()){
                    element(objAlertas.btnEnteratePorAhoraNo).click();
                }
                if(element(objAlertas.btnCerrarModal).isEnabled()){
                    element(objAlertas.btnCerrarModal).click();
                }
                if(element(objAlertas.btnCerrarEmail).isEnabled()){
                    element(objAlertas.btnCerrarEmail).click();
                }
                if(element(objAlertas.btnEnteratePorAhoraNo2).isEnabled()){
                    element(objAlertas.btnEnteratePorAhoraNo2).click();
                }
                if(element(objPaginaPrincipal.btnEmergencia).isEnabled()){
                    contador++;
                }
                i++;
                util.esperarSegundos(1);
                if(contador==3){
                    break;
                }
            }
    }
}
