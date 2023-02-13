package rimac.main.screen;

import rimac.main.object.ObjTusAsistencias;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScTusAsistencias extends BaseDriver {

    protected ObjTusAsistencias objTusAsistencias= ObjTusAsistencias.getInstancia();
    private long wdwTimeOut = 300L;
    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    protected UtilApp util = UtilApp.getInstancia();

    public void seleccionaProductoReembolsoSalud(){
        while(element(objTusAsistencias.btnReembolsoSalud).isCurrentlyVisible()==false){
            util.mobileSwipeScreenAndroid();
        }
        element(objTusAsistencias.btnReembolsoSalud).click();
    }

}
