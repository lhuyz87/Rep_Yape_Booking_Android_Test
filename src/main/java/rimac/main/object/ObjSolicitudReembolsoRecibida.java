package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjSolicitudReembolsoRecibida;
import rimac.main.util.BaseDriver;

public class ObjSolicitudReembolsoRecibida extends BaseDriver{
	
	// singleton
	private static ObjSolicitudReembolsoRecibida obj = null;

	private ObjSolicitudReembolsoRecibida() {
	}

	public static ObjSolicitudReembolsoRecibida getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjSolicitudReembolsoRecibida();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(id ="com.rimac.rimac_surrogas:id/title_congrats")
	public WebElement lblSolicitudRecibida;

	@AndroidFindBy(xpath = "//*[@text='Ir al inicio']")
	public WebElement btnIrInicio;
	
	
	
	
}
