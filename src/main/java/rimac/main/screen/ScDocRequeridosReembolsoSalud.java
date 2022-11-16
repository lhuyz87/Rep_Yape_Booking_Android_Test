package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjDocRequeridosReembolsoSalud;


public class ScDocRequeridosReembolsoSalud extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjDocRequeridosReembolsoSalud docRequeridosReembolsoSaludObject = ObjDocRequeridosReembolsoSalud.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScDocRequeridosReembolsoSalud.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void continuarDocRequeridos() {
		
		looger.info("Inicia documentos Requeridos");
		util.esperarSegundos(3);
		util.esperarElemento(3, docRequeridosReembolsoSaludObject.btnContinuar);
		looger.info("Se muestra boton Continuar");
		util.esperarSegundos(3);
		element(docRequeridosReembolsoSaludObject.btnContinuar).click();
//		try {
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
}