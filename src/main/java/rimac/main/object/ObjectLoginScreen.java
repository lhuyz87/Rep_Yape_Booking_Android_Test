package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import rimac.main.object.ObjectLoginScreen;

public class ObjectLoginScreen {
	
	// singleton
	private static ObjectLoginScreen obj = null;

	private ObjectLoginScreen() {
	}

	public static ObjectLoginScreen getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjectLoginScreen();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public final String btnIniciarSesion ="//*[@text='Iniciar sesión']";
	public final String txtUsername = "//*[@name='test-Username']";
	public final String txtPassword = "//*[@name='test-Password']";
	public final String btnLogin = "//*[@name='test-LOGINxxx']";
	
	public final String btnIniciarSesion(String platformName) {
		System.out.println("La plataforma es: "+platformName);
		if(platformName.compareTo("IOS")==0)
			return "sx";
		else
			return "com.rimac.rimac_surrogas:id/materialBtn";
	}
	
	public final String txtNroDocumento(String platformName) {
		if(platformName.compareTo("IOS")==0)
			return "//XCUIElementTypeTextField[@name='Nº de documento']";
		else
			return "com.rimac.rimac_surrogas:id/materialBtn";
	}
	
	
}
