package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import rimac.main.object.ObjCommons;
import rimac.main.object.ObjConsultaTusPagos;
import rimac.main.util.BaseDriver;
import rimac.main.util.UtilApp;

public class ScConsultaTusPagos extends BaseDriver {

    UtilApp util = UtilApp.getInstancia();
    ObjConsultaTusPagos objConsultaTusPagos=ObjConsultaTusPagos.getInstancia();
    ObjCommons objCommons= ObjCommons.getInstancia();

    public void descargar_historial() {
        util.esperarElemento(10, objConsultaTusPagos.btnDescargaHistorial);
        element(objConsultaTusPagos.btnDescargaHistorial).click();
        Serenity.takeScreenshot();
    }

    public boolean validacion_pdf() {
        int intentos = 0;

        boolean existePdf = false;
        while (element(objConsultaTusPagos.btnDownload).isCurrentlyVisible() && intentos < 5) {
            intentos++;

            existePdf = element(objConsultaTusPagos.btnAbrir).isCurrentlyVisible();
            try {
                element(objConsultaTusPagos.btnDescargaHistorial).click();
                util.esperarElementoVisible(5, objConsultaTusPagos.btnAbrir);
                element(objConsultaTusPagos.btnAbrir).click();
            } catch (Exception e) {
            }
        }
        Serenity.takeScreenshot();
        return existePdf;
    }
}
