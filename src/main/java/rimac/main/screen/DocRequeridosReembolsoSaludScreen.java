package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.PageObjectUtil2;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.LoginObject;
import rimac.main.object.DocRequeridosReembolsoSaludObject;


public class DocRequeridosReembolsoSaludScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected DocRequeridosReembolsoSaludObject docRequeridosReembolsoSaludObject = DocRequeridosReembolsoSaludObject.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(DocRequeridosReembolsoSaludScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void continuarDocRequeridos() {
		
		looger.info("Inicia documentos Requeridos");
		
		util.esperarElemento(8, docRequeridosReembolsoSaludObject.btnContinuar);
		element(docRequeridosReembolsoSaludObject.btnContinuar).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}