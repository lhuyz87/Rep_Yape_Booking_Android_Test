package rimac.main.screen;

import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjPaginaPrincipal;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class ScAlertas extends BaseDriver {

    protected ObjAlertas objAlertas=ObjAlertas.getInstancia();
    protected ObjPaginaPrincipal objPaginaPrincipal =ObjPaginaPrincipal.getInstancia();
    protected UtilApp util = UtilApp.getInstancia();

    public void omitirAlertas(int intentos) {
        int i=0;
        while(i<intentos){
            try{
                element(objAlertas.btnCerrarEmail).click();
            }catch(Exception e){

            }
            try{
                element(objAlertas.btnTalvezMasTarde).click();
            }catch(Exception e){

            }
            try{
                element(objAlertas.btnHuellaPorAhoraNo).click();
            }catch(Exception e){

            }
            try{
                element(objAlertas.btnEnteratePorAhoraNo).click();
            }catch(Exception e){

            }
            try{
                element(objAlertas.btnEnteratePorAhoraNo).click();
            }catch(Exception e){

            }
            try{
                element(objAlertas.btnCerrarModalInspeccion).click();
            }catch(Exception e){

            }
            try{
                element(objAlertas.btnCerrarModalError).click();
            }catch(Exception e){

            }
            util.esperarSegundos(1);
            i++;
        }
    }
}
