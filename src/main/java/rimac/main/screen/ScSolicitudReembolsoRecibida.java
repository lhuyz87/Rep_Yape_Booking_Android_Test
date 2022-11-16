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
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.object.ObjSolicitudReembolsoRecibida;


public class ScSolicitudReembolsoRecibida extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjSolicitudReembolsoRecibida objSolicitudReembolsoRecibida = ObjSolicitudReembolsoRecibida.getInstancia();
	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	public static Logger looger = Logger.getLogger(ScSolicitudReembolsoRecibida.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public String  obtenerMensaje() {
		looger.info("Ultimo Paso");
		util.esperarElemento(10, objSolicitudReembolsoRecibida.lblSolicitudRecibida);
		Serenity.takeScreenshot();
		String mensajeObtenido= objSolicitudReembolsoRecibida.lblSolicitudRecibida.getText();
		util.esperarElemento(5, objSolicitudReembolsoRecibida.btnIrInicio);
		element(objSolicitudReembolsoRecibida.btnIrInicio).click();
		util.esperarSegundos(5);
		
		return mensajeObtenido;
	}
	
	
	
}