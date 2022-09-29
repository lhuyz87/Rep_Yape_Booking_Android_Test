package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.SolicitudReembolsoRecibidaObject;
import rimac.main.screen.BaseScreen;

public class SolicitudReembolsoRecibidaObject extends BaseScreen{
	
	// singleton
	private static SolicitudReembolsoRecibidaObject obj = null;

	private SolicitudReembolsoRecibidaObject() {
	}

	public static SolicitudReembolsoRecibidaObject getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new SolicitudReembolsoRecibidaObject();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@text='Solicitud de reembolso recibida")
	public WebElement lblSolicitudRecibida;

	@AndroidFindBy(xpath = "//*[@text='Ir al inicio']")
	public WebElement btnIrInicio;
	
}
