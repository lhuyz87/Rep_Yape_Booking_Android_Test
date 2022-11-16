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
import rimac.main.object.ObjRegistrarHuella;
import rimac.main.object.ObjAlertas;


public class ScRegistrarHuella extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjRegistrarHuella registrarHuellaObject = ObjRegistrarHuella.getInstancia();

	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	protected ObjAlertas alertasObject = ObjAlertas.getInstancia();
	public static Logger looger = Logger.getLogger(ScRegistrarHuella.class.getName());
	
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
			break;
			
		case "Tienda":
			
			break;
			
		case "Perfil":
			
			break;

		default:
			break;
		}
		
		



	}
	
}