package rimac.main.screen;

import rimac.main.object.ObjNecesitoAyudaAsistencia;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

public class ScNecesitoAyuda extends BaseDriver {

    private long wdwTimeOut = 300L;

    protected UtilApp util = UtilApp.getInstancia();
    protected ObjNecesitoAyudaAsistencia objNecesitoAyudaAsistencia = ObjNecesitoAyudaAsistencia.getInstancia();

    public long getWdwTimeOut() {
        return wdwTimeOut;
    }
    public void seleccionarOpcion(String opcion) throws Exception {
        util.esperarElementoVisible(3,objNecesitoAyudaAsistencia.cmbEligeOpcion);
        element(objNecesitoAyudaAsistencia.cmbEligeOpcion).click();
        element(objNecesitoAyudaAsistencia.opcEligeOpcion(opcion)).click();
        util.esperarElementoVisible(3,objNecesitoAyudaAsistencia.btnContinuar);
        element(objNecesitoAyudaAsistencia.btnContinuar).click();
    }

    public void seleccionarSi() throws Exception {
        util.esperarElementoVisible(3,objNecesitoAyudaAsistencia.lblEnciendeLuces);
        element(objNecesitoAyudaAsistencia.btnSi).click();
        util.esperarElementoVisible(3,objNecesitoAyudaAsistencia.btnContinuar);
        element(objNecesitoAyudaAsistencia.btnContinuar).click();
    }

    public void seleccionarNo() throws Exception {
        util.esperarElementoVisible(3,objNecesitoAyudaAsistencia.lblEnciendeLuces);
        element(objNecesitoAyudaAsistencia.btnNo).click();
        util.esperarElementoVisible(3,objNecesitoAyudaAsistencia.btnContinuar);
        element(objNecesitoAyudaAsistencia.btnContinuar).click();
    }

    public void solicitarAsistenciaSugerida() throws Exception {
        util.esperarElementoVisible(3,objNecesitoAyudaAsistencia.lblAsistenciSugerida);
        util.esperarElementoVisible(3,objNecesitoAyudaAsistencia.btnSolicitar);
        element(objNecesitoAyudaAsistencia.btnSolicitar).click();
    }

}
