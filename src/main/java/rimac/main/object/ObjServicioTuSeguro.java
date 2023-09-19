package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjServicioTuSeguro;
import rimac.main.util.BaseDriver;

public class ObjServicioTuSeguro extends BaseDriver{
	
	// singleton
	private static ObjServicioTuSeguro obj = null;

	private ObjServicioTuSeguro() {
	}

	public static ObjServicioTuSeguro getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjServicioTuSeguro();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	
	@AndroidFindBy(xpath = "//*[@content-desc='Reembolso de salud']")
	public WebElement btnReembolsoSalud;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cobertura']")
	public WebElement tabCobertura;
	
}
