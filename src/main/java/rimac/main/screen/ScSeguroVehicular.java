package rimac.main.screen;

import rimac.main.object.ObjSeguroVehicular;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScSeguroVehicular extends BaseDriver {

    private long wdwTimeOut = 300L;

    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    protected ObjSeguroVehicular objSeguroVehicular= ObjSeguroVehicular.getInstancia();

    UtilApp util;

    public void opcPoliza(){
        util.esperarElemento(5,objSeguroVehicular.opcPoliza);
        element(objSeguroVehicular.opcPoliza).click();
    }

    public void descargarPdf(){
        util.esperarElemento(10, objSeguroVehicular.btnDescargarPoliza);
        element(objSeguroVehicular.btnDescargarPoliza).click();
    }

    public boolean seVisualizaPdf(){
        util.esperarSegundos(7);
        boolean existePDF = element(objSeguroVehicular.pdfPoliza).isCurrentlyVisible();
        return existePDF;
    }
}
