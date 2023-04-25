package rimac.main.screen;

import net.serenitybdd.core.Serenity;
import rimac.main.object.ObjPoliza;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilApp;

import static org.junit.Assert.assertTrue;

public class ScPoliza extends BaseDriver {

    ObjPoliza objPoliza = ObjPoliza.getInstancia();
    UtilApp util=UtilApp.getInstancia();

    private long wdwTimeOut = 300L;

    public void se_visualiza_numero_Poliza() throws Exception{
        util.esperarElemento(15,objPoliza.btnPoliza);
        element(objPoliza.btnPoliza).click();
        util.esperarElementoVisible(5, objPoliza.numeroPoliza);
        try{
            assertTrue(element(objPoliza.numeroPoliza).isCurrentlyVisible());
        }catch(AssertionError e){
            throw new IllegalAccessError("No se visualiza el número de Poliza");
        }finally{
            Serenity.takeScreenshot();
        }
    }

    public void intentarClickPoliza(){
        util.esperarElemento(15,objPoliza.btnPoliza);
            element(objPoliza.btnPoliza).click();
    }
}
