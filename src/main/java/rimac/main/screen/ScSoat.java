package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.NoSuchElementException;
import rimac.main.object.ObjDocumentoComprobantes;
import rimac.main.object.ObjDocumentos;
import rimac.main.object.ObjMediodePago;
import rimac.main.object.ObjSoat;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

public class ScSoat extends BaseDriver {
    private long wdwTimeOut = 300L;

    // util
    public static Logger looger = Logger.getLogger(ScAgregarNuevoDocumento.class.getName());

    public long getWdwTimeOut() {
        return wdwTimeOut;
    }

    UtilApp util = new UtilApp();
    protected ObjSoat objSoat = ObjSoat.getInstancia();

    public void iraPagos() {
        try {
            util.esperarElemento(10, objSoat.btnPagos);
            element(objSoat.btnPagos).click();
            Serenity.takeScreenshot();
        }
        catch(org.openqa.selenium.NoSuchElementException ex) {
            System.out.println("Error cuando seleccionamos opcion ir a pagos" + ex);
        }

    }

    public boolean obtener_mensaje_detallePago(){
        try {
            boolean solicitudExiste;
            util.esperarElemento(10, objSoat.msjDetPagos);
            solicitudExiste = element(objSoat.msjDetPagos).isCurrentlyVisible();
            return solicitudExiste;
        } catch (Exception e) {
            throw new IllegalAccessError("Error no se puede validar el seguimiento de asistencias vehiculares en el home");
        } finally {
            Serenity.takeScreenshot();
        }
    }
}
