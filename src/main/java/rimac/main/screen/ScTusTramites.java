package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.ss.formula.ThreeDEval;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjTramites;


public class ScTusTramites extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjTramites tramitesObject = ObjTramites.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScTusTramites.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	
	@SuppressWarnings("deprecation")
	public void seleccionarTramiteSalud(String tramite) {
		
		switch (tramite) {
		case "Atención médica virtual":
			
			break;
			
		case "Buscador de clínicas":
			
			break;
			
		case "Médico a domicilio":
			
			break;
			
		case "Reembolso de salud":
			looger.info("Iniciar Reembolso de salud");
			
			util.esperarElemento(10, tramitesObject.btnTodos);;
			util.scroll();
//			appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Reembolso de salud\").instance(0))"));

			element(tramitesObject.btnReembolsoSalud).click();
			looger.info("Termina Reembolso de salud");
			
		case "Programa Cuídate":
			
			break;
			
		case "Chequeo preventivo":
			
			break;
			
		case "Extensión de receta":
			
			break;

		default:
			break;
		}
		
	}
	
}