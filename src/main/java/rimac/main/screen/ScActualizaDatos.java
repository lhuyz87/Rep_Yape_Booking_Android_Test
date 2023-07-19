package rimac.main.screen;

import rimac.main.object.ObjActualizaDatos;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScActualizaDatos extends BaseDriver {

    ObjActualizaDatos objActualizaDatos= ObjActualizaDatos.getInstancia();
    UtilApp util = new UtilApp();
    public void actualizar_datos(String correo, String celular){
        util.esperarSegundos(2);
        if(element(objActualizaDatos.lblActualizaDatos).isCurrentlyVisible()){
            element(objActualizaDatos.txtCelular).clear();
            element(objActualizaDatos.txtCelular).sendKeys(celular);
            element(objActualizaDatos.txtCorreo).clear();
            element(objActualizaDatos.txtCorreo).sendKeys(correo);
            element(objActualizaDatos.btnContinuar).click();
        }
    }
}
