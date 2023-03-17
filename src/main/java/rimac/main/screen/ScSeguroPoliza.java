package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import rimac.main.object.ObjSeguroVehicular;
import rimac.main.object.ObjTabPoliza;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScSeguroPoliza extends BaseDriver {

    private long wdwTimeOut = 300L;

    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    protected ObjSeguroVehicular objSeguroVehicular= ObjSeguroVehicular.getInstancia();
    protected ObjTabPoliza objTabPoliza= ObjTabPoliza.getInstancia();

    UtilApp util;

    public void opcPoliza(){
        util.esperarElemento(5,objSeguroVehicular.opcPoliza);
        element(objSeguroVehicular.opcPoliza).click();
    }

    public void ir_EstadoCuenta(){
        int contador=0;
        while(element(objTabPoliza.btnEstadoCuenta).isCurrentlyVisible()==false && contador<4){
            util.mobileSwipeScreenAndroid();
        }
        element(objTabPoliza.btnEstadoCuenta).click();
    }

    public void descargarPdf(){
        util.esperarElemento(10, objTabPoliza.btnDescargarPoliza);
        element(objTabPoliza.btnDescargarPoliza).click();
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
            util.esperarSegundos(1);
            contador++;
        }
        while(!mesObtenido.equals(mes)&& contador<7){
            util.doSwipe(appiumDriver(), startMes, endMes, 500);
            mesObtenido = element(objSeguroVehicular.fechaMes).getText();
            util.esperarSegundos(1);
            contador++;
        }
        element(objSeguroVehicular.btnAceptarFecha).click();
    }

    public void descargarpdf(){
        util.esperarElementoVisible(5, objSeguroVehicular.btnDescargar);
        int contador=0;
        while(element(objSeguroVehicular.btnDescargar).isCurrentlyVisible()==false && contador<9){
            util.mobileSwipeScreenAndroid();
        }
        element(objSeguroVehicular.btnDescargar).click();
    }

    public boolean seVisualizaPdf(){
        util.esperarSegundos(7);
        boolean existePDF = element(objTabPoliza.pdfDocumento).isCurrentlyVisible();
        Serenity.takeScreenshot();
        return existePDF;
    }
}
