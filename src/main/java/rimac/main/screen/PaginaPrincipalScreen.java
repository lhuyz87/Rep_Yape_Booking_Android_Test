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
import rimac.main.object.PaginaPrincipalObject;
import rimac.main.screen.PaginaPrincipalScreen;

public class PaginaPrincipalScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected PaginaPrincipalObject objectPrincipalScreen = PaginaPrincipalObject.getInstancia();

	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
	public static Logger looger = Logger.getLogger(PaginaPrincipalScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void seleccionarOpcionPrincipal(String opcion) {
		looger.info("aplicación iniciada");
		util.esperarElemento(10, objectPrincipalScreen.btnTramite);
		
		
		switch (opcion) {
		case "Home":
			
			break;
			
		case "Seguros":
			
			break;
			
		case "Tramites":
			util.esperarElemento(5, objectPrincipalScreen.btnTramite);
			element(objectPrincipalScreen.btnTramite).click();
			
		case "Tienda":
			
			break;
			
		case "Perfil":
			
			break;

		default:
			break;
		}
		
		



	}
	
}