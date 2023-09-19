package rimac.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjComoRecibCodVeri;
import rimac.main.util.BaseDriver;

public class ObjComoRecibCodVeri extends BaseDriver{
	
	// singleton
	private static ObjComoRecibCodVeri obj = null;

	private ObjComoRecibCodVeri() {
	}

	public static ObjComoRecibCodVeri getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjComoRecibCodVeri();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@AndroidFindBy(id = "txtAnswerEventQuestion")
	public WebElement btnRespoPregun;

	@AndroidFindBy(xpath = "//*[@text='Elige cómo recibir tu código de']")
	public WebElement titEligeComoRecibir;
	
}
