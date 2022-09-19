package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjectLoginScreen;
import rimac.main.screen.BaseScreen;

public class ObjectLoginScreen extends BaseScreen{
	
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
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND (label == 'Iniciar sesión') AND visible == 1")
	@AndroidFindBy(xpath = "//*[@text='Iniciar sesión']")
	public WebElement btnIngresarSesion;
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND (label == 'Nº de documento') AND visible == 1")
    @AndroidFindBy(xpath = "//*[@text='Nº de documento']")
	public WebElement txtNumDocumento;
    
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSecureTextField' AND (label == 'Contraseña') AND visible == 1")
    @AndroidFindBy(xpath = "//*[@text='Contraseña']")
	public WebElement txtPassword;
    
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND (label == 'Done') AND visible == 1")
	public WebElement btnDone;
	
	
}
