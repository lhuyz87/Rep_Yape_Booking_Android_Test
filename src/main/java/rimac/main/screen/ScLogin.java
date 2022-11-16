package rimac.main.screen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.BaseDriver;
import rimac.main.util.MobileObjectUtil;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjLogin;
import rimac.main.screen.ScLogin;
import rimac.main.object.ObjAlertas;
import rimac.main.object.ObjRegistrarHuella;

public class ScLogin extends BaseDriver{

private long wdwTimeOut = 300L;
	
	protected ObjLogin objLogin = ObjLogin.getInstancia();

	// util
	protected MobileObjectUtil pageObjectUtil2 = MobileObjectUtil.getInstancia();
	protected ObjAlertas alertasObject = ObjAlertas.getInstancia();
	protected ObjRegistrarHuella registrarHuellaObject = ObjRegistrarHuella.getInstancia();
	
	public static Logger looger = Logger.getLogger(ScLogin.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void login(String dniUser, String passUser) {
		looger.info("aplicación iniciada");
		util.esperarElemento(4, objLogin.btnIngresarSesion);
		
		element(objLogin.btnIngresarSesion).click();
		element(objLogin.txtNumDocumento).click();
		element(objLogin.txtNumDocumento).sendKeys(dniUser);
		
		try {
			((HidesKeyboard) appiumDriver()).hideKeyboard();
		} catch (Exception e) {
			
		}

		element(objLogin.txtPassword).click();
		element(objLogin.txtPassword).sendKeys(passUser);
		try {
			((HidesKeyboard) appiumDriver()).hideKeyboard();
		} catch (Exception e) {
			
		}
	
		element(objLogin.btnIngresarSesion).click();
		
		util.esperarSegundos(5);
		
	}

	public void seleccOlvidaContra() {
		// TODO Auto-generated method stub
		looger.info("aplicación iniciada");
		util.esperarElemento(4, objLogin.btnIngresarSesion);
		element(objLogin.btnIngresarSesion).click();
		looger.info("aplicación iniciada");
		util.esperarElemento(10, objLogin.btnOlvideContra);
		Serenity.takeScreenshot();
		element(objLogin.btnOlvideContra).click();
		
	}
	
}