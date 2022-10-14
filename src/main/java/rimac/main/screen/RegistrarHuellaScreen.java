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
import rimac.main.object.RegistrarHuellaObject;
import rimac.main.object.AlertasObject;


public class RegistrarHuellaScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected RegistrarHuellaObject registrarHuellaObject = RegistrarHuellaObject.getInstancia();

	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
	protected AlertasObject alertasObject = AlertasObject.getInstancia();
	public static Logger looger = Logger.getLogger(RegistrarHuellaScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void seleccionarOpcionRegistrarHuella(String opcion) {
		looger.info("Registro de Huella");
		
		
		
		switch (opcion) {
		case "Aceptar":
			
			break;
			
		case "Por ahora no":
			
			util.esperarElemento(10, registrarHuellaObject.btnPorAhoraNo);
			element(registrarHuellaObject.btnPorAhoraNo).click();
			util.esperarSegundos(5);
			
			
		case "Tienda":
			
			break;
			
		case "Perfil":
			
			break;

		default:
			break;
		}
		
		



	}
	
}