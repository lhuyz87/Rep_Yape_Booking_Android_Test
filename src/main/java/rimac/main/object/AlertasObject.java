package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.AlertasObject;
import rimac.main.screen.BaseScreen;

public class AlertasObject extends BaseScreen{
	
	// singleton
	private static AlertasObject obj = null;

	private AlertasObject() {
	}

	public static AlertasObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new AlertasObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='MIENTRAS LA APP ESTÁ EN USO']")
	public WebElement btnAppEnUso;
	
	@AndroidFindBy(xpath = "//*[@text='SOLO ESTA VEZ']")
	public WebElement btnSoloUnaVez;
	
	
	@AndroidFindBy(xpath = "//*[@text='PERMITIR']")
	public WebElement btnPermitir;
	
}
