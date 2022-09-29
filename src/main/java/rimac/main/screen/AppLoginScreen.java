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
import rimac.main.screen.AppLoginScreen;

public class AppLoginScreen extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected LoginObject objLoginScreen = LoginObject.getInstancia();

	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
	public static Logger looger = Logger.getLogger(AppLoginScreen.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	AppiumDriver driver;
	
	public void login(String dniUser, String passUser) {
		looger.info("aplicación iniciada");
		util.esperarElemento(10, objLoginScreen.btnIngresarSesion);
		
		element(objLoginScreen.btnIngresarSesion).click();
		element(objLoginScreen.txtNumDocumento).click();
		element(objLoginScreen.txtNumDocumento).sendKeys(dniUser);
		element(objLoginScreen.txtPassword).click();
		element(objLoginScreen.txtPassword).sendKeys(passUser);
		

//		try {
//			((PushesFiles) appiumDriver()).pushFile("/data/local/tmp/foo.bar", new File("/Users/johndoe/files/foo.bar"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}


//		/**
//		 * btnDone solo aplica a iOS, para ocultar el teclado
//		 */
//		if(element(xpathLoginScreen.btnDone).isClickable()) {
//			element(xpathLoginScreen.btnDone).click();
//		}
		
		element(objLoginScreen.btnIngresarSesion).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}