package rimac.main.screen;

import java.util.logging.Logger;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.pages.PageObject;
import rimac.main.util.PageObjectUtil2;
import rimac.main.util.UtilDef;
import rimac.main.util.VariablesAppNativa;
import rimac.main.object.ObjectLoginScreen;
import rimac.main.screen.AppLoginPage;

public class AppLoginPage extends BaseScreen{

private long wdwTimeOut = 300L;
	
	protected ObjectLoginScreen xpathLoginScreen = ObjectLoginScreen.getInstancia();

	// util
	protected PageObjectUtil2 pageObjectUtil2 = PageObjectUtil2.getInstancia();
	public static Logger looger = Logger.getLogger(AppLoginPage.class.getName());
	
	public long getWdwTimeOut() {
		return wdwTimeOut;
	}
	
	UtilDef util = new UtilDef();
	
	public void login(String dniUser, String passUser) {
		looger.info("aplicación iniciada");
		util.esperarElemento(10, xpathLoginScreen.btnIngresarSesion);
		
		element(xpathLoginScreen.btnIngresarSesion).click();
		element(xpathLoginScreen.txtNumDocumento).click();
		element(xpathLoginScreen.txtNumDocumento).sendKeys(dniUser);
		element(xpathLoginScreen.txtPassword).click();
		element(xpathLoginScreen.txtPassword).sendKeys(passUser);
		
		/**
		 * btnDone solo aplica a iOS, para ocultar el teclado
		 */
		if(element(xpathLoginScreen.btnDone).isClickable()) {
			element(xpathLoginScreen.btnDone).click();
		}
		
		element(xpathLoginScreen.btnIngresarSesion).click();

	}
	
}