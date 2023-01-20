package rimac.main.screen;

import rimac.main.object.ObjActivaTuSeguro;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;

import java.util.logging.Logger;

public class ScActivaTuSeguro extends BaseDriver {

    protected ObjActivaTuSeguro objActivaTuSeguro= ObjActivaTuSeguro.getInstancia();
    public static Logger looger = Logger.getLogger(ScAsistenciaVehicular.class.getName());
    protected UtilApp util = UtilApp.getInstancia();
    protected MobileObjectUtil mobileObjectUtil = MobileObjectUtil.getInstancia();

    public void omitirModalActivatuSeguro(){

        util.esperarSegundos(5);
        if(element(objActivaTuSeguro.titActivatuSeguro).isCurrentlyVisible()){
            element(objActivaTuSeguro.btnCerrarModal).click();
        }
    }
}
