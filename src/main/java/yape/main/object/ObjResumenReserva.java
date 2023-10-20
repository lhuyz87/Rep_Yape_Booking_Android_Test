package yape.main.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import yape.main.object.ObjResumenReserva;
import yape.main.util.BaseDriver;

public class ObjResumenReserva extends BaseDriver{
	
	// singleton
	private static ObjResumenReserva obj = null;

	private ObjResumenReserva() {
	}

	public static ObjResumenReserva getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjResumenReserva();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	

	
	//*[contains(text(),'Palacio del Inka')]

	
	
	@AndroidFindBy(xpath = "//*[@text='Último paso']")
	public WebElement btnUltimoPaso;
	
	
	

}
