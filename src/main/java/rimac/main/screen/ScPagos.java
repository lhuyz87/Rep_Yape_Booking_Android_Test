package rimac.main.screen;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rimac.main.object.ObjAfiliarPago;
import rimac.main.object.ObjMediodePago;
import rimac.main.object.ObjPagos;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.time.Duration;

public class ScPagos extends BaseDriver {

    private long wdwTimeOut = 300L;

    public long getWdwTimeOut() {
        return wdwTimeOut;
    }
    UtilApp util = UtilApp.getInstancia();
    protected ObjPagos objPagos = ObjPagos.getInstancia();
    protected ObjMediodePago objMediodePago = ObjMediodePago.getInstancia();
    protected ObjAfiliarPago objAfiliarPago= ObjAfiliarPago.getInstancia();


    public void irMediosPago(){
        util.esperarElemento(4,objPagos.lblMetodoPago);
        int contador=0;
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.9));
        Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.1));

        while(element(objPagos.btnMediosPago).isCurrentlyVisible()==false && contador<7){
            util.doSwipe(appiumDriver(), start, end, 1000);
            contador++;
        }
        element(objPagos.btnMediosPago).click();
        boolean condicion1 = false;
        boolean condicion2 = false;
        boolean condicion3 = false;
        do {
            condicion1 = element(objMediodePago.lblMisTarjetas).isCurrentlyVisible();
            condicion2 = element(objMediodePago.btnAgregarTarjeta).isCurrentlyVisible();
            condicion3 = element(objMediodePago.lblNoPodemosEncontrar).isCurrentlyVisible();
            if (condicion3) {
                throw new IllegalAccessError("Error del aplicativo no se pueden mostrar las tarjetas");
            }
            if (!condicion1 && !condicion2) {
                util.esperarSegundos(1);
                contador++;
            }
        } while (!condicion1 && !condicion2 && contador < 15);
        util.esperarSegundos(3);
    }

    public void irAfiliarTarjeta(){
        util.esperarElemento(4,objPagos.lblMetodoPago);
        int contador=0;
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.9));
        Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.5));
        while(element(objPagos.lnkAfiliarTarjeta).isCurrentlyVisible()==false && contador<7){
            util.doSwipe(appiumDriver(), start, end, 1000);
            contador++;
        }
        element(objPagos.lnkAfiliarTarjeta).click();
        new WebDriverWait(androidDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(objAfiliarPago.lblAfiliarPago));
    }
}
