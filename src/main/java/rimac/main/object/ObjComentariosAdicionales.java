package rimac.main.object;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rimac.main.object.ObjComentariosAdicionales;
import rimac.main.util.BaseDriver;

public class ObjComentariosAdicionales extends BaseDriver{
	
	// singleton
	private static ObjComentariosAdicionales obj = null;

	private ObjComentariosAdicionales() {
	}

	public static ObjComentariosAdicionales getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new ObjComentariosAdicionales();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	@AndroidFindBy(xpath = "//*[@id='commentInput']")
	public WebElement txtDescripcion;
	
	@AndroidFindBy(xpath = "//*[@text='Enviar solicitud']")
	public WebElement btnEnviarSolicitud;

	@AndroidFindBy(xpath = "//*[@text='Ir al inicio']")
	public WebElement btnIralinicio;
	
}
