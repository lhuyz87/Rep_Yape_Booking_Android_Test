package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rimac.main.object.ObjCommons;
import rimac.main.object.ObjConsultaTusPagos;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.util.NoSuchElementException;

public class ScConsultaTusPagos extends BaseDriver {

    UtilApp util = UtilApp.getInstancia();
    ObjConsultaTusPagos objConsultaTusPagos=ObjConsultaTusPagos.getInstancia();
    ObjCommons objCommons= ObjCommons.getInstancia();

    public void descargar_historial() {
        util.esperarElemento(10, objConsultaTusPagos.btnDescargaHistorial);
        element(objConsultaTusPagos.btnDescargaHistorial).click();
        util.esperarElemento(10, objConsultaTusPagos.btnDescargaHistorial);
        Serenity.takeScreenshot();
    }

    public boolean validacion_descarga() {
        boolean existePdf = false;
        int contador = 0;
        while(contador<15){
            if(element(objConsultaTusPagos.btnAbrir).isCurrentlyVisible()){
                existePdf = true;
                break;
            }
            try{
                element(objConsultaTusPagos.btnDescargaHistorial).click();
                element(objConsultaTusPagos.btnAbrir).click();
            }catch(Exception e){

            }
        }
        Serenity.takeScreenshot();
        return existePdf;
    }

    public String obtenerUltimoMonto(String cuota){
        String montoHistorial="";
        try {
            Dimension dimension = appiumDriver().manage().window().getSize();
            Point start = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.9));
            Point end = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.5));
            int contador = 0;
            util.esperarElemento(10, objConsultaTusPagos.btnDescargaHistorial);
            while (contador < 4) {
                util.doSwipe(appiumDriver(), start, end, 1000);
                contador++;
            }
            waitForCondition().until(
                    ExpectedConditions.visibilityOf(objConsultaTusPagos.lblNumeroCuotaHistorial(cuota))
            );
            Serenity.takeScreenshot();
            montoHistorial= element(objConsultaTusPagos.lblMontoHistorial).getText();

        }catch(NoSuchElementException ex){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("No se visualiza la cuota pagada");
        }
        return montoHistorial;
    }

}