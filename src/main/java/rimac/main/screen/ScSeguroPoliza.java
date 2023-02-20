package rimac.main.screen;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import rimac.main.object.ObjSeguroVehicular;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScSeguroPoliza extends BaseDriver {

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

    public void ir_EstadoCuenta(){
        int contador=0;
        while(element(objSeguroVehicular.btnEstadoCuenta).isCurrentlyVisible()==false && contador<4){
            util.mobileSwipeScreenAndroid();
        }
        element(objSeguroVehicular.btnEstadoCuenta).click();
    }

    public void descargarPdf(){
        util.esperarElemento(10, objSeguroVehicular.btnDescargarPoliza);
        element(objSeguroVehicular.btnDescargarPoliza).click();
    }

    public void buscarFecha(String anio, String mes){
        util.esperarElemento(10, objSeguroVehicular.btnModificarFecha);
        element(objSeguroVehicular.btnModificarFecha).click();
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point startAnio= new Point((int)(dimension.width*0.6), (int)(dimension.height*0.5));
        Point endAnio= new Point((int)(dimension.width*0.6), (int)(dimension.height*0.6));
        Point startMes= new Point((int)(dimension.width*0.4), (int)(dimension.height*0.6));
        Point endMes= new Point((int)(dimension.width*0.4), (int)(dimension.height*0.5));
        String anioObtenido = element(objSeguroVehicular.fechaAnio).getText();
        String mesObtenido = element(objSeguroVehicular.fechaMes).getText();
        int contador=0;
        while(!anioObtenido.equals(anio)&& contador<7){
            util.doSwipe(appiumDriver(), startAnio, endAnio, 500);
            anioObtenido = element(objSeguroVehicular.fechaAnio).getText();
        }
        while(!mesObtenido.equals(mes)&& contador<7){
            util.doSwipe(appiumDriver(), startMes, endMes, 500);
            mesObtenido = element(objSeguroVehicular.fechaMes).getText();
        }
        element(objSeguroVehicular.btnAceptarFecha).click();
    }

    public void descargarPoliza(){
        util.esperarElementoVisible(5, objSeguroVehicular.btnDescargar);
        element(objSeguroVehicular.btnDescargar).click();
    }

    public boolean seVisualizaPdf(){
        util.esperarSegundos(7);
        boolean existePDF = element(objSeguroVehicular.pdfPoliza).isCurrentlyVisible();
        return existePDF;
    }
}