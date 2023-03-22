package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import rimac.main.object.ObjAnadirTarjeta;
import rimac.main.object.ObjMediodePago;
import rimac.main.object.ObjNuevaContra;
import rimac.main.object.ObjPerfil;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

public class ScPerfil extends BaseDriver {

    private long wdwTimeOut = 300L;

    protected ObjPerfil objPerfil = ObjPerfil.getInstancia();
    protected ObjMediodePago objMediodePago = ObjMediodePago.getInstancia();
    protected UtilApp util = UtilApp.getInstancia();

    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    public void irMediosDePago(){
        try {
            int contador = 0;
            boolean condicion1 = false;
            boolean condicion2 = false;
            boolean condicion3 = false;
            util.esperarElementoVisible(10, objPerfil.btnMediosPago);
            element(objPerfil.btnMediosPago).click();
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
            Serenity.takeScreenshot();
            util.esperarSegundos(3);
        }catch(Exception e){
            Serenity.takeScreenshot();
            throw new IllegalAccessError("Error para ingresar a Medios de Pago");
        }
    }
}
