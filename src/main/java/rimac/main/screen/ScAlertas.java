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
    private long wdwTimeOut = 300L;
    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    public void omitirAlertas(int intentos) throws Exception {
        try{
            for( int i=0; i<intentos; i++){
                if(element(objAlertas.btnHuellaPorAhoraNo).isCurrentlyVisible()){
                    element(objAlertas.btnHuellaPorAhoraNo).click();
                }
                if(element(objAlertas.btnCerrarModal).isCurrentlyVisible()){
                    element(objAlertas.btnCerrarModal).click();
                }
                if(element(objAlertas.btnEnteratePorAhoraNo).isCurrentlyVisible()){
                    element(objAlertas.btnEnteratePorAhoraNo).click();
                }
                if(element(objAlertas.btnCerrarModal).isCurrentlyVisible()){
                    element(objAlertas.btnCerrarModal).click();
                }
                i++;
                util.esperarSegundos(1);
            }
            util.esperarElemento(3,objPaginaPrincipal.btnEmergencia);

        }catch(Exception e){
            throw new Exception("Supero el tiempo de espera del aplicativo");
        }
    }
}
