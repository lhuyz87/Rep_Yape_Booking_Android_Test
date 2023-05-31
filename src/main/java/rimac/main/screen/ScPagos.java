package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rimac.main.object.ObjAfiliarPago;
import rimac.main.object.ObjCommons;
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
    protected ObjCommons objCommons = ObjCommons.getInstancia();


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

    public void irHistorialPagos(){
        util.esperarElemento(4,objPagos.lblMetodoPago);
        int contador=0;
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.9));
        Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.1));
        while(element(objPagos.btnHistorialPagos).isCurrentlyVisible()==false && contador<4){
            util.doSwipe(appiumDriver(), start, end, 1000);
            contador++;
        }
        element(objPagos.btnHistorialPagos).click();
    }

    public void iraPagarCuotas(){
        util.esperarSegundos(10);
        util.esperarElemento(4,objPagos.lblCuotasAPagar);
        System.out.println("entra aca1");
        int contador=0;
        Dimension dimension = appiumDriver().manage().window().getSize();
        Point start= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.9));
        Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.1));
        while(element(objPagos.btnPagarCuotas).isCurrentlyVisible()==false && contador<4){
            util.doSwipe(appiumDriver(), start, end, 1000);
            contador++;
        }
        element(objPagos.btnPagarCuotas).click();
        if(element(objPagos.titPagoAfiliado).isCurrentlyVisible() == true){
            element(objPagos.btnEntendido).click();
            System.out.println("entra aca2");
        }


    }


    public void seleccionarCuota() {
        element(objPagos.chkCuota1).click();
        element(objPagos.btnIniciarPago).click();
    }


    public boolean obtener_mensaje_confirmacion() {
        try {
            util.esperarSegundos(7);
            util.esperarElemento(4,objPagos.titHemosRecibidosuPago);
            boolean solicitudExiste = element(objPagos.titHemosRecibidosuPago).isCurrentlyVisible();
            Serenity.takeScreenshot();
            util.esperarSegundos(3);
            element(objPagos.btnIrAInicio).click();
            return solicitudExiste;

        } catch (Exception e) {
            throw new IllegalAccessError("Error no se puede validar el seguimiento de asistencias vehiculares en el home");
        } finally {
            Serenity.takeScreenshot();
        }

    }

    public String obtener_mensaje_pago() {
        try{
            String mensaje = "";
            int contador=0;
            while(contador<15) {
                if(element(objPagos.btnCuotaPagada).isCurrentlyVisible()){
                    mensaje = element(objPagos.btnCuotaPagada).getText();
                    break;
                }
                util.esperarSegundos(1);
                contador++;
            }
            util.esperarSegundos(2);
            if(element(objPagos.btnEntendido).isCurrentlyVisible()){
                element(objPagos.btnEntendido).click();
                Serenity.takeScreenshot();
            }
            util.esperarSegundos(3);
            element(objPagos.tapRegresarSegVehicu).click();
            return mensaje;
        }
        catch(Exception e){
            throw new IllegalAccessError("Error mensaje no es capturado");
        }
        finally {
            Serenity.takeScreenshot();
        }
    }


}
