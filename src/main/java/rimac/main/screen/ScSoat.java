package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.NoSuchElementException;
import rimac.main.object.*;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

public class ScSoat extends BaseDriver {
    private long wdwTimeOut = 300L;

    // util
    public static Logger looger = Logger.getLogger(ScAgregarNuevoDocumento.class.getName());
    protected ObjTusSeguros objTusSeguros = ObjTusSeguros.getInstancia();
    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    UtilApp util = new UtilApp();
    protected ObjSoat objSoat = ObjSoat.getInstancia();

    public void iraPagos() {
        try {
            util.esperarElemento(10,objTusSeguros.btnPagos);
            element(objTusSeguros.btnPagos).click();
            util.esperarSegundos(30);
        }
        catch(org.openqa.selenium.NoSuchElementException ex) {
            System.out.println("Error cuando seleccionamos ir a pagos" + ex);
        }

    }

    public boolean obtener_mensaje_detallePago(){
        try {
            util.esperarElementoVisible(10, objSoat.msjDetPagos2);
            boolean solicitudExiste = element(objSoat.msjDetPagos2).isCurrentlyVisible();
            Serenity.takeScreenshot();
            return solicitudExiste;

        } catch (Exception e) {
            throw new IllegalAccessError("Error en obtener mensaje detalle pago");
        } finally {
            Serenity.takeScreenshot();
        }
    }
}
