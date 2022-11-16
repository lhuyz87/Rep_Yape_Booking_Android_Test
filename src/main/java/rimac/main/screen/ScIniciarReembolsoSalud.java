package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

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
import rimac.main.object.ObjIniciarReembolsoSalud;


public class ScIniciarReembolsoSalud extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjIniciarReembolsoSalud iniciarReembolsoSaludObject = ObjIniciarReembolsoSalud.getInstancia();

	// util
	public static Logger looger = Logger.getLogger(ScIniciarReembolsoSalud.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();

	
	public void seleccionarEmpezarReembolso() {
		looger.info("Iniciar Metodo seleccionarEmpezarReembolso");
//		util.esperarElemento(5, iniciarReembolsoSaludObject.lblIniciarReembolso);
		util.esperarSegundos(5);
		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Empezar reembolso\").instance(0))"));

		util.esperarElemento(4, iniciarReembolsoSaludObject.btnEmpezarReembolso);
		element(iniciarReembolsoSaludObject.btnEmpezarReembolso).click();
		looger.info("Termina Metodo seleccionarEmpezarReembolso");
		
	}
	
}