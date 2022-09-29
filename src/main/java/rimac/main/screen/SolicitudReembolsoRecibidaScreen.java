package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.gargoylesoftware.htmlunit.html.Keyboard;
import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.PageObjectUtil2;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.LoginObject;
import rimac.main.object.SolicitudReembolsoRecibidaObject;


public class SolicitudReembolsoRecibidaScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected SolicitudReembolsoRecibidaObject solicitudReembolsoRecibidaObject = SolicitudReembolsoRecibidaObject.getInstancia();
	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
	public static Logger looger = Logger.getLogger(SolicitudReembolsoRecibidaScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void obtenerMensaje() {
		looger.info("Ultimo Paso");
		
		util.esperarElemento(15, solicitudReembolsoRecibidaObject.btnIrInicio);
		element(solicitudReembolsoRecibidaObject.btnIrInicio).click();
		util.esperarSegundos(15);
	}
	
	
	
}