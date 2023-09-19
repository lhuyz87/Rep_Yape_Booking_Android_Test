package rimac.main.screen;

import rimac.main.object.ObjPerfiladorSalud;
import rimac.main.object.ObjPerfiladorVehi;
import rimac.main.object.ObjTienda;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScTiendaRimac  extends BaseDriver {

    UtilApp util=UtilApp.getInstancia();
    ObjTienda objTienda = ObjTienda.getInstancia();
    ObjPerfiladorVehi objPerfiladorVehi= ObjPerfiladorVehi.getInstancia();

    public void opc_SoatDosMinutos(){
        util.mobileSwipeScreenAndroidFinal();
        element(objTienda.btnSoatDosminutos).click();
    }

    public void opc_SegurosDeSalud() throws Exception{
        util.mobileSwipeScreenAndroidFinal();
        element(objTienda.btnSegSalud).click();
    }
    public void opc_Salud() throws Exception {
        util.esperarElementoVisible(5,objTienda.btnSalud);
        element(objTienda.btnSalud).click();
        util.esperarElementoVisible(5,objTienda.opcSeguroTest);
        element(objTienda.opcSeguroTest).click();
    }

    public void opc_SegurosVehicular() throws Exception {
        util.esperarElementoVisible(5,objTienda.btnSeguroVehi);
        element(objTienda.btnSeguroVehi).click();
        util.esperarElementoVisible(5,objTienda.opcSeguroTest);
        element(objTienda.opcSeguroTest).click();
    }

    public void opc_Vehi() throws Exception {

        util.esperarElementoVisible(5,objPerfiladorVehi.btnContinuar);
        element(objPerfiladorVehi.btnContinuar).click();
    }

}
