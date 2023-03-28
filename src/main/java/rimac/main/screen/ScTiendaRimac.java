package rimac.main.screen;

import rimac.main.object.ObjTienda;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScTiendaRimac  extends BaseDriver {

    UtilApp util=UtilApp.getInstancia();
    ObjTienda objTienda = ObjTienda.getInstancia();
    public void opc_SoatDosMinutos(){
        util.mobileSwipeScreenAndroidFinal();
        element(objTienda.btnSoatDosminutos).click();
        util.esperarElementoVisible(5,objTienda.btnConoceMas);
        element(objTienda.btnConoceMas).click();
    }
}
